package com.schalldach.thomas.game.view;

import com.schalldach.thomas.game.model.IObserver;
import com.schalldach.thomas.game.objects.GameObject;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * @author Ondrej Stuchlik
 */
public class Canvas extends JPanel  {

    private List<GameObject> toBeDrawn;
    private GraphicsDrawer drawer;

    public Canvas(int x, int y, int width, int height) {
        drawer = new GraphicsDrawer();
        toBeDrawn = new ArrayList<>();
        this.setBackground(Color.WHITE);
        this.setDoubleBuffered(true);
        this.setLocation(x, y);
        this.setPreferredSize(new Dimension(width, height));
        this.setVisible(true);
    }

    public GraphicsDrawer getDrawer() {
        return drawer;
    }

    public void thisIsHowYouForceGuiToRepaint() {
        repaint();
    }

    public List<GameObject> getToBeDrawn() {
        return toBeDrawn;
    }

    public void setToBeDrawn(List<GameObject> toBeDrawn) {
        this.toBeDrawn = toBeDrawn;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawer.drawGameObject(toBeDrawn,g);
    }

}
