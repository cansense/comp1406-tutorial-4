import javafx.geometry.Point2D;

public abstract class MovableObject extends GameObject {
    protected int		direction;
    protected int 		speed;
    protected Point2D   previousLocation;

    public MovableObject(int d, int s, Point2D loc) {
        super(loc);
        direction = d;
        speed = s;
    }

    public Point2D getPreviousLocation() { return previousLocation; }
    public void setPreviousLocation(Point2D loc) { previousLocation = loc; }

    public String toString() {
        return super.toString() + " facing " + direction +
                " degrees going " + speed + " pixels per second";
    }

    public void update() {
        previousLocation = location;
        moveForward();
        draw();
    }

    public void moveForward() {
        if (speed > 0) {
            location = location.add((int) (Math.cos(Math.toRadians(direction)) * speed),
                                    (int) (Math.sin(Math.toRadians(direction)) * speed));
        }
    }

    public abstract void draw();
}
