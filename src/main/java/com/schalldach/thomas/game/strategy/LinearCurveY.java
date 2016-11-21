package com.schalldach.thomas.game.strategy;

import com.schalldach.thomas.game.helper.APosition;
import com.schalldach.thomas.game.helper.TwoDimPosition;

import java.util.Arrays;

/**
 * Created by B.Sc. Thomas Schalldach, on 21/11/2016.
 * The code contained by this file or application may be used for non-commercial purpose,
 * under the condition of crediting the author.
 * For commercial use, please contact software@thomas-schalldach.de
 */
public class LinearCurveY extends Strategy {
    @Override
    public APosition generateMovementVector(APosition pos) {
        Double[] position = new Double[2];
        pos.getVector().toArray(position);
        position[1] += this.SPEED;
        APosition p = new TwoDimPosition();
        p.addVector(Arrays.asList(position));
        return p;
    }
}
