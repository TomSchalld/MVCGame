package com.rojas.remy.game.controller;

import com.rojas.remy.game.objects.GameObject;

/**
 * Created by remy on 19/11/16.
 */
public interface IGameVisitor {
    public void draw(GameObject o);
}
