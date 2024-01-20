package devandgo.exercice;

public class Map {
    private final Location size;
    private char[][] tiles;

    public Map(Location size, char[][] tiles) {
        this.size = size;
        this.tiles = tiles;
    }

    public char[][] getTiles() {
        return tiles;
    }

    public char changeTile(Location location, char tile) {
        tiles[location.x()][location.y()] = tile;
        return tile;
    }

    public int getWidth() {
        return size.y();
    }

    public int getHeight() {
        return size.x();
    }
}
