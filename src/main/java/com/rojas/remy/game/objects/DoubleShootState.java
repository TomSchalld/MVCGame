package com.rojas.remy.game.objects;

import com.rojas.remy.game.model.Model;

/**
 * Created by remy on 07/12/16.
 */
public class DoubleShootState extends AbstractState {

    public DoubleShootState(Cannon c) {
        super(c);
    }

    @Override
    public void switchState() {

    }

    @Override
    public void shootState(Model m) {
        c.shoot(m);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        c.shoot(m);
    }
}
