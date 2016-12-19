package com.husiev.oleksandr.game.model;


public interface IObservable {

    public void attach(IObserver observer);
    public void detach(IObserver observer);
    public void notification();

}
