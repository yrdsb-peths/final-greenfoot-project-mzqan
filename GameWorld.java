import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Game screen. 
 * 
 * @author Megan Lee
 * @version June 2023
 */
public class GameWorld extends World
{
    private SimpleTimer respawnTimer  = new SimpleTimer(); // Timer for respawning magic
    private boolean canSpawnMagic = true; // Flag to track magic spawning 
    private int mana = 10; //Initial manal value
    private static int score = 0;
    private static int highscore =0;
    Label manabarPoints = new Label("MP: " + mana +"/100", 23); //Label to display mana
    Label scoreLabel = new Label("Score: " + score, 23); //Label to display currentscore
    Label highScoreLabel = new Label("High Score: " + highscore, 23); //Label to display highscore

            
    /**
     * Constructor for objects of class GameWorld.
     * 
     */
    public GameWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false); 
        prepare(); //Set up intial state of the game
    }
    
    /**
     * Set up the initial state of the game.
     * Creates and adds the initial game objects to the world.
     */
    public void prepare() {
        Wand wand = new Wand();
        addObject(wand,300,400); // Add wand object to the world
        
        MagicPoints manabar = new MagicPoints(30);
        addObject(manabar, 115, 35); // Add mana bar to the world
        
        addObject(manabarPoints, 115, 15); //Add mana label to the world
        
        addObject(scoreLabel, 520, 15); //Add score label to the world
        
        addObject(highScoreLabel, 502, 35); //Add high score label to the world
        highScoreLabel.setValue("High Score: " + highscore);
        spawnSkeleton(); //Spawn a skeleton object in the world
    }

    /**
     * Spawn a skeleton object in the world at a random x-coordinate.
     */
     public void spawnSkeleton()
    {
        Skeleton skeleton = new Skeleton ();
        addObject(skeleton, Greenfoot.getRandomNumber(600), 0);
    }

    /**
     * Spawn a magic object in the world at a random x-coordinate, if allowed.
     * The magic object is only spawned if there are no existing magic objects in the world.
     * The flag is set to prevent further spawning until the respawn timer reaches a certain threshold.
     */
    public void spawnMagic() {
        if (!canSpawnMagic) {
            return; // If magic cannot be spawned, exit the method
        }
        
        if (getObjects(Magic.class).isEmpty()) {
            // Only spawn magic if there are no existing magic objects in the world
            Magic magic = new Magic();
            addObject(magic, Greenfoot.getRandomNumber(600), 0);
            canSpawnMagic = false; // Set the flag to prevent further spawning
            respawnTimer.mark(); // Reset the timer for the next spawn
        }
    }
    
    /**
     * Increase the mana by 20, up to a maximum of 100.
     * If the mana is already at the maximum, the method exits.
     */
    public void increaseMana(){
        if (mana == 100) {
            return; // Mana is already at maximum, exit the method
        }
        else if(mana >=80){
            mana=100; // Set mana to maximum if it is close to reaching the maximum (+20 would be over 100)
        }
        else {
            mana+=20; // Increase mana by 20
        }
        manabarPoints.setValue("MP: " + mana + "/100"); // Update the mana label
    }
    
    /**
     * Decrease the mana by 1.
     */
    public void decreaseMana(){
        mana--; // Decrease mana by 1
        manabarPoints.setValue("MP: " + mana + "/100"); //Update the mana label
    }
    
    /**
     * Get the current mana value.
     */
    public int getMana(){
        return mana;
    }
    
     /**
     * End the game and switch to game over screen.
     */
    public void gameOver(){
        
        World gameOverWorld = new GameOverScreen();
        Greenfoot.setWorld(gameOverWorld); 
    }
    
    public void increaseScore(){
        score++;
        scoreLabel.setValue("Score: " + score);
        if (score > highscore) {
            highscore = score;
        }
        highScoreLabel.setValue("High Score: " + highscore);
    }
    
    public static int getScore(){
        return score;
    }
    
    public static void setScore(){
        score = 0;
    }
    
     /**
     * Act method for the world.
     * Called automatically by the Greenfoot framework.
     * It is responsible for spawning magic objects and resetting the spawn flag after a certain time interval.
     */
    public void act() {
        spawnMagic(); //Spawn magic object, if allowed.

        // Check if enough time has passed for the flag to be reset
        if (!canSpawnMagic && respawnTimer.millisElapsed() >= 10000) {
            canSpawnMagic = true; // Reset the flag to allow spawning
        }
    }
}
