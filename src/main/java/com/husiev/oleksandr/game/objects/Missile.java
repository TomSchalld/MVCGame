package com.husiev.oleksandr.game.objects;

import com.husiev.oleksandr.game.objects.strategies.MovementStrategy;

public class Missile extends GameObject {
    MovementStrategy movement;
    private int price;

    public void moveMissile() {
        this.move(movement.generateStep(this.getPosition()));
    }

    public void setMovement(MovementStrategy movement) {
        this.movement = movement;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
