import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Our Wizard's attack - a laser?
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MagicAttack extends Actor
{
    public MagicAttack(int rotation) {
        setRotation(rotation);
    }

    public void act()
    {
        move(3);
        if(getY() < 0){
            getWorld().removeObject(this);
        }
    }
}
