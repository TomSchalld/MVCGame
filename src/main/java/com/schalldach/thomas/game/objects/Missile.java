package com.schalldach.thomas.game.objects;

import com.schalldach.thomas.game.objects.strategies.MovementStrategy;

/**
 * Created by B.Sc. Thomas Schalldach on 16/10/2016. The code of this application is free to use for non-commercial projects,
 * as long as you ensure that you credit the author. For commercial usage, please contact software[at]thomas-schalldach.de
 */
public class Missile extends GameObject {
    MovementStrategy movement;

    public void moveMissile() {
        this.move(movement.generateStep(this.getPosition()));
    }

    public void setMovement(MovementStrategy movement) {
        this.movement = movement;
    }
}
