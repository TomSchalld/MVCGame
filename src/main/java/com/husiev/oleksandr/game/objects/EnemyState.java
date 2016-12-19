package com.husiev.oleksandr.game.objects;

import com.husiev.oleksandr.game.objects.strategies.MovementStrategy;
import com.husiev.oleksandr.game.utils.ImageScaling;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by Oleksandr on 19.11.2016.
 */
public class EnemyState {
    int timeToLive;
    int curIm;
    int imageNumber;
    BufferedImage img;
    String imgPath;
    EnemyState nextState;
    boolean dead;
    MovementStrategy movement;
    int score;

    public EnemyState(int timeToLive,int imageNumber, String imgPath){
        this.timeToLive = timeToLive;
        this.curIm = 0;
        this.imageNumber = imageNumber;
        this.imgPath = imgPath;
        this.dead = false;
    }

    public EnemyState(EnemyState enemyState){
        dead = enemyState.dead;
        timeToLive = enemyState.timeToLive;
        curIm = enemyState.curIm;
        imageNumber = enemyState.imageNumber;
        img = ImageScaling.deepCopy(enemyState.img);
        imgPath = enemyState.imgPath;
        movement = enemyState.getMovement();
        score = enemyState.getScore();
        dead = enemyState.dead;
        if(enemyState.nextState!=null)
            nextState = new EnemyState(enemyState.nextState);
    }

    public BufferedImage getNextPic(){
        try {
            timeToLive--;
            if (timeToLive==0)
                initTransition();
            curIm = (curIm) % imageNumber + 1;
            //System.out.println(imgPath+curIm+".png");
            BufferedImage img = ImageScaling.scale(ImageIO.read(getClass().getResourceAsStream(imgPath+curIm+".png")),40,60);
            return img;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void initTransition(){
        if(nextState==null) {
            return;
        }
        timeToLive = nextState.timeToLive;
        curIm = nextState.curIm;
        imageNumber = nextState.imageNumber;
        img = ImageScaling.deepCopy(nextState.img);
        imgPath = nextState.imgPath;
        movement = nextState.movement;
        score = nextState.getScore();
        dead = nextState.dead;
        nextState = nextState.nextState;
    }

    public void setNextState(EnemyState nextState) {
        this.nextState = new EnemyState(nextState);
    }

    public boolean isDead() {
        return dead;
    }

    public void setDead() {
        this.dead = true;
    }

    public MovementStrategy getMovement(){
        return movement;
    }

    public void setMovement(MovementStrategy movement) {
        this.movement = movement;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
