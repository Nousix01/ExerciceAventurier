package devandgo.exercice;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

public class MapFactory {
    public Map generateMap(String filePath, int width,int height) {
        char[][] tiles = new char[width][height];
        URL resource = this.getClass().getClassLoader().getResource(filePath);
        try (BufferedReader br = new BufferedReader(new FileReader(resource.getPath()))) {
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
                // Process each character as needed
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("Provided map is invalid", e);
        }
        return new Map(width,height ,tiles );
    }


}
