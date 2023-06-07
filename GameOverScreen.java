import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOverScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOverScreen extends World
{
    /**
     * Constructor for objects of class GameOverScreen.
     * 
     */
    public GameOverScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        prepare();
    }
    
    public void prepare() {
        Label scoreLabel = new Label(GameWorld.getScore(), 50);
        scoreLabel.setFillColor(Color.WHITE);
        addObject(scoreLabel, 300, 220);
        
        BackToTitleButton backToTitleBtn = new BackToTitleButton();
        addObject(backToTitleBtn, 300, 280);
    }
}
