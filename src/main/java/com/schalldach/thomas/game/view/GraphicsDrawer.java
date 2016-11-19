package com.schalldach.thomas.game.view;

import com.schalldach.thomas.game.objects.GameObject;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 *
 * @author Ondrej Stuchlik
 */
public class GraphicsDrawer{

    public void drawObject(Graphics g, GameObject obj) {
        g.drawImage(
                obj.getImage(),
                (int)(obj.getPosition().getxCoordinate() - obj.getImage().getWidth()/2),
                (int)(obj.getPosition().getyCoordinate() - obj.getImage().getHeight()/2),
                null);
    }
}
