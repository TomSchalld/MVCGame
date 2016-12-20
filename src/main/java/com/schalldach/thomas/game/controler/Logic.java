package com.schalldach.thomas.game.controler;

import com.schalldach.thomas.game.GameHistory;
import com.schalldach.thomas.game.helper.APosition;
import com.schalldach.thomas.game.model.IObserver;
import com.schalldach.thomas.game.model.Model;
import com.schalldach.thomas.game.objects.Cannon;
import com.schalldach.thomas.game.objects.GameObject;
import com.schalldach.thomas.game.objects.Visitor;
import com.schalldach.thomas.game.threads.EnemyMovementThread;
import com.schalldach.thomas.game.threads.RendererThread;
import com.schalldach.thomas.game.view.MainWindow;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by B.Sc. Thomas Schalldach on 22/10/2016. The code of this application is free to use for non-commercial projects,
 * as long as you ensure that you credit the author. For commercial usage, please contact software[at]thomas-schalldach.de
 */
public class Logic implements Visitor, IObserver {

    private Thread renderer;
    private Thread enemyThread;
    private RendererThread renderThread;
    private EnemyMovementThread enemyMovementThread;
    private final KeyListener keyListener;
    private final MainWindow view;
    private final Model model;
    private static Logic instance;
    private final static Object lock = new Object();
    private final GameHistory gameHistory;

    public MainWindow getView() {
        return view;
    }

    public Model getModel() {
        return model;
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
        this.gameHistory = new GameHistory();
        instantiateGameObjects();
        this.keyListener = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent evt) {
                cannonAction(evt);
            }
        };
        view = new MainWindow();


        view.setVisible(true);
        startGame();

    }

    private void startGame() {
        this.model.attach(this);
        renderThread = new RendererThread(this.model, this.gameHistory);
        enemyMovementThread = new EnemyMovementThread(this.model.getEnemies());
        renderer = new Thread(renderThread);
        enemyThread = new Thread(enemyMovementThread);
        renderer.start();
        enemyThread.start();
        view.addKeyListener(keyListener);
    }


    private void instantiateGameObjects() {
        this.getModel().doBasicInstantiation();
        gameHistory.save(model);
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
            model.detach(this);
            endGame();
        }
    }

    private void endGame() {
        stopThreads();
        final String end = "The game ended you have a score of : "
                + model.getScore().getIntScore() + " \nand you reached level: "
                + model.getScore().getLevel() + " \n Do you want to retry the last level?";
        int answer = JOptionPane.showConfirmDialog(null, end, "Game Over!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (answer == JOptionPane.YES_OPTION) {
            gameHistory.revert(model);
            startGame();
        } else {
            view.dispatchEvent(new WindowEvent(view, WindowEvent.WINDOW_CLOSING));
        }
    }

    private void stopThreads() {
        renderThread.setStopThread(true);
        enemyMovementThread.setThreadStop(true);
    }

    private void setScore() {
        view.getView().setScore(this.calculateScore(), this.calcLife());
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
        if (state == Cannon.CannonState.outOfAmmunition) {
            view.getView().setCannonAmmunitionIndicator("reloading the cannon....");
        } else {
            view.getView().setCannonAmmunitionIndicator("Shoot those damn Pirates");
        }
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
