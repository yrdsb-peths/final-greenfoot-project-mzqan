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
    
    public Wand() {
        setImage(wand);
        wand.scale(100,80);
    }
   
    public void act()
    {
        followCursor();
    }
 
    public void followCursor(){
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if(mouse!=null && mouse.getY()<380){
            turnTowards(mouse.getX(), mouse.getY());
        }
    }

}
