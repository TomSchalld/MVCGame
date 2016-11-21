package com.schalldach.thomas.game.factory;

import com.schalldach.thomas.game.objects.Cannon;
import com.schalldach.thomas.game.objects.GameObject;

/**
 * Created by B.Sc. Thomas Schalldach on 17/11/2016. The code of this application is free to use for non-commercial projects,
 * as long as you ensure that you credit the author. For commercial usage, please contact software[at]thomas-schalldach.de
 */
public abstract class GameObjectFactory {

    public static ConcreteFactory createCannonFactory(){
        return new CannonFactory();
    }

    public  static ConcreteFactory createCollisionFactory(){
        return new CollisionFactory();
    }

    public  static ConcreteFactory createEnemyFactory(){
        return new EnemyFactory();
    }

    public  static ConcreteFactory createMissileFactory(){
        return new MissileFactory();
    }
}
