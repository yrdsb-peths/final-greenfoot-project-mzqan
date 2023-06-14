import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * An Enemy, a skeleton: Danger for our wizard.
 * 
 * @author Megan 
 * @version June 2023
 */
public class Skeleton extends SmoothMover
{
    GreenfootImage skull = new GreenfootImage("images/skull.png"); //Image of the skeleton
    private double speed; //Speed of falling
    
    public Skeleton() {
        setImage(skull);
        skull.scale(40,40);
        skull.rotate(270);
        setRotation(90);
    }
    
    public void act(){
        //With every 10 points scored, increase speed by 0.1
        GameWorld world = (GameWorld) getWorld();
        speed = 0.75 + (0.1*(world.getLevel()));
    
        //Skeleton falls downwards
        move(speed);
        
       //If skeleton reaches the bottom, remove object and switch to game over screen
        if(getY() >= world.getHeight()) 
        {
            world.removeObject(this);
            world.spawnSkeleton();
            world.gameOver();
        }
    }
    
}
