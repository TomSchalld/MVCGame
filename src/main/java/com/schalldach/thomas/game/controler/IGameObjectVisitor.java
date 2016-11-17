package com.schalldach.thomas.game.controler;

import com.schalldach.thomas.game.objects.Cannon;
import com.schalldach.thomas.game.objects.Enemy;
import com.schalldach.thomas.game.objects.GameObject;
import com.schalldach.thomas.game.objects.Missile;

/**
 * Created by remy on 17/11/16.
 */
public interface IGameObjectVisitor {
    public void visit(Missile missile);
    public void visit(Enemy enemy);
    public void visit(Cannon cannon);
}