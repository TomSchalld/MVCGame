package com.rojas.remy.game.factory;

import com.rojas.remy.game.factory.MovementStrategy.MissileMovement;
import com.rojas.remy.game.helper.TwoDimPosition;
import com.rojas.remy.game.model.Model;
import com.rojas.remy.game.objects.GameObject;
import com.rojas.remy.game.objects.Missile;

/**
 * Created by remy on 17/11/16.
 */
public class MissileFactory extends ConcreteFactory {

    Model model;

    @Override
    public GameObject create() {
        Missile m = new Missile();
        return m;
    }

    public GameObject create(TwoDimPosition p){
        Missile m = new Missile();
        m.setPosition(p);
        m.setMovement(new MissileMovement());
        m.setImage(this.i);
        m.setDrawable(this.drawable);
        //MovementThread mt = new MovementThread(m);
        //mt.setModel(model);
        //mt.start();
        return m;
    }

    public void setModel(Model model){
        this.model = model;
    }

}