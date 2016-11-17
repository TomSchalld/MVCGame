package com.schalldach.thomas.game.controler;

import com.schalldach.thomas.game.model.IObserver;
import com.schalldach.thomas.game.model.Model;
import com.schalldach.thomas.game.objects.GameObject;
import com.schalldach.thomas.game.objects.Visitor;
import com.schalldach.thomas.game.view.Canvas;
import com.schalldach.thomas.game.view.MainWindow;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

/**
 * Created by B.Sc. Thomas Schalldach on 22/10/2016. The code of this application is free to use for non-commercial projects,
 * as long as you ensure that you credit the author. For commercial usage, please contact software[at]thomas-schalldach.de
 */
public class Logic implements Visitor, IObserver{

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
        if (instance ==null){
            synchronized (lock){
                if (instance ==null){
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
                System.out.println("key pressed: " + evt.getKeyCode());
            }
        });
        view.setVisible(true);
        update();


    }
    private void instantiateGameObjects(){
        this.getModel().doBasicInstantiation();
    }

    @Override
    public void update() {
        List<GameObject> objects = model.getObjects();
        objects.forEach(object -> object.accept(this));
        view.getView().repaint();
        //view.getView().getToBeDrawn().clear();

    }

    @Override
    public void visit(GameObject object) {
        view.getView().getToBeDrawn().add(object);

    }
}
