package com.schalldach.thomas.game.objects;

import com.schalldach.thomas.game.controler.GameVisitor;
import com.schalldach.thomas.game.factory.MovementStrategy.MovementStrategy;
import com.schalldach.thomas.game.helper.APosition;

import java.awt.image.BufferedImage;

public abstract class GameObject{
    protected APosition position;
    protected BufferedImage image;
    protected boolean drawable;
    protected MovementStrategy m;

    public void accept(GameVisitor gv){
        if(drawable){
            gv.draw(this);
        } else {
            gv.erase(this);
        }
    }

    public void setPosition(APosition p){
        position = p;
    }

    public void move(){
        m.move(this);
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

    public boolean isDrawable() {
        return drawable;
    }

    public void setDrawable(boolean drawable) {
        this.drawable = drawable;
    }

    public void setMovement(MovementStrategy m) {
        this.m=m;
    }

    public MovementStrategy getMovement(){
        return m;
    }
}
