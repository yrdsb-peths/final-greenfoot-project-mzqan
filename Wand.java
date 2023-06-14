import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A weapon for our wizard - a wand.
 * 
 * @author Megan Lee
 * @version June 2023
 */
public class Wand extends Actor
{
    GreenfootSound wandAttack = new GreenfootSound("shootwand.mp3"); //Sound for shooting the wand
    GreenfootImage wand = new GreenfootImage("images/wand.png"); //Image of the wand
    private SimpleTimer cooldownTimer = new SimpleTimer(); //Timer to enforce cooldown
    private boolean cooldown = true; //Flag to track cooldown
    private static String shootKey = "d"; //Key used to shoot
     
    public Wand() {
        setImage(wand);
    }
   
    public void act()
    {
        cooldownTimer();
        followCursor();
        
        if(Greenfoot.isKeyDown(shootKey) && cooldown){
            GameWorld world = (GameWorld) getWorld();
            if(world.getMana() == 0) {
                return;
            }
            else {
              shoot();
              wandAttack.play();
              world.decreaseMana();  
            }
        }
    }
 
    /**
     * Set direction of wand using mouse input
     */
    public void followCursor(){
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if(mouse!=null && mouse.getY()<400){
            turnTowards(mouse.getX(), mouse.getY());
        }
    }
    
    /**
     * Shoot magical attack
     * Reset cooldown timer
     */
    public void shoot(){
        MagicAttack laser = new MagicAttack(getRotation());
        getWorld().addObject(laser,300,400);
        cooldown = false;
        cooldownTimer.mark();
    }
    
    /**
     * If 1s has passed since last shot, reset cooldown
     */
    public void cooldownTimer(){
        if (cooldownTimer.millisElapsed() > 1000) {
            cooldown = true;
        }
    }
}
