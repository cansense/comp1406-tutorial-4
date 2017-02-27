public abstract class Game {
    public static final int     MAX_GAME_OBJECTS = 1000;

    public GameObject[]    gameObjects;
    public int             objectCount;
    public GameBoard       gameBoard;

    public Game() {
        gameObjects = new GameObject[MAX_GAME_OBJECTS];
        objectCount = 0;
    }

    public void add(GameObject obj) {
        if (objectCount < MAX_GAME_OBJECTS)
            gameObjects[objectCount++] = obj;
    }

    // The get methods
    public Object[] getGameObjects() { return gameObjects; }
    public int getObjectCount() { return objectCount; }

    public String toString() {
        return "Game with " + objectCount + " objects";
    }

    public void displayObjects() {
        for (int i=0; i<objectCount; i++)
            System.out.println(gameObjects[i]);
    }

    public void updateObjects() {
        for (int i = 0; i < objectCount; i++) {
            gameObjects[i].update();
        }
    }

    // Return an array of all Harmful objects in the game
    public Harmful[] harmfulObjects() {
        // First find out how many objects are Harmful
        int count = 0;
        for (GameObject g: gameObjects)
            if (g instanceof Harmful)
                count++;

        // Now create the array and fill it up
        Harmful[] badGuys = new Harmful[count];
        count = 0;
        for (GameObject g: gameObjects)
            if (g instanceof Harmful)
                badGuys[count++] = (Harmful)g;
        return badGuys;
    }

    public int assessDanger() {
        Harmful[] harmfuls = harmfulObjects();
        int sumOfDamageAmounts = 0;

        for (int i = 0; i < harmfuls.length; i++) {
            sumOfDamageAmounts += harmfuls[i].getDamageAmount();
        }

        return sumOfDamageAmounts;
    }

    public abstract char appearance();

    public void displayBoard() {
        gameBoard.display(gameObjects);
    }
}