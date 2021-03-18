import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Abstract Class that can be extended to control an object that requires movement.
 * @author (Joseph Pepe)
 * @version (2.0)
 */
public abstract class Mover extends Actor
{
    protected int life;
    private Vector movement;
    private double x_Axis = 0;
    private double y_Axis = 0;
    public Mover()
    {
        movement = new Vector();
        life = 100;
    }
    /**
     * Create new thing initialized with given speed.
     */
    public Mover(Vector speed)
    {
        movement = speed;
    }
    protected final void move() 
    {
        x_Axis += movement.getX();
        y_Axis += movement.getY();
        if(y_Axis >= getWorld().getHeight()) 
        {
            y_Axis = 0;
            setLocation(getX(), y_Axis);
        }
        else if(y_Axis < 0)
        {
            y_Axis = getWorld().getHeight();
            setLocation(getX(), y_Axis);
        }
        setLocation(x_Axis, y_Axis);
    }
    public void setLocation(double x, double y) 
    {
        x_Axis = x;
        y_Axis= y;
        super.setLocation((int) x, (int) y);
    }
    public void setLocation(int x, int y) 
    {
        setLocation((double) x, (double) y);
    }
    public double getX_Coordinate()
    {
        return x_Axis;
    }
    public double getY_Coordinate()
    {
        return y_Axis;
    }
    /**
     * Increase the speed with the given vector.
     */
    public void increaseSpeed(Vector newSpeed) 
    {
        movement.add(newSpeed);
    }
    /**
     * Return the current movement.
     */
    public Vector getMovement() 
    {
        return movement;
    }
}
