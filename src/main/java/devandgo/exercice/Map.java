package devandgo.exercice;

import devandgo.exercice.error.OutOfMapException;

public class Map {
    private final int width;
    private final int height;
    private char[][] tiles;

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Map(int width, int height, char[][] tiles) {
        this.width = width;
        this.height = height;
        this.tiles = tiles;
    }


    public char[][] getTiles() {
        return tiles;
    }

    public void updateTile(Coordinate location, char newTile) {
        this.tiles[location.y()][location.x()] = newTile;
    }

    public boolean isLocationFree(Coordinate location) {
        if(location.x() < 0 || location.x() >= getWidth() || location.y() < 0 || location.y() >= getHeight()) {
            throw new OutOfMapException("La position du joueur est en dehors de la carte");
        }
        return tiles[location.x()][location.y()] == ' ';
    }
}
