package com.husiev.oleksandr.game.controller;

import com.husiev.oleksandr.game.model.IObserver;
import com.husiev.oleksandr.game.utils.TwoDimPosition;
import com.husiev.oleksandr.game.utils.GameThread;
import com.husiev.oleksandr.game.model.Model;
import com.husiev.oleksandr.game.objects.GameObject;
import com.husiev.oleksandr.game.view.MainWindow;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Logic implements IVisitor,IObserver {
    //TODO split Logic and IVisitor, memento for pausing the game
    //TODO two movement strategies for missiles, add ballistic

    private MainWindow view;
    private Model model;
    private List<GameObject> gameObjectList;
    private static Logic logicInstance;
    private static Object lock = new Object();
    private GameThread gameThread;
    private List<Integer> windowSize;

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
                    case KeyEvent.VK_SPACE:
                        model.fireCannon();
                        break;
                    case KeyEvent.VK_UP:
                        position.updatePosition(-15.,0.);
                        break;
                    case KeyEvent.VK_DOWN:
                        position.updatePosition(15.,0.);
                        break;
                }
                if(borderCheck(position))
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
    public void visitGameObject(GameObject gameObject) {
        if(gameObject.hasToBeRendered())
            view.getView().getImages().add(gameObject);
    }

    @Override
    public void update() {
        view.getView().getImages().clear();
        List<GameObject> objects = model.getObjects();
        objects.forEach(object -> object.accept(this));
        view.getView().setScoreLabel(model.getScore());
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


    public void createMemento(){
        //model.persist or something
    }

}
