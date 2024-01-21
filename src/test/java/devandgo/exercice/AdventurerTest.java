package devandgo.exercice;

import static org.junit.jupiter.api.Assertions.*;

import devandgo.exercice.error.IncorrectStartingPositionError;
import devandgo.exercice.error.InvalidDirectionException;
import devandgo.exercice.error.OutOfMapException;
import org.junit.jupiter.api.Test;

import java.util.Arrays;


class AdventurerTest {
    @Test
    void shouldParseSmallMap() {
        final var map = new MapFactory().generateMap("small_map.txt", 2, 2);

        char[][] tiles = {
                {' ', '#'},
                {'#', '#'}
        };
        assertTrue(Arrays.deepEquals(tiles, map.getTiles()));
    }

    @Test
    void shouldFailWhenInvalidInput() {

        assertThrows(InvalidDirectionException.class, () -> {
            new PlayerInput("test_input/invalidInputTest.txt");
        });

    }

    @Test
    void shouldFailWhenOutOfMap() {
        final var map = new MapFactory().generateMap("carte.txt", 20, 20);
        final var playerInput = new PlayerInput("test_input/outOfMapTest.txt");
        final var adventurer = playerInput.createPlayer("Issam");

        assertThrows(OutOfMapException.class, () -> {
            new Game(map, adventurer).startGame();
        });
    }

    @Test
    void shouldGiveInvalidStartingPosition() {
        final var map = new MapFactory().generateMap("carte.txt",20,20);
        final var playerInput = new PlayerInput("test_input/invalidStartingPositionTest.txt");
        final var adventurer = playerInput.createPlayer("Issam");

        assertThrows(IncorrectStartingPositionError.class, () -> {
            new Game(map, adventurer).startGame();
        });
    }

    @Test
    void shouldGoToDesiredPosition1() throws IncorrectStartingPositionError {
        final var map = new MapFactory().generateMap("carte.txt", 20, 20);
        final var playerInput = new PlayerInput("test_input/test1.txt");
        final var adventurer = playerInput.createPlayer("Nour");
        final var location = new Game(map, adventurer).startGame();

        assertEquals(new Coordinate(9,2), location);

    }
    @Test
    void shouldGoToDesiredPosition2() throws IncorrectStartingPositionError {
        final var map = new MapFactory().generateMap("carte.txt", 20   , 20);
        final var playerInput = new PlayerInput("test_input/test2.txt");
        final var adventurer = playerInput.createPlayer("Mounir");
        Coordinate location = new Game(map, adventurer).startGame();

        assertEquals(new Coordinate(1,9), location);

    }

}