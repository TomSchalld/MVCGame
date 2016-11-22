package com.schalldach.thomas.game.controler;

import com.schalldach.thomas.game.helper.TwoDimPosition;
import com.schalldach.thomas.game.model.Model;
import com.schalldach.thomas.game.objects.GameObject;
import com.schalldach.thomas.game.objects.Missile;

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
        try {
            while(true){
                o.move();
                model.notification();
                Thread.sleep(2);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void setModel(Model m){
        model = m;
    }
}
