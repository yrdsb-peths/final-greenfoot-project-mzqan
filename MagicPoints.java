import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Manabar - our "ammo" for our wand.
 * 
 * @author Megan 
 * @version June 2023
 */
public class MagicPoints extends Actor
{
    public double mana;
    public int manablock;
    GreenfootImage[] manabar = new GreenfootImage[11];

    public MagicPoints(int magic) {
        for(int i=0; i<11;i++) {
            manabar[i] = new GreenfootImage("images/mana_bar/manabar" + i + ".png");
            manabar[i].scale(220,23);
        }
        setImage(manabar[1]);
    }
    
    public void act(){
        GameWorld world = (GameWorld) getWorld();
        mana = (world.getMana())/10;
        if(mana - (int) mana >= 0.5) {
            setImage(manabar[(int) mana +1]);
        }
        else {
            setImage(manabar[(int) mana]);
        }
        
    }
}
