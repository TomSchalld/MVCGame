package com.schalldach.thomas.game.model;

import com.schalldach.thomas.game.factory.AbstractGameObjectFactory;
import com.schalldach.thomas.game.factory.ConcreteFactory;
import com.schalldach.thomas.game.helper.APosition;
import com.schalldach.thomas.game.helper.Gravity;
import com.schalldach.thomas.game.helper.Score;
import com.schalldach.thomas.game.helper.TwoDimPosition;
import com.schalldach.thomas.game.objects.*;
import com.schalldach.thomas.game.threads.MissileMovementThread;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by B.Sc. Thomas Schalldach on 16/10/2016. The code of this application is free to use for non-commercial projects,
 * as long as you ensure that you credit the author. For commercial usage, please contact software[at]thomas-schalldach.de
 */
public class Model implements IObservable {
    final private ConcreteFactory missileFactory = AbstractGameObjectFactory.createMissileFactory();
    final private ConcreteFactory cannonFactory = AbstractGameObjectFactory.createCannonFactory();
    final private ConcreteFactory collisionFactory = AbstractGameObjectFactory.createCollisionFactory();
    final private ConcreteFactory enemyFactory = AbstractGameObjectFactory.createEnemyFactory();

    private int missileIndicator = 0;
    private List<IObserver> observers;
    private Cannon cannon;
    private List<Enemy> enemies;
    private List<Missile> missiles;
    private List<Collision> collisions;
    private Score score;
    private Gravity gravity;
    private Timer timer;

    public Model() {

        enemies = new ArrayList<>();
        missiles = new ArrayList<>();
        collisions = new ArrayList<>();
        observers = new ArrayList<>();


    }

    public List<IObserver> getObservers() {
        return observers;
    }

    public Cannon getCannon() {
        return cannon;
    }

    public  List<Enemy>  getEnemies() {
        return enemies;
    }

    public List<Missile> getMissiles() {
        return missiles;
    }

    public List<Collision> getCollisions() {
        return collisions;
    }

    public Score getScore() {
        return score;
    }

    public Gravity getGravity() {
        return gravity;
    }

    public Timer getTimer() {
        return timer;
    }

    @Override
    public void attach(IObserver observer) {
        observers.add(observer);
    }

    @Override
    public void detach(IObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notification() {
        // Canvas must implement IObserver
        observers.forEach(IObserver::update);
    }

    public void doBasicInstantiation() {
        APosition pos = new TwoDimPosition();
        pos.addVector(Arrays.asList(400.0, 100.0));
        cannonFactory.setInitialPosition(pos);
        this.cannon = (Cannon) cannonFactory.create();
        for (int i = 0; i < 10; i++) {
            this.enemies.add((Enemy) enemyFactory.create());
        }
        /*for (int i = 0; i < 100; i++) {
            missiles.add((Missile) factory.create());
        }
        this.factory =  AbstractGameObjectFactory.createCollisionFactory();*/

    }

    public List<GameObject> getObjects() {
        List<GameObject> list = new LinkedList<>();
        list.addAll(getMissiles());
        list.addAll(getEnemies());
        list.addAll(getCollisions());
        list.add(getCannon());
        return list;

    }
    public void moveCannonUp() {
        TwoDimPosition pos = (TwoDimPosition) cannon.getPosition();
        pos.addVector(Arrays.asList(0.0, pos.getyCoordinate()-30.0));
        notification();
    }

    public void moveCannonDown() {
        TwoDimPosition pos = (TwoDimPosition) cannon.getPosition();
        pos.addVector(Arrays.asList(0.0, pos.getyCoordinate()+30.0));
        notification();
    }

    public void moveMissile(Missile missile) {
        missile.getPosition().addVector(Arrays.asList(0.0, 120.0));
    }


    public void checkForCollision(){
        List<Enemy> enemyDisposal = new ArrayList<>();

        for (int i = 0; i < missiles.size(); i++) {
            for (int j = 0; j <enemies.size() ; j++) {
                if (missiles.get(i).getPosition().equals(enemies.get(j).getPosition())){
                    System.err.println("HIT!!!!!");
                    enemyDisposal.add(enemies.get(j));
                    collisionFactory.setInitialPosition(enemies.get(j).getPosition());
                    collisions.add((Collision) collisionFactory.create());
                }
            }
        }
        enemies.removeAll(enemyDisposal);

    }

    public void fireCannon() {
        if (missileIndicator < missiles.size()) {
            missiles.get(missileIndicator).move(cannon.getPosition().getVector());
            cannon.shoot(missiles.get(missileIndicator));
            missileIndicator++;
        }
        //notification();
    }

    public void createMissile() {
        missiles.add((Missile) missileFactory.create());
    }

    public void shoot() {
        if (cannon.getState()== Cannon.CannonState.shootable){
            this.createMissile();
            this.fireCannon();
        }else {
            System.err.println("Cant Shoot cannon is in state: " + cannon.getState());
        }

    }


    //methods
    /*
    * moveCanonUp
    * changeCanonAngle
    * shoot
    * changeGravity
    *
    * main game loop
    *
    * moves missiles, checks collisions, discards old objects
    *
    * moves objects
    * */
}
