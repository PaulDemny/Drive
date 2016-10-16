/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drive;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import pictures.ImageLoader;
import javax.swing.JButton;
import model.Manager;
import pictures.Pictures;

/**
 * panel that contains the pause 
 * @author Paul
 */
public class PausePanel extends JPanel implements ActionListener{
    
    private ImageLoader loader;
    private JButton resume;
    private JButton end;
    private Game game;
    private Manager manager;
    
    /**
     * Constructor of the Pausepanel
     * @param game instance of game form
     */
    public PausePanel(Game game){
        this.game = game;
        this.manager = Manager.getInstance();
        this.init();
    }
    
    /**
     * inits the panel
     */
    private void init(){
        this.setLayout(null);
        this.loader = ImageLoader.getInstance();
        this.setSize(1500, 1000);
        this.resume = new JButton("Resume Game");
        this.resume.setForeground(new Color(255,51,153));
        this.resume.setFont(new Font(Font.MONOSPACED, Font.BOLD, 50));
        this.resume.setBounds(150, 700, 500, 200);
        this.resume.setBackground(new Color(51,0,51));
        this.resume.addActionListener(this);
        this.add(resume);
        this.end = new JButton("Finish Game");
        this.end.setForeground(new Color(255,51,153));
        this.end.setFont(new Font(Font.MONOSPACED, Font.BOLD, 50));
        this.end.setBounds(800, 700, 500, 200);
        this.end.setBackground(new Color(51,0,51));
        this.end.addActionListener(this);
        this.add(end);
    }

    /**
     * paints the background and images
     * @param g Graphics object of the panel
     */
    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(loader.getImage(Pictures.Pause), 0, 0, 1500, 1000, null);
        g.setColor(new Color(51,0,51));
        g.fillRect(200, 510, 1050, 150);
        g.setColor(new Color(255,51,153));
        g.setFont(new Font(Font.MONOSPACED, Font.BOLD, 200));
        g.drawString("PAUSE", 470, 180);
        g.setFont(new Font(Font.MONOSPACED, Font.BOLD, 70));
        g.drawString("Level: ".concat(String.valueOf(this.manager.getLevel())).concat("   Score: ").concat(String.valueOf(this.manager.getScore())), 270, 600);
    }

    /**
     * KeyListener
     * @param e ActionEvent
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(resume)){
            this.setFocusable(false);
            game.killPause();
        }
        
        if(e.getSource().equals(end)){
            game.finish();
        }
    }
}
