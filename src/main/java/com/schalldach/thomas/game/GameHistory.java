package com.schalldach.thomas.game;

import com.schalldach.thomas.game.model.Model;

import java.util.Stack;

/**
 * Created by B.Sc. Thomas Schalldach on 22/10/2016. The code of this application is free to use for non-commercial projects,
 * as long as you ensure that you credit the author. For commercial usage, please contact software[at]thomas-schalldach.de
 */

//caretaker
public class GameHistory {

    private final Stack<GameMemento> gameStates;

    public GameHistory() {
        gameStates = new Stack<GameMemento>();
    }

    public void save(Model gameModel) {
        gameStates.push(gameModel.save());
    }

    public void revert(Model gameModel) {
        gameModel.reset(gameStates.peek());
        //revert state

    }


}
