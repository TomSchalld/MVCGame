package com.schalldach.thomas.game.objects;

import com.schalldach.thomas.game.strategy.Strategy;

/**
 * Created by B.Sc. Thomas Schalldach on 16/10/2016. The code of this application is free to use for non-commercial projects,
 * as long as you ensure that you credit the author. For commercial usage, please contact software[at]thomas-schalldach.de
 */
public class Enemy extends GameObject {


    private Strategy movementStrategy;


    public Strategy getMovementStrategy() {
        return movementStrategy;
    }

    public void setMovementStrategy(Strategy movementStrategy) {
        this.movementStrategy = movementStrategy;
    }

    public void move() {
        //move accordingly to strategy
        this.getPosition().addVector(movementStrategy.generateMovementVector(this.getPosition()));
        // System.out.println(this.getPosition().getVector());

    }

    @Override
    public Enemy clone() throws CloneNotSupportedException {
        Enemy clone = new Enemy();
        clone.setMovementStrategy(this.movementStrategy);
        clone.setImage(this.image);
        clone.position.addVector(this.position.getVector());
        return clone;
    }
}
