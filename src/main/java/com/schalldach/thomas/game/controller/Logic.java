package com.schalldach.thomas.game.controller;

import com.schalldach.thomas.game.utils.GameThread;
import com.schalldach.thomas.game.utils.TwoDimPosition;
import com.schalldach.thomas.game.model.IObserver;
import com.schalldach.thomas.game.model.Model;
import com.schalldach.thomas.game.objects.GameObject;
import com.schalldach.thomas.game.view.MainWindow;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by B.Sc. Thomas Schalldach on 22/10/2016. The code of this application is free to use for non-commercial projects,
 * as long as you ensure that you credit the author. For commercial usage, please contact software[at]thomas-schalldach.de
 */
public class Logic implements Visitor,IObserver{
    private MainWindow view;
    private Model model;
    private List<GameObject> gameObjectList;
    private static Logic logicInstance;
    private static Object lock = new Object();
    private GameThread gameThread;
    List<Integer> windowSize;

    public static Logic getInstance(){
        if(logicInstance==null) {
            synchronized (lock) {
                if(logicInstance==null) {
                    try {
                        logicInstance = new Logic();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return logicInstance;
    }

    private Logic() throws IOException {
        windowSize = new ArrayList<Integer>();
        windowSize.add(500);
        windowSize.add(500);
        view = new MainWindow(windowSize);

        model = new Model(windowSize);
        this.model.attach(this);

        view.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent evt) {
                int number = evt.getKeyCode();
                Integer [] vector;
                TwoDimPosition position = (TwoDimPosition) model.getCannon().getPosition();
                switch(number){
                    case 32:
                        model.fireCannon();
                        break;
                    case 38:
                        if(borderCheck(position))
                            position.updatePosition(-10.,0.);
                        break;
                    case 40:
                        if(borderCheck(position))
                            position.updatePosition(10.,0.);
                        break;
                }
                model.getCannon().changePosition(position);
                update();
            }
        });
        update();
        gameThread = new GameThread(model);
        new Thread(gameThread).start();
    }

    public List<GameObject> getObjects(){
        return model.getObjects();
    }

    @Override
    public void visit(GameObject gameObject) {
        if(gameObject.hasToBeRendered())
        view.getView().getImages().add(gameObject);
    }

    @Override
    public void update() {
        view.getView().getImages().clear();
        List<GameObject> objects = model.getObjects();
        objects.forEach(object -> object.accept(this));
        view.getView().repaint();
    }

    boolean borderCheck(TwoDimPosition pos){
        int width = view.getWindowWidth();
        int height = view.getWindowHeight();
        int x = (int)pos.getxCoordinate();
        int y = (int)pos.getyCoordinate();
        if(x >= width || y >= height || x<0 || y <0)
            return false;
        return true;
    }


}
