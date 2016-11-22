package com.schalldach.thomas.game.controler;

import com.schalldach.thomas.game.objects.GameObject;

/**
 * Created by remy on 19/11/16.
 */
public interface GameVisitor {
    public void visitCollisions(GameObject o);
    public void draw(GameObject o);
    public void erase(GameObject o);
}
