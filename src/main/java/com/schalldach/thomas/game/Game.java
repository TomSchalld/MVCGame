package com.schalldach.thomas.game;

import com.schalldach.thomas.game.controler.Logic;


/**
 * Created by B.Sc. Thomas Schalldach on 22/10/2016. The code of this application is free to use for non-commercial projects,
 * as long as you ensure that you credit the author. For commercial usage, please contact software[at]thomas-schalldach.de
 */
// originator
public class Game {
    private Logic controler;



    public GameMemento save(){
        return new GameMemento(this);
    }
    public void reset(GameMemento undoState){

    }
}