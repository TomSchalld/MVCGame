package com.husiev.oleksandr.game.utils;

import com.husiev.oleksandr.game.model.Model;

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
                if(model.isLost())
                    break;
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }

    }

}
