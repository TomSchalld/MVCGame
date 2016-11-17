package com.schalldach.thomas.game.model;

import com.schalldach.thomas.game.controler.GameModelVisitor;
import com.schalldach.thomas.game.controler.IGameModel;
import com.schalldach.thomas.game.factory.CannonFactory;
import com.schalldach.thomas.game.factory.EnemyFactory;
import com.schalldach.thomas.game.factory.MissileFactory;
import com.schalldach.thomas.game.objects.Cannon;
import com.schalldach.thomas.game.objects.Collision;
import com.schalldach.thomas.game.objects.Enemy;
import com.schalldach.thomas.game.objects.Missile;
import com.schalldach.thomas.game.helper.Gravity;
import com.schalldach.thomas.game.helper.Score;

import java.util.List;
import java.util.Timer;

public class Model implements IObservable, IGameModel{
    private List<IObserver> observers;
    private Cannon cannon;
    private List<Enemy> enemies;
    private List<Missile> missiles;
    private Score score;
    private Gravity gravity;
    private Timer timer;

    public Model(CannonFactory cf, MissileFactory mf, EnemyFactory ef){
        //TODO setup factories
        cannon = (Cannon) cf.create();
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
        for(Missile m : missiles){
            //TODO Move missiles
        }
        for(Enemy e: enemies){
            //TODO Move enemies
        }
        //TODO On user input, move cannon
        notification();
    }

    @Override
    public void accept(GameModelVisitor visitor) {
        //TODO Draw the gameObjects
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
