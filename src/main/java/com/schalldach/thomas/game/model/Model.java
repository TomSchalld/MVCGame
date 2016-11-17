package com.schalldach.thomas.game.model;

import com.schalldach.thomas.game.objects.Cannon;
import com.schalldach.thomas.game.objects.Collision;
import com.schalldach.thomas.game.objects.Enemy;
import com.schalldach.thomas.game.objects.Missile;
import com.schalldach.thomas.game.helper.Gravity;
import com.schalldach.thomas.game.helper.Score;

import java.util.List;
import java.util.Timer;

public class Model implements IObservable{
    private List<IObserver> observers;
    private Cannon cannon;
    private List<Enemy> enemies;
    private List<Missile> missiles;
    private List<Collision> collisions;
    private Score score;
    private Gravity gravity;
    private Timer timer;


    public Model(){
        //TODO setup factories
        
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
        for(IObserver o : observers){
            o.update();
        }
    }

    public void progressGame(){

        notification();
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
