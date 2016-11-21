package com.schalldach.thomas.game.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by B.Sc. Thomas Schalldach on 08/11/2016. The code of this application is free to use for non-commercial projects,
 * as long as you ensure that you credit the author. For commercial usage, please contact software[at]thomas-schalldach.de
 */
public abstract class APosition {
    protected List<Double> coordinates;

    public void addVector(List<Double> dim){
        List<Double> newCors = new ArrayList<>(dim);
        coordinates.clear();
        coordinates.addAll(newCors);
        //dimension.forEach(el -> coordinates.add(el));
    }

    public void addVector(APosition dimension){
        this.addVector(dimension.coordinates);
    }


    public List<Double> getVector(){
        return new ArrayList<Double>(coordinates);
    }

    public boolean equals(APosition position){
        List<Double> vec = position.getVector();
        for(int i=0;i<vec.size();i++){
            if(Math.abs(vec.get(i)- coordinates.get(i))>10)
                return false;
        }
        return true;
    }

}
