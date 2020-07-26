import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * @author (Joseph Pepe) 
 * @version (2.0)
 */
public class StartScreen extends World
{
    /**
     * Constructor for objects of class StartScreen.
     */
    public StartScreen()
    {    
        super(900,500, 1); 
        prepare();
    }
    /**
     * Prepare the world for the start of the program.
     * Create the initial objects and add them to the world.
     */
    private void prepare()
    {
        addObject(new Enter(),465,270);
    }
    public void act()
    {
        if(Greenfoot.isKeyDown("enter") || Greenfoot.mouseClicked(this) ||Greenfoot.isKeyDown("space"))
        {
            Greenfoot.setWorld(new DC_Universe());
        }
    }
}
