package MainLogic;

public class Grid {
    private static Grid gridInstance = null;
    private int xDim;
    private int yDim;

    SpaceObject[][] gridData;

    private Grid() {
        xDim = 5;
        yDim = 7;
        gridData = new SpaceObject[xDim][yDim];
    }

    public static synchronized Grid instance() {
        if (gridInstance == null)
            gridInstance = new Grid();

        return gridInstance;
    }

    //TODO: Make this cleaner - generic method?
    public SpaceObject test(Spaceship entry) {
        gridData[3][4] = entry;

        return gridData[3][4];
    }
}
