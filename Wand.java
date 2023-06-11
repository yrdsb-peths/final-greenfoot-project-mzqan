import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A weapon for our wizard - a wand.
 * 
 * @author Megan Lee
 * @version June 2023
 */
public class Wand extends Actor
{
    GreenfootImage wand = new GreenfootImage("images/wand.png");
    private static String shootKey = "d";
    private SimpleTimer cooldownTimer = new SimpleTimer();
    private boolean cooldown = true;
     
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
                world.decreaseMana();  
            }
        }
    }
 
    public void followCursor(){
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if(mouse!=null && mouse.getY()<400){
            turnTowards(mouse.getX(), mouse.getY());
        }
    }
    
    public void shoot(){
        MagicAttack laser = new MagicAttack(getRotation());
        getWorld().addObject(laser,300,400);
        cooldown = false;
        cooldownTimer.mark();
    }
    
    public void cooldownTimer(){
        if (cooldownTimer.millisElapsed() > 1000) {
            cooldown = true;
        }
    }
}
