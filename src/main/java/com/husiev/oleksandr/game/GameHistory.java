package com.husiev.oleksandr.game;

import java.util.Stack;


//caretaker
public class GameHistory {

    private Stack<GameMemento> gameStates;

    public GameHistory() {
        gameStates = new Stack<GameMemento>();
    }

    public void save(Game game){
        gameStates.push(game.save());
    }
    public void revert(Game game){
        game.reset(gameStates.pop());
        //revert state

    }


}
