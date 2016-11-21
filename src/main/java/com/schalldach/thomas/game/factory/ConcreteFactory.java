package com.schalldach.thomas.game.factory;

import com.schalldach.thomas.game.utils.APosition;
import com.schalldach.thomas.game.objects.GameObject;

import java.awt.image.BufferedImage;

/**
 * Created by Oleksandr on 17.11.2016.
 */
public abstract class ConcreteFactory {


    BufferedImage image;
    APosition initialPosition;

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public GameObject create(){
        return null;
    };

    public APosition getInitialPosition() {
        return initialPosition;
    }

    public void setInitialPosition(APosition initialPosition) {
        this.initialPosition = initialPosition;
    }
}
