import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A button: Player clicks it to start a game.
 * 
 * @author Megan Lee
 * @version June 2023
 */
public class PlayButton extends Actor
{
    GreenfootSound buttonClick = new GreenfootSound("buttonclick.mp3"); //Sound for the button click
    GreenfootImage play = new GreenfootImage("images/newgame0.png"); //Image for the play button.
    GreenfootImage playHovered = new GreenfootImage("images/newgame1.png"); //Image for the play button when hovered.
    
    /**
     * Constructor for PlayButton.
     * Sets the initial image of the button.
     */
    public PlayButton() {
        setImage(play); 
    }
    
    /**
     * Act method for the PlayButton.
     * It handles the image change when the mouse hovers over the button,
     * and switches to the game screen when the button is clicked.
     */
    public void act()
    {
        if (Greenfoot.mouseMoved(this)) {
            setImage(playHovered); // Change the image to playHovered when the mouse moves over button
        }
        if (Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this)) {
            setImage(play); // Change the image back to play when the mouse moves away from button
        }
        if (Greenfoot.mouseClicked(this))
        {
            buttonClick.play(); //Plays button click sound
            setImage(playHovered);
            Greenfoot.delay(10);
            World gameWorld = new GameWorld();
            Greenfoot.setWorld(gameWorld); // Start the game by setting the world to a new GameWorld
        }
    }
}
