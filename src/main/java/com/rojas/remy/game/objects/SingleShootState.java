package com.rojas.remy.game.objects;

import com.rojas.remy.game.model.Model;

/**
 * Created by remy on 06/12/16.
 */
public class SingleShootState extends AbstractShootState {
    public SingleShootState(Cannon c) {
        super(c);
    }

    @Override
    public void shootState(Model m) {
        c.shoot(m);
    }
}