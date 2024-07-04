package oop_coursework;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * The race class used to create race objects holding the race information
 * @author Dominik Deak - w1778659
 */
public class Race {

    /* I used the LocalDateTime class to store the race dates
    * I implemented this using a guide on this website: https://www.w3schools.com/java/java_date.asp */
    private LocalDateTime date;

    /**
     * Holds the names of all the drivers for this race object
     */
    private final ArrayList<String> RACE_NAMES = new ArrayList<>();

    /**
     * Holds all the starting positions of the drivers for this race object
     */
    private final ArrayList<Integer> STARTING_POSITIONS = new ArrayList<>();

    /**
     * Holds all the final positions of the drivers for this race object
     */
    private final ArrayList<Integer> FINAL_POSITIONS = new ArrayList<>();
    private int numberOfDrivers;

    // Methods to update and fetch race information
    public void addDate() {
        this.date = LocalDateTime.now();
    }
    public void setDate(String date) {
        this.date = LocalDateTime.parse(date);
    }
    public LocalDateTime getDate() {
        return this.date;
    }
    public void addDrivers(ArrayList<Formula1Driver> driverArray) {
        for (Formula1Driver formula1Driver : driverArray) {
            this.RACE_NAMES.add(formula1Driver.getName());
            this.numberOfDrivers++;
        }
    }
    public void setRaceName(String name) {
        this.RACE_NAMES.add(name);
    }
    public String getName(int index) {
        return this.RACE_NAMES.get(index);
    }
    public void addStartingPosition(int position) {
        this.STARTING_POSITIONS.add(position);
    }
    public int getStartingPosition(int index) {
        return this.STARTING_POSITIONS.get(index);
    }
    public void addFinalPosition(int position) {
        this.FINAL_POSITIONS.add(position);
    }
    public int getFinalPosition(int index) {
        return this.FINAL_POSITIONS.get(index);
    }
    public void setNumberOfDrivers(int numberOfDrivers) {
        this.numberOfDrivers = numberOfDrivers;
    }
    public int getNumberOfDrivers() {
        return this.numberOfDrivers;
    }
}
