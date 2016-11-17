package com.schalldach.thomas.game.view;


import com.schalldach.thomas.game.controler.Logic;
import com.schalldach.thomas.game.helper.TwoDimPosition;
import com.schalldach.thomas.game.objects.GameObject;
import com.schalldach.thomas.game.objects.Visitor;


import java.awt.Graphics;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Ondrej Stuchlik
 */
public class GraphicsDrawer {
    /*private static final int INFO_X = 5;
    private static final int INFO_Y = 15;*/


    public void drawGameObject(List<GameObject> objects, Graphics g) {
       objects.forEach(object -> g.drawImage(object.getImage(),
               (int)((TwoDimPosition)object.getPosition()).getxCoordinate() - object.getImage().getWidth() / 2,
               (int)((TwoDimPosition)object.getPosition()).getyCoordinate() - object.getImage().getHeight() / 2, null));

    }


}
