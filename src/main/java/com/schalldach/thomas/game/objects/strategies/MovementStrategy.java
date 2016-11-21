package com.schalldach.thomas.game.objects.strategies;

import com.schalldach.thomas.game.utils.APosition;

import java.util.List;

/**
 * Created by Oleksandr on 19.11.2016.
 */
public abstract class MovementStrategy {
    protected double speed;

    public abstract APosition generateStep(APosition position);
}
