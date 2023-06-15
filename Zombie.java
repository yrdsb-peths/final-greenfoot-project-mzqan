import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * An Enemy, a zombie: Danger for our wizard.
 * 
 * @author Megan Lee
 * @version June 2023
 */
public class Zombie extends SmoothMover
{
    GreenfootSound death = new GreenfootSound("enemydeath.mp3"); //Sound for death of enemy
    GreenfootImage zombie = new GreenfootImage("images/zombie2.png"); //Image of zombie 
    private double speed; //Speed of falling
    private int zombieHP=2; //Number of hits needed to "kill"
   
    public Zombie() {
        setImage(zombie);
        zombie.scale(40,40);
        zombie.rotate(270);
        setRotation(90);
    }
    
    public void act(){
        //With every 10 points scored, increase speed by 0.1
        GameWorld world = (GameWorld) getWorld();
        speed = 0.75 + (0.1*(world.getLevel()));
        
        //Zombie falls downwards
         move(speed);
        
        //If skeleton reaches the bottom, remove object and switch to game over screen
        if(getY() >= world.getHeight()) 
        {
            world.removeObject(this);
            world.gameOver();
        }
        else {
            getShot();
        }
    }

    /**
     * If shot once, decrease # of hits needed to "kill", play enemy death sound effect
     * If shot twice, "kill" the zombie, increase score by 5, and play enemy death sound effect
     */
    public void getShot(){
        if(isTouching(MagicAttack.class)){
            death.play();
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
