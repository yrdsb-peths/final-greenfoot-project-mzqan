import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Game screen. 
 * 
 * @author Megan Lee
 * @version June 2023
 */
public class GameWorld extends World
{
    int mana = 10;
    Label manabarPoints = new Label("MP: " + mana +"/100", 23);
    private SimpleTimer respawnTimer  = new SimpleTimer();
    private int respawnCD = 2;
    /**
     * Constructor for objects of class GameWorld.
     * 
     */
    public GameWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false); 
        respawnTimer.mark();
        prepare();
    }
    
    public void prepare() {
        Wand wand = new Wand();
        addObject(wand,300,400);
        spawnSkeleton();
        MagicPoints manabar = new MagicPoints(30);
        addObject(manabar, 115, 35);
        addObject(manabarPoints, 115, 15);
    }
    
     public void spawnSkeleton()
    {
        Skeleton skeleton = new Skeleton ();
        addObject(skeleton, Greenfoot.getRandomNumber(600), 0);
    }
    
    public void spawnMagic() {
        if(respawnTimer.millisElapsed() % 1000 != respawnCD) {
            return;
        }
        else {
            respawnCD+=2;
            Magic magic = new Magic();
            addObject(magic, Greenfoot.getRandomNumber(600), 0);
        }
    }
    
    public void act(){
        spawnMagic();
    }
    
    public void increaseMP(){
        if (mana == 100) {
            return;
        }
        else if(mana >=80){
            mana=100;
        }
        else {
            mana+=20;
        }
        manabarPoints.setValue("MP: " + mana + "/100");
    }
    
    public void decreaseMP(){
        mana--;
        manabarPoints.setValue("MP: " + mana + "/100");
    }
    
    public int getMana(){
        return mana;
    }
}
