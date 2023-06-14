import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Game screen. 
 * 
 * @author Megan Lee
 * @version June 2023
 */
public class GameWorld extends World
{
    private SimpleTimer respawnMagicTimer  = new SimpleTimer(); // Timer for respawning magic
    private boolean canSpawnMagic = true; // Flag to track magic spawning 
    
    private SimpleTimer respawnZombieTimer = new SimpleTimer();// Timer for respawning zombies
    private boolean canSpawnZombie = true; //Flag to track zombie spawning
    
    private static int score = 0; //Current game score
    private static int highscore = 0; //All-time highscore
    
    private static int level = 0; //Current level
    
    private int mana = 25; //Initial manal value
    
    Label manabarPoints = new Label("MP: " + mana +"/100", 23); //Label to display mana
    Label scoreLabel = new Label("Score: " + score, 23); //Label to display currentscore
    Label highScoreLabel = new Label("High Score: " + highscore, 23); //Label to display highscore

            
    public GameWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false); 
        prepare(); 
    }
    
    /**
     * Set up the initial state of the game.
     * Creates and adds the initial game objects to the world
     */
    public void prepare() {
        Wand wand = new Wand();
        addObject(wand,300,400); 
        
        MagicPoints manabar = new MagicPoints(30);
        addObject(manabar, 115, 35); 
        
        addObject(manabarPoints, 115, 15); 
        
        addObject(scoreLabel, 520, 15);
        
        addObject(highScoreLabel, 499, 35); 
        highScoreLabel.setValue("High Score: " + highscore);
        
        spawnSkeleton(); 
    }

    /**
     * Spawn skeleton from top of screen, at a random x-coordinate.
     */
     public void spawnSkeleton()
    {
        Skeleton skeleton = new Skeleton ();
        addObject(skeleton, Greenfoot.getRandomNumber(600), 0);
    }
    
    /**
     * Spawn zombie from top of screen, at a random x-coordinate.
     */
     public void spawnZombie()
    {
        if (!canSpawnZombie) {
            return; // If timer has not reached threshold, return
        }
        
        //If 30s has passed, spawn one zombie & reset timer
        if (getObjects(Zombie.class).isEmpty() && respawnZombieTimer.millisElapsed() >= 30000) {
            Zombie zombie = new Zombie();
            addObject(zombie, Greenfoot.getRandomNumber(600), 0);
            canSpawnMagic = false;
            respawnZombieTimer.mark(); 
        }  
    }
    
    /**
     * Spawn a magic object in the world at a random x-coordinate, if allowed.
     * The magic object is only spawned if there are no existing magic objects in the world.
     *
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
            respawnMagicTimer.mark(); // Reset the timer for the next spawn
        }
    }
    
    /**
     * Get the current mana value.
     */
    public int getMana(){
        return mana;
    }
    
    /**
     * Increase the mana by 20, up to a maximum of 100
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
     * Returns score.
     */
    public static int getScore(){
        return score;
    }
    
    /**
     * Resets score to 0.
     */
    public static void setScore(){
        score = 0;
    }
    
    /**
     * Increase score
     * Check if needed to update highscore
     */
    public void increaseScore(int points){
        score+=points;
        scoreLabel.setValue("Score: " + score);
        if (score > highscore) {
            highscore = score;
        }
        highScoreLabel.setValue("High Score: " + highscore);
        
        //Every 10 points scored, increase level difficulty
        if (score % 10 == 0) {
        level += 1;
        }
    }
    
    /**
     * Returns difficulty level.
     */
    public static int getLevel(){
        return level;
    }
    
    /**
     * End the game and switch to game over screen.
     */
    public void gameOver(){
        level = 0;
        World gameOverWorld = new GameOverScreen();
        Greenfoot.setWorld(gameOverWorld); 
    }
    
    public void act() {
        spawnMagic(); //Spawn magic object, if allowed

        // Check if 15s has passed for the flag to be reset
        if (!canSpawnMagic && respawnMagicTimer.millisElapsed() >= 15000) {
            canSpawnMagic = true; 
        }
        
        // Check if 30s has passed for the flag to be reset
        if (!canSpawnZombie && respawnZombieTimer.millisElapsed() >= 30000) {
            canSpawnZombie = true;
        }

        // Check if it's time to spawn a zombie
        if (canSpawnZombie) {
            spawnZombie();
            canSpawnZombie = false; 
            respawnZombieTimer.mark(); // Reset the timer for the next spawn
        }
    }
}
