import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A button: Player clicks it to control/navigate the InstructionsScreen.
 * 
 * @author Megan Lee 
 * @version June 2023
 */
public class NextButton extends Actor
{
    GreenfootSound buttonClick = new GreenfootSound("buttonclick.mp3"); //Sound for the button click
    GreenfootImage next = new GreenfootImage("images/next0.png"); //Image for the next button
    GreenfootImage nextHovered = new GreenfootImage("images/next1.png"); //Image for the next button when hovered
    
    public NextButton() {
        setImage(next);
    }
        
    public void act()
    {
        if (Greenfoot.mouseMoved(this)) {
            setImage(nextHovered); // Change the image when mouse hovers over button
        }
        if (Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this)) {
            setImage(next); // Change the image back when the mouse moves away from button
        }
        if (Greenfoot.mouseClicked(this))
        {
            buttonClick.play();
            setImage(nextHovered);
            Greenfoot.delay(10);
            InstructionsScreen.switchNext(); //Switches forward to next screen
        }
    }
}
