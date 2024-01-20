package devandgo.exercice;

public class Player {
    private final String name;
    private Location location;

    private final String actions;

    public void setLocation(Location location) {
        this.location = location;
    }

    public Player(String name, Location location, String actions) {
        this.name = name;
        this.location = location;
        this.actions = actions;
    }

    public Location getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

    public String getActions() {
        return actions;
    }
}
