package com.husiev.oleksandr.game.controller;

/**
 * Created by Oleksandr on 22.11.2016.
 */
public interface IVisitable {
    public void accept(IVisitor visitor);
}
