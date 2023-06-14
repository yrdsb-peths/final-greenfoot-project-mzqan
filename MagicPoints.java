import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Manabar - to track our "ammo" for our wand.
 * 
 * @author Megan 
 * @version June 2023
 */
public class MagicPoints extends Actor
{
    GreenfootImage[] manabar = new GreenfootImage[11]; //Array for images of varying values of the mana bar
    private int manaSection = 1; //Tracker for mana value's corresponding image
    
    public MagicPoints(int magic) {
        for(int i=0; i<11;i++) {
            manabar[i] = new GreenfootImage("images/mana_bar/manabar" + i + ".png"); 
            manabar[i].scale(220,23);
        }
        setImage(manabar[1]);
    }
    
    public void act(){
        GameWorld world = (GameWorld) getWorld();
        //Turns mana value into a single digit, rounded value 
        if(world.getMana() % 10 >= 5) { 
            manaSection = (world.getMana() + (10 - (world.getMana() % 10)))/10;
        }
        else {
            manaSection = world.getMana() / 10;
        }
        //Updates mana bar image accordingly 
        setImage(manabar[manaSection]);
    }
}
