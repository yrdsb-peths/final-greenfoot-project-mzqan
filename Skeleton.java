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
    private double speed;
    /**
     * Act - do whatever the Skeleton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Skeleton() {
        setImage(skull);
        skull.scale(40,40);
    }
    public void act(){
        GameWorld world = (GameWorld) getWorld();
        speed = 0.5 + (0.1*(world.getLevel()));
        int x = getX();
        double y = getY() + speed;
        setLocation(x, y);
        
       
        if(getY() >= world.getHeight()) 
        {
            world.removeObject(this);
            world.spawnSkeleton();
            world.gameOver();
        }
    }
    
}
