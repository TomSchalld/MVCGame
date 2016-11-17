package com.schalldach.thomas.game.factory;

import com.schalldach.thomas.game.objects.Collision;
import com.schalldach.thomas.game.objects.GameObject;

import javax.imageio.ImageIO;
import java.io.IOException;

/**
 * Created by B.Sc. Thomas Schalldach on 17/11/2016. The code of this application is free to use for non-commercial projects,
 * as long as you ensure that you credit the author. For commercial usage, please contact software[at]thomas-schalldach.de
 */
public class CollisionFactory extends ConcreteFactory {
    public CollisionFactory() {
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/images/collision.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public GameObject create() {
        GameObject o = new Collision();
        o.setImage(getImage());
        return o;
    }
}
