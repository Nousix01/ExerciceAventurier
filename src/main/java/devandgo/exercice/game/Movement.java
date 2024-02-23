package devandgo.exercice.game;

import devandgo.exercice.exception.InvalidDirectionException;

public enum Movement {
    UP('N') {
        @Override
        public Coordinate getNewLocation(Coordinate oldLocation) {
            return new Coordinate(oldLocation.x()-1, oldLocation.y());
        }
    }, DOWN('S') {
        @Override
        public Coordinate getNewLocation(Coordinate oldLocation) {
            return new Coordinate(oldLocation.x()+1, oldLocation.y());
        }
    }, LEFT('O') {
        @Override
       public Coordinate getNewLocation(Coordinate oldLocation) {
            return new Coordinate(oldLocation.x(), oldLocation.y()-1);
        }
    }, RIGHT('E') {
        @Override
        public Coordinate getNewLocation(Coordinate oldLocation) {
            return new Coordinate(oldLocation.x(), oldLocation.y()+1);
        }
    };

    private final char direction;

    Movement(char direction) {
        this.direction = direction;
    }

    public static Movement from(char direction) {
        for (Movement movement : Movement.values()) {
            if (movement.direction == direction) {
                return movement;
            }
        }
        throw new InvalidDirectionException(GameMessages.UNKNOWN_DIRECTION + direction);
    }


    public abstract Coordinate getNewLocation(Coordinate oldLocation);
}
