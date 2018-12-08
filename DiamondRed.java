public class DiamondRed extends Mover {

    public DiamondRed() {
        getImage().setTransparency(0);
    }

    @Override
    public void act() {
        if (Hero.collectGem == true) {
            setImage("hud_gem_red.png");
        }
    }
    
}