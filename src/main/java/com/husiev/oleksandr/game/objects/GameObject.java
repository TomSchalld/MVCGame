package com.husiev.oleksandr.game.objects;

import com.husiev.oleksandr.game.controller.IVisitable;
import com.husiev.oleksandr.game.utils.APosition;
import com.husiev.oleksandr.game.utils.TwoDimPosition;
import com.husiev.oleksandr.game.controller.IVisitor;

import java.awt.image.BufferedImage;


public abstract class GameObject implements IVisitable{
    //TODO transfer buffered image to drawer
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

    public void accept(IVisitor visitor){
        visitor.visitGameObject(this);
    }

    public boolean hasToBeRendered() {
        return render;
    }
}
