package com.rojas.remy.game.factory.MovementStrategy;

import com.rojas.remy.game.objects.GameObject;
import com.rojas.remy.game.helper.TwoDimPosition;

/**
 * Created by remy on 19/11/16.
 */
public class MissileMovement implements MovementStrategy {

    @Override
    public void move(GameObject m) {
        if(m.getPosition().getxCoordinate()>=500 ||
                m.getPosition().getyCoordinate()>=500 ||
                m.getPosition().getyCoordinate()<0 ||
                m.getPosition().getxCoordinate()<0)
            m.setDrawable(false);
        else
            m.setPosition(new TwoDimPosition(m.getPosition().getxCoordinate()+1,m.getPosition().getyCoordinate()));
    }

}

