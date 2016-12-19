package com.husiev.oleksandr.game.objects;

import com.husiev.oleksandr.game.objects.strategies.MovementStrategy;


public class Enemy extends GameObject {
    //TODO enemy state transition table(map)
    EnemyState enemyState;



    public void moveEnemy() {
        this.move(enemyState.getMovement().generateStep(this.getPosition()));
        image = enemyState.getNextPic();
    }

    public void setStrategy(MovementStrategy strategy) {
        enemyState.setMovement(strategy);
    }

    public void setEnemyState(EnemyState enemyState) {
        this.enemyState = new EnemyState(enemyState);
    }

    public void forceTransition(){
        enemyState.initTransition();
    }

    public boolean isDead(){
        return enemyState.isDead();
    }

    public int getScore() {
        return enemyState.getScore();
    }
}
