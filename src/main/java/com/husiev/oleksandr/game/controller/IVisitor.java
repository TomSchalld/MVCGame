package com.husiev.oleksandr.game.controller;

import com.husiev.oleksandr.game.objects.GameObject;

/**
 * Created by Oleksandr on 17.11.2016.
 */
public interface IVisitor {
    public void visitGameObject(GameObject gameObject);
}
