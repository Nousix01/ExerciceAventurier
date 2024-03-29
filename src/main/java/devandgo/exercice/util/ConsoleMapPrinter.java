package devandgo.exercice.util;


import devandgo.exercice.map.Map;
import devandgo.exercice.map.MapPrinter;

public class ConsoleMapPrinter implements MapPrinter {
    // A business class that takes care of printing the map to the console.


    @Override
    public void displayMap(Map map) {
        for (char[] row : map.getTiles()) {
            for (char cell : row) {
                System.out.print(cell);
            }
            System.out.println();
        }
    }
}
