package com.schalldach.thomas.game.controler;

import com.schalldach.thomas.game.factory.CannonFactory;
import com.schalldach.thomas.game.model.IObserver;
import com.schalldach.thomas.game.model.Model;
import com.schalldach.thomas.game.objects.Cannon;
import com.schalldach.thomas.game.objects.Enemy;
import com.schalldach.thomas.game.objects.GameObject;
import com.schalldach.thomas.game.objects.Missile;
import com.schalldach.thomas.game.view.Canvas;
import com.schalldach.thomas.game.view.MainWindow;
import com.schalldach.thomas.game.view.UI;
import com.sun.org.apache.bcel.internal.classfile.Visitor;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

/**
 * Created by B.Sc. Thomas Schalldach on 22/10/2016. The code of this application is free to use for non-commercial projects,
 * as long as you ensure that you credit the author. For commercial usage, please contact software[at]thomas-schalldach.de
 */
public class Logic implements GameVisitor, IObserver{

    private MainWindow view;
    private Model model;
    private CannonFactory cannonFactory;
    private static Logic logic = null;

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
                if(evt.getKeyCode()==32) {
                    GameObject missile = model.fireMissile();
                }
                else {
                    model.moveCannon(evt.getKeyCode());
                }
            }
        });
        view.setVisible(true);
    }

    @Override
    public void visitCollisions(GameObject o) {
        //TODO Check for collisions
    }

    @Override
    public void update() {
        view.getCanvas().repaint();
    }

    @Override
    public void draw(GameObject o){
        view.getCanvas().setDrawableObj(o);
    }

    @Override
    public void erase(GameObject o){
        view.getCanvas().unSetDrawabelObj(o);
    }
}
