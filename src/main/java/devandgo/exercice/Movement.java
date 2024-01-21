package devandgo.exercice;

import devandgo.exercice.error.InvalidDirectionException;

public enum Movement {
    UP('N') {
        @Override
        Coordinate getNewLocation(Coordinate oldLocation) {
            return new Coordinate(oldLocation.x()-1, oldLocation.y());
        }
    }, DOWN('S') {
        @Override
        Coordinate getNewLocation(Coordinate oldLocation) {
            return new Coordinate(oldLocation.x()+1, oldLocation.y());
        }
    }, LEFT('O') {
        @Override
        Coordinate getNewLocation(Coordinate oldLocation) {
            return new Coordinate(oldLocation.x(), oldLocation.y()-1);
        }
    }, RIGHT('E') {
        @Override
        Coordinate getNewLocation(Coordinate oldLocation) {
            return new Coordinate(oldLocation.x(), oldLocation.y()+1);
        }
    };

    private final char direction;

    Movement(char direction) {
        this.direction = direction;
    }

    static Movement from(char direction) {
        for (Movement movement : Movement.values()) {
            if (movement.direction == direction) {
                return movement;
            }
        }
        throw new InvalidDirectionException("Unknown direction: " + direction);
    }

    abstract Coordinate getNewLocation(Coordinate oldLocation);
}
