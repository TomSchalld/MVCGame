package com.schalldach.thomas.game.objects;

/**
 * Created by B.Sc. Thomas Schalldach on 16/10/2016. The code of this application is free to use for non-commercial projects,
 * as long as you ensure that you credit the author. For commercial usage, please contact software[at]thomas-schalldach.de
 */
public class Collision extends GameObject {
    @Override
    public Collision clone() throws CloneNotSupportedException {
        Collision clone = new Collision();
        clone.setImage(this.image);
        clone.position.addVector(this.position.getVector());
        return clone;
    }
}
