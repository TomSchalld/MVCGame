package com.rojas.remy.game.factory.MovementStrategy;

/**
 * Created by remy on 15/12/16.
 */
public class GravityMovementFactory extends MovementStrategyFactory {
    @Override
    public MovementStrategy create() {
        return new GravityMovementStrategy();
    }
}
