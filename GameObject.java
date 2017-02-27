import javafx.geometry.Point2D;

public abstract class GameObject {
    protected Point2D location;
    protected String name;

    public GameObject(Point2D loc) {
        location = loc;
    }

    public Point2D getLocation() { return location; }
    public void setLocation(Point2D newLocation) { location = newLocation; }

    public String toString() {
        return name + " at (" + (int)location.getX() + "," + (int)location.getY() + ")";
    }

    public abstract void update();
}
