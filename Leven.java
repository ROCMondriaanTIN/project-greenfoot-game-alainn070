import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Levens here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Leven extends Mover
{
    public Leven(){
        setImage("hud_p1Alt.png");
    }
    public void act() 
    {
        applyVelocity();
        
    }    
}