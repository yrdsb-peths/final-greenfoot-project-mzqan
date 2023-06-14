import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A button: Player clicks it to control/navigate the InstructionsScreen.
 * 
 * @author Megan Lee
 * @version June 2023
 */
public class BackButton extends Actor
{
    GreenfootSound buttonClick = new GreenfootSound("buttonclick.mp3"); //Sound for the button click
    GreenfootImage back = new GreenfootImage("images/back0.png"); //Image for the back button
    GreenfootImage backHovered = new GreenfootImage("images/back1.png"); //Image for the back button when hovered
    
    public BackButton() {
        setImage(back);
    }
    
    public void act()
    {
        if (Greenfoot.mouseMoved(this)) {
            setImage(backHovered); // Change the image when the mouse hovers over button
        }
        if (Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this)) {
            setImage(back); // Change image back when mouse moves away from button
        }
        if (Greenfoot.mouseClicked(this))
        {
            buttonClick.play(); 
            setImage(backHovered);
            Greenfoot.delay(10);
            InstructionsScreen.switchBack(); //Switch back to previous screen
        }
    }
}
