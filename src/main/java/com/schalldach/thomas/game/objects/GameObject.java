package com.schalldach.thomas.game.objects;

import com.schalldach.thomas.game.controler.GameModelVisitor;
import com.schalldach.thomas.game.controler.IGameObject;
import com.schalldach.thomas.game.helper.APosition;
import com.schalldach.thomas.game.helper.TwoDimPosition;

import java.util.List;
import java.awt.Image;

public abstract class GameObject implements IGameObject{
    protected APosition position;
    protected Image image;
    protected IMoveDynamic moveDynamic;
    public GameObject() {
        this.position = new TwoDimPosition();
    }

    public void accept(GameModelVisitor gov){
        gov.visit(this);
    };

    public abstract void move(List<Integer> vector);

    public APosition getPosition() {
        return position;
    }

    public Image getImage(){
        return image;
    }

    public void setImage(Image i){
        this.image = i;
    }

}
