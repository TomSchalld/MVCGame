package com.schalldach.thomas.game.factory;

import com.schalldach.thomas.game.factory.MovementStrategy.MovementStrategy;
import com.schalldach.thomas.game.helper.APosition;
import com.schalldach.thomas.game.model.Config;
import com.schalldach.thomas.game.objects.GameObject;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by remy on 17/11/16.
 */
public abstract class ConcreteFactory {
    protected BufferedImage i;

    protected boolean drawable;

    protected MovementStrategy movement;

    protected APosition initPosition;

    public abstract GameObject create();

    public void setImage(String i){
        try {
            this.i = ImageIO.read(getClass().getResourceAsStream(i));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setInitPosition(APosition p){
        initPosition = p;
    }

    public void setDrawable(boolean drawable) {
        this.drawable = drawable;
    }

    public MovementStrategy getMovement() {
        return movement;
    }

    public void setMovement(MovementStrategy movement) {
        this.movement = movement;
    }
}
