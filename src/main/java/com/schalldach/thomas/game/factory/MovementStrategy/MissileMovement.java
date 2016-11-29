package com.schalldach.thomas.game.factory.MovementStrategy;

import com.schalldach.thomas.game.helper.APosition;
import com.schalldach.thomas.game.helper.TwoDimPosition;
import com.schalldach.thomas.game.model.Model;
import com.schalldach.thomas.game.objects.GameObject;
import com.schalldach.thomas.game.objects.Missile;

import java.util.List;

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

