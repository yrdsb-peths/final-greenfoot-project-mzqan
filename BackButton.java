import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A button: Player clicks it to control the InstructionsScreen
 * 
 * @author Megan Lee
 * @version June 2023
 */
public class BackButton extends Actor
{
    GreenfootSound buttonClick = new GreenfootSound("buttonclick.mp3"); //Sound for the button click
    GreenfootImage back = new GreenfootImage("images/back0.png"); //Image for the back button
    GreenfootImage backHovered = new GreenfootImage("images/back1.png"); //Image for the back button when hovered
    
    /**
     * Constructor for BackButton.
     * Sets the initial image of the button.
     */
    public BackButton() {
        setImage(back);
    }
    
    /**
     * Act method for the BackButton.
     * It handles the image change when the mouse hovers over the button,
     * and switches to the previous screen when the button is clicked.
     */
    public void act()
    {
        if (Greenfoot.mouseMoved(this)) {
            setImage(backHovered); // Change the image to backToTitleHovered when the mouse moves over button
        }
        if (Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this)) {
            setImage(back); // Change the image back to backToTitle when the mouse moves away from button
        }
        if (Greenfoot.mouseClicked(this))
        {
            buttonClick.play(); //Plays button click sound
            setImage(backHovered);
            Greenfoot.delay(10);
            InstructionsScreen.switchBack(); //Switch back to previous screen
        }
    }
}
