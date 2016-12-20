package com.schalldach.thomas.game.threads;

import com.schalldach.thomas.game.objects.GameObject;
import com.schalldach.thomas.game.objects.Missile;

/**
 * Created by B.Sc. Thomas Schalldach on 19/11/2016. The code of this application is free to use for non-commercial projects,
 * as long as you ensure that you credit the author. For commercial usage, please contact software[at]thomas-schalldach.de
 */
public class MissileMovementThread implements Runnable {

    private final Missile missile;


    public MissileMovementThread(GameObject missile) {
        this.missile=(Missile) missile;
    }

    @Override
    public void run() {

        for (int i=0; i<100;i++){
            this.missile.move();
            if (this.missile.isPositionNotValid()){
                break;
            }
            try {
                Thread.sleep(60);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}
