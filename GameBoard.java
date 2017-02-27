public class GameBoard {
    private static final int HEIGHT = 15;
    private static final int WIDTH  = 20;

    private char[][] grid;

    public void display(GameObject[] objects) {
        for (int i = 0; i < objects.length; i++) {
            if (objects[i] instanceof MovableObject) {
                ((MovableObject) objects[i]).draw();
            }
            else if (objects[i] instanceof StationaryObject) {
                objects[i].update();
            }
        }
    }

    public void display(Game g) {
        // Erase the stuff at the old player and ball locations
        for(int go=0; go<g.getObjectCount(); go++) {
            if (g.getGameObjects()[go] instanceof MovableObject) {
                MovableObject m = (MovableObject) g.getGameObjects()[go];
                int x = (int) m.getPreviousLocation().getX();
                int y = (int) m.getPreviousLocation().getY();

                // If m's previous location is in a valid range,
                // put a ' ' at m's previous location in the grid
                if (x > 0 && x < WIDTH && y > 0 && y < HEIGHT) {
                    // How to I insert a ' '?
                }
            }
        }

        // Draw the game objects on the board now
        for(int go=0; go<g.getObjectCount(); go++) {
            if (g.getGameObjects()[go] instanceof Wall) {
                Wall w = (Wall) g.getGameObjects()[go];
                /* Display the appropriate characters along the wall */
            }
            else {
                int x = (int) g.getGameObjects()[go].getLocation().getX();
                int y = (int) g.getGameObjects()[go].getPreviousLocation().getY();

                // If m's previous location is in a valid range,
                // display the appropriate character at obj's location
                if (x > 0 && x < WIDTH && y > 0 && y < HEIGHT) {
                    /* Display the appropriate character at obj’s location */
                }
            }
        }

        // Now display it
        for (int r=0; r<HEIGHT; r++) {
            for (int c=0; c<WIDTH; c++) {
                System.out.print(grid[r][c]);
            }
            System.out.println();
        }
    }
}
