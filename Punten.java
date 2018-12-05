import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Punten here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Punten extends Actor
{
    static int punten = 0;
    public void addedToWorld(World w)
    {
        getWorld();
    }
    /**
     * Act - do whatever the Punten wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setImage(new GreenfootImage("Score: " + punten, 24, Color.GREEN, Color.WHITE));
    }    
    public static void scoreToevoegenDia()
    {
        punten += 1000;
    }
    public static void scoreToevoegenLeven()
    {
        punten += 500;
    }
}