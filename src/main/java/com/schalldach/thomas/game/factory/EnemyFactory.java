package com.schalldach.thomas.game.factory;

import com.schalldach.thomas.game.helper.APosition;
import com.schalldach.thomas.game.helper.TwoDimPosition;
import com.schalldach.thomas.game.objects.Enemy;
import com.schalldach.thomas.game.objects.GameObject;
import com.schalldach.thomas.game.strategy.LinearCurveX;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created by B.Sc. Thomas Schalldach on 17/11/2016. The code of this application is free to use for non-commercial projects,
 * as long as you ensure that you credit the author. For commercial usage, please contact software[at]thomas-schalldach.de
 */

public class EnemyFactory extends ConcreteFactory {


    private final int initialX[] = {400,450,500,550,600,650,750, 800,850,900, 950, 1000, 1050};
    private final int initialY[] = {200,250,300,350};

    public EnemyFactory() {
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/images/pirate_ship_free_15.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public GameObject create() {
        this.genInitialPos();
        Enemy o = new Enemy();
        o.getPosition().addVector(getInitialPosition());
        o.setMovementStrategy(new LinearCurveX());
        double moveMentSpeed = -1;
        o.getMovementStrategy().setSPEED(moveMentSpeed);
        o.setImage(getImage());
        return o;
    }

    private void genInitialPos() {
        APosition pos = new TwoDimPosition();
        int x = (int)  (Math.random() * initialX.length);
        int y = (int) (Math.random() * initialY.length);

        pos.addVector(Arrays.asList(0.0 + initialX[x], 0.0 + initialY[y]));
        this.setInitialPosition(pos);
    }
}
