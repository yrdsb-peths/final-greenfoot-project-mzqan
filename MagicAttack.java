import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Our Wizard's attack - a laser?
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MagicAttack extends Actor
{
    GreenfootImage[] attack = new GreenfootImage[20];
    SimpleTimer animationTimer = new SimpleTimer();
    
    public MagicAttack(int rotation) {
        for(int i=0; i<6;i++) {
            attack[i] = new GreenfootImage("images/attack_sprites/attack" + (i+1) + ".png");
            attack[i].scale(200,200);
        }
        for(int i=6; i<20;i++) {
            attack[i] = new GreenfootImage("images/attack_sprites/attack6.png");
            attack[i].scale(200,200);
        }
        setImage(attack[0]);
        setRotation(rotation);
    }
    int imageIndex = 0;
    public void animateAttack() {
        if(animationTimer.millisElapsed() < 200) {
            return;
        }
        animationTimer.mark();
        setImage(attack[imageIndex]);
        imageIndex = (imageIndex + 1) % attack.length;
    }
    public void act()
    {
        move(3);
        if(getY() < 0){
            getWorld().removeObject(this);
        }
        animateAttack();
    }
}
