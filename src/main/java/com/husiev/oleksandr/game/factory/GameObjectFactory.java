package com.husiev.oleksandr.game.factory;


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
