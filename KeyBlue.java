
public class KeyBlue extends Mover {

    public KeyBlue() {
        super();
        setImage("hud_keyBlue_disabled.png");
    }

    public void act() {

        if (Hero.blueOpen == true) {
            setImage("hud_keyBlue.png");
        } else {
            setImage("hud_keyBlue_disabled.png");
        }
    }

}