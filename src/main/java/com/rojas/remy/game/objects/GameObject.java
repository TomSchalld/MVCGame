package com.rojas.remy.game.objects;

import com.rojas.remy.game.controller.IGameVisitor;
import com.rojas.remy.game.factory.MovementStrategy.MovementStrategy;
import com.rojas.remy.game.helper.APosition;
import com.rojas.remy.game.helper.TwoDimPosition;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public abstract class GameObject{
    protected APosition position;
    protected BufferedImage image;
    protected boolean drawable;
    protected MovementStrategy movementStrategy;
    protected int decay;

    public void accept(IGameVisitor gv){
        if(drawable){
            gv.draw(this);
        }
    }

    public void setPosition(APosition p){
        position = p;
    }

    public void move(){
        movementStrategy.move(this);
    };

    public APosition getPosition() {
        return position;
    }

    public BufferedImage getImage(){
        return image;
    }

    public void setImage(BufferedImage i){
        this.image = i;
    }

    public void setImage(String i){
        try {
            this.image = ImageIO.read(getClass().getResourceAsStream(i));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean isDrawable() {
        return drawable;
    }

    public void setDrawable(boolean drawable) {
        this.drawable = drawable;
    }

    public void setMovement(MovementStrategy m) {
        this.movementStrategy=m;
    }

    public MovementStrategy getMovement(){
        return movementStrategy;
    }

    public int getDecay(){
        return decay;
    }

    public void decay(){
    };
}
