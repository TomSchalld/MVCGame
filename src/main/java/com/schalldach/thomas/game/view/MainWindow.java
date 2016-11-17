package com.schalldach.thomas.game.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * @author Ondrej Stuchlik
 */
public class MainWindow extends JFrame {

    private Canvas view = null;

    public Canvas getView() {
        return view;
    }

    public MainWindow() {
        try {
            view = new Canvas(0, 0, 1080, 720);

            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setTitle("MyShooter");
            this.setResizable(false);

            Dimension window = Toolkit.getDefaultToolkit().getScreenSize();
            this.setLocation(
                    (int) (window.getWidth() / 2 - 250),
                    (int) (window.getHeight() / 2 - 250));
            this.add(view);
            this.pack();
        } catch (Exception ex) {
            ex.printStackTrace(System.err);
        }
    }

    public void showHelp() {
        JOptionPane.showMessageDialog(this,
                "Controls: \n"
                        + "here goes some description...");
    }
}
