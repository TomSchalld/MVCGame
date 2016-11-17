package com.schalldach.thomas.game.view;


import com.schalldach.thomas.game.controler.Logic;
import com.schalldach.thomas.game.helper.TwoDimPosition;
import com.schalldach.thomas.game.objects.GameObject;
import com.schalldach.thomas.game.objects.Visitor;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * @author Ondrej Stuchlik
 */
public class GraphicsDrawer implements Visitor{
    private static final int INFO_X = 5;
    private static final int INFO_Y = 15;
    private Graphics g;


    public void drawGameObject(GameObject object) {
        this.g.drawImage(object.getImage(),
                (int)((TwoDimPosition)object.getPosition()).getxCoordinate() - object.getImage().getWidth() / 2,
                (int)((TwoDimPosition)object.getPosition()).getyCoordinate() - object.getImage().getHeight() / 2, null);
    }


    public void drawGame(Graphics g) {
        List<GameObject> objects = new LinkedList<>();
                objects.addAll(Logic.getInstance().getModel().getCollisions());
                objects.addAll(Logic.getInstance().getModel().getEnemies());
                objects.addAll(Logic.getInstance().getModel().getMissiles());
                objects.add(Logic.getInstance().getModel().getCannon());

        objects.forEach(object -> object.accept(this));
    }

    @Override
    public void visit(GameObject object) {
        drawGameObject(object);
    }
}
