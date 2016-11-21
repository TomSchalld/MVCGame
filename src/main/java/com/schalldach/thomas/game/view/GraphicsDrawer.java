package com.schalldach.thomas.game.view;

import com.schalldach.thomas.game.utils.TwoDimPosition;
import com.schalldach.thomas.game.objects.GameObject;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 *
 * @author Ondrej Stuchlik
 */
public class GraphicsDrawer{

    public void drawGameObject(Graphics g, GameObject gameObject) {
        TwoDimPosition position = (TwoDimPosition) gameObject.getPosition();
        BufferedImage img = gameObject.getImage();
        g.drawImage(img,
                (int)position.getxCoordinate() - img.getWidth()/2,
                (int)position.getyCoordinate() - img.getHeight()/2, null);
    }

}
