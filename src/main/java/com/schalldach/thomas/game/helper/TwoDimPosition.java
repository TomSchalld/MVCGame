package com.schalldach.thomas.game.helper;

import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.List;

/**
 * Created by B.Sc. Thomas Schalldach on 16/10/2016. The code of this application is free to use for non-commercial projects,
 * as long as you ensure that you credit the author. For commercial usage, please contact software[at]thomas-schalldach.de
 */
public class TwoDimPosition extends APosition {


    private double xCoordinate;
    private double yCoordinate;

    public TwoDimPosition() {
        this.xCoordinate = 0.0;
        this.yCoordinate = 0.0;
    }

    private void changePosition(double deltaX, double deltaY) {
        //make sure position change doesnt violate window size
        this.setxCoordinate(this.getxCoordinate() + deltaX);
        this.setyCoordinate(this.getyCoordinate() + deltaY);
    }

    public double getxCoordinate() {
        return xCoordinate;
    }

    public void setxCoordinate(double xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public double getyCoordinate() {
        return yCoordinate;
    }

    public void setyCoordinate(double yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public List<Double> getVector(){
        return Arrays.asList(getxCoordinate(),getyCoordinate());
    }

    @Override
    public void addVector(List<Double> dimension) {
        changePosition(dimension.get(0),dimension.get(1));

    }
}
