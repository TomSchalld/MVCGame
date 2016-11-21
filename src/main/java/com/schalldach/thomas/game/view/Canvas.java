package com.schalldach.thomas.game.view;

import com.schalldach.thomas.game.objects.GameObject;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ondrej Stuchlik
 */
public class Canvas extends JPanel {

    private List<GameObject> toBeDrawn;
    private GraphicsDrawer drawer;
    private JPanel gameStats;
    private JLabel cannonState;
    private JLabel score;
    private JLabel scoreNumber;

    public Canvas(int x, int y, int width, int height) {
        this.setLayout(null);
        drawer = new GraphicsDrawer();
        toBeDrawn = new ArrayList<>();
        this.setBackground(Color.WHITE);
        this.setDoubleBuffered(true);
        this.setLocation(x, y);
        this.setPreferredSize(new Dimension(width, height));
        this.setVisible(true);
        this.initiateGameStats(width);


    }

    private void initiateGameStats(int width) {
        this.gameStats = new JPanel();
        this.gameStats.setBounds(0, 0, width, 50);
        this.gameStats.setVisible(true);
        this.gameStats.setLayout(null);
        cannonState = new JLabel();
        cannonState.setText("Cannon State");
        cannonState.setLocation(750, 0);
        cannonState.setSize(150,50);
        cannonState.setVisible(true);
        this.gameStats.add(cannonState);
        score = new JLabel();
        score.setText("Score");
        score.setLocation(950, 0);
        score.setSize(100,50);
        score.setVisible(true);
        this.gameStats.add(score);
        scoreNumber = new JLabel();
        scoreNumber.setText("0");
        scoreNumber.setLocation(1000, 0);
        scoreNumber.setSize(100,50);
        scoreNumber.setVisible(true);
        this.gameStats.add(scoreNumber);
        this.add(gameStats);

    }

    public void setCannonState(String state) {
        cannonState.setText(state);
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
        drawer.drawGameObject(toBeDrawn, g);
    }

    public void setScore(int score) {
        this.scoreNumber.setText(""+score);
    }
}
