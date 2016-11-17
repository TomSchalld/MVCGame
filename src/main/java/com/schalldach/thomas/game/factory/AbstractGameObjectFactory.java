package com.schalldach.thomas.game.factory;

/**
 * Created by B.Sc. Thomas Schalldach on 17/11/2016. The code of this application is free to use for non-commercial projects,
 * as long as you ensure that you credit the author. For commercial usage, please contact software[at]thomas-schalldach.de
 */
public abstract class AbstractGameObjectFactory {


    public static ConcreteFactory createCannonFactory() {
        return new CannonFactory();
    }

    public static ConcreteFactory createCollisionFactory() {
        return new CollisionFactory();
    }

    public static ConcreteFactory createMissileFactory() {
        return new MissileFactory();
    }

    public static ConcreteFactory createEnemyFactory() {
        return new EnemyFactory();
    }




}
