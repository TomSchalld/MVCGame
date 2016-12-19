package com.husiev.oleksandr.game.view;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 *
 * @author Ondrej Stuchlik
 */
public class MainWindow extends JFrame {

    Canvas view;
    GraphicsDrawer graphicsDrawer;
    int windowWidth;
    int windowHeight;


    public MainWindow(List<Integer> windowSize) {
        windowWidth = windowSize.get(0);
        windowHeight = windowSize.get(1);
        try {
            view = new Canvas(0, 0, windowWidth, windowHeight);
            graphicsDrawer = new GraphicsDrawer();
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setTitle("MyShooter");
            this.setResizable(false);

            Dimension window = Toolkit.getDefaultToolkit().getScreenSize();
            this.setLocation(
                  (int) (window.getWidth() / 2 - 250),
                  (int) (window.getHeight() / 2 - 250));

            this.add(view);
            this.setVisible(true);
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

    public void drawGameObject(){
    }

    public Canvas getView() {
        return view;
    }

    public int getWindowWidth() {
        return windowWidth;
    }

    public int getWindowHeight() {
        return windowHeight;
    }

}
