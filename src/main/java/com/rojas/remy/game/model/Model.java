package com.rojas.remy.game.model;

import com.rojas.remy.game.factory.CannonFactory;
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
    private List<GameObject> things;
    private List<GameObject> enemies;
    private List<GameObject> missiles;
    private List<GameObject> collisions;
    private CollisionFactory colf;
    private CannonFactory cf;
    private MissileFactory mf;
    private EnemyFactory ef;
    private Score score;
    private Timer timer;
    private final int numEnemies=5;

    public Model(){
        observers = new ArrayList<IObserver>();
        missiles = new ArrayList<GameObject>();
        enemies = new ArrayList<GameObject>();
        collisions = new ArrayList<GameObject>();
        things = new ArrayList<GameObject>();
        cf = new CannonFactory();
        cf.setDrawable(true);
        cf.setImage(Config.CANNON_IMAGE);
        cf.setInitPosition(Config.CANNON_INIT_POS);
        cf.setMovement(null);
        mf = new MissileFactory();
        mf.setImage(Config.MISSILE_IMAGE);
        mf.setMovement(new SpaceMissileMovement());
        mf.setDrawable(true);
        mf.setModel(this);
        ef = new EnemyFactory();
        ef.setImage(Config.ENEMY_IMAGE1);
        ef.setDrawable(true);
        ef.setMovement(new EnemyMovement());
        ef.setModel(this);
        colf = new CollisionFactory();
        colf.setDrawable(true);
        colf.setImage(Config.COLLISION_IMAGE);
        cannon = (Cannon) cf.create();
        drawableObjects = new ArrayList<GameObject>();
        drawableObjects.add(cannon);
        initTimer();

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
                    enemies.removeIf(enemy -> contact(m,enemy));
                }

                missiles.removeIf(missile -> !missile.isDrawable());

                enemies.forEach(enemy -> enemy.move());

                collisions.forEach(col -> col.decay());
                collisions.removeIf(col -> col.getDecay() < 0);

                while(enemies.size()<numEnemies){
                    fireEnemy();
                }

                notification();
            }
        }, 0, 30);
    }

    private boolean contact(GameObject a, GameObject b){

        //Collision with eachother
        if(Math.abs(a.getPosition().getxCoordinate()-b.getPosition().getxCoordinate()) - Math.abs(a.getImage().getWidth() + b.getImage().getWidth()) <= 0 &&
                Math.abs(a.getPosition().getyCoordinate()-b.getPosition().getyCoordinate()) - Math.abs(a.getImage().getHeight() + b.getImage().getHeight()) <= 0){
            a.setDrawable(false);
            b.setDrawable(false);
            collisions.add(colf.create(new TwoDimPosition(b.getPosition().getxCoordinate(), b.getPosition().getyCoordinate())));
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

    //////////// MEMENTO
/*
    public Object createMemento() {
        Memento memento = new Memento();
        memento.gravity = this.gravity;
    }

    public void loadMemento(Object o) {

        Memento memento = (Memento) o;

    }

    private class Memento{
        public int gravity;
    }
    */
}
