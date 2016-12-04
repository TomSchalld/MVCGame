package com.rojas.remy.game.objects;

import java.util.List;

/**
 * Created by remy on 17/11/16.
 */
public interface IMoveDynamic {
    public void move(List<Integer> vector, int direction, double amount);
}
