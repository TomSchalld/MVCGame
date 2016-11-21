package com.schalldach.thomas.game.factory;

import com.schalldach.thomas.game.helper.APosition;
import com.schalldach.thomas.game.helper.TwoDimPosition;
import com.schalldach.thomas.game.objects.Cannon;
import com.schalldach.thomas.game.objects.GameObject;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created by B.Sc. Thomas Schalldach on 17/11/2016. The code of this application is free to use for non-commercial projects,
 * as long as you ensure that you credit the author. For commercial usage, please contact software[at]thomas-schalldach.de
 */
public class CannonFactory extends ConcreteFactory {

    private BufferedImage shooting;
    private BufferedImage notShooting;


    public CannonFactory() {
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/images/cannonComplete_30.png"));
            notShooting = ImageIO.read(getClass().getResourceAsStream("/images/cannonComplete_30.png"));
            shooting = ImageIO.read(getClass().getResourceAsStream("/images/cannonComplete_shooting_30.png"));
            APosition pos = new TwoDimPosition();
            pos.addVector(Arrays.asList(540.0, 550.0));
            setInitialPosition(pos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public GameObject create() {
        Cannon o = new Cannon();
        o.getPosition().addVector(getInitialPosition().getVector());
        o.setImage(getImage());
        o.setNotShooting(notShooting);
        o.setShooting(shooting);
        return o;
    }
}
