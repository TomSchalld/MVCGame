package com.schalldach.thomas.game.factory;

import com.schalldach.thomas.game.helper.APosition;
import com.schalldach.thomas.game.objects.GameObject;

import java.awt.image.BufferedImage;

/**
 * Created by B.Sc. Thomas Schalldach on 17/11/2016. The code of this application is free to use for non-commercial projects,
 * as long as you ensure that you credit the author. For commercial usage, please contact software[at]thomas-schalldach.de
 */
public abstract class ConcreteFactory {

    private APosition initialPosition;

    protected BufferedImage image;

    public APosition getInitialPosition() {
        return initialPosition;
    }

    public void setInitialPosition(APosition initialPosition) {
        this.initialPosition = initialPosition;
    }

    public BufferedImage getImage() {
        return image;
    }

    public abstract GameObject create();
}
