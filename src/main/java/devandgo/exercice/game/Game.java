package devandgo.exercice.game;

import devandgo.exercice.exception.IncorrectStartingPositionError;
import devandgo.exercice.map.Map;
import devandgo.exercice.map.MapTiles;
import devandgo.exercice.player.Player;

public class Game {
    private final Map map;
    private final Player player;

    public Game(Map map, Player aventurier) {
        this.map = map;
        this.player = aventurier;
    }

    public Coordinate startGame() throws IncorrectStartingPositionError {
        player.setPlayerPosition(map);
        for (int i = 0; i < player.getTurns(); i++) {
            Movement movement = player.getAction(i);
            Coordinate oldLocation = player.getCurrentLocation();
            Coordinate newLocation = movement.getNewLocation(oldLocation);
            if (map.isLocationFree(newLocation)) {
                map.updateTile(newLocation, MapTiles.PLAYER);
                map.updateTile(oldLocation , MapTiles.EMPTY);
                player.setCurrentLocation(newLocation);
            }

        }
        // return the final location of the player
        return player.getFinalLocation();
    }
}
