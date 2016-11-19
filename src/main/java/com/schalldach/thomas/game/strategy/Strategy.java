package com.schalldach.thomas.game.strategy;

import com.schalldach.thomas.game.helper.APosition;

import java.util.List;

/**
 * Created by B.Sc. Thomas Schalldach on 19/11/2016. The code of this application is free to use for non-commercial projects,
 * as long as you ensure that you credit the author. For commercial usage, please contact software[at]thomas-schalldach.de
 */
public abstract class Strategy {

    protected final int SPEED = 30;

    public abstract APosition generateMovementVector(APosition pos);

}
