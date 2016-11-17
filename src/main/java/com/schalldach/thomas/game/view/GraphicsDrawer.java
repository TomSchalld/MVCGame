package com.schalldach.thomas.game.view;

import com.schalldach.thomas.game.controler.IGameObjectVisitor;
import com.schalldach.thomas.game.objects.GameObject;
import cz.fit.dpo.mvcshooter.Cannon;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 *
 * @author Ondrej Stuchlik
 */
public class GraphicsDrawer implements IGameObjectVisitor{


    public void drawObject(Graphics g, GameObject obj) {
        g.drawImage(obj.getImage(),
              obj.getPosition().getxCoordinate() - obj.getImage().getWidth()/2,
              obj.getPosition().getyCoordinate() - obj.getImage().getHeight()/2, null);
    }
}
