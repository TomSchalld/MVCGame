package com.schalldach.thomas.game;

import java.util.Stack;

/**
 * Created by B.Sc. Thomas Schalldach on 22/10/2016. The code of this application is free to use for non-commercial projects,
 * as long as you ensure that you credit the author. For commercial usage, please contact software[at]thomas-schalldach.de
 */

//caretaker
public class GameHistory {

    private Stack<GameMemento> gameStates;

    public GameHistory() {
        gameStates = new Stack<GameMemento>();
    }

    public void save(Game game) {
        gameStates.push(game.save());
    }

    public void revert(Game game) {
        game.reset(gameStates.pop());
        //revert state

    }


}
