package com.husiev.oleksandr.game;

import com.husiev.oleksandr.game.controller.Logic;


// originator
public class Game {
    private Logic controler;



    public GameMemento save(){
        return new GameMemento(this);
    }
    public void reset(GameMemento undoState){

    }
}
