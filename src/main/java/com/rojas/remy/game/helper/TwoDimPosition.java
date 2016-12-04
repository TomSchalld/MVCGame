package com.rojas.remy.game.helper;

import java.util.List;

/**
 * Created by B.Sc. Thomas Schalldach on 16/10/2016. The code of this application is free to use for non-commercial projects,
 * as long as you ensure that you credit the author. For commercial usage, please contact software[at]thomas-schalldach.de
 */
public class TwoDimPosition extends APosition{

    private int xCoordinate;
    private int yCoordinate;

    public TwoDimPosition() {
        this.xCoordinate = 0;
        this.yCoordinate= 0;
    }

    public TwoDimPosition(int x, int y){
        this.xCoordinate=x;
        this.yCoordinate=y;
    }

    private void changePosition(int deltaX, int deltaY){
        //TODO make sure position change doesnt violate window size
        this.setxCoordinate(this.getxCoordinate()+deltaX);
        this.setyCoordinate(this.getyCoordinate()+deltaY);
    }

    private void updatePosition(int posX, int posY){
        //TODO make sure position change doesnt violate window size
        this.setxCoordinate(posX);
        this.setyCoordinate(posY);
    }

    public int getxCoordinate() {
        return xCoordinate;
    }

    public void setxCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public int getyCoordinate() {
        return yCoordinate;
    }

    public void setyCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    @Override
    public void addVector(List<Integer> dimension) {
        changePosition(dimension.get(0),dimension.get(1));
    }
}
