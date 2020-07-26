import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * @author (Joseph Pepe) 
 * @version (2.0)
 */
public class Enter extends Actor
{
    private GreenfootImage image1;
    private GreenfootImage image2;
    public Enter()
    {
        image1 = new GreenfootImage("Enter.png");
        image2 = new GreenfootImage("blank.png");
        setImage(image1);
    }
    public void act() 
    {
       int x = Greenfoot.getRandomNumber(100);
       switchImage(x);
    }    
    public void switchImage(int x)
    {
        if (x > 97)
            setImage(image2);
        else if(x < 8)
            setImage(image1);
    }
}
