import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * @author (Joseph Pepe) 
 * @version (2.0)
*/
public class Batman extends Superhero
{
    public Batman()
    {
        shotsFired = 0;
        projectileReloadTime = 6;
        reloadDelayCount = 0;
        gifImage = new GifImage("BatmanSprite.gif");
    }
    /**
     * Act - do whatever Batman wants to do. 
     * This method is called whenever the 'Act' or 'Run' button is pressed.
     */
    public void act() 
    {
        setImage(gifImage.getCurrentImage());
        move();
        changePosition();
        reloadDelayCount++;
    } 
    /**
     * Allows Batman to randomly move his position.
     */
    private void changePosition() 
    {
        int x = Greenfoot.getRandomNumber(60);
        if(x > 40 && x < 60)
        {
            setLocation(getX(), getY() - 8);
        }
        if(x <= 20)
        {
            setLocation(getX(), getY() + 12);
        }
        fire();
    }
    private void fire() 
    {
        if(reloadDelayCount >= projectileReloadTime)
        {
            Batarang b = new Batarang(getMovement().copy(), getRotation() + 180);
            getWorld().addObject(b, getX() - 90, getY() - 40);
            b.move();
            shotsFired++;
            reloadDelayCount = 0;
        }
    }
}
