package com.husiev.oleksandr.game.objects.strategies;

import com.husiev.oleksandr.game.utils.APosition;
import com.husiev.oleksandr.game.utils.TwoDimPosition;

import java.util.List;

/**
 * Created by Oleksandr on 19.11.2016.
 */
public class StraightShot extends MovementStrategy {

    public StraightShot(double speed){
        this.speed = speed;
    }

    @Override
    public APosition generateStep(APosition position) {
        List<Double> currentPosition = position.getVector();
        //Object[] currentPosition = new Double[2];
        //currentPosition  = (Double[])position.getVector().toArray();
        //currentPosition[0] = (Double)currentPosition[0]+speed*3;
        currentPosition.set(1,currentPosition.get(1)+speed);
        APosition newPosition = new TwoDimPosition();
        newPosition.addVector(currentPosition);
        return newPosition;
    }
}
