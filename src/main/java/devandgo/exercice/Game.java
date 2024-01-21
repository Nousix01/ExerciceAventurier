package devandgo.exercice;

import devandgo.exercice.error.IncorrectStartingPositionError;

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
                map.updateTile(newLocation, 'A');
                map.updateTile(oldLocation , ' ');
                player.setCurrentLocation(newLocation);
            }

        }
        // return the final location of the player
        return player.getFinalLocation();
    }
}
