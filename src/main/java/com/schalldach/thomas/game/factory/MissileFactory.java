package com.schalldach.thomas.game.factory;

import com.schalldach.thomas.game.objects.GameObject;
import com.schalldach.thomas.game.objects.Missile;
import com.schalldach.thomas.game.objects.strategies.MovementStrategy;
import com.schalldach.thomas.game.utils.APosition;

/**
 * Created by Oleksandr on 17.11.2016.
 */
public class MissileFactory extends ConcreteFactory {
    private MovementStrategy strategy;

    @Override
    public GameObject create() {
        Missile m = initMissile();
        return m;
    }

    public GameObject create(APosition position) {
        Missile m = initMissile();
        m.changePosition(position);
        return m;
    }

    public Missile initMissile(){
        Missile m = new Missile();
        m.setImage(image);
        m.setMovement(strategy);
        return m;
    }

    public MovementStrategy getStrategy() {
        return strategy;
    }

    public void setStrategy(MovementStrategy strategy) {
        this.strategy = strategy;
    }
}
