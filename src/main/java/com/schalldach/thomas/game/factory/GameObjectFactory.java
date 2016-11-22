package com.schalldach.thomas.game.factory;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by B.Sc. Thomas Schalldach on 17/11/2016. The code of this application is free to use for non-commercial projects,
 * as long as you ensure that you credit the author. For commercial usage, please contact software[at]thomas-schalldach.de
 */
public abstract class GameObjectFactory {

    private static final int INFO_X = 5;
    private static final int INFO_Y = 15;

    public static ConcreteFactory createEnemyFactory(){
        return new EnemyFactory();
    }

    public static CannonFactory createCannonFactory(){
        return new CannonFactory();
    }

    public static ConcreteFactory createMissileFactory(){
        return new MissileFactory();
    }

    public static ConcreteFactory createCollisionFactoy(){
        return new CollisionFactory();
    }

    public static ConcreteFactory createScoreFactoy(){
        return new ScoreFactory();
    }

    public static ConcreteFactory createGravityFactory(){
        return new GravityFactory();
    }

    public static ConcreteFactory createTimerFactory(){
        return new TimerFactory();
    }

}
