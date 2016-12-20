package com.schalldach.thomas.game.view;

import com.schalldach.thomas.game.helper.Score;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.*;

/**
 * Created by B.Sc. Thomas Schalldach on 22/10/2016. The code of this application is free to use for non-commercial projects,
 * as long as you ensure that you credit the author. For commercial usage, please contact software[at]thomas-schalldach.de
 */
public class Box extends JFrame {

    private Score score;

    public Box(Score score) throws HeadlessException {
        this.score = score;
        JLabel label = new JLabel("The game ended you have a score of : " + score.getIntScore() + " and you reached level: "+score.getLevel()+" please close the game now.");
        label.setVisible(true);
        this.add(label);
        this.setSize(300,100);
        this.setVisible(true);
        this.setLocation(800,450);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


}
