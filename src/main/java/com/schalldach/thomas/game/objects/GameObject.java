package com.schalldach.thomas.game.objects;

import com.schalldach.thomas.game.controler.GameVisitor;
import com.schalldach.thomas.game.helper.APosition;

import java.awt.image.BufferedImage;
import java.util.List;

public abstract class GameObject{
    protected APosition position;
    protected BufferedImage image;
    protected IMoveDynamic moveDynamic;
    protected boolean drawable;

    public void accept(GameVisitor gv){
        gv.visitDrawing(this);
    }

    public abstract void move(List<Integer> vector);

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
}
