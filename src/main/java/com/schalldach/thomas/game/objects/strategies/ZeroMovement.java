package com.schalldach.thomas.game.objects.strategies;

import com.schalldach.thomas.game.utils.APosition;

/**
 * Created by Oleksandr on 19.11.2016.
 */
public class ZeroMovement extends MovementStrategy {
    @Override
    public APosition generateStep(APosition position) {
        return position;
    }
}
