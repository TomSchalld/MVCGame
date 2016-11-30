package com.schalldach.thomas.game.controler;

import com.schalldach.thomas.game.objects.GameObject;

/**
 * Created by remy on 19/11/16.
 */
public interface IGameVisitor {
    public void draw(GameObject o);
}
