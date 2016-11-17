package mvcshooter;

import cz.fit.dpo.mvcshooter.view.MainWindow;

import javax.swing.*;

/**
 *
 * @author stue
 */
public class Shooter {
    
    public static void main(String[] args) {        
        SwingUtilities.invokeLater(new Runnable(){

            @Override
            public void run() {
               new MainWindow().setVisible(true);
            }
        });
    }
}
