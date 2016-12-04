package com.rojas.remy.game.controller;

import com.rojas.remy.game.objects.GameObject;
import com.rojas.remy.game.view.MainWindow;

/**
 * Created by remy on 29/11/16.
 */
public class GameVisitor implements IGameVisitor {
    private final MainWindow view;

    public GameVisitor(MainWindow view) {
        this.view = view;
    }

    @Override
    public void draw(GameObject o){
        //view.getCanvas().drawObject(o);
        view.getCanvas().setDrawableObj(o);
    }
}
