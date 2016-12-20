package com.schalldach.thomas.game.threads;

import com.schalldach.thomas.game.GameHistory;
import com.schalldach.thomas.game.model.Model;

/**
 * Created by B.Sc. Thomas Schalldach on 19/11/2016. The code of this application is free to use for non-commercial projects,
 * as long as you ensure that you credit the author. For commercial usage, please contact software[at]thomas-schalldach.de
 */
public class RendererThread implements Runnable, Pausable {

    private final Model m;
    private final GameHistory history;
    private boolean stopThread;

    @SuppressWarnings("SameParameterValue")
    public void setStopThread(boolean stopThread) {
        this.stopThread = stopThread;
    }

    public RendererThread(Model m, GameHistory history) {
        this.m = m;
        this.history = history;
    }

    @Override
    public void run() {

        while (true){
            m.notification();
            try {
                m.checkForCollision();
            }catch (Exception ignored){

            }
            if (m.isNewLevel()) {
                history.save(m);
                m.setNewLevel(false);
            }
            if (stopThread()) {
                break;
            }
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    private boolean stopThread() {
        return this.stopThread;
    }
}
