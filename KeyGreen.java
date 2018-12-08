public class KeyGreen extends Mover {

    public KeyGreen() {
        super();
        setImage("hud_keyGreem_disabled.png");
    }

    public void act() {
        if (Hero.greenOpen == true) {
            setImage("hud_keyGreen.png");
        } else {
            setImage("hud_keyGreem_disabled.png");
        }
    }

}