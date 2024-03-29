package com.schalldach.thomas.game.strategy;

import com.schalldach.thomas.game.helper.APosition;

/**
 * Created by B.Sc. Thomas Schalldach on 19/11/2016. The code of this application is free to use for non-commercial projects,
 * as long as you ensure that you credit the author. For commercial usage, please contact software[at]thomas-schalldach.de
 */
public abstract class Strategy {

    double SPEED = 30;

    public void setSPEED(double SPEED) {
        this.SPEED = SPEED;
    }

    public abstract APosition generateMovementVector(APosition pos);

}
