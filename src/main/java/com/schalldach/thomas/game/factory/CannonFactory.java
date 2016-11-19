package com.schalldach.thomas.game.factory;

import com.schalldach.thomas.game.model.Config;
import com.schalldach.thomas.game.objects.Cannon;
import com.schalldach.thomas.game.objects.GameObject;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by remy on 17/11/16.
 */
public class CannonFactory extends ConcreteFactory{

    @Override
    public GameObject create() {
        Cannon c = new Cannon();
        c.setImage(i);
        c.setDrawable(drawable);
        return c;
    }
}
