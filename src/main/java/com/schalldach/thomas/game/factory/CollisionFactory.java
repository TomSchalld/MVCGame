package com.schalldach.thomas.game.factory;

import com.schalldach.thomas.game.objects.Collision;
import com.schalldach.thomas.game.objects.GameObject;

/**
 * Created by B.Sc. Thomas Schalldach on 17/11/2016. The code of this application is free to use for non-commercial projects,
 * as long as you ensure that you credit the author. For commercial usage, please contact software[at]thomas-schalldach.de
 */
public class CollisionFactory implements ConcreteFactory {
    @Override
    public GameObject create() {
        return new Collision();
    }
}
