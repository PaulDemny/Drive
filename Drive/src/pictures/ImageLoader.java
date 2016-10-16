/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pictures;

import java.awt.Image;
import java.awt.image.BufferedImage;
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
    private BufferedImage backGame      = null;
    private BufferedImage picHero       = null;
    private BufferedImage picAirplane   = null;
    private BufferedImage picBlackCar   = null;
    private BufferedImage picBlueCar    = null;
    private BufferedImage picBlueRacer  = null;
    private BufferedImage picBullet     = null;
    private BufferedImage picDredger    = null;
    private BufferedImage picFireTruck  = null;
    private BufferedImage picJeep       = null;
    private BufferedImage picLightning  = null;
    private BufferedImage picLilaRacer  = null;
    private BufferedImage picNeoRacer   = null;
    private BufferedImage picPolice     = null;
    private BufferedImage picRedCar     = null;
    private BufferedImage picTank       = null;
    
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
            this.backGame       = ImageIO.read(getClass().getClassLoader().getResource("pictures/files/Street2.jpg"));
            this.picHero        = ImageIO.read(getClass().getClassLoader().getResource("pictures/files/Hero.png"));
            this.picAirplane    = ImageIO.read(getClass().getClassLoader().getResource("pictures/files/Airplane.png"));
            this.picBlackCar    = ImageIO.read(getClass().getClassLoader().getResource("pictures/files/BlackCar.png"));
            this.picBlueCar     = ImageIO.read(getClass().getClassLoader().getResource("pictures/files/BlueCar.png"));
            this.picBlueRacer   = ImageIO.read(getClass().getClassLoader().getResource("pictures/files/BlueRacer.png"));
            this.picBullet      = ImageIO.read(getClass().getClassLoader().getResource("pictures/files/Bullet.png"));
            this.picDredger     = ImageIO.read(getClass().getClassLoader().getResource("pictures/files/Dredger.png"));
            this.picFireTruck   = ImageIO.read(getClass().getClassLoader().getResource("pictures/files/FireTruck.png"));
            this.picJeep        = ImageIO.read(getClass().getClassLoader().getResource("pictures/files/Jeep.png"));
            this.picLightning   = ImageIO.read(getClass().getClassLoader().getResource("pictures/files/Lightning.png"));
            this.picLilaRacer   = ImageIO.read(getClass().getClassLoader().getResource("pictures/files/LilaRacer.png"));
            this.picNeoRacer    = ImageIO.read(getClass().getClassLoader().getResource("pictures/files/NeoRacer.png"));
            this.picPolice      = ImageIO.read(getClass().getClassLoader().getResource("pictures/files/Police.png"));
            this.picRedCar      = ImageIO.read(getClass().getClassLoader().getResource("pictures/files/RedCar.png"));
            this.picTank        = ImageIO.read(getClass().getClassLoader().getResource("pictures/files/Tank.png"));
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
                
            case Game:
                imageInstance = this.backGame;
                break;
                
            case Hero:
                imageInstance = this.picHero;
                break;
            
            case Airplane:
                imageInstance = this.picAirplane;
                break;
                
            case BlackCar:
                imageInstance = this.picBlackCar;
                break;
                
            case BlueCar:
                imageInstance = this.picBlueCar;
                break;
                
            case BlueRacer:
                imageInstance = this.picBlueRacer;
                break;
                
            case Bullet:
                imageInstance = this.picBullet;
                break;
                
            case Dredger:
                imageInstance = this.picDredger;
                break;
                
            case FireTruck:
                imageInstance = this.picFireTruck;
                break;
                
            case Jeep:
                imageInstance = this.picJeep;
                break;
                
            case Lightning:
                imageInstance = this.picLightning;
                break;
                
            case LilaRacer:
                imageInstance = this.picLilaRacer;
                break;
                
            case NeoRacer:
                imageInstance = this.picNeoRacer;
                break;
                
            case Police:
                imageInstance = this.picPolice;
                break;
                
            case RedCar:
                imageInstance = this.picRedCar;
                break;
                
            case Tank:
                imageInstance = this.picTank;
                break;
            default:
                imageInstance = null;
        }
        return imageInstance;
    }
}
    

