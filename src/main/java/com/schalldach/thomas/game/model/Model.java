package com.schalldach.thomas.game.model;

import com.schalldach.thomas.game.factory.AbstractGameObjectFactory;
import com.schalldach.thomas.game.factory.ConcreteFactory;
import com.schalldach.thomas.game.helper.APosition;
import com.schalldach.thomas.game.helper.Gravity;
import com.schalldach.thomas.game.helper.Score;
import com.schalldach.thomas.game.helper.TwoDimPosition;
import com.schalldach.thomas.game.objects.*;
import com.schalldach.thomas.game.threads.MissileMovement;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by B.Sc. Thomas Schalldach on 16/10/2016. The code of this application is free to use for non-commercial projects,
 * as long as you ensure that you credit the author. For commercial usage, please contact software[at]thomas-schalldach.de
 */
public class Model implements IObservable {
    private ExecutorService executor;
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
        executor = Executors.newFixedThreadPool(10);


    }

    public List<IObserver> getObservers() {
        return observers;
    }

    public Cannon getCannon() {
        return cannon;
    }

    public List<Enemy> getEnemies() {
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
        ConcreteFactory factory = AbstractGameObjectFactory.createCannonFactory();
        APosition pos = new TwoDimPosition();
        pos.addVector(Arrays.asList(400.0, 100.0));
        factory.setInitialPosition(pos);
        this.cannon = (Cannon) factory.create();
        factory = AbstractGameObjectFactory.createEnemyFactory();
        for (int i = 0; i < 10; i++) {
            enemies.add((Enemy) factory.create());
        }
        factory = AbstractGameObjectFactory.createMissileFactory();
        for (int i = 0; i < 10; i++) {
            missiles.add((Missile) factory.create());
        }
        factory = AbstractGameObjectFactory.createCollisionFactory();
        for (int i = 0; i < 10; i++) {
            collisions.add((Collision) factory.create());
        }
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

    public void randomizeEnemies() {
        enemies.forEach(enemy -> enemy.getPosition().addVector(Arrays.asList(Math.random() * 10, Math.random() * 10)));
        notification();
    }

    public void fireCannon() {
        if (missileIndicator < 10) {
            missiles.get(missileIndicator).move(cannon.getPosition().getVector());

            executor.execute(new MissileMovement(missiles.get(missileIndicator)));
            missileIndicator++;
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
