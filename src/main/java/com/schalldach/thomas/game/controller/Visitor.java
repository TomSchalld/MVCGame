package com.schalldach.thomas.game.controller;

import com.schalldach.thomas.game.objects.GameObject;

/**
 * Created by Oleksandr on 17.11.2016.
 */
public interface Visitor {
    public void visit(GameObject gameObject);
}
