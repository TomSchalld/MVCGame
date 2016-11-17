package com.schalldach.thomas.game.factory;

import com.schalldach.thomas.game.objects.Canon;
import com.schalldach.thomas.game.objects.GameObject;

/**
 * Created by B.Sc. Thomas Schalldach on 17/11/2016. The code of this application is free to use for non-commercial projects,
 * as long as you ensure that you credit the author. For commercial usage, please contact software[at]thomas-schalldach.de
 */
public abstract class GameObjectFactory {

    public enum Method{
        Canon, Enemy, Missile,Collision,Score,Gravity, Timer
    }



    public static GameObject create(Method param){

        switch (param){
            case Canon:
                return new Canon();
            case
        }

        return null,
    }


}
