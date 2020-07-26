import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * @author (Joseph Pepe) 
 * @version (2.0)
 */
public class SupermanHealthBar extends Actor
{
    private int healthBarWidth = 100;
    private int healthBarHeight = 15;
    private int pixelsPerHealthPoint;
    private Superman superman;
    public SupermanHealthBar(Superman character)
    {
        if(character != null)
        {
            superman = character;
            pixelsPerHealthPoint = (int) healthBarWidth / superman.getHealth();
            updateHealthBar();
        }
    }
    /**Act - do whatever the HealthBar wants to do.*/
    public void act() 
    {
        updateHealthBar();
    }
    public void updateHealthBar()
    {
        setImage(new GreenfootImage(healthBarWidth + 2 , healthBarHeight + 2));
        GreenfootImage myImage = getImage();
        myImage.setColor(Color.WHITE);
        myImage.drawRect(0,0 ,healthBarWidth + 1, healthBarHeight + 1);
        myImage.setColor(Color.GREEN);
        myImage.fillRect(1, 1 , superman.getHealth() * pixelsPerHealthPoint , healthBarHeight);
    }
}