package com.rojas.remy.game.objects;

/**
 * Created by remy on 16/12/16.
 */
public class Brick extends GameObject {
    private int health;

    public Brick(int health){
        this.health = health;
    }

    public void takeDamage(int amount){
        if(health>0) health-=amount;
        else drawable = false;
    }

}
