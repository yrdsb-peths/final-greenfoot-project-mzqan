import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A button: Player clicks it to go back to title screen (after game over).
 * 
 * @author Megan Lee
 * @version June 2023
 */
public class BackToTitleButton extends Actor

{
    GreenfootSound buttonClick = new GreenfootSound("buttonclick.mp3"); //Sound for the button click
    GreenfootImage backToTitle = new GreenfootImage("images/backtotitle0.png"); //Image for the instructions button.
    GreenfootImage backToTitleHovered = new GreenfootImage("images/backtotitle1.png"); //Image for the instructions button when hovered.
    
    public BackToTitleButton() {
        setImage(backToTitle);
    }
    
    public void act()
    {
        if (Greenfoot.mouseMoved(this)) {
            setImage(backToTitleHovered); // Change the image when mouse hovers over button
        }
        if (Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this)) {
            setImage(backToTitle); // Change the image back when the mouse moves away from button
        }
        if (Greenfoot.mouseClicked(this))
        {
            buttonClick.play(); 
            setImage(backToTitleHovered);
            Greenfoot.delay(10);
            World titlescreen = new TitleScreen();
            Greenfoot.setWorld(titlescreen); //Switches to title screen
        }
    }
}