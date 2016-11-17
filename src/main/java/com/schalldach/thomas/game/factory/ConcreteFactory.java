package com.schalldach.thomas.game.factory;

import com.schalldach.thomas.game.objects.GameObject;

import java.awt.*;

/**
 * Created by remy on 17/11/16.
 */
public abstract class ConcreteFactory {
    protected Image i;

    public abstract GameObject create();

    public void setImage(Image i){
        this.i=i;
    };
}
