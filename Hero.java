import greenfoot.*;
import java.util.List;

/**
 *
 * @author R. Springer
 */
public class Hero extends Mover {

    private final double gravity;
    private final double acc;
    private final double drag;
    private GreenfootImage run1 = new GreenfootImage("p1_walk01 L.png");
    private GreenfootImage run2 = new GreenfootImage("p1_walk02 L.png");
    private GreenfootImage run3 = new GreenfootImage("p1_walk03 L.png");
    private GreenfootImage run4 = new GreenfootImage("p1_walk04 L.png");
    private GreenfootImage run5 = new GreenfootImage("p1_walk05 L.png");
    private GreenfootImage run6 = new GreenfootImage("p1_walk06 L.png");
    private GreenfootImage run7 = new GreenfootImage("p1_walk07 L.png");
    private GreenfootImage run8 = new GreenfootImage("p1_walk08 L.png");
    private GreenfootImage run9 = new GreenfootImage("p1_walk09 L.png");
    private GreenfootImage run10 = new GreenfootImage("p1_walk10 L.png");
    private GreenfootImage run11 = new GreenfootImage("p1_walk11 L.png");
    private GreenfootImage run12 = new GreenfootImage("p1_walk01.png");
    private GreenfootImage run13 = new GreenfootImage("p1_walk02.png");
    private GreenfootImage run14 = new GreenfootImage("p1_walk03.png");
    private GreenfootImage run15 = new GreenfootImage("p1_walk04.png");
    private GreenfootImage run16 = new GreenfootImage("p1_walk05.png");
    private GreenfootImage run17 = new GreenfootImage("p1_walk06.png");
    private GreenfootImage run18 = new GreenfootImage("p1_walk07.png");
    private GreenfootImage run19 = new GreenfootImage("p1_walk08.png");
    private GreenfootImage run20 = new GreenfootImage("p1_walk09.png");
    private GreenfootImage run21 = new GreenfootImage("p1_walk10.png");
    private GreenfootImage run22 = new GreenfootImage("p1_walk11.png");
    
    
    private int frame = 1;
    private int speed = 3;
    private boolean onGround;
    private boolean isTouching;
    private boolean start;
    public static boolean collectGem;
    public static int player = 1;
    private int width;
    public static boolean keyCollect = false;
    public static boolean keyCollectRed = false;
    public static boolean keyCollectBlue = false;
    public static boolean keyCollectGreen = false;
    public static boolean coinAdded = false;
    public static boolean keyNotFound = false;
    public static boolean blueOpen = false;
    public static boolean greenOpen = false;
    public static boolean redOpen = false;
    boolean coinGold= false;
    public String worldName="";
    public  int leven = 3;
    private int levens = 3;
    int x = 70;
    int y = 1273;
    int coins= 0;
    private CollisionEngine collisionEngine;
    private TileEngine tileEngine;
    

     public Hero(CollisionEngine collisionEngine, TileEngine tileEngine) {
        super();
        this.collisionEngine = collisionEngine;
        this.tileEngine = tileEngine;
        gravity = 9.8;
        acc = 0.6;
        drag = 0.8;
        setImage("p1_front.png");
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
        eatcoinGold();
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
         for (Tile tile : getIntersectingObjects(Tile.class)) {
            if (start == true) {
                start = false;
            }                       
            if (tile.getImage().toString().contains("door_open")) {
                Greenfoot.setWorld(new LevelTwee());
                setLocation(300, 200);
            }            
            if (tile.getImage().toString().contains("GemBlue")) {
                removeTile(tile);
                collectGem = true;
            }
            if (tile.getImage().toString().contains("GemGreen")) {
                removeTile(tile);
                collectGem = true;
            }
            if (tile.getImage().toString().contains("GemRed")) {
                removeTile(tile);
                collectGem = true;
            }

            if (tile.getImage().toString().contains("KeyBlue")) {
                removeTile(tile);
                blueOpen = true;
            }

            if (tile.getImage().toString().contains("KeyRed")) {
                removeTile(tile);
                redOpen = true;
            }

            if (tile.getImage().toString().contains("KeyGreen")) {
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
    
    boolean onGround(){
        Actor under = getOneObjectAtOffset(0, getImage().getHeight()/2, Tile.class);
        return under != null;
        }
        
    public void handleInput() {
        if (Greenfoot.isKeyDown("w")) {
            velocityY = -20;
        }

        if (Greenfoot.isKeyDown("a")) {
            velocityX = -2;
        } else if (Greenfoot.isKeyDown("d")) {
            velocityX = 2;
        }
    }
    
    public void lava(){
        for(Actor hero : getIntersectingObjects(LavaTile.class)){
            if(hero != null) {
                setLocation(x,y);
            }
        }
    }
    public void water(){
        for (Actor hero : getIntersectingObjects(WaterTile.class)){
            if(hero != null) {
                setLocation(x,y);
            }
        }
    }    
    
     public boolean eatcoinGold()

    {
        for(Actor coinGolder : getIntersectingObjects(CoinGoldTile.class))

        {
            if(isTouching(CoinGoldTile.class))

            {
                removeTouching(CoinGoldTile.class);
                coinGold= true;
                break;
            }
        }
        return coinGold;
    }
    
    public int getWidth() {
        return getImage().getWidth();
    }

    public int getHeight() {
        return getImage().getHeight();
    }

public void animatieRight() {
        if(frame == 1)
        {
            setImage(run12);
        }
        else if (frame == 2)
        {
            setImage(run13);
        }
        else if (frame == 3)
        {
            setImage(run14);
        }
        else if (frame == 4)
        {
            setImage(run15);
        }
        else if (frame == 5)
        {
            setImage(run16);
        }
        else if (frame == 6)
        {
            setImage(run17);
        }
        else if (frame == 7)
        {
            setImage(run18);
        }
        else if (frame == 8)
        {
            setImage(run19);
        }
        else if (frame == 9)
        {
            setImage(run20);
        }
        else if (frame == 10)
        {
            setImage (run21);
            frame = 0;
            return;
        }
        frame ++;                              
       }
       
           public void animatieLeft() {
        if(frame == 1)
        {
            setImage(run1);
        }
        else if (frame == 2)
        {
            setImage(run2);
        }
        else if (frame == 3)
        {
            setImage(run3);
        }
        else if (frame == 4)
        {
            setImage(run4);
        }
        else if (frame == 5)
        {
            setImage(run5);
        }
        else if (frame == 6)
        {
            setImage(run6);
        }
        else if (frame == 7)
        {
            setImage(run7);
        }
        else if (frame == 8)
        {
            setImage(run8);
        }
        else if (frame == 9)
        {
            setImage(run9);
        }
        else if (frame == 10)
        {
            setImage (run10);
            frame = 0;
            return;
        }
        frame ++;
    }
}