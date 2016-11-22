package com.schalldach.thomas.game.factory.MovementStrategy;

import com.schalldach.thomas.game.helper.APosition;
import com.schalldach.thomas.game.helper.TwoDimPosition;
import com.schalldach.thomas.game.objects.GameObject;


/**
 * Created by remy on 19/11/16.
 */
public interface MovementStrategy {
    public void move(GameObject o);
}
