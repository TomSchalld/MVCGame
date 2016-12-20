package com.schalldach.thomas.game.view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.Dimension;
import java.awt.Toolkit;

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
            this.setTitle("Cannon of Port Royale");
            this.setResizable(false);

            Dimension window = Toolkit.getDefaultToolkit().getScreenSize();
            this.setLocation(
                    (int) (window.getWidth() / 2 - 250),
                    (int) (window.getHeight() / 2 - 250));
            this.add(view);
            this.pack();
            JOptionPane.showMessageDialog(null, "Move the cannon with the arrow keys left and right\n" +
                    "Shoot the dirty pirates with space\n" +
                    "as soon as all ships are destroyed, the next level begins\n" +
                    "when you lost all your lives, the game is over.");
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
