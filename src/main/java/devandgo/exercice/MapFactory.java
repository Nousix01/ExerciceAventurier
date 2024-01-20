package devandgo.exercice;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MapFactory {
    public Map generateMap(String filePath, Location size) {
        char[][] tiles = new char[20][20];
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            int c;
            int i = 0, j = 0;
            // Read characters until the end of the file
            while ((c = br.read()) != -1) {
                char character = (char) c;
                if (character == '\n' || character == '\r') {
                    if (character == '\n') {
                        i++;
                        j = 0;
                    }
                } else {
                    tiles[i][j] = character;
                    j++;
                }
                // Process each character as needed (e.g., print it)
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("Provided map is invalid", e);
        }
        return new Map(size ,tiles );
    }


}
