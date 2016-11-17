package com.schalldach.thomas.game.factory;

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
        try {
            setImage(ImageIO.read(getClass().getResourceAsStream("/images/cannon.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //TODO implement get/setters
        return c;
    }



}
