package com.schalldach.thomas.game.objects;

import com.schalldach.thomas.game.helper.APosition;
import com.schalldach.thomas.game.helper.TwoDimPosition;

import java.awt.*;
import java.util.Arrays;

/**
 * Created by B.Sc. Thomas Schalldach on 16/10/2016. The code of this application is free to use for non-commercial projects,
 * as long as you ensure that you credit the author. For commercial usage, please contact software[at]thomas-schalldach.de
 */
public abstract class GameObject {
    protected APosition position;
    protected Image image;


    public GameObject() {
        this.position = new TwoDimPosition();
    }

    public void move() {
        Integer vector[] = new Integer[]{1, 2};
        position.addVector(Arrays.asList(vector));
    }

    public APosition getPosition() {
        return position;
    }

    public void setPosition(APosition position) {
        this.position = position;
    }

}
