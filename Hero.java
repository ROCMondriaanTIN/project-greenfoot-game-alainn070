import greenfoot.*;
import java.util.*;

/**
 *
 * @author R. Springer
 */
public class Hero extends Mover {

    private final double gravity;
    private final double acc;
    private final double drag;
    
    
    private int frame = 1;
    private int speed = 3;
    private boolean onGround;
    private int spawnX;
    private int spawnY;
    private boolean isTouching;
    private boolean start;    
    public static int player = 1;
    private int width;
    public static boolean starCollect = false;
    public static boolean GemCollectBlue = false;
    public static boolean keyCollect = false;
    public static boolean keyCollectRed = false;
    public static boolean keyCollectBlue = false;
    public static boolean keyCollectGreen = false;
    public static boolean blueOpen = false;
    public static boolean greenOpen = false;
    public static boolean redOpen = false;
    int Gem= 0;
    int star = 0;
    private boolean toLevel2;
    private int levens = 3;
    private int setPlaynumber = 1;
    int x = 70;
    int y = 1273;
    int coins= 0;
    private CollisionEngine collisionEngine;
    private TileEngine tileEngine;
    
    private int setPlayNumber = 1;
    private int walkL = -10;
    private int walkR = 10;
    private int springNumy;
    private ArrayList<GreenfootImage> animatieP1;
    private ArrayList<GreenfootImage> animatieP2;
    private ArrayList<GreenfootImage> animatieP3;
    private ArrayList<GreenfootImage> currentAnimation;
    

    public Hero(CollisionEngine collisionEngine, TileEngine tileEngine) {
        super();
        this.collisionEngine = collisionEngine;
        this.tileEngine = tileEngine;
        gravity = 9.8;
        acc = 0.6;
        drag = 0.8;
        setImage("p1_front.png"); 
        animatieP1 = new ArrayList<GreenfootImage>();
        animatieP2 = new ArrayList<GreenfootImage>();
        animatieP3 = new ArrayList<GreenfootImage>();
        for(int i = 1; i <= 11; i++) {
            String imageStart = "p1_walk0";
            animatieP1.add(new GreenfootImage(imageStart + i + ".png"));
            animatieP2.add(new GreenfootImage(imageStart + i + ".png"));
            animatieP3.add(new GreenfootImage(imageStart + i + ".png"));
    }
    // verander current animatie naar de nieuw character zodra je deze oppakt.
    currentAnimation = animatieP1;
    currentAnimation = animatieP2;
    currentAnimation = animatieP3;
    }
    private void removeTile(Tile tile) {
        tile.getImage().setTransparency(0);
        tile.isSolid = false;
    }
    @Override
    public void act() {
        handleInput();
        water();
        lava();
        toLevel2();
        velocityX *= drag;
        velocityY += acc;
        if (velocityY > gravity) {
            velocityY = gravity;
        }
        applyVelocity();
        handleInput();

        for (Actor enemy : getIntersectingObjects(Enemy.class)) {
            if (enemy != null) {
                //getWorld().removeObject(this);
                setLocation(70, 1273);
                setPlaynumber = 1;
                break;                
            }
        }
                for (Actor enemy : getIntersectingObjects(Enemy2.class)) {
            if (enemy != null) {
                //getWorld().removeObject(this);
                setLocation(70, 1273);
                break;                
            }
        }
        List <Tile> tiles = collisionEngine.getCollidingTiles(this, true);
         for (Tile tile : getIntersectingObjects(Tile.class)) {
            if (tile != null) {

            if(tile.getImage().toString().contains("hud_p1Alt")){
             setPlaynumber = 1;
            // getWorld().removeObject(tile);
             break;
     }else if(tile.getImage().toString().contains("hud_p2Alt")){
             setPlaynumber = 2;
            // getWorld().removeObject(tile);
             break;
     }else if(tile.getImage().toString().contains("hud_p3Alt")){
             setPlaynumber = 3;
            // getWorld().removeObject(tile);
             break;
            }
            
            if (tile.getImage().toString().contains("star")) {
                removeTile(tile);
                starCollect = true;
            }
            
            if (tile.getImage().toString().contains("gemBlue")) {
                removeTile(tile);
                GemCollectBlue = true;
            }

            if (tile.getImage().toString().contains("keyBlue")) {
                removeTile(tile);
                blueOpen = true;
            }

            if (tile.getImage().toString().contains("keyRed")) {
                removeTile(tile);
                redOpen = true;
            }

            if (tile.getImage().toString().contains("keyGreen")) {
                removeTile(tile);
                greenOpen = true;
            }
            
            if (tile.getImage().toString().contains("lock_blue") && (blueOpen == true)) {
                removeTile(tile);

            }
            
            if (tile.getImage().toString().contains("lock_green") && (greenOpen == true)) {
                removeTile(tile);

            }
            
            if (tile.getImage().toString().contains("lock_red") && (redOpen == true)) {
                removeTile(tile);

            }

        }
    }  

    
}
    
    public void isTouching() {
        if(isTouching (Star.class)) {
            star++;
        }
    }
    
    public void toLevel2() {
        if(isTouching (Door.class)) {
            if(getWorld() instanceof TitleScreen) Greenfoot.setWorld(new LevelEen());
            if(getWorld() instanceof LevelEen) Greenfoot.setWorld(new LevelTwee());
            if(getWorld() instanceof LevelTwee) Greenfoot.setWorld(new LevelDrie());
            if(getWorld() instanceof LevelDrie) Greenfoot.setWorld(new LevelVier());
        }
    }

    
    boolean onGround(){
        Actor under = getOneObjectAtOffset(0, getImage().getHeight()/2, Tile.class);
        return under != null;
        }
    
        
    public void handleInput() { 
        if(setPlaynumber == 1){
           getImage().scale(78, 97);
           springNumy = -14;
           walkL = -10;
           walkR = 10;
        }else if(setPlaynumber == 2){
            getImage().scale(82, 120);
            springNumy = -17;
            walkL = -10;
            walkR = 10;
        }else if(setPlaynumber == 3){
            getImage().scale(56, 64);
            springNumy = -11;
            walkL = -7;
            walkR = 7;
        }
        if (Greenfoot.isKeyDown("w") && (onGround() == true)) {
            velocityY = -16;
            setImage("p1_jump.png");
        }

        else if (Greenfoot.isKeyDown("a")) {
            velocityX = -5;
            animatie();
            flip();
        } 
        if (Greenfoot.isKeyDown("d")) {
            velocityX = 5;
            animatie();
            flip();
        }
        
    }
    
    public void water(){
        for (Actor hero : getIntersectingObjects(WaterTile.class)){
            if(hero != null) {
                setLocation(x,y);
            }
        }
    }
    public void lava(){
        for (Actor hero : getIntersectingObjects(LavaTile.class)){
            if(hero != null) {
                setLocation(x,y);
            }
        }
    }

    
    public void flip() { 
        for (int i = 1; i < 11; i++) { 
            if (getImage().equals(animatieP1)) {
                getImage().mirrorHorizontally();
               }
            else if (getImage().equals(animatieP2)) {
                getImage().mirrorHorizontally();
            }
            else if (getImage().equals(animatieP3)) {
                getImage().mirrorHorizontally();
            }
    }
}


public void animatie() {
        frame++;
        if(frame >= 11) frame = 0;
        setImage(currentAnimation.get(frame));
   }
   
    public int getWidth() {
        return getImage().getWidth();
    }

    public int getHeight() {
        return getImage().getHeight();
    }
        
}
