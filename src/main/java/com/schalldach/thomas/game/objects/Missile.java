package com.schalldach.thomas.game.objects;

import com.schalldach.thomas.game.controler.MovementThread;

import java.util.List;

/**
 * Created by B.Sc. Thomas Schalldach on 16/10/2016. The code of this application is free to use for non-commercial projects,
 * as long as you ensure that you credit the author. For commercial usage, please contact software[at]thomas-schalldach.de
 */
public class Missile extends GameObject {
    private Thread moving;

    public Thread getMoving() {
        return moving;
    }

    public void setMoving(MovementThread moving) {
        this.moving = moving;
    }
}
