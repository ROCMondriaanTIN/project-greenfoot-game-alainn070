public class GemGreen extends Mover {

    public GemGreen() {
        super();
        setImage("gemGreen.png");
    }

    public void act() {

        if (Hero.GemCollectGreen == true) {
            setImage("hud_gem_green.png");
        } else {
            setImage("gemGreen.png");
        }
    }

}