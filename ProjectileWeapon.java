/**
 * @author (Joseph Pepe) 
 * @version (2.0)
 */
public abstract class ProjectileWeapon extends Mover
{
    public ProjectileWeapon(Vector speed, int rotation)
    {
        super(speed);
        setRotation(rotation);
        increaseSpeed(new Vector(rotation, 15));
        life = 50;
    }
}