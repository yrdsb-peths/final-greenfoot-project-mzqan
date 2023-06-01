import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Game screen. 
 * 
 * @author Megan Lee
 * @version June 2023
 */
public class GameWorld extends World
{

    /**
     * Constructor for objects of class GameWorld.
     * 
     */
    public GameWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false); 
        prepare();
    }
    
    public void prepare() {
        Wand wand = new Wand();
        addObject(wand,getWidth()/2,getHeight());
    }
}
