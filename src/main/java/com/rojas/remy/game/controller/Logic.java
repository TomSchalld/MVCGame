package com.rojas.remy.game.controller;

import com.rojas.remy.game.memento.Keeper;
import com.rojas.remy.game.objects.GameObject;
import com.rojas.remy.game.view.MainWindow;
import com.rojas.remy.game.factory.CannonFactory;
import com.rojas.remy.game.model.IObserver;
import com.rojas.remy.game.model.Model;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 * Created by B.Sc. Thomas Schalldach on 22/10/2016. The code of this application is free to use for non-commercial projects,
 * as long as you ensure that you credit the author. For commercial usage, please contact software[at]thomas-schalldach.de
 */
public class Logic implements IObserver{

    private MainWindow view;
    private Model model;
    private static Logic logic = null;
    private Keeper mementoKeeper;
    //call mementoKeeper.save();

    public static Logic getLogic(){
        if(logic==null){
            logic = new Logic();
        }
        return logic;
    }

    private Logic(){
        view = new MainWindow();
        model = new Model();
        model.attach(this);
        view.getCanvas().setDrawableObj(model.getCannon());
        view.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent evt) {
                // delegate to controller
                switch (evt.getKeyCode()) {
                    case KeyEvent.VK_DOWN:
                        //model.moveCannonDown();
                        break;
                    case KeyEvent.VK_UP:
                        //model.moveCannonUp();
                        break;
                    case KeyEvent.VK_LEFT:
                       // model.forceOfCannonDown();
                        break;
                    case KeyEvent.VK_RIGHT:
                        //model.forceOfCannonUp();
                        break;
                    case KeyEvent.VK_PAGE_UP:
                        //model.aimCannonUp();
                        break;
                    case KeyEvent.VK_PAGE_DOWN:
                        //model.aimCannonDown();
                        break;
                    case KeyEvent.VK_SPACE:
                        model.getCannon().getShootState().shootState(model);
                        break;
                    case KeyEvent.VK_S:
                        model.getCannon().getShootState().switchState();
                        break;
                    case KeyEvent.VK_D:
                        model.switchMissileMovement();
                        break;
                    case KeyEvent.VK_P:
                        if(model.getTimer()==null){
                            model.loadMemento();
                        } else {
                            model.pause();
                        }
                        break;
                    case KeyEvent.VK_B:
                        model.buildBrick();
                        break;
                    case KeyEvent.VK_L:
                        break;
                    case KeyEvent.VK_HOME:
                        //model.increaseGravity();
                        break;
                    case KeyEvent.VK_END:
                        //model.decreaseGravity();
                        break;
                    case KeyEvent.VK_F1:
                        //view.showHelp();
                        break;
                }

                if(evt.getKeyCode()==32) {
                    //model.getCannon().getShootState().shootState(model);
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
        /*model.getCannon().accept(view.getCanvas().getGv());
        model.getEnemies().forEach(e -> e.accept(view.getCanvas().getGv()));
        model.getMissiles().forEach(m -> m.accept(view.getCanvas().getGv()));
        model.getCollisions().forEach(c -> c.accept((view.getCanvas().getGv())));
        model.getWall().forEach(b -> b.accept(view.getCanvas().getGv()));*/
        view.getCanvas().setDrawableObj(model.getCannon());
        view.getCanvas().setDrawableObj((ArrayList<GameObject>) model.getEnemies());
        view.getCanvas().setDrawableObj((ArrayList<GameObject>) model.getMissiles());
        view.getCanvas().setDrawableObj((ArrayList<GameObject>) model.getCollisions());
        view.getCanvas().setDrawableObj((ArrayList<GameObject>) model.getWall());
        view.getCanvas().repaint();
    }


}



