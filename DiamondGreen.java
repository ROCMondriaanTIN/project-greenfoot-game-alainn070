public class DiamondGreen extends Mover {

    public DiamondGreen() {
        getImage().setTransparency(0);
    }

    @Override
    public void act() {
        if (Hero.collectGem == true) {
            setImage("hud_gem_green.png");
        }
    }
    
}