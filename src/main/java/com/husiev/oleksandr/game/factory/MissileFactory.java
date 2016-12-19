package com.husiev.oleksandr.game.factory;

import com.husiev.oleksandr.game.objects.Missile;
import com.husiev.oleksandr.game.objects.strategies.MovementStrategy;
import com.husiev.oleksandr.game.utils.APosition;
import com.husiev.oleksandr.game.objects.GameObject;

/**
 * Created by Oleksandr on 17.11.2016.
 */
public class MissileFactory extends ConcreteFactory {
    private MovementStrategy strategy;
    private int price;

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
        m.setPrice(price);
        return m;
    }

    public MovementStrategy getStrategy() {
        return strategy;
    }

    public void setStrategy(MovementStrategy strategy) {
        this.strategy = strategy;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
