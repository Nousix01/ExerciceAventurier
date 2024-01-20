package devandgo.exercice;

import static org.junit.jupiter.api.Assertions.*;

import devandgo.exercice.game_exception.IncorrectStartingPositionError;
import org.junit.jupiter.api.Test;


class AventurierTest {
    @Test
    void generateMapTest() {
        Map map = new MapFactory().generateMap("../carte.txt", new Location(20, 20));
        assertEquals(20, map.getWidth());
        assertEquals(20, map.getHeight());
    }

    @Test
    void test1() throws IncorrectStartingPositionError {
        Map map = new MapFactory().generateMap("../carte.txt", new Location(20, 20));
        PlayerInput playerInput = new PlayerInput("./test_input/test1.txt");
        Player aventurier = new Player("Nour", playerInput.getStartLocation(), playerInput.getActions());
        Location location = new Game(map, aventurier, new ConsoleMapPrinter()).startGame();

        assertEquals(new Location(9,2), location);

    }
    @Test
    void test2() throws IncorrectStartingPositionError {
        Map map = new MapFactory().generateMap("../carte.txt", new Location(20, 20));
        PlayerInput playerInput = new PlayerInput("./test_input/test2.txt");
        Player aventurier = new Player("Mounir", playerInput.getStartLocation(), playerInput.getActions());
        Location location = new Game(map, aventurier, new ConsoleMapPrinter()).startGame();
        assertEquals(new Location(1,9), location);

    }
    @Test
    void unvalidInputTest() {
        Map map = new MapFactory().generateMap("../carte.txt", new Location(20, 20));
        PlayerInput playerInput = new PlayerInput("./test_input/test3.txt");
        Player aventurier = new Player("Issam", playerInput.getStartLocation(), playerInput.getActions());
        assertThrows(IncorrectStartingPositionError.class, () -> {
            new Game(map, aventurier, new ConsoleMapPrinter()).startGame();
        });

    }
    @Test
    void InvalidStartingPositionTest() {
        Map map = new MapFactory().generateMap("../carte.txt", new Location(20, 20));
        PlayerInput playerInput = new PlayerInput("./test_input/test3.txt");
        Player aventurier = new Player("Youness", playerInput.getStartLocation(), playerInput.getActions());
       assertThrows(IncorrectStartingPositionError.class, () -> {
           new Game(map, aventurier, new ConsoleMapPrinter()).startGame();
       });


    }
}