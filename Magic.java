import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Falling magical orbs that provide 20 mana each.
 * 
 * @author Megan
 * @version June 2023
 */
public class Magic extends SmoothMover
{
    GreenfootImage magic = new GreenfootImage("images/magic.png"); //Image for the magical orb
    
    public Magic() {
        setImage(magic);
        magic.scale(35,35);
    }
    
    public void act(){
        //Magic orb falls downwards
        int x = getX();
        double y = getY() + 0.5;
        setLocation(x, y);
        
        //If it reaches the bottom, remove object
        GameWorld world = (GameWorld) getWorld();
        if(getY() >= world.getHeight()) 
        {
            world.removeObject(this); 
        }
    }
}
