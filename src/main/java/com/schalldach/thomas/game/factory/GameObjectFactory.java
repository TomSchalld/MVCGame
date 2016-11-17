package com.schalldach.thomas.game.factory;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by B.Sc. Thomas Schalldach on 17/11/2016. The code of this application is free to use for non-commercial projects,
 * as long as you ensure that you credit the author. For commercial usage, please contact software[at]thomas-schalldach.de
 */
public abstract class GameObjectFactory {

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

    public static ConcreteFactory createEnemyFactory(){
        return new EnemyFactory();
    }

    public static CannonFactory createCannonFactory(){
        return new CannonFactory();
    }

    public static ConcreteFactory createMissileFactory(){
        return new MissileFactory();
    }

    public static ConcreteFactory createCollisionFactoy(){
        return new CollisionFactory();
    }

    public static ConcreteFactory createScoreFactoy(){
        return new ScoreFactory();
    }

    public static ConcreteFactory createGravityFactory(){
        return new GravityFactory();
    }

    public static ConcreteFactory createTimerFactory(){
        return new TimerFactory();
    }

}
