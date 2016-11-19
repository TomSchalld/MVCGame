package com.schalldach.thomas.game.model;

import com.schalldach.thomas.game.factory.CannonFactory;
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
    private Score score;
    private Gravity gravity;
    private Timer timer;

    public Model(){
        observers = new ArrayList<IObserver>();
        cf = new CannonFactory();
        cf.setImage(Config.CANNON_IMAGE);
        cf.setDrawable(true);
        cannon = (Cannon) cf.create();
        notification();
        //TODO setup factories
    }

    @Override
    public void attach(IObserver observer) {
        observers.add(observer);
        System.out.println("Added Observer: "+observer.toString());
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

    public List<GameObject> getDrawableObjects(){
        drawableObjects = new ArrayList<GameObject>();
        drawableObjects.add(cannon);
        for(Missile m : missiles){
            if(m.isDrawable()) drawableObjects.add(m);
        }
        for(Enemy e : enemies){
            if(e.isDrawable()) drawableObjects.add(e);
        }
        return drawableObjects;
    }

}
