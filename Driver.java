package oop_coursework;

/**
 * The abstract driver class extended by the Formula1Driver class
 * @author Dominik Deak - w1778659
 */
public abstract class Driver {

    private String name;
    private String location;
    private String team;

    // Getter and setters for the class attributes
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public String getLocation() {
        return this.location;
    }
    public void setTeam(String team) {
        this.team = team;
    }
    public String getTeam() {
        return this.team;
    }
}
