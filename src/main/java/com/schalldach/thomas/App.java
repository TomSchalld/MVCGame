package com.schalldach.thomas;

import com.schalldach.thomas.game.controler.Logic;
import com.schalldach.thomas.game.view.MainWindow;

import javax.swing.*;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                Logic.getInstance();
            }
        });
    }
}

