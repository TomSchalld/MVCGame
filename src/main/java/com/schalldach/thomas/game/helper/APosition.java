package com.schalldach.thomas.game.helper;

import java.util.List;

/**
 * Created by B.Sc. Thomas Schalldach on 08/11/2016. The code of this application is free to use for non-commercial projects,
 * as long as you ensure that you credit the author. For commercial usage, please contact software[at]thomas-schalldach.de
 */
public abstract class APosition {

    protected List<Double> coordinates;

    public void addVector(List<Double> dimension) {
        coordinates.clear();
        coordinates.addAll(dimension);
    }

    public void addVector(APosition position){
        this.addVector(position.coordinates);

    }

    @Override
    public boolean equals(Object obj) {

        return super.equals(obj);
    }

    public List<Double> getVector() {
        return this.coordinates;
    }



}
