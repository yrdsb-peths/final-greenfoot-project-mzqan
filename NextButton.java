import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A button: Player clicks it to control the InstructionsScreen
 * 
 * @author Megan Lee 
 * @version June 2023
 */
public class NextButton extends Actor
{
    GreenfootSound buttonClick = new GreenfootSound("buttonclick.mp3"); //Sound for the button click
    GreenfootImage next = new GreenfootImage("images/next0.png"); //Image for the next button
    GreenfootImage nextHovered = new GreenfootImage("images/next1.png"); //Image for the next button when hovered
    
    /**
     * Constructor for NextButton.
     * Sets the initial image of the button.
     */
    public NextButton() {
        setImage(next);
    }
    
    /**
     * Act method for the NextButton.
     * It handles the image change when the mouse hovers over the button,
     * and switches to the next screen when the button is clicked.
     */
    public void act()
    {
        if (Greenfoot.mouseMoved(this)) {
            setImage(nextHovered); // Change the image to backToTitleHovered when the mouse moves over button
        }
        if (Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this)) {
            setImage(next); // Change the image back to backToTitle when the mouse moves away from button
        }
        if (Greenfoot.mouseClicked(this))
        {
            buttonClick.play(); //Plays button click sound
            setImage(nextHovered);
            Greenfoot.delay(10);
            InstructionsScreen.switchNext(); //Switches forward to next screen
        }
    }
}
