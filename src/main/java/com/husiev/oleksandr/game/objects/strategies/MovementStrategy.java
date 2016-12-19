package com.husiev.oleksandr.game.objects.strategies;

import com.husiev.oleksandr.game.utils.APosition;

/**
 * Created by Oleksandr on 19.11.2016.
 */
public abstract class MovementStrategy {
    protected double speed;

    public abstract APosition generateStep(APosition position);
}
