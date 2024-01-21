package devandgo.exercice;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class PlayerInput {
    private final Coordinate startLocation;
    private final List<Movement> movements = new ArrayList<>();

    public PlayerInput(String filePath) {
        URL resource = this.getClass().getClassLoader().getResource(filePath);
        try(BufferedReader br = new BufferedReader(new FileReader(resource.getPath()))) {
            String firstLine = br.readLine();
            // find the "," and split the string into two parts

            int commaIndex = firstLine.indexOf(',');
            int startLocationX = Integer.parseInt(firstLine.substring(0,commaIndex));
            int startLocationY = Integer.parseInt(firstLine.substring(commaIndex+1));
            startLocation = new Coordinate(startLocationY, startLocationX);
            for (char movement :  br.readLine().toCharArray()) {
                movements.add(Movement.from(movement));
            }
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public Player createPlayer(String name) {
        return new Player(name, startLocation, movements);
    }

}
