import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DoorTile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DoorTile extends Actor {
    public void act() {
        if (isTouching(Hero.class) && getWorld().getObjects(Key.class).isEmpty())
            Greenfoot.setWorld(new LevelTwee());
    }
}