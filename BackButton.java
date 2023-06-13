import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BackButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BackButton extends Actor
{
    GreenfootSound buttonClick = new GreenfootSound("buttonclick.mp3");
    GreenfootImage back = new GreenfootImage("images/back0.png"); //Image for the instructions button.
    GreenfootImage backHovered = new GreenfootImage("images/back1.png"); //Image for the instructions button when hovered.
    
    /**
     * Constructor for BackToTitleButton.
     * Sets the initial image of the button.
     */
    public BackButton() {
        setImage(back);
    }
    
    /**
     * Act method for the BackToTitleButton.
     * It handles the image change when the mouse hovers over the button,
     * and switches to the title screen when the button is clicked.
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
            buttonClick.play();
            setImage(backHovered);
            Greenfoot.delay(10);
            InstructionsScreen.switchBack();
        }
    }
}
