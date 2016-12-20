package com.schalldach.thomas.game.helper;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by B.Sc. Thomas Schalldach on 16/10/2016. The code of this application is free to use for non-commercial projects,
 * as long as you ensure that you credit the author. For commercial usage, please contact software[at]thomas-schalldach.de
 */
public class TwoDimPosition extends APosition {


    //make sure position change doesnt violate window size .... done!

    public TwoDimPosition() {
        super();
        this.coordinates = new ArrayList<>(2);
        this.coordinates.addAll(Arrays.asList(0.0,0.0));
    }


    public double getxCoordinate() {
        return this.coordinates.get(0);
    }


    public double getyCoordinate() {
        return this.coordinates.get(1);
    }


    @Override
    public boolean equals(Object obj) {

        TwoDimPosition pos;

        if (obj instanceof TwoDimPosition){
            pos = (TwoDimPosition)obj;
        }else {
            System.err.println("DAFUQ!!!");
            return false;
        }

        if (this.getxCoordinate() - pos.getxCoordinate() < 50 && this.getxCoordinate() - pos.getxCoordinate()>0) {
            if (this.getyCoordinate() - pos.getyCoordinate() < 50 && this.getyCoordinate() - pos.getyCoordinate() > 0) {
                return true;
            }
        }

       return false;
    }
}
