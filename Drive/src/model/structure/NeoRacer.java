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
public class NeoRacer extends Enemy{
    /**
     * constructor for a NeoRacer
     * @param rect rectangle for kollission
     * @param velocity velocity of the movement
     * @param img image flag
     */
    public NeoRacer(Rectangle rect, int velocity, Pictures img) {
        super(rect, velocity, img);
    }
}
