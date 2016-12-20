package com.schalldach.thomas.game.threads;

/**
 * Created by tscha on 20/12/2016.
 */
public interface Pausable {
    default void pause() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
