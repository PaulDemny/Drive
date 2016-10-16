/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.structure;

import java.awt.Rectangle;
import pictures.Pictures;
/**
 * calss for dino object
 * @author Paul
 */
public class Hero extends Figures{
   
    private volatile int heroVertVelocity;
    private volatile int heroHoriVelocity;
    private Thread walking;
    private boolean movement;

    /**
     * constructor for the hero
     * @param rect Ractangle for the kollission
     * @param img image flag
     */
    public Hero(Rectangle rect, Pictures img) {
        super(rect, img);
        this.heroVertVelocity = 0;
        this.heroHoriVelocity = 0;
        this.movement = true;
    }

    /**
     * kills dino movement
     */
    public void killHero(){
        this.movement = false;
    }

    /**
     * setter of the dino velocity
     * @param direction velocity of the movement
     */
    @Override
    public void move(int direction) {
        this.heroHoriVelocity = direction;
    }
    
    public void  drive(int direction){
        this.heroVertVelocity = direction;
    }
    
    /**
     * inits hero
     */
    public void startHero(){
        this.walking = new Thread(){
            @Override
            public void run() {
                while (movement) {
                    if(heroVertVelocity > 0){
                        if(rect.y + rect.height < 990){
                            rect.y += heroVertVelocity;
                        }
                    }
                    if(heroVertVelocity < 0){
                        if(rect.y > 40){
                            rect.y += heroVertVelocity;
                        }
                    }
                    if(heroHoriVelocity < 0){
                        if(rect.x > 10){
                            rect.x += heroHoriVelocity;
                        }
                    }
                    if(heroHoriVelocity > 0){
                        if(rect.x + rect.width < 1490){
                            if(rect.x < 1490){
                            rect.x += heroHoriVelocity;
                        }
                        }
                    }
                    try {
                        Thread.sleep(25);
                    } 
                    catch (Exception ex) {
                        System.err.println(ex.getMessage());
                    }
                }
            }
        };
        this.walking.start();
        this.movement = true;
    }
}
