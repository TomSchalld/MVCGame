package com.schalldach.thomas.game.view;

import com.schalldach.thomas.game.objects.GameObject;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.*;

/**
 *
 * @author Ondrej Stuchlik
 */
public class GraphicsDrawer{

    public void drawObjects(Graphics g, java.util.ArrayList<GameObject> objects) {
        for(GameObject obj : objects){
            g.drawImage(
                obj.getImage(),
                (obj.getPosition().getxCoordinate() - obj.getImage().getWidth()/2),
                (obj.getPosition().getyCoordinate() - obj.getImage().getHeight()/2),
                null);
        }
    }
}
