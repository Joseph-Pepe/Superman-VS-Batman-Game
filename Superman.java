import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * @author (Joseph Pepe) 
 * @version (2.0)
*/
public class Superman extends Superhero
{
    public Superman()
    {
        shotsFired = 0;
        projectileReloadTime = 6;
        reloadDelayCount = 0;
        gifImage = new GifImage("SupermanFlies.gif");
    }
    /**
     * This method is called whenever the 'Act' or 'Run' button is pressed.
     */
    public void act() 
    {
        setImage(gifImage.getCurrentImage());
        move();
        checkKeys();
        reloadDelayCount++;
    }
    /**
     * Check which keys are being pressed by the user and act accordingly.
     */
    private void checkKeys() 
    {
        if(Greenfoot.isKeyDown("w"))
        {
            setLocation(getX(), getY() - 4);
        }
        if(Greenfoot.isKeyDown("s"))
        {
            setLocation(getX(), getY() + 4);
        }   
        if(Greenfoot.isKeyDown("d")) {
            fire();
        }     
    }
    /**
     * Fire a laser when user is ready.
     */
    private void fire() 
    {
        if(reloadDelayCount >= projectileReloadTime) 
        {
            Laser b = new Laser(getMovement().copy(), getRotation());
            getWorld().addObject(b, getX() + 50, getY() - 57);
            b.move();
            //Greenfoot.playSound("Laser.wav");
            shotsFired++;
            reloadDelayCount = 0;
        }
    }
    /**
     * Hit Superman dealing the given amount of damage.
    */
    public void hit(int damage) 
    {
        if(damage >= 0)
            life -= damage;
            
        if (life <= 0)
        {
            DC_Universe world = (DC_Universe) getWorld();
            explode();
            lose();     
            world.gameOver();
        }
    }
    private void explode()
    {
        Greenfoot.playSound("MetalExplosion.wav");
        getWorld().addObject(new Explosion(), getX(), getY());
    }
    /**
     * If health is zero, Superman loses.
     */
    private void lose()
    {
        getWorld().removeObject(this);
        return;
    }
}