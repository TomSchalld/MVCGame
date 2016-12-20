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
    private final GraphicsDrawer drawer;
    private JLabel cannonState;
    private JLabel scoreNumber;
    private JLabel lifesNumber;
    private JLabel loading;


    @SuppressWarnings("SameParameterValue")
    public Canvas(@SuppressWarnings("SameParameterValue") int x, @SuppressWarnings("SameParameterValue") int y, @SuppressWarnings("SameParameterValue") int width, @SuppressWarnings("SameParameterValue") int height) {
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

        JPanel gameStats = new JPanel();
        gameStats.setBounds(0, 0, width, 50);
        gameStats.setVisible(true);
        gameStats.setLayout(null);
        cannonState = new JLabel();
        cannonState.setText("Cannon State");
        cannonState.setLocation(750, 0);
        cannonState.setSize(150, 50);
        cannonState.setVisible(true);
        gameStats.add(cannonState);
        JLabel score = new JLabel();
        score.setText("Score");
        score.setLocation(950, 0);
        score.setSize(100, 50);
        score.setVisible(true);
        gameStats.add(score);
        scoreNumber = new JLabel();
        scoreNumber.setText("0");
        scoreNumber.setLocation(1000, 0);
        scoreNumber.setSize(100, 50);
        scoreNumber.setVisible(true);
        gameStats.add(scoreNumber);
        JLabel lifes = new JLabel();
        lifes.setText("Lifes");
        lifes.setLocation(150, 0);
        lifes.setSize(100, 50);
        lifes.setVisible(true);
        gameStats.add(lifes);
        lifesNumber = new JLabel();
        lifesNumber.setText("0");
        lifesNumber.setLocation(100, 0);
        lifesNumber.setSize(100, 50);
        lifesNumber.setVisible(true);
        gameStats.add(lifesNumber);
        loading = new JLabel();
        loading.setText("Shoot those damn Pirates");
        loading.setLocation(550, 0);
        loading.setSize(250, 50);
        loading.setVisible(true);
        gameStats.add(loading);
        this.add(gameStats);

    }

    public void setCannonAmmunitionIndicator(String text) {
        loading.setText(text);
    }

    public void setCannonState(String state) {
        cannonState.setText(state);
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
        drawer.drawOcean(g);
        drawer.drawFortress(g);
        drawer.drawGameObject(toBeDrawn, g);
    }


    public void setScore(int score, int lifes) {
        this.scoreNumber.setText("" + score);
        this.lifesNumber.setText("" + lifes);
    }
}
