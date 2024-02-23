package devandgo.exercice.map;

public class MapConfig {
    private final String filePath ;
     private final int width;
    private final int height;
    private final String fileType;

    public MapConfig(String fileType, String filePath, int width, int height) {
        this.filePath = filePath;
        this.width = width;
        this.height = height;
        this.fileType = fileType;
    }

    public String getFilePath() {
        return filePath;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String getFileType() {
        return fileType;
    }
}
