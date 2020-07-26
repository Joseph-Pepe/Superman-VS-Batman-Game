import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * @author (Joseph Pepe) 
 * @version (2.0)
 */
public class Laser extends ProjectileWeapon
{
    public Laser(Vector speed, int rotation)
    {
        super(speed,rotation);
        Greenfoot.playSound("Laser.wav");
    }
    /**
     * The laser will damage Batman.
     */
    public void act()
    {
        move();
        hitEnemy();
    }
    private void hitEnemy()
    {
        if (isTouching(Batman.class)) 
        {
            DC_Universe DC = (DC_Universe)getWorld();
            DC.addScore(20);
        }
        if(life <= 0) 
        {
            getWorld().removeObject(this);
        } 
        else
        {
            touchEnemy();
        }
    }
    private void touchEnemy()
    {
        Batman batman = (Batman) getOneIntersectingObject(Batman.class);
        if(batman != null){
            getWorld().removeObject(this);
        }
        else{
            life--;
        }
    }
}
