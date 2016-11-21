package com.schalldach.thomas.game.model;

import com.schalldach.thomas.game.factory.*;
import com.schalldach.thomas.game.objects.strategies.StraightShot;
import com.schalldach.thomas.game.objects.strategies.ZeroMovement;
import com.schalldach.thomas.game.objects.strategies.ZombieMovement;
import com.schalldach.thomas.game.utils.ImageScaling;
import com.schalldach.thomas.game.utils.TwoDimPosition;
import com.schalldach.thomas.game.objects.*;
import com.schalldach.thomas.game.utils.Gravity;
import com.schalldach.thomas.game.utils.Score;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Timer;

/**
 * Created by B.Sc. Thomas Schalldach on 16/10/2016. The code of this application is free to use for non-commercial projects,
 * as long as you ensure that you credit the author. For commercial usage, please contact software[at]thomas-schalldach.de
 */
public class Model implements IObservable{
    private List<IObserver> observers;
    private Cannon cannon;
    private List<Enemy> enemies;
    private volatile List<Missile> missiles;
    private List<Collision> collisions;
    private Score score;
    private Gravity gravity;
    private Timer timer;
    private List<Integer> windowSize;

    private CannonFactory cannonFactory;
    private CollisionFactory collisionFactory;
    private EnemyFactory enemyFactory;
    private MissileFactory missileFactory;

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


    public Model(List<Integer> windowSize) throws IOException {
        this.windowSize = windowSize;
        cannonFactory = (CannonFactory)GameObjectFactory.createCannonFactory();
        cannonFactory.setImage(ImageIO.read(getClass().getResourceAsStream("/images/cannon.png")));
        cannonFactory.setInitialPosition(new TwoDimPosition(100.,100.));
        cannon = (Cannon)cannonFactory.create();

        missileFactory = (MissileFactory)GameObjectFactory.createMissileFactory();
        missileFactory.setImage(ImageIO.read(getClass().getResourceAsStream("/images/bullet/small_bullet1.png")));
        StraightShot straightShot = new StraightShot(30);
        missileFactory.setStrategy(straightShot);

        enemyFactory = (EnemyFactory)GameObjectFactory.createEnemyFactory();
        enemyFactory.setWindowSize(windowSize);
        enemyFactory.setInitialPosition(new TwoDimPosition(200.,200.));
        enemyFactory.setImage(
                ImageScaling.scale(
                        ImageIO.read(getClass().getResourceAsStream("/images/zombie/appear/appear_1.png"))
                        ,40,60));
        EnemyState wakeState = new EnemyState(11,11,"/images/zombie/appear/appear_");
        wakeState.setMovement(new ZeroMovement());
        EnemyState walkState = new EnemyState(10000,10,"/images/zombie/walk/go_");
        walkState.setMovement(new ZombieMovement(5));
        EnemyState dyingState = new EnemyState(8,8,"/images/zombie/die/die_");
        dyingState.setMovement(new ZeroMovement());
        EnemyState deadState = new EnemyState(100,1,"/images/zombie/dead_");
        deadState.setMovement(new ZeroMovement());
        deadState.setDead();
        dyingState.setNextState(deadState);
        walkState.setNextState(dyingState);
        wakeState.setNextState(walkState);
        enemyFactory.setWakeState(wakeState);
        observers = new LinkedList<IObserver>();
        enemies = new LinkedList<Enemy>();
        missiles = new LinkedList<Missile>();
        collisions = new LinkedList<Collision>();
    }

    public List<GameObject> getObjects(){
        List<GameObject> objects = new LinkedList<GameObject>();
        objects.addAll(enemies);
        objects.addAll(missiles);
        objects.addAll(collisions);
        objects.add(cannon);
        return objects;
    }

    public void moveCannon(List<Integer> vector){
        List<Double> doubleVector = new ArrayList<>();
        vector.forEach(el -> doubleVector.add(el.doubleValue()));
        TwoDimPosition pos = new TwoDimPosition();
        pos.addVector(doubleVector);
        cannon.move(pos);
    }

    public Cannon getCannon(){
        return cannon;
    }

    public void fireCannon() {
        missiles.add((Missile)missileFactory.create(cannon.getPosition()));
    }

    public void modelUpdate(){
        //System.out.println(missiles.get(0).getPosition().getVector().get(0));
        if(enemies.size()<10)
            enemies.add((Enemy)enemyFactory.create());
        for(int i=0;i<enemies.size();i++) {
            enemies.get(i).moveEnemy();
            if(!isValid((TwoDimPosition) enemies.get(i).getPosition())) {
                enemies.remove(i);
            }
        }
        for(int i=0;i<missiles.size();i++){
            missiles.get(i).moveMissile();
            for(int j=0;j<enemies.size();j++)
                if(enemies.get(j).getPosition().equals(missiles.get(i).getPosition())) {
                    enemies.get(j).forceTransition();
                    System.out.println("collision");
                }
            if(!isValid((TwoDimPosition) missiles.get(i).getPosition()))
                missiles.remove(i);
        }
        //missiles.forEach(missile -> missile.moveMissile() );
        //missiles.forEach(missile ->System.out.println(missile.getPosition().getVector().get(0)) );
    }

    public boolean isValid(TwoDimPosition pos) {
        List<Double> vector = pos.getVector();
        if (vector.get(0) < 0 || vector.get(0) >= windowSize.get(0)
            || (vector.get(1)<0 || vector.get(1)>=windowSize.get(1)))
            return false;
        return true;
    }
}
