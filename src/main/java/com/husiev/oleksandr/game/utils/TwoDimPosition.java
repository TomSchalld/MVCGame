package com.husiev.oleksandr.game.utils;

import java.util.ArrayList;
import java.util.Arrays;

public class TwoDimPosition extends APosition{

    //make sure position change doesnt violate window size

    public TwoDimPosition() {
        super();
        coordinates = new ArrayList<Double>();
        coordinates.addAll(Arrays.asList(0.,0.));
    }

    public TwoDimPosition(TwoDimPosition position) {
        super();
        coordinates = new ArrayList<>();
        coordinates.addAll(position.coordinates);
    }

    public TwoDimPosition(double x, double y) {
        super();
        coordinates = new ArrayList<Double>();
        coordinates.addAll(Arrays.asList(0.,0.));
        coordinates.set(0,x);
        coordinates.set(1,y);
    }


    public void updatePosition(double deltaX, double deltaY){
        coordinates.set(0,coordinates.get(0)+deltaX);
        coordinates.set(1,coordinates.get(1)+deltaY);
    }
    public double getxCoordinate() {
        return coordinates.get(1);
    }

    public double getyCoordinate() {
        return coordinates.get(0);
    }

    public APosition getPosition(){
        return new TwoDimPosition(this);
    }
}
