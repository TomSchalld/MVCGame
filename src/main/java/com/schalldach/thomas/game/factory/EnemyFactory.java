package com.schalldach.thomas.game.factory;

import com.schalldach.thomas.game.controler.MovementThread;
import com.schalldach.thomas.game.helper.TwoDimPosition;
import com.schalldach.thomas.game.model.Model;
import com.schalldach.thomas.game.objects.Enemy;
import com.schalldach.thomas.game.objects.GameObject;

import java.awt.*;
import java.util.Random;

/**
 * Created by remy on 17/11/16.
 */
public class EnemyFactory extends ConcreteFactory {

    Model model;

    @Override
    public GameObject create() {
        Enemy e = new Enemy();
        e.setDrawable(drawable);
        e.setMovement(movement);
        e.setPosition(new TwoDimPosition(new Random().nextInt(500),new Random().nextInt(500)));
        e.setImage(i);
        //MovementThread mov = new MovementThread(e);
        //mov.setModel(model);
        //mov.start();
        return e;
    }

    public void setModel(Model model){
        this.model = model;
    }
}
