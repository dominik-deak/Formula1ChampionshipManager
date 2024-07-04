package oop_coursework;

/**
 * The Formula 1 Driver class that extends the abstract driver class
 * @author Dominik Deak - w1778659
 */
public class Formula1Driver extends Driver {

    private int numberOfFirstPositions;
    private int numberOfSecondPositions;
    private int numberOfThirdPositions;
    private int numberOfPoints;
    private int numberOfRaces;

    // Constructor initialising the fields
    public Formula1Driver(String name, String location, String team) {
        super.setName(name);
        super.setLocation(location);
        super.setTeam(team);
        this.numberOfFirstPositions = 0;
        this.numberOfSecondPositions = 0;
        this.numberOfThirdPositions = 0;
        this.numberOfPoints = 0;
        this.numberOfRaces = 0;
    }

    // Getter and setters for the class attributes
    public void setNumberOfFirstPositions(int numberOfFirstPositions) {
        this.numberOfFirstPositions = numberOfFirstPositions;
    }
    public int getNumberOfFirstPositions() {
        return this.numberOfFirstPositions;
    }
    public void setNumberOfSecondPositions(int numberOfSecondPositions) {
        this.numberOfSecondPositions = numberOfSecondPositions;
    }
    public int getNumberOfSecondPositions() {
        return this.numberOfSecondPositions;
    }
    public void setNumberOfThirdPositions(int numberOfThirdPositions) {
        this.numberOfThirdPositions = numberOfThirdPositions;
    }
    public int getNumberOfThirdPositions() {
        return this.numberOfThirdPositions;
    }
    public void setNumberOfPoints(int numberOfPoints) {
        this.numberOfPoints = numberOfPoints;
    }
    public int getNumberOfPoints() {
        return this.numberOfPoints;
    }
    public void setNumberOfRaces(int numberOfRaces) {
        this.numberOfRaces = numberOfRaces;
    }
    public int getNumberOfRaces() {
        return this.numberOfRaces;
    }

    // Additional methods to update driver statistics
    public void incrementFirstPositions() {
        this.numberOfFirstPositions++;
    }
    public void incrementSecondPositions() {
        this.numberOfSecondPositions++;
    }
    public void incrementThirdPositions() {
        this.numberOfThirdPositions++;
    }
    public void incrementRaces() {
        this.numberOfRaces++;
    }
    public void addPoints(int numberOfPoints) {
        this.numberOfPoints += numberOfPoints;
    }
}
