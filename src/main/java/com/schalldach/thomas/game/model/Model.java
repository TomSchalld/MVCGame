package com.schalldach.thomas.game.model;

import com.schalldach.thomas.game.objects.Canon;
import com.schalldach.thomas.game.objects.Collision;
import com.schalldach.thomas.game.objects.Enemy;
import com.schalldach.thomas.game.objects.Missile;
import com.schalldach.thomas.game.helper.Gravity;
import com.schalldach.thomas.game.helper.Score;

import java.util.List;
import java.util.Timer;

/**
 * Created by B.Sc. Thomas Schalldach on 16/10/2016. The code of this application is free to use for non-commercial projects,
 * as long as you ensure that you credit the author. For commercial usage, please contact software[at]thomas-schalldach.de
 */
public class Model {
    private Canon canon;
    private List<Enemy> enemies;
    private List<Missile> missiles;
    private List<Collision> collisions;
    private Score score;
    private Gravity gravity;
    private Timer timer;

    //methods
    /*
    * moveCanonUp
    * changeCanonAngle
    * shoot
    * changeGravity
    *
    * main game loop
    *
    * moves missiles, checks collisions, discards old objects
    *
    * moves objects
    * */
}