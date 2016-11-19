package com.schalldach.thomas.game.objects;

import com.schalldach.thomas.game.strategy.Strategy;

/**
 * Created by B.Sc. Thomas Schalldach on 16/10/2016. The code of this application is free to use for non-commercial projects,
 * as long as you ensure that you credit the author. For commercial usage, please contact software[at]thomas-schalldach.de
 */
public class Missile extends GameObject {

    private Strategy strategy;

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void move(){
        //move accordingly to strategy
        this.getPosition().addVector(strategy.generateMovementVector(this.getPosition()));
        //System.out.println(this.getPosition().getVector());

    }

}
