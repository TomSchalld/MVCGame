package com.husiev.oleksandr.game.view;

import com.husiev.oleksandr.game.model.IObserver;
import com.husiev.oleksandr.game.objects.GameObject;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Ondrej Stuchlik
 */
public class Canvas extends JPanel implements IObserver {
    List<GameObject> images;
    GraphicsDrawer drawer = new GraphicsDrawer();
    private JLabel scoreLabel;

    public Canvas(int x, int y, int width, int height) {
        super();
        images = new LinkedList<GameObject>();
        drawer = new GraphicsDrawer();
        this.setBackground(Color.WHITE);
        this.setDoubleBuffered(true);
        this.setLocation(x, y);
        this.setPreferredSize(new Dimension(width,height));
        this.setVisible(true);

        scoreLabel = new JLabel("0");
        scoreLabel.setLocation(400,10);
        add(scoreLabel);

    }

    public void thisIsHowYouForceGuiToRepaint() {
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        images.forEach(img -> drawer.drawGameObject(g, img));
    }

    @Override
    public void update() {
        repaint();
    }

    public List<GameObject> getImages() {
        return images;
    }


    public void setScoreLabel(Integer score){
        scoreLabel.setText(score.toString());
    }
}
