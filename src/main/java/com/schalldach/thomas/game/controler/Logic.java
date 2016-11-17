package com.schalldach.thomas.game.controler;

import com.schalldach.thomas.game.helper.APosition;
import com.schalldach.thomas.game.helper.TwoDimPosition;
import com.schalldach.thomas.game.model.IObserver;
import com.schalldach.thomas.game.model.Model;
import com.schalldach.thomas.game.objects.GameObject;
import com.schalldach.thomas.game.objects.Visitor;
import com.schalldach.thomas.game.view.MainWindow;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by B.Sc. Thomas Schalldach on 22/10/2016. The code of this application is free to use for non-commercial projects,
 * as long as you ensure that you credit the author. For commercial usage, please contact software[at]thomas-schalldach.de
 */
public class Logic implements Visitor, IObserver {

    private MainWindow view;
    private Model model;
    private static Logic instance;
    private static Object lock = new Object();


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
        view = new MainWindow();
        view.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent evt) {
                // delegate to controller
                moveCannon(evt);
                //update();
                System.out.println("key pressed: " + evt.getKeyCode());
            }

            private void moveCannon(KeyEvent evt) {
                APosition pos = model.getCannon().getPosition();
                switch (evt.getKeyCode()) {
                    case 37:
                        System.out.println("left");
                        break;
                    case 38:
                        System.out.println("up");
                        model.moveCannonUp();
                        break;
                    case 39:
                        System.out.println("right");
                        break;
                    case 40:
                        System.out.println("down");
                        model.moveCannonDown();
                        break;

                }
            }
        });
        view.setVisible(true);


    }

    private void instantiateGameObjects() {
        this.getModel().doBasicInstantiation();
    }

    @Override
    public void update() {
        view.getView().setToBeDrawn(new LinkedList<>());
        List<GameObject> objects = model.getObjects();
        objects.forEach(object -> object.accept(this));
        view.getView().repaint();

    }

    @Override
    public void visit(GameObject object) {
        view.getView().getToBeDrawn().add(object);
    }
}
