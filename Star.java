public class Star extends Mover {

    public Star() {
        super();
        setImage("star.png");
    }

    public void act() {

        if (Hero.starCollect == true) {
            setImage("star.png");
        } else {
            setImage("star.png");
        }
    }

}