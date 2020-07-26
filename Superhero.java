import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author (Joseph Pepe) 
 * @version (2.0)
 */
public abstract class Superhero extends Mover
{
    protected int projectileReloadTime;           // The minimum delay between shooting the projectile.
    protected int reloadDelayCount;               // How long ago we fired the projectile the last time.
    protected int shotsFired;                     // Number of shots fired.   
    protected GifImage gifImage;
    /**
     * Return the current health of the superhero.
     */
    public int getHealth()
    {
        return life;
    }
    /**Return the number of shots fired from the superhero.
     */
    public int getShotsFired()
    {
        return shotsFired;
    }
    /**
     * Return the approximate current speed of the superhero.
     */
    public int getSpeed()
    {
        return (int) (getMovement().getLength() * 10);
    }
    /**
     * Set the time needed for re-loading the weapon. 
     * The shorter this time is,the faster the projectile weapon can fire.
     */
    public void setGunReloadTime(int reloadTime)
    {
        projectileReloadTime = reloadTime;
    }
}