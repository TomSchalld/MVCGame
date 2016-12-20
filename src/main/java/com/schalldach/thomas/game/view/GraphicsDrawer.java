package com.schalldach.thomas.game.view;


import com.schalldach.thomas.game.helper.TwoDimPosition;
import com.schalldach.thomas.game.objects.GameObject;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

/**
 * @author Ondrej Stuchlik
 */
public class GraphicsDrawer {

    private BufferedImage fortress;
    private BufferedImage waves;


    public GraphicsDrawer() {
        try {
            this.fortress = ImageIO.read(getClass().getResourceAsStream("/images/foreground.png"));
            this.waves = ImageIO.read(getClass().getResourceAsStream("/images/waves.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void drawGameObject(List<GameObject> objects, Graphics g) {
        objects.forEach(object -> g.drawImage(object.getImage(),
                (int) ((TwoDimPosition) object.getPosition()).getxCoordinate() - object.getImage().getWidth() / 2,
                (int) ((TwoDimPosition) object.getPosition()).getyCoordinate() - object.getImage().getHeight() / 2, null));

    }

    public void drawFortress(Graphics g) {
        g.drawImage(this.fortress, 0, 480, null);
    }

    public void drawOcean(Graphics g) {
        g.drawImage(this.waves, 0, 0, null);

    }


}
