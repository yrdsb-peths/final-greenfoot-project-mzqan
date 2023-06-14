import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Our Wizard's attack - a magical laser.
 * 
 * @author Megan
 * @version June 2023
 */
public class MagicAttack extends SmoothMover
{
    GreenfootSound death = new GreenfootSound("enemydeath.mp3"); //Sound for death of enemy
    GreenfootSound collectMagic = new GreenfootSound("magic.mp3"); //Sound for collection of magic
    GreenfootImage[] attack = new GreenfootImage[20]; //Array of images for the magical attack
    SimpleTimer animationTimer = new SimpleTimer(); //Timer to animate magical attack
    
    public MagicAttack(int rotation) {
        for(int i=0; i<6;i++) {
            attack[i] = new GreenfootImage("images/attack_sprites/attack" + (i+1) + ".png");
            attack[i].scale(80,23);
        }
        
        for(int i=6; i<20;i++) {
            attack[i] = new GreenfootImage("images/attack_sprites/attack6.png");
            attack[i].scale(80,23);
        }
        
        setImage(attack[0]);
        setRotation(rotation);
    }
    
    public void act()
    {
        move(3);
        if(getY() < 0){
            getWorld().removeObject(this);
        }
        else { 
            animateAttack();
            kill();
            gainMP();
        }
    }
    
    /**
     * Animate the attack.
     * Loop through sprites at 200ms intervals.
     */
    int imageIndex = 0;
    public void animateAttack() {
        if(animationTimer.millisElapsed() < 200) {
            return;
        }
        animationTimer.mark();
        setImage(attack[imageIndex]);
        imageIndex = (imageIndex + 1) % attack.length;
    }
    
    /**
     * If shot, "Kill" the skeleton and spawn new skeleton
     * Increase score by 1 and play enemy death sound effect
     */    
    public void kill(){
        if(isTouching(Skeleton.class)) {  
            death.play();
            removeTouching(Skeleton.class);
            GameWorld world = (GameWorld) getWorld();
            world.spawnSkeleton();
            world.increaseScore(1);
        }
    }
    
    /**
     * If shot, remove magic orb
     * Increase mana by 20
     */    
    public void gainMP(){
       if(isTouching(Magic.class)) {  
           collectMagic.play(); 
           removeTouching(Magic.class);
           GameWorld world = (GameWorld) getWorld();
           world.increaseMana();
        } 
    }
}
