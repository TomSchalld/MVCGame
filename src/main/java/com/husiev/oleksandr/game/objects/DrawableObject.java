package com.husiev.oleksandr.game.objects;

import com.husiev.oleksandr.game.utils.ImageScaling;

/**
 * Created by Oleksandr on 21.11.2016.
 */
public class DrawableObject extends GameObject{
    public DrawableObject(GameObject gameObject) {
        this.setImage(ImageScaling.deepCopy(gameObject.getImage()));
        this.changePosition(gameObject.getPosition());
    }
}
