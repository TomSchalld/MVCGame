package com.schalldach.thomas.game.objects;

import com.schalldach.thomas.game.helper.APosition;
import com.schalldach.thomas.game.helper.TwoDimPosition;

import java.awt.image.BufferedImage;
import java.util.List;

/**
 * Created by B.Sc. Thomas Schalldach on 16/10/2016. The code of this application is free to use for non-commercial projects,
 * as long as you ensure that you credit the author. For commercial usage, please contact software[at]thomas-schalldach.de
 */
public abstract class GameObject implements Cloneable {
    final APosition position;
    BufferedImage image;

    GameObject() {
        this.position = new TwoDimPosition();
    }

    public boolean isPositionNotValid(){

        if(position.getVector().get(0)<=1090&&position.getVector().get(1)<=720){
            if(position.getVector().get(0)>=0&&position.getVector().get(1)>=0)
            return false;
        }
        return true;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void move(List<Double> vector) {
        position.addVector(vector);
    }

    public APosition getPosition() {
        return position;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }
}
