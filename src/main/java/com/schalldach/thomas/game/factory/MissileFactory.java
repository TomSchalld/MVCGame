package com.schalldach.thomas.game.factory;

import com.schalldach.thomas.game.objects.GameObject;
import com.schalldach.thomas.game.objects.Missile;
import com.schalldach.thomas.game.strategy.LinearCurveX;
import com.schalldach.thomas.game.strategy.LinearCurveY;
import com.schalldach.thomas.game.strategy.Strategy;

import javax.imageio.ImageIO;
import java.io.IOException;

/**
 * Created by B.Sc. Thomas Schalldach on 17/11/2016. The code of this application is free to use for non-commercial projects,
 * as long as you ensure that you credit the author. For commercial usage, please contact software[at]thomas-schalldach.de
 */
public class MissileFactory extends ConcreteFactory {




    Strategy missileStrategy;

    public MissileFactory() {
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/images/cannonball_30.png"));
             missileStrategy= new LinearCurveY();
            setMissileSpeed(-30);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void setMissileSpeed(int speed){
        missileStrategy.setSPEED(speed);
      }

    @Override
    public GameObject create() {
        Missile m = new Missile();
        m.setStrategy(missileStrategy);
        m.setImage(getImage());
        return m;
    }
}
