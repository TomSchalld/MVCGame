package com.schalldach.thomas.model;

import com.schalldach.thomas.gameSrc.Canon;
import com.schalldach.thomas.gameSrc.Collision;
import com.schalldach.thomas.gameSrc.Enemy;
import com.schalldach.thomas.gameSrc.Missile;
import com.schalldach.thomas.gameSrc.helper.Gravity;
import com.schalldach.thomas.gameSrc.helper.Score;

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


}
