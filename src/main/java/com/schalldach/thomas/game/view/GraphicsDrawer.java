package com.schalldach.thomas.game.view;

import cz.fit.dpo.mvcshooter.Cannon;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author Ondrej Stuchlik
 */
public class GraphicsDrawer {
    private static final int INFO_X = 5;
    private static final int INFO_Y = 15;

    private BufferedImage cannonImage;
    private BufferedImage enemyImage1;
    private BufferedImage enemyImage2;
    private BufferedImage missileImage;
    private BufferedImage collisionImage;


    public GraphicsDrawer() {
        try {
            cannonImage = ImageIO.read(getClass().getResourceAsStream("/images/cannon.png"));
            enemyImage1 = ImageIO.read(getClass().getResourceAsStream("/images/enemy1.png"));
            enemyImage2 = ImageIO.read(getClass().getResourceAsStream("/images/enemy2.png"));
            missileImage = ImageIO.read(getClass().getResourceAsStream("/images/missile.png"));
            collisionImage = ImageIO.read(getClass().getResourceAsStream("/images/collision.png"));
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        }
    }


    public void drawCannon(Graphics g, Cannon cannon) {
        g.drawImage(cannonImage,
                cannon.getX() - cannonImage.getWidth() / 2,
                cannon.getY() - cannonImage.getHeight() / 2, null);
    }

    public void drawMissile(Graphics g, Missile missile) {

    }

    public void drawEnemy(Graphics g, Enemy enemy) {

    }

    public void drawCollision(Graphics g, Collision collision) {

    }

    public void drawInfo(Graphics g, ModelInfo info) {

    }


    // fake classes just to satisfy compilator
    class Missile {
    }

    class Collision {
    }

    class Enemy {
    }

    class ModelInfo {
    }

}