package com.rojas.remy.game.factory.MovementStrategy;

import com.rojas.remy.game.helper.TwoDimPosition;
import com.rojas.remy.game.objects.GameObject;

/**
 * Created by remy on 07/12/16.
 */
public class GravityMovementStrategy implements MovementStrategy {
    private TwoDimPosition speed;
    private int gravity;

    public GravityMovementStrategy(){
        gravity = 1;
        speed = new TwoDimPosition(5,-10);
    }

    @Override
    public void move(GameObject o) {
        if(o.getPosition().getxCoordinate()>=500 ||
                o.getPosition().getyCoordinate()>=500 ||
                o.getPosition().getyCoordinate()<0 ||
                o.getPosition().getxCoordinate()<0)
            o.setDrawable(false);
        else {
            speed.setyCoordinate(speed.getyCoordinate()+gravity);
            o.setPosition(new TwoDimPosition(o.getPosition().getxCoordinate()+speed.getxCoordinate(),o.getPosition().getyCoordinate()+ speed.getyCoordinate()));
        }
    }
}
