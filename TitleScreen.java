import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Titlescreen: go to new game or instructions
 * 
 * @author Megan
 * @version June 2023
 */
public class TitleScreen extends World
{
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        prepare();
    }
    
    public void prepare() {
        PlayButton playBtn = new PlayButton();
        addObject(playBtn, 300, 255);
        
        InstructionsButton instructionsBtn = new InstructionsButton();
        addObject(instructionsBtn, 300, 330);
    }
}
