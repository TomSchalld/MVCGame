package com.schalldach.thomas.game.controler;

/**
 * Created by remy on 17/11/16.
 * Game Object Visitor pattern
 */
public interface IGameModel {
    public void accept(GameModelVisitor visitor);
}
