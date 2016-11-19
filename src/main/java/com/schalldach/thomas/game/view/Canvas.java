package com.schalldach.thomas.game.view;

import com.schalldach.thomas.game.model.IObserver;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Ondrej Stuchlik
 */
public class Canvas extends JPanel {
    GraphicsDrawer drawer = new GraphicsDrawer();

    public Canvas(int x, int y, int width, int height) {
        this.setBackground(Color.WHITE);
        this.setDoubleBuffered(true);
        this.setLocation(x, y);
        this.setPreferredSize(new Dimension(width,height));
        this.setVisible(true);        
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    public GraphicsDrawer getDrawer() {
        return drawer;
    }

    public void repainter(){
        repaint();
    }
}
