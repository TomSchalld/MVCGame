package com.schalldach.thomas.game.strategy;

import com.schalldach.thomas.game.helper.APosition;
import com.schalldach.thomas.game.helper.TwoDimPosition;

import java.util.Arrays;

/**
 * Created by B.Sc. Thomas Schalldach on 19/11/2016. The code of this application is free to use for non-commercial projects,
 * as long as you ensure that you credit the author. For commercial usage, please contact software[at]thomas-schalldach.de
 */
public class LinearCurveX extends Strategy {


    @Override
    public APosition generateMovementVector(APosition pos) {
        Double[] position = new Double[2];
        pos.getVector().toArray(position);
        position[0] += this.SPEED;
        APosition p = new TwoDimPosition();
        p.addVector(Arrays.asList(position));
        return p;
    }
}
