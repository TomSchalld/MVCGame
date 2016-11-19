package com.schalldach.thomas.game.helper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by B.Sc. Thomas Schalldach on 16/10/2016. The code of this application is free to use for non-commercial projects,
 * as long as you ensure that you credit the author. For commercial usage, please contact software[at]thomas-schalldach.de
 */
public class TwoDimPosition extends APosition {


    //make sure position change doesnt violate window size

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




}
