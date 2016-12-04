package com.rojas.remy.game.controller;

import com.rojas.remy.game.objects.GameObject;
import com.rojas.remy.game.view.MainWindow;
import com.rojas.remy.game.factory.CannonFactory;
import com.rojas.remy.game.model.IObserver;
import com.rojas.remy.game.model.Model;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by B.Sc. Thomas Schalldach on 22/10/2016. The code of this application is free to use for non-commercial projects,
 * as long as you ensure that you credit the author. For commercial usage, please contact software[at]thomas-schalldach.de
 */
public class Logic implements IObserver{

    private MainWindow view;
    private Model model;
    private CannonFactory cannonFactory;
    private static Logic logic = null;
    private final int numEnemies=5;

    private GameVisitor gameVisitor;

    public static Logic getLogic(){
        if(logic==null){
            logic = new Logic();
        }
        return logic;
    }

    private Logic(){
        view = new MainWindow();
        model = new Model();
        gameVisitor = new GameVisitor(view);
        model.attach(this);
        view.getCanvas().setDrawableObj(model.getCannon());
        view.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent evt) {
                // delegate to controller
                if(evt.getKeyCode()==32) {
                    model.fireMissile();
                }
                else {
                    model.moveCannon(evt.getKeyCode());
                }
            }
        });
        view.setVisible(true);
    }

    @Override
    public void update() {
        view.getCanvas().resetDrawableObj();
        for(GameObject m : model.getMissiles()){
            m.accept(gameVisitor);
        }
        for(GameObject e : model.getEnemies()){

            e.accept(gameVisitor);
        }
        model.getCannon().accept(gameVisitor);
        view.getCanvas().repaint();
    }


}
