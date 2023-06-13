import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Our Wizard's attack - a laser?
 * 
 * @author Megan
 * @version June 2023
 */
public class MagicAttack extends SmoothMover
{
    GreenfootSound death = new GreenfootSound("enemydeath.mp3");
    GreenfootSound collectMagic = new GreenfootSound("magic.mp3");
    GreenfootImage[] attack = new GreenfootImage[20];
    SimpleTimer animationTimer = new SimpleTimer();
    
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
        else {
            animateAttack();
            kill();
            gainMP();
        }
    }
    
    public void kill(){
        if(isTouching(Skeleton.class)) {  
            death.play();
            removeTouching(Skeleton.class);
            GameWorld world = (GameWorld) getWorld();
            world.spawnSkeleton();
            world.increaseScore(1);
        }
    }
    
    public void gainMP(){
       if(isTouching(Magic.class)) {  
           collectMagic.play(); 
           removeTouching(Magic.class);
           GameWorld world = (GameWorld) getWorld();
           world.increaseMana();
        } 
    }
}
