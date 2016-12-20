package com.schalldach.thomas.game.helper;

/**
 * Created by B.Sc. Thomas Schalldach on 16/10/2016. The code of this application is free to use for non-commercial projects,
 * as long as you ensure that you credit the author. For commercial usage, please contact software[at]thomas-schalldach.de
 */
public class Score {

    private int lifes;
    private int intScore;
    private int level;

    public Score() {
        this.intScore = 0;
        this.lifes = 10;
        this.level = 0;
    }

    public int getLifes() {
        return lifes;
    }

    public void kill() {
        this.intScore++;
    }

    public int getIntScore() {
        return intScore;
    }

    public void takeLife() {
        lifes--;
    }

    public void levelUp() {
        this.level++;
    }

    public int getLevel() {
        return level;
    }
}
