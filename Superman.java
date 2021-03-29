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

/*[Second approach extending the Mover class] - Different, but not as good as first approach.

public class Superman extends Mover
{
   private int gunReloadTime;                  // The minimum delay between firing the gun.
   private int reloadDelayCount;               // How long ago we fired the gun the last time.
   private int shotsFired;                     // Number of shots fired.  
   GifImage gifImage;
   public Superman()
   {
       shotsFired = 0;
       gunReloadTime = 6;
       reloadDelayCount = 0;
      
       gifImage = new GifImage("SupermanFlies.gif");
   }
   
   //Act - do whatever Superman wants to do. This method is called whenever
   //the 'Act' or 'Run' button gets pressed in the environment.
   
   public void act()
   {
       setImage(gifImage.getCurrentImage());
       move();
       checkKeys();
       reloadDelayCount++;
   } 
   //Return the number of shots fired from this rocket.
  
   public int getShotsFired()
   {
       return shotsFired;
   }
   //Return the approximate current travelling speed of this rocket.
   
   public int getSpeed()
   {
       return (int) (getMovement().getLength() * 10);
   }
   
   //Set the time needed for reloading the rocket's gun. The shorter this time is,
   //the faster the rocket can fire. The (initial) standard time is 20.
    
   public void setGunReloadTime(int reloadTime)
   {
       gunReloadTime = reloadTime;
   }
   
   //Check whether there are any keys pressed and react to them.
  
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
   
   //Fire a bullet if the gun is ready.
  
   private void fire()
   {
       if(reloadDelayCount >= gunReloadTime)
       {
           Laser b = new Laser(getMovement().copy(), getRotation());
           getWorld().addObject(b, getX() + 50, getY() - 57);
           b.move();
           Greenfoot.playSound("Laser.wav");
           shotsFired++;
           reloadDelayCount = 0;
       }
   
   //Hit Batman dealing the given amount of damage.
  
   public void hit(int damage)
   {
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
  
   //If health is zero, Batman loses
 
   private void lose()
   {
       getWorld().removeObject(this);
       return;
   }
   protected void finalize()
   {
       Greenfoot.setWorld(new StartScreen());
   }
}

*/
