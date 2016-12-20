package com.schalldach.thomas.game.objects;

import com.schalldach.thomas.game.strategy.Strategy;

/**
 * Created by B.Sc. Thomas Schalldach on 16/10/2016. The code of this application is free to use for non-commercial projects,
 * as long as you ensure that you credit the author. For commercial usage, please contact software[at]thomas-schalldach.de
 */
public class Missile extends GameObject {

    private Strategy strategy;

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void move(){
        //move accordingly to strategy
        try {
            this.getPosition().addVector(strategy.generateMovementVector(this.getPosition()));
        } catch (NullPointerException e) {
        }

    }
    @Override
    public Missile clone() throws CloneNotSupportedException {
        Missile clone = new Missile();
        clone.setImage(this.image);
        clone.position.addVector(this.position.getVector());
        return clone;
    }

}
