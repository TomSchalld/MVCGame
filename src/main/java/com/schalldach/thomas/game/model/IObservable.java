package com.schalldach.thomas.game.model;

/**
 * Created by B.Sc. Thomas Schalldach on 08/11/2016. The code of this application is free to use for non-commercial projects,
 * as long as you ensure that you credit the author. For commercial usage, please contact software[at]thomas-schalldach.de
 */
public interface IObservable {

    public void attach(IObserver observer);
    public void detach(IObserver observer);
    public void notification();

}
