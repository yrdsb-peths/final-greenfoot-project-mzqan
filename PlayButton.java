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
    //GreenfootImage playHovered = new GreenfootImage("images/newgame1.png");
    
    public PlayButton() {
        setImage(play);
    }
    
    public void act()
    {     
        //if(Greenfoot.mouseMoved(this)){
        //    setImage(playHovered);
        //}
        //else{
        //    setImage(play);
        //}
        if(Greenfoot.mouseClicked(this))
        {
            World gameWorld = new GameWorld();
            Greenfoot.setWorld(gameWorld);
        }
    }
}
