package devandgo.exercice;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PlayerInput {
    private final Location startLocation;
    private final String actions;

    public PlayerInput(String filepath) {

        try(BufferedReader br = new BufferedReader(new FileReader(filepath))){
            String firstLine = br.readLine();
            // find the "," and split the string into two parts

            int commaIndex = firstLine.indexOf(',');
            int startLocationX = Integer.parseInt(firstLine.substring(0,commaIndex));
            int startLocationY = Integer.parseInt(firstLine.substring(commaIndex+1));
            startLocation = new Location(startLocationX, startLocationY);
            actions = br.readLine();
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public Location getStartLocation() {
        return startLocation;
    }

    public String getActions() {
        return actions;
    }
}
