package com.schalldach.thomas.game.controler;

import com.schalldach.thomas.game.helper.APosition;
import com.schalldach.thomas.game.model.IObserver;
import com.schalldach.thomas.game.model.Model;
import com.schalldach.thomas.game.objects.Cannon;
import com.schalldach.thomas.game.objects.GameObject;
import com.schalldach.thomas.game.objects.Visitor;
import com.schalldach.thomas.game.threads.EnemyMovementThread;
import com.schalldach.thomas.game.threads.RendererThread;
import com.schalldach.thomas.game.view.*;
import com.schalldach.thomas.game.view.Box;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by B.Sc. Thomas Schalldach on 22/10/2016. The code of this application is free to use for non-commercial projects,
 * as long as you ensure that you credit the author. For commercial usage, please contact software[at]thomas-schalldach.de
 */
public class Logic implements Visitor, IObserver {

    private final Thread renderer;
    private final Thread enemyThread;
    private final RendererThread renderThread;
    private final EnemyMovementThread enemyMovementThread;
    private final KeyListener keyListener;
    private MainWindow view;
    private Model model;
    private static Logic instance;
    private static Object lock = new Object();
    private EnemyMovementThread thread;
    private boolean gameIsPaused = false;

    public MainWindow getView() {
        return view;
    }

    public void setView(MainWindow view) {
        this.view = view;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public static Logic getInstance() {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) {
                    instance = new Logic();
                }
            }
        }
        return instance;
    }

    private Logic() {

        this.model = new Model();
        instantiateGameObjects();
        this.model.attach(this);
        this.keyListener = new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent evt) {
                cannonAction(evt);
            }
        };
        view = new MainWindow();
        view.addKeyListener(keyListener);
        view.setVisible(true);
        renderThread = new RendererThread(this.model);
        enemyMovementThread = new EnemyMovementThread(this.model.getEnemies());
        renderer = new Thread(renderThread);
        enemyThread = new Thread(enemyMovementThread);
        renderer.start();
        enemyThread.start();

    }


    private void instantiateGameObjects() {
        this.getModel().doBasicInstantiation();
    }

    @Override
    public void update() {
        view.getView().setToBeDrawn(new LinkedList<>());
        List<GameObject> objects = model.getObjects();
        objects.forEach(object -> object.accept(this));
        this.setCannonState();
        this.setScore();
        view.getView().repaint();
        if (model.isGameEnd()) {
            JFrame endBox = new Box(model.getScore());
            model.detach(this);
        }
    }

    private void setScore() {
        view.getView().setScore(this.calculateScore(),this.calcLife());
    }

    private int calcLife() {
        return model.getScore().getLifes();
    }

    private int calculateScore() {
        return model.getScore().getIntScore();
    }

    private void setCannonState() {
        Cannon.CannonState state = model.getCannon().getState();
        view.getView().setCannonState(Cannon.CannonState.valueOf(state));
    }

    @Override
    public void visit(GameObject object) {
        view.getView().getToBeDrawn().add(object);
    }

    private void cannonAction(KeyEvent evt) {
        APosition pos = model.getCannon().getPosition();
        switch (evt.getKeyCode()) {
            case 32:
                model.shoot();
                break;
            case 37:
                model.moveCannonLeft();
                break;
            case 38:
                //model.moveCannonUp();
                break;
            case 39:
                model.moveCannonRight();
                break;
            case 40:
                //model.moveCannonDown();
                break;

        }
    }

    public void minusPoint() {
        if (getModel().hasLifes()) {
            getModel().takeALife();
        } else {
            getView().removeKeyListener(keyListener);
        }
    }
}
