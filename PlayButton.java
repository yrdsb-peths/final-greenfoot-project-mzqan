import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayButton extends Actor
{
    GreenfootImage play = new GreenfootImage("images/newgame0.png");
    GreenfootImage playHovered = new GreenfootImage("images/newgame1.png");
    
    public PlayButton() {
        setImage(play);
    }
    
    public void act()
    {     
        if(Greenfoot.mouseClicked(this))
        {
            setImage(playHovered);
            Greenfoot.delay(10);
            World gameWorld = new GameWorld();
            Greenfoot.setWorld(gameWorld);
        }
    }
}
