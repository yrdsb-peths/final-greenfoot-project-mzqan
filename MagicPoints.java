import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MagicPoints here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MagicPoints extends Actor
{
    GreenfootImage[] manabar = new GreenfootImage[6];
    
    public MagicPoints(int magic) {
        for(int i=0; i<6;i++) {
            manabar[i] = new GreenfootImage("images/mana_bar/manabar" + i + ".png");
            manabar[i].scale(220,23);
        }
        setImage(manabar[2]);
    }
}
