package com.schalldach.thomas.game.factory;

import com.schalldach.thomas.game.utils.TwoDimPosition;
import com.schalldach.thomas.game.objects.Cannon;
import com.schalldach.thomas.game.objects.GameObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Oleksandr on 17.11.2016.
 */
public class CannonFactory extends ConcreteFactory{

    @Override
    public GameObject create() {
        Cannon cannon = new Cannon(image);
        List<Double> posVector = new ArrayList<Double>();
        posVector.add(100.);
        posVector.add(100.);
        initialPosition.addVector(posVector);
        cannon.changePosition(initialPosition);
        return cannon;
    }

}
