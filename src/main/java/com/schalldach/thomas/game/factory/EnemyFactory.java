package com.schalldach.thomas.game.factory;

import com.schalldach.thomas.game.helper.APosition;
import com.schalldach.thomas.game.helper.TwoDimPosition;
import com.schalldach.thomas.game.objects.Enemy;
import com.schalldach.thomas.game.objects.GameObject;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created by B.Sc. Thomas Schalldach on 17/11/2016. The code of this application is free to use for non-commercial projects,
 * as long as you ensure that you credit the author. For commercial usage, please contact software[at]thomas-schalldach.de
 */

public class EnemyFactory extends ConcreteFactory {


    private final int initialX[] = {550, 600, 650, 700, 750, 800, 850, 900, 950, 1000, 1050};
    private final int initialY[] = {150, 250, 350, 450, 550, 650};


    public EnemyFactory() {
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/images/enemy1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public GameObject create() {
        this.genInitialPos();
        GameObject o = new Enemy();
        o.setImage(getImage());
        return o;
    }

    private void genInitialPos() {
        APosition pos = new TwoDimPosition();
        int x = (int) (1 + Math.random() * 11);
        int y = (int) (1 + Math.random() * 6);

        pos.addVector(Arrays.asList(0.0 + x, 0.0 + y));
        this.setInitialPosition(pos);
    }
}
