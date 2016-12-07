package com.rojas.remy.game.controller;

import com.rojas.remy.game.objects.GameObject;
import com.rojas.remy.game.view.Canvas;
import com.rojas.remy.game.view.MainWindow;

/**
 * Created by remy on 29/11/16.
 */
public class GameVisitor implements IGameVisitor {
    private final Canvas view;

    public GameVisitor(Canvas view) {
        this.view = view;
    }

    @Override
    public void draw(GameObject o){
        //view.setDrawableObj(o);
        view.getDrawer().drawObject(view.getGraphics(),o);
    }
}
