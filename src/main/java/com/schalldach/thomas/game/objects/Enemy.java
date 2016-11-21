package com.schalldach.thomas.game.objects;

import com.schalldach.thomas.game.objects.strategies.MovementStrategy;

/**
 * Created by B.Sc. Thomas Schalldach on 16/10/2016. The code of this application is free to use for non-commercial projects,
 * as long as you ensure that you credit the author. For commercial usage, please contact software[at]thomas-schalldach.de
 */
public class Enemy extends GameObject {
    EnemyState enemyState;



    public void moveEnemy() {
        System.out.println(enemyState.getMovement().getClass());
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

}
