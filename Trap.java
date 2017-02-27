import javafx.geometry.Point2D;

public class Trap extends StationaryObject implements Harmful {

    public Trap(Point2D loc) {
        super(loc);
        name = "Trap";
    }

    public int getDamageAmount() {
        return -50;
    }
}