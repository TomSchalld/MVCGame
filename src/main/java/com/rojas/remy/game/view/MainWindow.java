package com.rojas.remy.game.view;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {


    private Canvas view = null;

    public Canvas getCanvas(){
        return view;
    }

    public MainWindow() {
        try {
            view = new Canvas(0, 0, 500, 500);

            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setTitle("MySchoolShooter");
            this.setResizable(false);

            Dimension obrazovka = Toolkit.getDefaultToolkit().getScreenSize();
            this.setLocation(
                  (int) (obrazovka.getWidth() / 2 - 250),
                  (int) (obrazovka.getHeight() / 2 - 250));

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
