package com.husiev.oleksandr.game.factory;

import com.husiev.oleksandr.game.objects.Cannon;
import com.husiev.oleksandr.game.objects.GameObject;

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
