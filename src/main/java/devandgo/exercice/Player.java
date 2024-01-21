package devandgo.exercice;

import devandgo.exercice.error.IncorrectStartingPositionError;

import java.util.List;

public class Player {
    private final String name;
    private Coordinate currentLocation;

    private final List<Movement> actions;

    public void setCurrentLocation(Coordinate currentLocation) {
        this.currentLocation = currentLocation;
    }

    void setPlayerPosition(Map map) throws IncorrectStartingPositionError {
        try {
            if (map.isLocationFree(currentLocation)) {
                map.updateTile(currentLocation, 'A');
            } else {
                throw new IncorrectStartingPositionError("La position du joueur est déjà occupée");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            // The player can't move outside the map
            throw new ArrayIndexOutOfBoundsException("La position du joueur est en dehors de la carte");
        }
    }

    public Player(String name, Coordinate currentLocation, List<Movement> actions) {
        this.name = name;
        this.currentLocation = currentLocation;
        this.actions = actions;
    }

    public Coordinate getCurrentLocation() {
        return currentLocation;
    }

    public Coordinate getFinalLocation() {
        return new Coordinate(currentLocation.y(), currentLocation.x());
    }

    public int getTurns() {
        return actions.size();
    }

    public Movement getAction(int i) {
        return actions.get(i);
    }
}
