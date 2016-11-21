package com.schalldach.thomas.game.utils;

import com.schalldach.thomas.game.model.Model;

/**
 * Created by Oleksandr on 17.11.2016.
 */

public class GameThread implements Runnable {

    private Model model;

    public GameThread(Model model){
        this.model = model;
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(30);
                model.modelUpdate();
                model.notification();


            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }

    }

}
