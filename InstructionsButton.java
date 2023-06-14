import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A button: Player clicks it to learn how to play, switches to Instructions screen.
 * 
 * @author Megan Lee
 * @version June 2023
 */
public class InstructionsButton extends Actor

{
    GreenfootSound buttonClick = new GreenfootSound("buttonclick.mp3"); //Sound for the button click
    GreenfootImage instructions = new GreenfootImage("images/instructions0.png"); //Image for the instructions button
    GreenfootImage instructionsHovered = new GreenfootImage("images/instructions1.png"); //Image for the instructions button when hovered
    
    public InstructionsButton() {
        setImage(instructions);
    }
    
    public void act()
    {
        if (Greenfoot.mouseMoved(this)) {
            setImage(instructionsHovered); // Change the image when mouse hovers over button
        }
        if (Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this)) {
            setImage(instructions); // Change the image back when the mouse moves away from button
        }
        if (Greenfoot.mouseClicked(this))
        {
            buttonClick.play(); 
            setImage(instructionsHovered);
            Greenfoot.delay(10);
            World instructionsWorld = new InstructionsScreen(); 
            Greenfoot.setWorld(instructionsWorld); // Switches to instructions screen
        }
    }
}
