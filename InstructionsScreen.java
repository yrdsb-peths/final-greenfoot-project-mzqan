import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * How To Play Screen.
 * 
 * @author Megan Lee 
 * @version June 2023
 */
public class InstructionsScreen extends World
{   
    GreenfootImage[] instructions = new GreenfootImage[3];
    public static int currentScreen = 0;
    /**
     * Constructor for objects of class InstructionsScreen.
     * 
     */
    public InstructionsScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        prepare();
    }
    
    public void prepare() {
        for(int i=0; i<3;i++) {
            instructions[i] = new GreenfootImage("images/howtoplay" + (i+1) + ".jpg");
            instructions[i].scale(600,400);
        }
        
        BackButton backBtn = new BackButton();
        addObject(backBtn, 185, 355);
        
        NextButton nextBtn = new NextButton();
        addObject(nextBtn, 420, 355);
        
        setBackground(instructions[currentScreen]);
    }
    
    public static void switchBack(){
        if(currentScreen>0){
            currentScreen--;
        }
        else {
            currentScreen=0;
            World titlescreen = new TitleScreen();
            Greenfoot.setWorld(titlescreen);
        }
    }
    
    public static void switchNext(){
        if(currentScreen<2) {
            currentScreen++;
        }
        else {
            currentScreen=0;
            World titlescreen = new TitleScreen();
            Greenfoot.setWorld(titlescreen);
        }
    }
    
    public void act(){
        setBackground(instructions[currentScreen]);
    }
}
