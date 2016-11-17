package com.schalldach.thomas.game.factory;

import com.schalldach.thomas.game.objects.GameObject;
import com.schalldach.thomas.game.objects.Missile;

import javax.imageio.ImageIO;
import java.io.IOException;

/**
 * Created by B.Sc. Thomas Schalldach on 17/11/2016. The code of this application is free to use for non-commercial projects,
 * as long as you ensure that you credit the author. For commercial usage, please contact software[at]thomas-schalldach.de
 */
public class MissileFactory extends ConcreteFactory {

    public MissileFactory() {
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/images/missile.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public GameObject create() {
        GameObject o = new Missile();
        o.setImage(getImage());
        return o;
    }
}
