import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Magical orbs that provide 20 mana each.
 * 
 * @author Megan
 * @version June 2023
 */
public class Magic extends SmoothMover
{
    GreenfootImage magic = new GreenfootImage("images/magic.png");
    /**
     * Act - do whatever the Skeleton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Magic() {
        setImage(magic);
        magic.scale(35,35);
    }
    public void act(){
        int x = getX();
        double y = getY() + 0.5;
        setLocation(x, y);
        
        GameWorld world = (GameWorld) getWorld();
        if(getY() >= world.getHeight()) 
        {
            world.removeObject(this);
        }
    }
}
