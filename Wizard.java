import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Wizard, our hero.
 * 
 * @author Megan Lee
 * @version June 2023
 */
public class Wizard extends Actor
{
    GreenfootImage idle = new GreenfootImage("images/wizard_sprites/attack1.png");
    //GreenfootImage[] attack = new GreenfootImage[15];
    
    public Wizard() {
        //for(int i = 2; i < 17;i++) {
        //    attack[i] = new GreenfootImage("images/wizard_sprites/wizard_attack" + i + ".png");
        //}
    }
    
    public void act()
    {
        setRotation(270);
        
        if(Greenfoot.isKeyDown("up"))
        {
            move(-3);
        }
        else if(Greenfoot.isKeyDown("down"))
        {
            move(3);
        }
    }
}
