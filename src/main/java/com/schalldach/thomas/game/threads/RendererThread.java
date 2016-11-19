package com.schalldach.thomas.game.threads;

import com.schalldach.thomas.game.model.Model;

/**
 * Created by B.Sc. Thomas Schalldach on 19/11/2016. The code of this application is free to use for non-commercial projects,
 * as long as you ensure that you credit the author. For commercial usage, please contact software[at]thomas-schalldach.de
 */
public class RendererThread implements Runnable {

    private Model m;

    public RendererThread(Model m) {
        this.m = m;
    }

    @Override
    public void run() {

        while (true){
            m.notification();
            m.checkForCollision();
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
