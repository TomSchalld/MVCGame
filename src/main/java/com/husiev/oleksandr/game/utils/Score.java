package com.husiev.oleksandr.game.utils;

import com.husiev.oleksandr.game.objects.Enemy;

public class Score {
    private int score;
    private int enemiesKilled;



    public Score(int startScore){
        score = startScore;
        enemiesKilled = 0;
    }

    public void enemyHit(Enemy enemy){
        score += enemy.getScore();
        enemiesKilled++;
    }

    public void enemyWon(Enemy enemy){
        score -= enemy.getScore()*2;

    }

    public boolean isLost(){
        return score < 0;
    }

    public int getScore(){
        if(!isLost())
            return score;
        return enemiesKilled;
    }

    public void substractScore(Integer price){
        score -= price;
    }

    public int getEnemiesKilled() {
        return enemiesKilled;
    }
}
