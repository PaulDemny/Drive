/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pictures;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 * class for imageloader 
 * @author Paul
 */
public class ImageLoader {
    
    private static ImageLoader imageLoaderInstance = new ImageLoader();
    
    private BufferedImage backMenue     = null;
    private BufferedImage backHighscore = null;
    private BufferedImage backInstruct  = null;
    private BufferedImage backPause     = null;
    private BufferedImage backGameOver  = null;
    
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
        try{
        
            this.backGameOver   = ImageIO.read(getClass().getClassLoader().getResource("pictures/files/GameOver.jpg"));
            this.backHighscore  = ImageIO.read(getClass().getClassLoader().getResource("pictures/files/Highscore.jpg"));
            this.backInstruct   = ImageIO.read(getClass().getClassLoader().getResource("pictures/files/Instruction.jpg"));
            this.backMenue      = ImageIO.read(getClass().getClassLoader().getResource("pictures/files/Menue.jpg"));
            this.backPause      = ImageIO.read(getClass().getClassLoader().getResource("pictures/files/Pause.jpg"));
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
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
    public Image getImage(Pictures imageName){
        Image imageInstance = null;
        
        switch(imageName){
            
            case GameOver:
                imageInstance = this.backGameOver;
                break;
                
            case Highscore:
                imageInstance = this.backHighscore;
                break;
               
            case Instruction:
                imageInstance = this.backInstruct;
                break;
                
            case Menue:
                imageInstance = this.backMenue;
                break;
              
            case Pause:
                imageInstance = this.backPause;
                break;
            
            default:
                imageInstance = null;
        }
        return imageInstance;
    }
}
    

