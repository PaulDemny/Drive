/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pictures;

import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;

/**
 * class for imageloader 
 * @author Paul
 */
public class ImageLoader {
    
    private static ImageLoader imageLoaderInstance = new ImageLoader();
    
    private BufferedImage background    = null;
    private BufferedImage large         = null;
    private BufferedImage middle        = null;
    private BufferedImage small         = null;
    private BufferedImage normal        = null;
    
    /**
     * constructor for imageloader
     */
    private ImageLoader(){
        initLoader();
    }
    
    /**
     * inits the loader
     */
    private void initLoader(){
    }
    
    /**
     * getInstance for the singleton pattern
     * @return instance of the loader 
     */
    public static ImageLoader getInstance(){
        return imageLoaderInstance;
    }
    
    /**
     * factory method
     * @param imageName flag for state machine
     * @return returns image
     */
    public Image getImage(pictures.Pictures imageName){
        Image imageInstance = null;
        return imageInstance;
    }
}
    

