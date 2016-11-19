package com.schalldach.thomas.game.helper;

import java.util.List;

/**
 * Created by B.Sc. Thomas Schalldach on 16/10/2016. The code of this application is free to use for non-commercial projects,
 * as long as you ensure that you credit the author. For commercial usage, please contact software[at]thomas-schalldach.de
 */
public class TwoDimPosition extends APosition{

    private float xCoordinate;
    private float yCoordinate;

    public TwoDimPosition() {
        this.xCoordinate = 0;
        this.yCoordinate= 0;
    }

    private void changePosition(float deltaX, float deltaY){
        //TODO make sure position change doesnt violate window size
        this.setxCoordinate(this.getxCoordinate()+deltaX);
        this.setyCoordinate(this.getyCoordinate()+deltaY);
    }

    private void updatePosition(float posX, float posY){
        //TODO make sure position change doesnt violate window size
        this.setxCoordinate(posX);
        this.setyCoordinate(posY);
    }

    public float getxCoordinate() {
        return xCoordinate;
    }

    public void setxCoordinate(float xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public float getyCoordinate() {
        return yCoordinate;
    }

    public void setyCoordinate(float yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    @Override
    public void addVector(List<Integer> dimension) {
        changePosition(dimension.get(0),dimension.get(1));
    }
}
