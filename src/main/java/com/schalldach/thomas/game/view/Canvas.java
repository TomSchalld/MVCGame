package com.schalldach.thomas.game.view;

import com.schalldach.thomas.game.objects.GameObject;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ondrej Stuchlik
 */
public class Canvas extends JPanel {
    GraphicsDrawer drawer = new GraphicsDrawer();
    private List<GameObject> drawableObj;


    public Canvas(int x, int y, int width, int height) {
        this.setBackground(Color.WHITE);
        this.setDoubleBuffered(true);
        this.setLocation(x, y);
        this.setPreferredSize(new Dimension(width,height));
        this.setVisible(true);
        drawableObj = new ArrayList<GameObject>();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawer.drawObjects(g,(ArrayList<GameObject>)drawableObj);
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

    public void unSetDrawabelObj(GameObject o) {
        drawableObj.remove(o);
    }
}
