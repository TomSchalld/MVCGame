package com.rojas.remy;

import com.rojas.remy.game.controller.Logic;

import javax.swing.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        SwingUtilities.invokeLater(Logic::getLogic);
    }
}
