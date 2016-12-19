package com.husiev.oleksandr.game.utils;

import java.util.ArrayList;
import java.util.List;

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
            if(Math.abs(vec.get(i)- coordinates.get(i))>15)
                return false;
        }
        return true;
    }

}
