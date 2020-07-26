import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Calendar;
/**
 * @author (Joseph Pepe) 
 * @version (2.0)
 */
public class GameOver extends Actor
{
    public static final float FONT_SIZE = 48.0f;
    public static final int HEIGHT = 300;
    public static final int WIDTH = 550;
    /**
     * Create a score board.
     */
    public GameOver()
    {
        this(100);
    }
    /**
     * Create a score board for the final result.
     */
    public GameOver(int score)
    {
        makeImage("Superman: " + DC_Universe.getPlayerScore());
    }
    /**
     * Make the score board image.
     */
    private void makeImage(String title)
    {
        GreenfootImage image = new GreenfootImage(WIDTH, HEIGHT);
        image.setColor(new Color(255,255,255, 128));
        image.fillRect(0, 0, WIDTH, HEIGHT);
        image.setColor(new Color(0, 0, 0, 128));
        image.fillRect(5, 5, WIDTH-10, HEIGHT-10);
        Font font = image.getFont();
        font = font.deriveFont(FONT_SIZE);
        image.setFont(font);
        image.setColor(Color.WHITE);
        image.drawString(title, 70, 150);
        setImage(image);
    }
}