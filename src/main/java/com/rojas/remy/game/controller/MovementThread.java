package com.rojas.remy.game.controller;

import com.rojas.remy.game.model.Model;
import com.rojas.remy.game.objects.GameObject;

/**
 * Created by remy on 19/11/16.
 */
public class MovementThread extends Thread implements Runnable {

    GameObject o;

    Model model;

    public MovementThread(GameObject o){
       this.o = o;
    }

    @Override
    public void run() {
        while(o.getPosition().getxCoordinate()<500){
            o.move();
            model.notification();
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void setModel(Model m){
        model = m;
    }
}
