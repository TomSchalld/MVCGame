package com.husiev.oleksandr;

import com.husiev.oleksandr.game.controller.Logic;

import javax.swing.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run() {
               Logic logic = Logic.getInstance();

            }
        });
    }
}
