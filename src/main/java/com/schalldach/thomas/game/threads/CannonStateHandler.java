package com.schalldach.thomas.game.threads;

import com.schalldach.thomas.game.objects.Cannon;

/**
 * Created by B.Sc. Thomas Schalldach on 19/11/2016. The code of this application is free to use for non-commercial projects,
 * as long as you ensure that you credit the author. For commercial usage, please contact software[at]thomas-schalldach.de
 */
public class CannonStateHandler implements Runnable {


    private Cannon cannon;

    public CannonStateHandler(Cannon cannon) {
        this.cannon = cannon;
    }

    @Override
    public void run() {
        if(cannon.getState()==Cannon.CannonState.coolDown){
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                cannon.setState(Cannon.CannonState.shootable);
            }
        }else if (cannon.getState()== Cannon.CannonState.outOfAmmunition){
            //either hit reload or wait
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                cannon.setState(Cannon.CannonState.shootable);
                cannon.setShots(0);
            }
        }

    }
}
