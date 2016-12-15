package com.rojas.remy.game.factory.MovementStrategy;

import com.rojas.remy.game.objects.GameObject;
import com.rojas.remy.game.helper.TwoDimPosition;

import java.util.Random;

/**
 * Created by remy on 22/11/16.
 */
public class EnemyMovement implements MovementStrategy {
    @Override
    public void move(GameObject o) {
        switch(new Random().nextInt(8)){
            case 0: if(o.getPosition().getxCoordinate()<500) o.setPosition(new TwoDimPosition(o.getPosition().getxCoordinate()+1,o.getPosition().getyCoordinate()));
                break;
            case 1: if(o.getPosition().getxCoordinate()>100) o.setPosition(new TwoDimPosition(o.getPosition().getxCoordinate()-1,o.getPosition().getyCoordinate()));
                break;
            case 2: if(o.getPosition().getyCoordinate()<500) o.setPosition(new TwoDimPosition(o.getPosition().getxCoordinate(),o.getPosition().getyCoordinate()+1));
                break;
            case 3: if(o.getPosition().getyCoordinate()>0) o.setPosition(new TwoDimPosition(o.getPosition().getxCoordinate(),o.getPosition().getyCoordinate()-1));
                break;
            default: if(o.getPosition().getxCoordinate()>100) o.setPosition(new TwoDimPosition(o.getPosition().getxCoordinate()-1,o.getPosition().getyCoordinate()));
                break;
        };
    }

}
