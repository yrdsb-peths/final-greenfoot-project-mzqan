import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Game screen. 
 * 
 * @author Megan Lee
 * @version June 2023
 */
public class GameWorld extends World
{
    int score;
    Label manabarPoints = new Label("MP: " + score, 23);
    private SimpleTimer respawnTimer  = new SimpleTimer();
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
        addObject(wand,300,400);
        spawnSkeleton();
        MagicPoints manabar = new MagicPoints(30);
        addObject(manabar, 115, 35);
        addObject(manabarPoints, 115, 15);
        spawnMagic();
    }
    
     public void spawnSkeleton()
    {
        Skeleton skeleton = new Skeleton ();
        addObject(skeleton, Greenfoot.getRandomNumber(600), 0);
    }
    
    
    public void spawnMagic() {
        respawnTimer.mark();
        if(respawnTimer.millisElapsed() < 3000) {
            return;
        }
        Magic magic = new Magic();
        addObject(magic, Greenfoot.getRandomNumber(600), 0);
    }
}
