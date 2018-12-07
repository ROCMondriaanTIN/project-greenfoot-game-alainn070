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
    boolean key=false;
    boolean key2;
    boolean key3;
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
    private int levens = 5;
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
        setImage("p1.png");                
    }

    @Override
    public void act() {
        handleInput();
        water();
        lava();
        eatKeys();
        eatKeys2();
        eatKeys3();
        eatKeys4();
        Door1();
        Door2();
        Door3();
        Door4();
        Door5();
        Door6();
        levels();
        detectPortal();
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
    }
    boolean onGround(){
        Actor under = getOneObjectAtOffset(0, getImage().getHeight()/2, Tile.class);
        return under != null;
        }
        
    public void handleInput() { 
        if (Greenfoot.isKeyDown("w") && (onGround() == true)) {
            velocityY = -30;
            setImage("p1_jump.png");
        }

        else if (Greenfoot.isKeyDown("a")) {
            velocityX = -5;
            animatieLeft();
        } 
        if (Greenfoot.isKeyDown("d")) {
            velocityX = 5;
            animatieRight();
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

    

    public int getWidth() {
        return getImage().getWidth();
    }

    public int getHeight() {
        return getImage().getHeight();
    }
    
     public boolean eatKeys()
    {
        for(Actor keys : getIntersectingObjects(Key.class))
        {
        
            if(isTouching(Key.class))
            {
                removeTouching(Key.class);
                key= true;
                break;
            }
        }
        return key;
    }
    
    public boolean eatKeys3()
    {
        for(Actor keys : getIntersectingObjects(Key3.class))
        {
        
            if(isTouching(Key3.class))
            {
                removeTouching(Key3.class);
                key3= true;
                break;
            }
        }
        return key;
    }
      
     public boolean eatKeys2()
    {
        for(Actor keys : getIntersectingObjects(Key2.class))
        {
        
            if(keys!=null)
            {
                removeTouching(Key2.class);
                key2=true;
                break;
            }
        }
        return key2;
    }
    
     public int eatKeys4()   
   {
          if(isTouching(Coin.class))
          {              
                removeTouching(Coin.class);
                coins++;
           }      
           return coins;
        }
        
    public boolean Door1()
    {
    if(key2==true && isTouching(DoorLock1.class))
    
    {
   setLocation(549 , 3102);
   key2=false;
    }
    return key2;
    }
    
    public boolean Door2()
    {
    if(key2==true && isTouching(DoorLock2.class))
    
    {
   setLocation(143 , 3102);
   key2=false;
    }
    return key2;
    }
    
    public boolean Door3()
    {
    if(key2==true && isTouching(DoorLock3.class))
    
    {
   setLocation(549 , 3102);
   key2=false;
    }
    return key2;
    }
    
    public boolean Door4()
    {
    if(key2==true && isTouching(DoorLock4.class))
    
    {
   setLocation(544 , 3700);
   key2=false;
    }
    return key2;
    }
                
    public boolean Door5()
    {
    if(key2==true && isTouching(DoorLock5.class))
    
    {
   setLocation(143 , 3102);
   key2=false;
    }
    return key2;
    }
    
    public boolean Door6()
    {
    if(key2==true && isTouching(DoorLock6.class))
    
    {
   Greenfoot.setWorld(new LevelDrie());
   key2=false;
    }
    return key2;
    }
    
    public void levels ()
    {
    for (Actor deur: getIntersectingObjects(DoorLock7.class))
        {
        if (key3==true&&coins==21)
        {
           if(isTouching(DoorLock7.class))
           Greenfoot.setWorld(new LevelVier());
           String Active="LevelVier";
        }
        }    
    }
    
    private void detectPortal()
    {
        for (Actor deur: getIntersectingObjects(DoorLock.class))
        {
        if (key==true)
        {
           if(isTouching(DoorLock.class))
           Greenfoot.setWorld(new LevelTwee());
           String Active="LevelTwee";
        }
        }
        
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
   