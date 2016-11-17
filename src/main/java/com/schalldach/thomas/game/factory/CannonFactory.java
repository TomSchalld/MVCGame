package com.schalldach.thomas.game.factory;

import com.schalldach.thomas.game.helper.APosition;
import com.schalldach.thomas.game.helper.TwoDimPosition;
import com.schalldach.thomas.game.objects.Cannon;
import com.schalldach.thomas.game.objects.GameObject;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by B.Sc. Thomas Schalldach on 17/11/2016. The code of this application is free to use for non-commercial projects,
 * as long as you ensure that you credit the author. For commercial usage, please contact software[at]thomas-schalldach.de
 */
public class CannonFactory extends ConcreteFactory {


    public CannonFactory() {
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/images/cannon.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public GameObject create() {
        GameObject o = new Cannon();
        o.getPosition().addVector(((TwoDimPosition)getInitialPosition()).getVector());
        o.setImage(getImage());
        return o;
    }
}
