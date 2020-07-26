/**
 * @author (Joseph Pepe) 
 * @version (2.0)
 */
public class Batarang extends ProjectileWeapon
{
    /** The damage this Batarang will deal */
    private static int damage = 2;
    public Batarang(Vector speed, int rotation)
    {
        super(speed,rotation);
    }
    /**
     * The batarang will damage Superman.
     */
    public void act()
    {
        move();
        Collision();
    }
     /**
     * Check whether we are colliding with a Laser.
     */
    private boolean checkCollision() 
    {
        Laser laser = (Laser) getOneIntersectingObject(Laser.class);
        if(laser != null) 
        {
            getWorld().addObject(new Explosion(), getX(), getY());
            getWorld().removeObject(laser);
            getWorld().removeObject(this);
            return true;
        }
        return false;
    }
    private void Collision()
    {
        if(!checkCollision())
        {
            damagePlayer();
        }
    }
    private void damagePlayer()
    {
        if(life <= 0) {
            getWorld().removeObject(this);
        } 
        else{
            touchPlayer();
        }
    }
    private void touchPlayer()
    {
        Superman superman = (Superman) getOneIntersectingObject(Superman.class);
        if(superman != null){
            getWorld().removeObject(this);
            superman.hit(damage);
        }
        else{
            life--;
        }
    }
}
