package com.schalldach.thomas.game.model;

import com.schalldach.thomas.game.controler.GameVisitor;
import com.schalldach.thomas.game.controler.Logic;
import com.schalldach.thomas.game.factory.CannonFactory;
import com.schalldach.thomas.game.factory.EnemyFactory;
import com.schalldach.thomas.game.factory.MissileFactory;
import com.schalldach.thomas.game.factory.MovementStrategy.EnemyMovement;
import com.schalldach.thomas.game.factory.MovementStrategy.MissileMovement;
import com.schalldach.thomas.game.helper.TwoDimPosition;
import com.schalldach.thomas.game.objects.*;
import com.schalldach.thomas.game.helper.Gravity;
import com.schalldach.thomas.game.helper.Score;

import java.util.*;

public class Model implements IObservable{
    private List<GameObject> drawableObjects;
    private List<IObserver> observers;
    private Cannon cannon;
    private List<Enemy> enemies;
    private List<Missile> missiles;
    private CannonFactory cf;
    private MissileFactory mf;
    private EnemyFactory ef;
    private Score score;
    private Gravity gravity;
    private Timer timer;

    public Model(){
        observers = new ArrayList<IObserver>();
        missiles = new ArrayList<Missile>();
        enemies = new ArrayList<Enemy>();
        cf = new CannonFactory();
        cf.setDrawable(true);
        cf.setImage(Config.CANNON_IMAGE);
        cf.setInitPosition(Config.CANNON_INIT_POS);
        cf.setMovement(null);
        mf = new MissileFactory();
        mf.setImage(Config.MISSILE_IMAGE);
        mf.setMovement(new MissileMovement());
        mf.setDrawable(true);
        mf.setModel(this);
        ef = new EnemyFactory();
        ef.setImage(Config.ENEMY_IMAGE1);
        ef.setDrawable(true);
        ef.setMovement(new EnemyMovement());
        ef.setModel(this);
        cannon = (Cannon) cf.create();
        drawableObjects = new ArrayList<GameObject>();
        drawableObjects.add(cannon);
        initTimer();
        //TODO setup factories

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
        notification();
    }

    public Missile fireMissile(GameVisitor visitor){
        //TODO Two shooting modes
        Missile m = (Missile)mf.create((TwoDimPosition) cannon.getPosition());
        missiles.add(m);
        m.accept(visitor);
        return m;
    }

    public void fireEnemy(GameVisitor visitor){
        Enemy e = (Enemy) ef.create();
        enemies.add(e);
        e.accept(visitor);
    }

    private void initTimer(){
        this.timer = new Timer();
        this.timer.schedule(new TimerTask() {
            @Override
            public void run() {
                for (Enemy e : enemies){
                    e.move();
                }
                for (Missile m : missiles) {
                    m.move();
                }
                notification();
            }
        }, 0, 5);
    }

    public List<Missile> getMissiles() {
        return missiles;
    }

    public List<Enemy> getEnemies() { return enemies;}

    public Cannon getCannon() {return cannon;}
}
