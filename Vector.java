/**
 * @author (Joseph Pepe) 
 * @version (2.0)
 */
public class Vector  
{
    double dx;
    double dy;
    double length;
    int direction;
    public Vector()
    {
        dx = 0;
        dy = 0;
    }
    public Vector(int newDirection, double newLength)
    {
       length = newLength;
       direction = newDirection;
       dx = newLength * Math.cos(Math.toRadians(newDirection));
       dy = newLength * Math.sin(Math.toRadians(newDirection));    
    }
    public Vector(int newDirection, double newLength,double newDx,double newDy)
    {
       direction = newDirection;
       length = newLength;
       dx = newDx;
       dy = newDy;    
    }
    public Vector(Vector otherVector)
    {
       direction = otherVector.direction;
       length = otherVector.length;
       dx = otherVector.dx;
       dy = otherVector.dy; 
    }
    /**
     * Set the direction of this vector.
     */
    public void setDirection(int newDirection)
    {
        direction = newDirection;
        dx = length * Math.cos(Math.toRadians(newDirection));
        dy = length * Math.sin(Math.toRadians(newDirection));   
    }
    /**
     * Add other vector to this vector.
     */
    public void add(Vector other)
    {
        dx += other.dx;
        dy += other.dy;    
        direction = (int) Math.toDegrees(Math.atan2(dy, dx));
        length = Math.sqrt(dx*dx+dy*dy);
    }   
    /**
     * Return the x offset of this vector.
     */
    public double getX()
    {
        return dx;
    }
    /**
     * Return the y offset of this vector.
     */
    public double getY()
    {
        return  dy;
    }
    /**
     * Return the current direction (in degrees).
     */
    public int getDirection()
    {
        return direction;
    }
    /**
     * Return the current length of the vector.
     */
    public double getLength()
    {
        return length;
    }
    /**
     * Create a copy of this vector.
     */
    public Vector copy()
    {
        return new Vector(this);
    }    
}
