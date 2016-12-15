package com.rojas.remy.game.objects;

import com.rojas.remy.game.model.Model;

/**
 * Created by remy on 06/12/16.
 */
public abstract class AbstractShootState {
    Cannon c;

    public AbstractShootState(Cannon c){
        this.c = c;
    }

    public void switchState(){
        c.nextState();
    };

    public abstract void shootState(Model m);

}
