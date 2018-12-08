public class KeyRed extends Mover {

    public KeyRed() {
        super();
        setImage("hud_keyRed_disabled.png");
    }

    public void act() {
        if (Hero.redOpen == true) {
            setImage("hud_keyRed.png");
        } else {
            setImage("hud_keyRed_disabled.png");
        }
    }

}