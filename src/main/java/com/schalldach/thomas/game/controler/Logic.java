package com.schalldach.thomas.game.controler;

import com.schalldach.thomas.game.model.IObserver;
import com.schalldach.thomas.game.model.Model;
import com.schalldach.thomas.game.objects.Cannon;
import com.schalldach.thomas.game.objects.Enemy;
import com.schalldach.thomas.game.objects.Missile;
import com.schalldach.thomas.game.view.Canvas;
import com.schalldach.thomas.game.view.MainWindow;
import com.schalldach.thomas.game.view.UI;

/**
 * Created by B.Sc. Thomas Schalldach on 22/10/2016. The code of this application is free to use for non-commercial projects,
 * as long as you ensure that you credit the author. For commercial usage, please contact software[at]thomas-schalldach.de
 */
public class Logic {

    private Canvas view;
    private Model model;
    private IObserver missileObsever;
    private IObserver enemyObserver;



    private IObserver cannonObserver;
    private static Logic logic = null;
    private GameObjectVisitor gov;


    public static Logic getLogic(){
        if(logic==null){
            logic = new Logic();
            logic.setModel(new Model());
            logic.setObservers();
            logic.getModel().attach(logic.getMissileObsever());
            logic.getModel().attach(logic.getCannonObserver());
            logic.getModel().attach(logic.getEnemyObserver());
        }
        return logic;
    }

    private void setObservers(){
        missileObsever = new IObserver() {
            @Override
            public void update() {
                //TODO visitor missiles
            }
        };
        enemyObserver = new IObserver() {
            @Override
            public void update() {
                //TODO visito enemies
            }
        };
        cannonObserver = new IObserver() {
            @Override
            public void update() {
                //TODO visit cannon
            }
        };
    }


    public void drawObject(){
        //view.getGraphics();
    }
    public void visit(Cannon cannon){
        cannon.getPosition();
    }
    public void visit(Enemy enemy){
        enemy.getPosition();
    }
    public void visit(Missile missile){
        missile.getPosition();
    }

    public Canvas getView() {
        return view;
    }

    public void setView(Canvas view) {
        this.view = view;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public IObserver getMissileObsever() {
        return missileObsever;
    }

    public IObserver getEnemyObserver() {
        return enemyObserver;
    }

    public void setEnemyObserver(IObserver enemyObserver) {
        this.enemyObserver = enemyObserver;
    }

    public IObserver getCannonObserver() {
        return cannonObserver;
    }

    public void setCannonObserver(IObserver cannonObserver) {
        this.cannonObserver = cannonObserver;
    }

    public void setMissileObsever(IObserver missileObsever) {
        this.missileObsever = missileObsever;
    }

    private Logic(){
    }
}
