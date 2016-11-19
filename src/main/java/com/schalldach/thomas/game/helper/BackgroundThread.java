package com.schalldach.thomas.game.helper;

import com.schalldach.thomas.game.model.Model;

/**
 * Created by B.Sc. Thomas Schalldach on 17/11/2016. The code of this application is free to use for non-commercial projects,
 * as long as you ensure that you credit the author. For commercial usage, please contact software[at]thomas-schalldach.de
 */
public class BackgroundThread implements Runnable{

    private static Model model;


    public BackgroundThread(Model model) {
        this.model = model;
    }
    public static void fireCannon() {
        model.moveMissile(model.getMissiles().get(0));
    }
    @Override
    public void run() {

        while (true){
            model.randomizeEnemies();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }


    }
}
