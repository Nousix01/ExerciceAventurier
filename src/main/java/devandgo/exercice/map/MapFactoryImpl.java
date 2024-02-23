package devandgo.exercice.map;

import devandgo.exercice.exception.ExceptionMessages;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;

public class MapFactoryImpl implements MapFactory {
    public Map generateMap(MapConfig mapConfig) {
        char[][] tiles = new char[mapConfig.getWidth()][mapConfig.getHeight()];
        switch (mapConfig.getFileType()) {
            case SupportedFiles.TEXT_FILE:
                URL resource = this.getClass().getClassLoader().getResource(mapConfig.getFilePath());
                try (BufferedReader br = new BufferedReader(new FileReader(resource.getPath()))) {
                    int lineIndex = 0;
                    Iterator<String> iterator = br.lines().iterator();
                    while(iterator.hasNext()){
                        String line = iterator.next();
                        for (int k = 0; k < line.length(); k++) {
                            tiles[lineIndex][k] = line.charAt(k);
                        }
                        lineIndex++;
                    }
                    return new Map(mapConfig.getWidth(), mapConfig.getHeight(), tiles);

                } catch (IOException e) {
                    throw new IllegalArgumentException(ExceptionMessages.INVALID_MAP);
                }
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_MAP_FILE_TYPE);
        }


    }


}
