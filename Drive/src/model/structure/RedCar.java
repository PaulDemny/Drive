/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.structure;

import java.awt.Rectangle;
import pictures.Pictures;

/**
 *
 * @author Paul
 */
public class RedCar extends Enemy{
    /**
     * constructor for a RedCar
     * @param rect rectangle for kollission
     * @param velocity velocity of the movement
     * @param img image flag
     */
    public RedCar(Rectangle rect, int velocity, Pictures img) {
        super(rect, velocity, img);
    }
}
