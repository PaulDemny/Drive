/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.structure;

import java.awt.Rectangle;
import pictures.ImageLoader;
import pictures.Pictures;

/**
 * factory of factory method pattern
 * @author Paul
 */
public class FigureFactory {

    private static FigureFactory figureFactory = new FigureFactory();
    private Figures newfig;
    private ImageLoader loader;

    /**
     * constructor of the figure factory
     */
    private FigureFactory(){
        loader = pictures.ImageLoader.getInstance();
    }

    /**
     * Singleton pattern instance method
     * @return static instance of figure factory
     */
    public static FigureFactory getInstance(){
        return figureFactory;
    }

    /**
     * method creates a new figure
     * @param objectName flag for the stata machine 
     * @param velocity move velocity of the new figure
     * @param position street selection
     * @return new figure
     */
    public Figures factFigure(Names objectName, int velocity, int position){
        
        newfig = null;
        
        switch(objectName){
            case Airplane:
                newfig = new Airplane(new Rectangle(position, -500 , loader.getImage(Pictures.Airplane).getWidth(null), loader.getImage(Pictures.Airplane).getHeight(null)), velocity, Pictures.Airplane);
                break;
                
            case BlackCar:
                newfig = new BlackCar(new Rectangle(position, -500 , loader.getImage(Pictures.BlackCar).getWidth(null), loader.getImage(Pictures.BlackCar).getHeight(null)), velocity, Pictures.BlackCar);
                break;
                
            case BlueCar:
                newfig = new BlueCar(new Rectangle(position, -500 , loader.getImage(Pictures.BlueCar).getWidth(null), loader.getImage(Pictures.BlueCar).getHeight(null)), velocity, Pictures.BlueCar);
                break;
                
            case BlueRacer:
                newfig = new BlueRacer(new Rectangle(position, -500 , loader.getImage(Pictures.BlueRacer).getWidth(null), loader.getImage(Pictures.BlueRacer).getHeight(null)), velocity, Pictures.BlueRacer);
                break;
                
            case Bullet:
                newfig = new Bullet(new Rectangle(position, -500 , loader.getImage(Pictures.Bullet).getWidth(null), loader.getImage(Pictures.Bullet).getHeight(null)), velocity, Pictures.Bullet);
                break;
                
            case Dredger:
                newfig = new Dredger(new Rectangle(position, -500 , loader.getImage(Pictures.Dredger).getWidth(null), loader.getImage(Pictures.Dredger).getHeight(null)), velocity, Pictures.Dredger);
                break;
                
            case FireTruck:
                newfig = new FireTruck(new Rectangle(position, -500 , loader.getImage(Pictures.FireTruck).getWidth(null), loader.getImage(Pictures.FireTruck).getHeight(null)), velocity, Pictures.FireTruck);
                break;
                
            case Hero:
                newfig = new Hero(new Rectangle(670, 550 , loader.getImage(Pictures.Hero).getWidth(null), loader.getImage(Pictures.Hero).getHeight(null)), Pictures.Hero);
                break;
                
            case Jeep:
                newfig = new Jeep(new Rectangle(position, -500 , loader.getImage(Pictures.Jeep).getWidth(null), loader.getImage(Pictures.Jeep).getHeight(null)), velocity, Pictures.Jeep);
                break;
                
            case Lightning:
                newfig = new Lightning(new Rectangle(position, -500 , loader.getImage(Pictures.Lightning).getWidth(null), loader.getImage(Pictures.Lightning).getHeight(null)), velocity, Pictures.Lightning);
                break;
                
            case LilaRacer:
                newfig = new LilaRacer(new Rectangle(position, -500 , loader.getImage(Pictures.LilaRacer).getWidth(null), loader.getImage(Pictures.LilaRacer).getHeight(null)), velocity, Pictures.LilaRacer);
                break;
                
            case NeoRacer:
                newfig = new NeoRacer(new Rectangle(position, -500 , loader.getImage(Pictures.NeoRacer).getWidth(null), loader.getImage(Pictures.NeoRacer).getHeight(null)), velocity, Pictures.NeoRacer);
                break;
                
            case Police:
                newfig = new Police(new Rectangle(position, -500 , loader.getImage(Pictures.Police).getWidth(null), loader.getImage(Pictures.Police).getHeight(null)), velocity, Pictures.Police);
                break;
                
            case RedCar:
                newfig = new RedCar(new Rectangle(position, -500 , loader.getImage(Pictures.RedCar).getWidth(null), loader.getImage(Pictures.RedCar).getHeight(null)), velocity, Pictures.RedCar);
                break;
                
            case Tank:
                newfig = new Tank(new Rectangle(position, -500 , loader.getImage(Pictures.Tank).getWidth(null), loader.getImage(Pictures.Tank).getHeight(null)), velocity, Pictures.Tank);
                break;
        }
        return newfig;
    }
}
