package com.schalldach.thomas.game.model;

import com.schalldach.thomas.game.helper.APosition;
import com.schalldach.thomas.game.helper.TwoDimPosition;

import java.util.List;

/**
 * Factories Configuration
 * Created by remy on 19/11/16.
 */
public class Config {

    //images
    public static String ENEMY_IMAGE1 = "/images/enemy1.png";
    public static String ENEMY_IMAGE2 = "/images/enemy2.png";
    public static String CANNON_IMAGE = "/images/cannon.png";
    public static String MISSILE_IMAGE = "/images/missile.png";
    public static String COLLISION_IMAGE = "/images/collision.png";

    public static APosition CANNON_INIT_POS = new TwoDimPosition(40,40);

}