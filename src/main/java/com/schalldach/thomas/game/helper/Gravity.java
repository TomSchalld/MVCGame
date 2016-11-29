package com.schalldach.thomas.game.helper;

import com.schalldach.thomas.game.objects.IMoveDynamic;

import java.util.List;

/**
 * Created by B.Sc. Thomas Schalldach on 16/10/2016. The code of this application is free to use for non-commercial projects,
 * as long as you ensure that you credit the author. For commercial usage, please contact software[at]thomas-schalldach.de
 */
public class Gravity implements IMoveDynamic{
    @Override
    public void move(List<Integer> vector, int direction, double amount) {
        vector.set(0, vector.get(0)+1);
    }
}