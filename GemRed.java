public class GemRed extends Mover {

    public GemRed() {
        super();
        setImage("gemRed.png");
    }

    public void act() {

        if (Hero.GemCollectRed == true) {
            setImage("hud_gem_red.png");
        } else {
            setImage("gemRed.png");
        }
    }

}