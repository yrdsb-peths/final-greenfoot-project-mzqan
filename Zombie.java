import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Zombie here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Zombie extends SmoothMover
{
    GreenfootImage zombie = new GreenfootImage("images/zombie2.png");
    private double speed;
    private int zombieHP=2;
    /**
     * Act - do whatever the Skeleton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Zombie() {
        setImage(zombie);
        zombie.scale(40,40);
    }
    public void act(){
        GameWorld world = (GameWorld) getWorld();
        speed = 0.5 + (0.2*(world.getLevel()));
        int x = getX();
        double y = getY() + speed;
        setLocation(x, y);
        
        if(getY() >= world.getHeight()) 
        {
            world.removeObject(this);
            world.gameOver();
        }
        else {
            getShot();
        }
        
    }

    public void getShot(){
        if(isTouching(MagicAttack.class)){
            removeTouching(MagicAttack.class);
            zombieHP --;
            GameWorld world = (GameWorld) getWorld();
            if(zombieHP < 1){
                world.increaseScore(5);
                world.removeObject(this);
            }
        }
    }
}
