import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Game Over Screen: Player can view their recent score, and go back to title screen.
 * 
 * @author Megan Lee
 * @version June 2023
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
    
    /**
     * Add buttons, creates label to display score.
     */
    public void prepare() {
        Label scoreLabel = new Label(GameWorld.getScore(), 35);
        scoreLabel.setFillColor(Color.WHITE);
        addObject(scoreLabel, 308, 226);
        
        BackToTitleButton backToTitleBtn = new BackToTitleButton();
        addObject(backToTitleBtn, 300, 300);
    }
}
