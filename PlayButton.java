import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A button: Player clicks it to start a new game.
 * 
 * @author Megan Lee
 * @version June 2023
 */
public class PlayButton extends Actor
{
    GreenfootSound buttonClick = new GreenfootSound("buttonclick.mp3"); //Sound for the button click
    GreenfootImage play = new GreenfootImage("images/newgame0.png"); //Image for the play button
    GreenfootImage playHovered = new GreenfootImage("images/newgame1.png"); //Image for the play button when hovered
    
    public PlayButton() {
        setImage(play); 
    }
    
    public void act()
    {
        if (Greenfoot.mouseMoved(this)) {
            setImage(playHovered); // Change the image when mouse hovers over button
        }
        if (Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this)) {
            setImage(play); // Change the image back when the mouse moves away from button
        }
        if (Greenfoot.mouseClicked(this))
        {
            buttonClick.play();
            setImage(playHovered);
            Greenfoot.delay(10);
            World gameWorld = new GameWorld();
            Greenfoot.setWorld(gameWorld); // Start the game by setting the world to a new GameWorld
        }
    }
}
