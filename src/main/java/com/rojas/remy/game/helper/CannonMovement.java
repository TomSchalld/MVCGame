package com.rojas.remy.game.helper;

import com.rojas.remy.game.objects.IMoveDynamic;

import java.util.List;

/**
 * Created by remy on 17/11/16.
 */
public class CannonMovement implements IMoveDynamic {
    @Override
    public void move(List<Integer> vector, int direction, double amount) {
        vector.set(1, (int) (vector.get(1)+direction*amount));
    }
}
