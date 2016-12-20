package com.schalldach.thomas.game.model;

import com.schalldach.thomas.game.GameMemento;
import com.schalldach.thomas.game.factory.AbstractGameObjectFactory;
import com.schalldach.thomas.game.factory.ConcreteFactory;
import com.schalldach.thomas.game.helper.Score;
import com.schalldach.thomas.game.objects.*;

import java.util.*;

/**
 * Created by B.Sc. Thomas Schalldach on 16/10/2016. The code of this application is free to use for non-commercial projects,
 * as long as you ensure that you credit the author. For commercial usage, please contact software[at]thomas-schalldach.de
 */
public class Model implements IObservable {
    final private ConcreteFactory missileFactory = AbstractGameObjectFactory.createMissileFactory();
    final private ConcreteFactory cannonFactory = AbstractGameObjectFactory.createCannonFactory();
    final private ConcreteFactory collisionFactory = AbstractGameObjectFactory.createCollisionFactory();
    final private ConcreteFactory enemyFactory = AbstractGameObjectFactory.createEnemyFactory();

    private int missileIndicator = 0;
    private final List<IObserver> observers;
    private Cannon cannon;
    private List<Enemy> enemies;
    private List<Missile> missiles;
    private List<Collision> collisions;
    private Score score;
    private boolean gameEnd = false;
    private boolean newLevel;

    public Model() {

        enemies = new ArrayList<>();
        missiles = new ArrayList<>();
        collisions = new ArrayList<>();
        observers = new ArrayList<>();
        score = new Score();


    }

    public Cannon getCannon() {
        return cannon;
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }

    public List<Missile> getMissiles() {
        return missiles;
    }

    public List<Collision> getCollisions() {
        return collisions;
    }

    public Score getScore() {
        return score;
    }

    public void attach(IObserver observer) {
        observers.add(observer);
    }

    public void detach(IObserver observer) {
        observers.remove(observer);
    }

    public void notification() {
        // Canvas must implement IObserver
        try {
            observers.forEach(IObserver::update);
        }catch (ConcurrentModificationException e){

        }
    }

    public void doBasicInstantiation() {


        this.cannon = (Cannon) cannonFactory.create();
        generateEnemies(score.getLevel());

    }

    private void generateEnemies(int level) {
        for (int i = 0; i < 10 + level; i++) {
            this.enemies.add((Enemy) enemyFactory.create());
        }
    }

    public List<GameObject> getObjects() {
        List<GameObject> list = new LinkedList<>();
        list.addAll(getMissiles());
        list.addAll(getEnemies());
        list.addAll(getCollisions());
        list.add(getCannon());
        return list;

    }

    public void moveCannonLeft() {
        cannon.move(Arrays.asList(cannon.getPosition().getVector().get(0) - 30.0, cannon.getPosition().getVector().get(1)));
        if (cannon.isPositionNotValid()) {
            moveCannonRight();
        }
    }

    public void moveCannonRight() {
        cannon.move(Arrays.asList(cannon.getPosition().getVector().get(0) + 30.0, cannon.getPosition().getVector().get(1)));
        if (cannon.isPositionNotValid()) {
            moveCannonLeft();
        }
    }


    public void checkForCollision() throws ArrayIndexOutOfBoundsException{
        List<Enemy> enemyDisposal = new ArrayList<>();
        List<Missile> missileDisposal = new ArrayList<>();
        List<Enemy> enemies = new ArrayList<>(this.enemies);
        List<Missile> missiles = new ArrayList<>(this.missiles);

        for (int i = 0; i < missiles.size(); i++) {
            for (int j = 0; j < enemies.size(); j++) {
                    if (missiles.get(i).getPosition().equals(enemies.get(j).getPosition())) {
                        enemyDisposal.add(enemies.get(j));
                        missileDisposal.add(missiles.get(i));
                        if (missileIndicator > 0) {
                            missileIndicator--;
                        }
                        collisionFactory.setInitialPosition(enemies.get(j).getPosition());
                        collisions.add((Collision) collisionFactory.create());
                        score.kill();
                    }


            }
        }
        this.enemies.removeAll(enemyDisposal);
        this.missiles.removeAll(missileDisposal);
        if (enemies.isEmpty() && !gameEnd) {
            score.levelUp();
            collisions.clear();
            missiles.clear();
            missileIndicator = 0;
            generateEnemies(score.getLevel());
            this.setNewLevel(true);
        }
    }


    private void fireCannon() {
        if (missileIndicator < missiles.size()) {
            missiles.get(missileIndicator).move(cannon.getPosition().getVector());
            cannon.shoot(missiles.get(missileIndicator));
            missileIndicator++;
        }
    }

    private void createMissile() {
        missiles.add((Missile) missileFactory.create());
    }

    public synchronized void shoot() {
        if (cannon.getState() == Cannon.CannonState.shootable) {
            this.createMissile();
            this.fireCannon();
        } else {
            System.err.println("Cant Shoot cannon is in state: " + cannon.getState());
        }

    }

    public boolean hasLifes() {
        return score.getLifes() > 0;
    }

    public void takeALife() {
        score.takeLife();
        if (!hasLifes()) {
            endGame();
        }
    }

    private void endGame() {
        enemies.clear();
        missiles.clear();
        collisions.clear();
        this.gameEnd = true;
    }

    public boolean isGameEnd() {
        return gameEnd;
    }

    public GameMemento save() {
        return new GameMemento(this);
    }

    public void reset(GameMemento pop) {

        this.missileIndicator = pop.getMissileIndicator();
        this.collisions=pop.getCollisions();
        this.missiles=pop.getMissiles();
        this.enemies=pop.getEnemies();
        this.score=pop.getScore();
        this.gameEnd=pop.isGameEnd();

    }

    public boolean isNewLevel() {
        return newLevel;
    }

    public void setNewLevel(boolean newLevel) {
        this.newLevel = newLevel;
    }

    public int getMissileIndicator() {
        return missileIndicator;
    }
}
