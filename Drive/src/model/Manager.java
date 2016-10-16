/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Rectangle;
import java.util.Timer;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.TimerTask;
import drive.IObserver;
import model.structure.Names;
import model.structure.Hero;
import pictures.Pictures;
import model.structure.FigureFactory;
import pictures.ImageLoader;
import model.structure.Figures;

/**
 * manger of the model 
 * @author Paul
 */
public class Manager{

    private static Manager manager = new Manager();
    private FigureFactory factory;
    private ImageLoader loader;
    private Hero hero;
    private Timer managerTime;
    private Timer enemyTime;
    private TimerTask task;
    private TimerTask passsive;
    private int gameVelocity;
    private int intervallCreate;
    private List <Figures> enemies;
    private List <IObserver> observers;
    private Rectangle backRect;
    private int level;
    private Random rnd;
    private int levelIncrement;
    private int score;

    /**
     * constructor of the manager
     */
    private Manager(){
    }    

    /**
     * inits the manager
     */
    public void init(){
        this.factory         = FigureFactory.getInstance();
        this.loader          = ImageLoader.getInstance();
        this.rnd             = new Random();
        this.gameVelocity    = 20;
        this.intervallCreate = 30;
        this.level           = 1;
        this.levelIncrement  = 0;
        this.score           = 0;
        this.hero            = (Hero) factory.factFigure(Names.Hero, this.gameVelocity, 0);
        this.enemies         = new ArrayList <>();
        this.observers       = new ArrayList <>();
        this.backRect        = new Rectangle(0, -950, this.loader.getImage(Pictures.Game).getWidth(null), this.loader.getImage(Pictures.Game).getHeight(null));
    }

    /**
     * Instance for the singleton pattern
     * @return static manager instance
     */
    public static Manager getInstance(){
        return Manager.manager;
    }

    /**
     * starts all timers
     */
    public void start(){
      this.managerTime     = new Timer();
      this.enemyTime       = new Timer();
      this.task            = new TimerTask(){
            @Override
            public void run(){
                move();
                if(kolission()){
                    notifyObservers(States.GameOver);
                    stop();
                }
            }
        };
        this.passsive = new TimerTask(){
            @Override
            public void run() {
                factEnemies();
            }
        };
      this.managerTime.scheduleAtFixedRate(task, 0, this.intervallCreate);
      this.enemyTime.scheduleAtFixedRate(passsive, 0, this.intervallCreate * 50);
      this.hero.startHero();
    }

    /**
     * stops all timers
     */
    public void stop(){
        this.managerTime.cancel();
        this.enemyTime.cancel();
        this.hero.killHero();
    }

    /**
     * products all enemies
     */
    private void factEnemies(){
        this.raiseLevelCheck();
        this.addBlueCar();
        this.addRedCar();
        this.addBlackCar();
        this.addPolice();
        if(this.level >= 10){
            this.addBlueRacer();
            this.addLilaRacer();
            this.addNeoRacer();
            this.addDredger();
            this.addFireTruck();
        }
        if(this.level >= 15){
            this.addBullet();
            this.addAirplane();
            this.addJeep();
            this.addLightning();
            this.addTank();
        }
    }
    
    private int factPos(){
        int position = 0;
        switch(rnd.nextInt(6)){
            case 0:
                position = 70;
                break;
            
            case 1:
                position = 310;
                break;
             
            case 2:
                position = 550;
                break;
               
            case 3:
                position = 775;
                break;
                
            case 4:
                position = 1015;
                break;
                
            case 5:
                position = 1255;
                break;
        }
        return position;
    }
    
    /**
     * produces an Airplane
     */
    private void addAirplane(){
        switch(this.rnd.nextInt(10)){
            case 0: case 2: case 4: case 6:case 8:
                enemies.add(factory.factFigure(Names.Airplane, this.gameVelocity, this.factPos()));
                break;
        }
    }
    
    /**
     * produces a BlackCar
     */
    private void addBlackCar(){
        switch(this.rnd.nextInt(10)){
            case 0: case 2: case 4: case 6:case 8:
                enemies.add(factory.factFigure(Names.BlackCar, this.gameVelocity, this.factPos()));
                break;
        }
    }
    
    /**
     * produces a BlueCar
     */
    private void addBlueCar(){
        switch(this.rnd.nextInt(10)){
            case 0: case 2: case 4: case 6:case 8:
                enemies.add(factory.factFigure(Names.BlueCar, this.gameVelocity, this.factPos()));
                break;
        }
    }
    
    /**
     * produces a BlueRacer
     */
    private void addBlueRacer(){
        switch(this.rnd.nextInt(10)){
            case 0: case 2: case 4: case 6:case 8:
                enemies.add(factory.factFigure(Names.BlueRacer, this.gameVelocity, this.factPos()));
                break;
        }
    }
    
    /**
     * produces a Bullet
     */
    private void addBullet(){
        switch(this.rnd.nextInt(10)){
            case 0: case 2: case 4: case 6:case 8:
                enemies.add(factory.factFigure(Names.Bullet, this.gameVelocity, this.factPos()));
                break;
        }
    }
    
    /**
     * produces a Dredger
     */
    private void addDredger(){
        switch(this.rnd.nextInt(10)){
            case 0: case 2: case 4: case 6:case 8:
                enemies.add(factory.factFigure(Names.Dredger, this.gameVelocity, this.factPos()));
                break;
        }
    }
    
