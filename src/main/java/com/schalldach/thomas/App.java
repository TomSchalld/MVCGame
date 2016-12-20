package com.schalldach.thomas;

import com.schalldach.thomas.game.controler.Logic;

import javax.swing.*;

/**
 * Hello world!
 */
class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Logic::getInstance);
    }
}

