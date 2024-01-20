package devandgo.exercice;

import devandgo.exercice.game_exception.IncorrectStartingPositionError;

public class Game {
    private final Map map;
    private final Player aventurier;

    public Game(Map map, Player aventurier, MapPrinter mapPrinter) {
        this.map = map;
        this.aventurier = aventurier;
    }

    public Location startGame() throws IncorrectStartingPositionError {
        setPlayerPosition(aventurier,map);
        for(int i = 0; i < aventurier.getActions().length(); i++) {
            char action = aventurier.getActions().charAt(i);
            switch (action) {
                case 'N':
                    movePlayer(aventurier, map, Direction.UP);
                    break;
                case 'S':
                    movePlayer(aventurier, map, Direction.DOWN);
                    break;
                case 'E':
                    movePlayer(aventurier, map, Direction.RIGHT);
                    break;
                    case 'O':
                    movePlayer(aventurier, map, Direction.LEFT);
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + action);
            }
        }
        return aventurier.getLocation();
    }

    private void setPlayerPosition(Player aventurier,Map map) throws IncorrectStartingPositionError {
        try {
            if (map.getTiles()[aventurier.getLocation().y()][aventurier.getLocation().x()] == ' ') {
                map.getTiles()[aventurier.getLocation().y()][aventurier.getLocation().x()] = 'A';
            } else {

        throw new IncorrectStartingPositionError("La position du joueur est déjà occupée");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            // The player can't move outside the map
            throw new ArrayIndexOutOfBoundsException("La position du joueur est en dehors de la carte");
        }
    }

    private void movePlayer(Player player,Map map,Direction direction) throws IncorrectStartingPositionError{

        try {
            Location location = player.getLocation();
            switch (direction) {
                case UP:
                    //The x-axis and y-axis are inverted in the map
                    if(map.getTiles()[location.y() - 1][location.x()] == ' ') {
                    map.getTiles()[location.y() - 1][location.x()] = 'A';
                    map.getTiles()[location.y()][location.x()] = ' ';
                    player.setLocation(new Location(location.x(), location.y() - 1));
                } else {
                throw new IncorrectStartingPositionError("La position du joueur est déjà occupée");
                    }
                    break;
                case DOWN:
                if(map.getTiles()[location.y() + 1][location.x()] == ' ') {
                    map.getTiles()[location.y() + 1][location.x()] = 'A';
                    map.getTiles()[location.y()][location.x()] = ' ';
                    player.setLocation(new Location(location.x(), location.y() + 1));
                } else {
                    throw new IncorrectStartingPositionError("La position du joueur est déjà occupée");

                }
                    break;
                case RIGHT:
                if(map.getTiles()[location.y()][location.x() + 1] == ' ') {
                    map.getTiles()[location.y()][location.x() + 1] = 'A';
                    map.getTiles()[location.y()][location.x()] = ' ';
                    player.setLocation(new Location(location.x()+1, location.y()));
                } else {
                    throw new IncorrectStartingPositionError("La position du joueur est déjà occupée");
                }
                    break;
                case LEFT:
                if(map.getTiles()[location.y()][location.x() - 1] == ' ') {
                    map.getTiles()[location.y()][location.x() - 1] = 'A';
                    map.getTiles()[location.y()][location.x()] = ' ';
                    player.setLocation(new Location(location.x()-1, location.y()));
                } else {
                    throw new IncorrectStartingPositionError("La position du joueur est déjà occupée");
                }
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + direction);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            // The player can't move outside the map
            throw new ArrayIndexOutOfBoundsException("La position du joueur est en dehors de la carte");

    }



    }
}
