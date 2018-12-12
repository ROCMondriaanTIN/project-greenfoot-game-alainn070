public class GemBlue extends Mover {

    public GemBlue() {
        super();
        setImage("gemBlue.png");
    }

    public void act() {

        if (Hero.GemCollectBlue == true) {
            setImage("hud_gem_blue.png");
        } else {
            setImage("gemBlue.png");
        }
    }

}