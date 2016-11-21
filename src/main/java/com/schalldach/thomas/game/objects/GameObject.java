package com.schalldach.thomas.game.objects;

import com.schalldach.thomas.game.utils.APosition;
import com.schalldach.thomas.game.utils.TwoDimPosition;
import com.schalldach.thomas.game.controller.Visitor;

import java.awt.image.BufferedImage;
import java.util.List;

/**
 * Created by B.Sc. Thomas Schalldach on 16/10/2016. The code of this application is free to use for non-commercial projects,
 * as long as you ensure that you credit the author. For commercial usage, please contact software[at]thomas-schalldach.de
 */
public abstract class GameObject {
    protected APosition position;
    protected BufferedImage image;
    boolean render;

    public void move(APosition position){
        this.position.addVector(position.getVector());
    }

    public GameObject() {
        this.position = new TwoDimPosition();
        render = true;
    }

    public APosition getPosition() {
        return new TwoDimPosition((TwoDimPosition) position);
    }

    public void changePosition(APosition position) {
        this.position = position;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public void accept(Visitor visitor){
        visitor.visit(this);
    }

    public boolean hasToBeRendered() {
        return render;
    }
}
