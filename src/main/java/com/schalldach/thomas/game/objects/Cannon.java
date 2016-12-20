package com.schalldach.thomas.game.objects;

import com.schalldach.thomas.game.threads.CannonStateHandler;
import com.schalldach.thomas.game.threads.MissileMovementThread;

import java.awt.image.BufferedImage;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by B.Sc. Thomas Schalldach on 16/10/2016. The code of this application is free to use for non-commercial projects,
 * as long as you ensure that you credit the author. For commercial usage, please contact software[at]thomas-schalldach.de
 */
public class Cannon extends GameObject {
    private BufferedImage shooting;
    private BufferedImage notShooting;
    private final ExecutorService executor = Executors.newFixedThreadPool(10);


    public enum CannonState {
        shootable, shooting, coolDown, outOfAmmunition;


        public static String valueOf(CannonState state) {
            switch (state) {
                case shootable:
                    return "Shoot the pirate scum!";
                case shooting:
                    return "Cannon is fireing!";
                case coolDown:
                    return "The cannon is cooling!";
                case outOfAmmunition:
                    return "We ran out of ammunition!";
            }
            return "";
        }
    }

    private int shots = 0;
    private CannonState state = CannonState.shootable;


    public void setShooting(BufferedImage shooting) {
        this.shooting = shooting;
    }

    public void setNotShooting(BufferedImage notShooting) {
        this.notShooting = notShooting;
    }

    public void changeImageShootingNotShooting() {
        if (this.image.equals(shooting)) {
            this.image = notShooting;
        } else {
            this.image = shooting;
        }
    }

    public CannonState getState() {
        return state;
    }

    public void setState(@SuppressWarnings("SameParameterValue") CannonState state) {
        this.state = state;
    }

    public void setShots(@SuppressWarnings("SameParameterValue") int shots) {
        this.shots = shots;
    }

    public synchronized void shoot(Missile missile) {

        this.state = CannonState.shooting;
        this.changeImageShootingNotShooting();
        //Maybe put this into the missile so thread can be stopped
        executor.execute(new MissileMovementThread(missile));
        shots++;
        this.state = CannonState.coolDown;
        int maxShots = 10;
        if (shots == maxShots) {
            this.state = CannonState.outOfAmmunition;
            this.changeImageShootingNotShooting();
        }
        Thread cannonStateHandler = new Thread(new CannonStateHandler(this));
        cannonStateHandler.start();
    }

}
