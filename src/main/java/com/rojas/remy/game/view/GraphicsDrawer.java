package com.rojas.remy.game.view;

import com.rojas.remy.game.objects.GameObject;

import java.awt.*;
import java.util.*;

/**
 *
 * @author Ondrej Stuchlik
 */
public class GraphicsDrawer{

    public void drawObjects(Graphics g, java.util.ArrayList<GameObject> objects) {
        Iterator<GameObject> oi = objects.iterator();
        while(oi.hasNext()){
            GameObject obj = oi.next();
            g.drawImage(
                obj.getImage(),
                (obj.getPosition().getxCoordinate() - obj.getImage().getWidth()/2),
                (obj.getPosition().getyCoordinate() - obj.getImage().getHeight()/2),
                null);
        }
    }

    public void drawObject(Graphics g, GameObject obj) {
        g.drawImage(
                obj.getImage(),
                (obj.getPosition().getxCoordinate() - obj.getImage().getWidth()/2),
                (obj.getPosition().getyCoordinate() - obj.getImage().getHeight()/2),
                null);
    }
}
