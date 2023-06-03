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
    //GreenfootImage playHovered = new GreenfootImage("images/instructions1.png");
    
    public InstructionsButton() {
        setImage(instructions);
    }
    
    public void act()
    {     
        //if(Greenfoot.mouseMoved(this)){
        //    setImage(playHovered);
        //}
        //else{
        //    setImage(play);
        //}
        //if(Greenfoot.mouseClicked(this))
        //{
        //    World instructions = new instructionsWorld();
        //    Greenfoot.setWorld(instructionsWorld);
        //}
    }
}
