package com.rojas.remy.game.model;

import com.rojas.remy.game.factory.CannonFactory;
import com.rojas.remy.game.factory.BrickFactory;
import com.rojas.remy.game.factory.CollisionFactory;
import com.rojas.remy.game.factory.EnemyFactory;
import com.rojas.remy.game.factory.MissileFactory;
import com.rojas.remy.game.factory.MovementStrategy.EnemyMovement;
import com.rojas.remy.game.factory.MovementStrategy.SpaceMissileMovement;
import com.rojas.remy.game.helper.Score;
import com.rojas.remy.game.helper.TwoDimPosition;
import com.rojas.remy.game.objects.*;

import java.util.*;

public class Model implements IObservable{


    private List<GameObject> drawableObjects;
    private List<IObserver> observers;
    private Cannon cannon;
    private List<GameObject> enemies;
    private List<GameObject> missiles;
    private List<GameObject> collisions;
    private List<GameObject> wall;
    private CollisionFactory colf;
    private CannonFactory cf;
    private MissileFactory mf;
    private EnemyFactory ef;
    private BrickFactory bf;
    private Score score;
    private Timer timer;
    private final int numEnemies=5;
    private Memento memento;

    public Model(){
        observers = new ArrayList<IObserver>();
        missiles = new ArrayList<GameObject>();
        enemies = new ArrayList<GameObject>();
        collisions = new ArrayList<GameObject>();
        wall = new ArrayList<GameObject>();
        bf = new BrickFactory();
        bf.setImage(Config.BRICK_IMAGE);
        bf.setDrawable(true);
        cf = new CannonFactory();
        cf.setDrawable(true);
        cf.setImage(Config.CANNON_IMAGE);
        cf.setInitPosition(Config.CANNON_INIT_POS);
        cf.setMovement(null);
        mf = new MissileFactory();
        mf.setImage(Config.MISSILE_IMAGE);
        mf.setMovement(new SpaceMissileMovement());
        mf.setDrawable(true);
        ef = new EnemyFactory();
        ef.setImage(Config.ENEMY_IMAGE1);
        ef.setDrawable(true);
        ef.setMovement(new EnemyMovement());
        colf = new CollisionFactory();
        colf.setDrawable(true);
        colf.setImage(Config.COLLISION_IMAGE);
        cannon = (Cannon) cf.create();
        drawableObjects = new ArrayList<GameObject>();
        drawableObjects.add(cannon);
        buildAWall(wall, 100);
        initTimer();

    }

    private void buildAWall(List<GameObject> wall, int xpos) {
        int ypos = 100;
        while (ypos<500 - bf.getImage().getHeight()/2){
            wall.add(bf.create(new TwoDimPosition(xpos, ypos)));
            ypos+=bf.getImage().getHeight();
        }
    }

    @Override
    public void attach(IObserver observer) {
        observers.add(observer);
        notification();
    }
    @Override
    public void detach(IObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notification() {
        for(IObserver o : observers){
            o.update();
        }
    }

    public void moveCannon(int keypressed){
        if(keypressed==40) cannon.setPosition(new TwoDimPosition(cannon.getPosition().getxCoordinate(),cannon.getPosition().getyCoordinate()+10));
        if(keypressed==38) cannon.setPosition(new TwoDimPosition(cannon.getPosition().getxCoordinate(),cannon.getPosition().getyCoordinate()-10));
    }

    public void fireMissile(){
        Missile m = (Missile)mf.create((TwoDimPosition) cannon.getPosition());
        missiles.add(m);
    }

    public void fireEnemy(){
        Enemy e = (Enemy) ef.create();
        enemies.add(e);
    }

    private void initTimer(){
        this.timer = new Timer();
        this.timer.schedule(new TimerTask() {
            @Override
            public void run() {

                Iterator<GameObject> missileIterator = missiles.iterator();
                while(missileIterator.hasNext()){
                    GameObject m = missileIterator.next();
                    m.move();
                    enemies.removeIf(enemy -> enemyHit(m,enemy));
                }

                Iterator<GameObject> wallIterator = wall.iterator();
                while(wallIterator.hasNext()){
                    Brick b = (Brick) wallIterator.next();
                    missiles.removeIf(m -> wallHit(m,b));
                    enemies.removeIf(e-> wallHit(e,b));
                }

                wall.removeIf(brick -> !brick.isDrawable());
                missiles.removeIf(missile -> !missile.isDrawable());

                enemies.forEach(enemy -> enemy.move());

                collisions.forEach(col -> col.decay());
                collisions.removeIf(col -> col.getDecay() < 0);

                while(enemies.size()<numEnemies){
                    fireEnemy();
                }

                notification();
            }
        }, 0, 20);
    }

    private boolean enemyHit(GameObject m, GameObject e){
        if(contact(m,e)){
            collisions.add(colf.create(new TwoDimPosition(e.getPosition().getxCoordinate(), e.getPosition().getyCoordinate())));
            m.setDrawable(false);
            e.setDrawable(false);
            return true;
        }
        return false;
    }

    private boolean wallHit(GameObject o, Brick brick){
        if(contact(o,brick)){
            brick.takeDamage();
            o.setDrawable(false);
            return true;
        }
        return false;
    }

    private boolean contact(GameObject a, GameObject b){
        //Collision with eachother
        if(Math.abs(a.getPosition().getxCoordinate()-b.getPosition().getxCoordinate()) - Math.abs(a.getImage().getWidth() + b.getImage().getWidth())/2 <= 0 &&
                Math.abs(a.getPosition().getyCoordinate()-b.getPosition().getyCoordinate()) - Math.abs(a.getImage().getHeight() + b.getImage().getHeight())/2 <= 0){
            return true;
        }
        return false;
    }


    public List<GameObject> getMissiles() {
        return missiles;
    }

    public List<GameObject> getEnemies() { return enemies;}

    public Cannon getCannon() {return cannon;}

    public List<GameObject> getCollisions() {
        return collisions;
    }

    public List<GameObject> getWall() { return wall;}

    public Timer getTimer() {
        return timer;
    }

    public void switchMissileMovement(){
        mf.switchMovement();
    }


    public void pause() {
        memento = new Memento(enemies, missiles, collisions, cannon);
        timer.cancel();
        timer = null;

    }

    public void loadMemento() {
        enemies = memento.getEnemies();
        missiles = memento.getMissiles();
        collisions = memento.getCollisions();
        cannon = (Cannon) memento.getCannon();
        memento = null;
        initTimer();
    }

    private class Memento{
        private List<GameObject> enemies;
        private List<GameObject> missiles;
        private List<GameObject> collisions;
        private GameObject cannon;

        public Memento(List<GameObject> enemies, List<GameObject> missiles, List<GameObject> collisions, GameObject cannon){
            this.enemies = enemies;
            this.missiles = missiles;
            this.collisions = collisions;
            this.cannon = cannon;
        }

        public List<GameObject> getEnemies() {
            return enemies;
        }

        public List<GameObject> getMissiles() {
            return missiles;
        }

        public List<GameObject> getCollisions() {
            return collisions;
        }

        public GameObject getCannon() {
            return cannon;
        }
    }

}
