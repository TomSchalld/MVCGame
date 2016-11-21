package com.schalldach.thomas.game.view;

import com.schalldach.thomas.game.model.IObserver;
import com.schalldach.thomas.game.objects.GameObject;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Ondrej Stuchlik
 */
public class Canvas extends JPanel implements IObserver{
    List<GameObject> images;
    GraphicsDrawer drawer = new GraphicsDrawer();

    public Canvas(int x, int y, int width, int height) {
        super();
        images = new LinkedList<GameObject>();
        drawer = new GraphicsDrawer();
        this.setBackground(Color.WHITE);
        this.setDoubleBuffered(true);
        this.setLocation(x, y);
        this.setPreferredSize(new Dimension(width,height));
        this.setVisible(true);        
    }

    public void thisIsHowYouForceGuiToRepaint() {
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        synchronized (images) {
            images.forEach(img -> drawer.drawGameObject(g, img));
        }
    }

    @Override
    public void update() {
        repaint();
    }

    public List<GameObject> getImages() {
        return images;
    }

}
