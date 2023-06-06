import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class InstructionsButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class InstructionsButton extends Actor

{
    GreenfootImage instructions = new GreenfootImage("images/instructions0.png");
    GreenfootImage instructionsHovered = new GreenfootImage("images/instructions1.png");
    
    public InstructionsButton() {
        setImage(instructions);
    }
    
    public void act()
    {     
        
        if(Greenfoot.mouseMoved(this)|| Greenfoot.mouseDragged(this)){
            setImage(instructionsHovered);
        }
        else{
            setImage(instructions);
        }
        //if(Greenfoot.mouseClicked(this))
        //{
        //    World instructions = new instructionsWorld();
        //    Greenfoot.setWorld(instructionsWorld);
        //}
    }
}
