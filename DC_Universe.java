import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * The world of Batman Vs Superman
 * @author (Joseph Pepe) 
 * @version (2.0)
 */
public class DC_Universe extends World
{
    private static int score;
    private int gameTime;
    private int scoreBoardTime;
    private Superman superman;
    private SupermanHealthBar bar;
    
    public DC_Universe()
    {    
        // Create a new world with (x,y) cells with a cell size of 1x1 pixels.
        super(900, 500, 1); 
        setGameUp();
    }
    public void act()
    {
        countTime();
        changehealthBarPosition();
    }
    private void changehealthBarPosition()
    {
        bar.setLocation((int)superman.getX_Coordinate(),(int)superman.getY_Coordinate() + 80);
    }
    private void setGameUp()
    {
        superman = new Superman();
        addObject(superman,80,300);
        addObject(new Batman(), 850, 300);
        bar = new SupermanHealthBar(superman);
        addObject(bar,(int)superman.getX_Coordinate(),(int)superman.getY_Coordinate() + 80);
        score = 0;
        gameTime = 1000;
        scoreBoardTime = 1100;
        showScore();
        showTime();
    }
    /**
     * Show our current score on screen.
     */
    private void showScore()
    {
        showText("Score: " + score, 80, 25);
    }
    public void addScore(int points)
    {
        if(gameTime >= 0)
            score += points;
        showScore();
    }
    
    public static int getPlayerScore()
    {
        return score;
    }
    
    /**
     * Count down the game time and display it. Stop the gamewith a winning message when time is up.
    */
    private void countTime()
    {
        gameTime--;
        scoreBoardTime--;
        showTime();
        if (gameTime == 0)
        {
            gameOver();
        }
        if(scoreBoardTime == 0)
        {
             Greenfoot.setWorld(new StartScreen());
             Greenfoot.stop();
        }
    }
    
    /**
     * Show the remaining game time on screen.
     */
    private void showTime()
    {
        if(gameTime >= 0)
            showText("Time: " + gameTime, 750, 25);
    }
    
    public int getGameTime()
    {
        return gameTime;
    }
    
    /**
     * This method is called when the game is over.
     */
    public void gameOver() 
    {
        addObject(new GameOver(), getWidth()/2, getHeight()/2);
    }
}