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
    GreenfootImage[] attack = new GreenfootImage[16];
    
    SimpleTimer animationTimer = new SimpleTimer();
    public Wizard() {
        for(int i = 2; i < 16;i++) {
            attack[i] = new GreenfootImage("images/wizard_sprites/attack" + i + ".png");
            attack[i].rotate(90);
            attack[i].scale(150,150);
        }
        idle.rotate(90);
        idle.scale(150,150);
        setImage(idle);
        setRotation(270);
         
    }
    
    /**
     * Animate the wizard's attack
     */
    public void animateWizard() {
        for (int i = 0; i < attack.length; i++) {
            animationTimer.mark();
            while (animationTimer.millisElapsed() < 100) {
                setImage(attack[i]);
                Greenfoot.delay(1);  // Delay for smooth animation
            }
        }
        setImage(idle);
    }
        
    public void act()
    {        
        
        if(Greenfoot.isKeyDown("up"))
        {
            move(-3);
        }
        else if(Greenfoot.isKeyDown("down"))
        {
            move(3);
        }
        
        if(Greenfoot.isKeyDown("d")) {
            animateWizard();
        }
        
    }
}
