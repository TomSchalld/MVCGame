package com.husiev.oleksandr.game.view;

import com.husiev.oleksandr.game.controller.IVisitor;
import com.husiev.oleksandr.game.utils.TwoDimPosition;
import com.husiev.oleksandr.game.objects.GameObject;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 *
 * @author Ondrej Stuchlik
 */
public class GraphicsDrawer{

    Graphics g;


    public void drawGameObject(Graphics g, GameObject gameObject) {
        TwoDimPosition position = (TwoDimPosition) gameObject.getPosition();
        BufferedImage img = gameObject.getImage();
        g.drawImage(img,
                (int)position.getxCoordinate() - img.getWidth()/2,
                (int)position.getyCoordinate() - img.getHeight()/2, null);
    }



}
