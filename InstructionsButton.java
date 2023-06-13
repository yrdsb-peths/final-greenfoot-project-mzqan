import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A button: Player clicks it to learn how to play.
 * 
 * @author Megan Lee
 * @version June 2023
 */
public class InstructionsButton extends Actor

{
    GreenfootSound buttonClick = new GreenfootSound("buttonclick.mp3");
    GreenfootImage instructions = new GreenfootImage("images/instructions0.png"); //Image for the instructions button.
    GreenfootImage instructionsHovered = new GreenfootImage("images/instructions1.png"); //Image for the instructions button when hovered.
    
    /**
     * Constructor for InstructionsButton.
     * Sets the initial image of the button.
     */
    public InstructionsButton() {
        setImage(instructions);
    }
    
    /**
     * Act method for the InstructionsButton.
     * It handles the image change when the mouse hovers over the button,
     * and switches to the instructions screen when the button is clicked.
     */
    public void act()
    {
        if (Greenfoot.mouseMoved(this)) {
            setImage(instructionsHovered); // Change the image to instructionsHovered when the mouse moves over button
        }
        if (Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this)) {
            setImage(instructions); // Change the image back to instructions when the mouse moves away from button
        }
        if (Greenfoot.mouseClicked(this))
        {
            buttonClick.play();
            setImage(instructionsHovered);
            Greenfoot.delay(10);
            World instructionsWorld = new InstructionsScreen();
            Greenfoot.setWorld(instructionsWorld);
        }
    }
}