    /**
     * produces a FireTruck
     */
    private void addFireTruck(){
        switch(this.rnd.nextInt(10)){
            case 0: case 2: case 4: case 6:case 8:
                enemies.add(factory.factFigure(Names.FireTruck, this.gameVelocity, this.factPos()));
                break;
        }
    }
    
    /**
     * produces a Bullet
     */
    private void addJeep(){
        switch(this.rnd.nextInt(10)){
            case 0: case 2: case 4: case 6:case 8:
                enemies.add(factory.factFigure(Names.Jeep, this.gameVelocity, this.factPos()));
                break;
        }
    }
    
    /**
     * produces a Lightning
     */
    private void addLightning(){
        switch(this.rnd.nextInt(10)){
            case 0: case 2: case 4: case 6:case 8:
                enemies.add(factory.factFigure(Names.Lightning, this.gameVelocity, this.factPos()));
                break;
        }
    }
    
    /**
     * produces a LilaRacer
     */
    private void addLilaRacer(){
        switch(this.rnd.nextInt(10)){
            case 0: case 2: case 4: case 6:case 8:
                enemies.add(factory.factFigure(Names.LilaRacer, this.gameVelocity, this.factPos()));
                break;
        }
    }
    
    /**
     * produces a NeoRacer
     */
    private void addNeoRacer(){
        switch(this.rnd.nextInt(10)){
            case 0: case 2: case 4: case 6:case 8:
                enemies.add(factory.factFigure(Names.NeoRacer, this.gameVelocity, this.factPos()));
                break;
        }
    }
    
    /**
     * produces a Police
     */
    private void addPolice(){
        switch(this.rnd.nextInt(10)){
            case 0: case 2: case 4: case 6:case 8:
                enemies.add(factory.factFigure(Names.Police, this.gameVelocity, this.factPos()));
                break;
        }
    }
    
    /**
     * produces a RedCar
     */
    private void addRedCar(){
        switch(this.rnd.nextInt(10)){
            case 0: case 2: case 4: case 6:case 8:
                enemies.add(factory.factFigure(Names.RedCar, this.gameVelocity, this.factPos()));
                break;
        }
    }
    
    /**
     * produces a Tank
     */
    private void addTank(){
        switch(this.rnd.nextInt(10)){
            case 0: case 2: case 4: case 6:case 8:
                enemies.add(factory.factFigure(Names.Tank, this.gameVelocity, this.factPos()));
                break;
        }
    }
    
    /**
     * raises the level
     */
    private void raiseLevelCheck(){
        this.levelIncrement++;
        if (this.levelIncrement > 60) {
            this.level++;
            this.gameVelocity++;
            this.levelIncrement = 0;
        }
    }

    /**
     * calls the move method of all enemies and the dino
     */
    private void move(){
        this.killEnemies();
        for (int i = 0; i < this.enemies.size(); i++){
            this.enemies.get(i).move(this.gameVelocity);
        }
        if (this.backRect.y >= -10){
            this.backRect.setLocation(0, -950);
        }
        this.backRect.y  += this.gameVelocity;
    }

    /**
     * dino getter
     * @return dino of the model
     */
    public Hero getHero(){
        return this.hero;
    }

    /**
     * enemy list getter
     * @return enemy list
     */
    public List <Figures> getEnemies(){
         return this.enemies;
    }

    /**
     * forward method
     */
    public void forward(){
        this.hero.move(25);
    }
    
    /**
     * reverse method
     */
    public void revers(){
        this.hero.move(-25);
    }
    
    /**
     * up method
     */
    public void up(){
        this.hero.drive(-25);
    }
    
    /**
     * down method
     */
    public void down(){
        this.hero.drive(25);
    }

    /**
     * getter for the background rectangle
     * @return rectangle of background
     */
    public Rectangle getBackRect(){
        return this.backRect;
    }
    
    /**
     * checks for kollission
     * @return true if kollission happened
     */
    private boolean kolission(){
        boolean kollission = false;
        for (int i = 0; i < enemies.size(); i++){
            if(this.enemies.get(i).getRect().intersects(this.hero.getRect())){
                kollission = true;
            }
        }
        return kollission;
    }

    /**
     * hero model does not move horizontal
     */
    public void stillHori() {
        this.hero.move(0);
    }
    
    /**
     * hero model does not move vertical
     */
    public void stillVert() {
        this.hero.drive(0);
    }

    /**
     * getter for the level
     * @return level of the model
     */
    public int getLevel() {
        return this.level;
    }

    /**
     * kills the nemeys that are not visible
     */
    private void killEnemies(){
        for(int i = 0; i < this.enemies.size(); i++){
            if(this.enemies.get(i).getRect().y > 1500){
                this.score += 10;
                this.enemies.remove(i);
            }
        }
        this.notifyObservers(States.LevelUpdate);
    }

    /**
     * getter for the score
     * @return score of the model
     */
    public int getScore() {
        return this.score;
    }
    
    /**
     * attach method of the observer pattern
     * @param observer observer to attach
     */
    public void attach(IObserver observer){
        this.observers.add(observer);
    }
    
    /**
     * notification method of the observer pattern
     * @param state state for the state machine
     */
    private void notifyObservers(States state){
        for (int i = 0; i < this.observers.size(); i++){
            this.observers.get(i).update(state);
        }
    }
}
