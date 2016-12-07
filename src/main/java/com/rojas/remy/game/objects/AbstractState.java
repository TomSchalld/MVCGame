package com.rojas.remy.game.objects;

import com.rojas.remy.game.model.Model;

/**
 * Created by remy on 06/12/16.
 */
public abstract class AbstractState {
    Cannon c;

    public AbstractState(Cannon c){
        this.c = c;
    }

    public abstract void switchState();

    public abstract void shootState(Model m);

}
