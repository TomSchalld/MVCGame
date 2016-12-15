package com.rojas.remy.game.factory;

import com.rojas.remy.game.factory.MovementStrategy.*;
import com.rojas.remy.game.helper.TwoDimPosition;
import com.rojas.remy.game.objects.GameObject;
import com.rojas.remy.game.objects.Missile;

import java.util.HashMap;

/**
 * Created by remy on 17/11/16.
 */
public class MissileFactory extends ConcreteFactory {

    private HashMap<MovementStrategyFactory, MovementStrategyFactory> movementStrategyTransTable;

    private MovementStrategyFactory movementFactory;

    public MissileFactory(){
        movementStrategyTransTable = new HashMap<MovementStrategyFactory, MovementStrategyFactory>();
        SpaceMovementFactory smf = new SpaceMovementFactory();
        GravityMovementFactory gmf = new GravityMovementFactory();
        movementStrategyTransTable.put(smf,gmf);
        movementStrategyTransTable.put(gmf,smf);
        this.movementFactory = smf;
    }

    @Override
    public GameObject create() {
        Missile m = new Missile();
        return m;
    }

    public GameObject create(TwoDimPosition p){
        Missile m = new Missile();
        m.setPosition(p);
        m.setMovement(movementFactory.create());
        m.setImage(this.i);
        m.setDrawable(this.drawable);
        return m;
    }

    public void switchMovement(){
        this.movementFactory = movementStrategyTransTable.get(this.movementFactory);
        System.out.println("Changed movement strategy to "+movement.getClass().toString());
    }
}
