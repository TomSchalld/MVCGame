package com.rojas.remy.game.view;

import com.rojas.remy.game.controller.GameVisitor;
import com.rojas.remy.game.objects.GameObject;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Ondrej Stuchlik
 */
public class Canvas extends JPanel {
    GraphicsDrawer drawer = new GraphicsDrawer();
    private ArrayList<GameObject> drawableObj;
    private GameVisitor gv;


    public Canvas(int x, int y, int width, int height) {
        this.setBackground(Color.WHITE);
        this.setDoubleBuffered(true);
        this.setLocation(x, y);
        this.setPreferredSize(new Dimension(width,height));
        this.setVisible(true);
        drawableObj = new ArrayList<GameObject>();
        gv = new GameVisitor(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Iterator<GameObject> oi = drawableObj.iterator();
        while(oi.hasNext()){
            GameObject obj = oi.next();
            //obj.accept(gv);
            drawer.drawObject(g,obj);
        }
    }

    public GraphicsDrawer getDrawer() {
        return drawer;
    }

    public void resetDrawableObj() {
        drawableObj.clear();
    }

    public void setDrawableObj(GameObject o) {
        drawableObj.add(o);
    }

    public void setDrawableObj(ArrayList<GameObject> objs) { drawableObj.addAll(objs);}

    public void drawObject(GameObject o) {
        drawer.drawObject(getGraphics(),o);
    }

    public GameVisitor getGv() {
        return gv;
    }
}
