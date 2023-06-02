import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Danger for our wizard.
 * 
 * @author Megan 
 * @version June 2023
 */
public class Skeleton extends SmoothMover
{
    GreenfootImage skull = new GreenfootImage("images/skull.png");
    /**
     * Act - do whatever the Skeleton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Skeleton() {
        setImage(skull);
        skull.scale(80,80);
    }
    public void act(){
        //Apple falls downwards
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
