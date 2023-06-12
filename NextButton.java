import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class NextButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NextButton extends Actor
{
    GreenfootImage next = new GreenfootImage("images/next0.png"); //Image for the instructions button.
    GreenfootImage nextHovered = new GreenfootImage("images/next1.png"); //Image for the instructions button when hovered.
    
    /**
     * Constructor for BackToTitleButton.
     * Sets the initial image of the button.
     */
    public NextButton() {
        setImage(next);
    }
    
    /**
     * Act method for the BackToTitleButton.
     * It handles the image change when the mouse hovers over the button,
     * and switches to the title screen when the button is clicked.
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
            setImage(nextHovered);
            Greenfoot.delay(10);
            InstructionsScreen.switchNext();
        }
    }
}
