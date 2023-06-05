import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Magic here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
