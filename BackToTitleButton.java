import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A button: Player clicks it to go back to title screen.
 * 
 * @author Megan Lee
 * @version June 2023
 */
public class BackToTitleButton extends Actor

{
    GreenfootSound buttonClick = new GreenfootSound("buttonclick.mp3");
    GreenfootImage backToTitle = new GreenfootImage("images/backtotitle0.png"); //Image for the instructions button.
    GreenfootImage backToTitleHovered = new GreenfootImage("images/backtotitle1.png"); //Image for the instructions button when hovered.
    
    /**
     * Constructor for BackToTitleButton.
     * Sets the initial image of the button.
     */
    public BackToTitleButton() {
        setImage(backToTitle);
    }
    
    /**
     * Act method for the BackToTitleButton.
     * It handles the image change when the mouse hovers over the button,
     * and switches to the title screen when the button is clicked.
     */
    public void act()
    {
        if (Greenfoot.mouseMoved(this)) {
            setImage(backToTitleHovered); // Change the image to backToTitleHovered when the mouse moves over button
        }
        if (Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this)) {
            setImage(backToTitle); // Change the image back to backToTitle when the mouse moves away from button
        }
        if (Greenfoot.mouseClicked(this))
        {
            buttonClick.play();
            setImage(backToTitleHovered);
            Greenfoot.delay(10);
            World titlescreen = new TitleScreen();
            Greenfoot.setWorld(titlescreen);
        }
    }
}