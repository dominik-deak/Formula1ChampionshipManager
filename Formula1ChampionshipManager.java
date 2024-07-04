package oop_coursework;

import java.util.*;
import java.io.*;

/**
 * The Formula 1 Championship Manager class that implements the interface
 * @author Dominik Deak - w1778659
 */
public class Formula1ChampionshipManager implements ChampionshipManager {

    /**
     * Holds all the created drivers
     */
    private static final ArrayList<Formula1Driver> F1_DRIVERS = new ArrayList<>();

    /**
     * Holds all the created races
     */
    private static final ArrayList<Race> F1_RACES = new ArrayList<>();

    /**
     * The point scheme for the races
     */
    public static final int[][] POINT_SCHEME = {{1, 25}, {2, 18}, {3, 15}, {4, 12}, {5, 10}, {6, 8}, {7, 6}, {8, 4}, {9, 2}, {10, 1}};

    /**
     * Prompts the user to enter a name, location and team
     * Creates and adds a new driver with the aforementioned attributes to the championship after passing validation
     */
    public void createDriver() {
        System.out.print("-------------------------------------\nPlease enter the name of the driver: ");
        String name = USER_INPUT.next();
        for (Formula1Driver f1_Driver : F1_DRIVERS) {
            if (f1_Driver.getName().equals(name)) {
                System.out.println(name + " is already in the championship");
                return;
            }
        }
        System.out.print("Please enter the location of the driver: ");
        String location = USER_INPUT.next();
        System.out.print("Please enter the team of the driver: ");
        String team = USER_INPUT.next();
        for (Formula1Driver f1_Driver : F1_DRIVERS) {
            if (f1_Driver.getTeam().equals(team)) {
                System.out.println(team + " is already in the championship");
                return;
            }
        }
        Formula1Driver F1driver = new Formula1Driver(name, location, team);
        F1_DRIVERS.add(F1driver);
        System.out.println(name + " and their team " + team + " have been added to the championship");
    }

    /**
     * Removes a selected driver and their attributes from the championship if they exist
     */
    public void deleteDriver() {
        if (F1_DRIVERS.isEmpty()) {
            System.out.println("There are no drivers in the championship");
        } else {
            System.out.print("-------------------------------------\nPlease enter the name of the driver you wish to delete: ");
            String name = USER_INPUT.next();
            for (int i = 0; i < F1_DRIVERS.size(); i++) {
                if (F1_DRIVERS.get(i).getName().equals(name)) {
                    System.out.println(name + " and their team " + F1_DRIVERS.get(i).getTeam() + " have been removed from the championship");
                    F1_DRIVERS.remove(i);
                    return;
                }
            }
            System.out.println("Sorry, couldn't find a driver with that name");
        }
    }

    /**
     * Changes a selected driver's team to a new one after validation
     */
    public void changeDriverTeam() {
        if (F1_DRIVERS.isEmpty()) {
            System.out.println("There are no drivers in the championship");
        } else {
            System.out.print("-------------------------------------\nPlease enter the name of the driver you wish to change the team of: ");
            String name = USER_INPUT.next();
            for (int i = 0; i < F1_DRIVERS.size(); i++) {
                if (F1_DRIVERS.get(i).getName().equals(name)) {
                    System.out.print("Please enter a new team for the driver: ");
                    String team = USER_INPUT.next();
                    for (Formula1Driver f1_driver : F1_DRIVERS) {
                        if (f1_driver.getTeam().equals(team)) {
                            System.out.println("Sorry, this team already exists in the championship");
                            return;
                        }
                    }
                    F1_DRIVERS.get(i).setTeam(team);
                    System.out.println("Successfully changed the team of " + name + " to " + team);
                    return;
                }
            }
            System.out.println("Sorry, couldn't find a driver with that name");
        }
    }

    /**
     * Displays all the statistics of a selected driver if they exist
     */
    public void displayDriverStatistics() {
        if (F1_DRIVERS.isEmpty()) {
            System.out.println("There are no drivers in the championship");
        } else {
            System.out.print("-------------------------------------\nPlease enter the name of a driver to see their statistics: ");
            String name = USER_INPUT.next();
            for (Formula1Driver f1_driver : F1_DRIVERS) {
                if (f1_driver.getName().equals(name)) {
                    System.out.println("Driver name: " + f1_driver.getName() +
                            "\nDriver location: " + f1_driver.getLocation() +
                            "\nDriver team: " + f1_driver.getTeam() +
                            "\nNumber of first positions: " + f1_driver.getNumberOfFirstPositions() +
                            "\nNumber of second positions: " + f1_driver.getNumberOfSecondPositions() +
                            "\nNumber of third positions: " + f1_driver.getNumberOfThirdPositions() +
                            "\nNumber of points: " + f1_driver.getNumberOfPoints() +
                            "\nNumber of races: " + f1_driver.getNumberOfRaces());
                    return;
                }
            }
            System.out.println("Sorry, couldn't find a driver with that name");
        }
    }

    /**
     * Displays the statistics of all the drivers in the championship
     * Orders the drivers by their number of points
     * If two drivers have the same number of points, orders them by their number of first positions
     */
    public void displayDriverTable() {
        if (F1_DRIVERS.isEmpty()) {
            System.out.println("There are no drivers in the championship");
        } else {
            ArrayList<Formula1Driver> sortedDrivers = new ArrayList<>(F1_DRIVERS);
            /* I used lambda expressions to simplify my code
            * I used the Integer.compare() method to compare and sort the two objects by the respective fields
            * I implemented them using the guides on these websites:
            * https://www.w3schools.com/java/java_lambda.asp
            * https://www.javatpoint.com/java-integer-compare-method
            * https://howtodoinjava.com/java/collections/arraylist/arraylist-sort-objects-by-field
            * https://stackoverflow.com/questions/6850611/sort-a-list-of-objects-by-multiple-fields */
            sortedDrivers.sort((o1, o2) -> {
                int compareValue = Integer.compare(o1.getNumberOfPoints(), o2.getNumberOfPoints());
                if (compareValue == 0) {
                    return Integer.compare(o1.getNumberOfFirstPositions(), o2.getNumberOfFirstPositions());
                }
                return compareValue;
            });
            // I reversed the order of the arraylist using this guide: https://www.javatpoint.com/how-to-reverse-arraylist-in-java
            Collections.reverse(sortedDrivers);
            for (Formula1Driver sortedDriver : sortedDrivers) {
                System.out.print("\nName: " + sortedDriver.getName() +
                        ", Location: " + sortedDriver.getLocation() +
                        ", Team: " + sortedDriver.getTeam() +
                        ", First positions: " + sortedDriver.getNumberOfFirstPositions() +
                        ", Second positions: " + sortedDriver.getNumberOfSecondPositions() +
                        ", Third positions: " + sortedDriver.getNumberOfThirdPositions() +
                        ", Points: " + sortedDriver.getNumberOfPoints() +
                        ", Races: " + sortedDriver.getNumberOfRaces());
            }
            System.out.println("\n");
        }
    }

    /**
     * Adds a new race to the championship
     * Automatically adds the current date and time of the system that is running the program
     * Prompts the user to enter the final positions for all the drivers
     * Automatically updates driver statistics according to their final positions
     */
    public void addRace() {
        if (F1_DRIVERS.isEmpty()) {
            System.out.println("There are no drivers in the championship");
        } else {
            try {
                Race F1Race = new Race();
                F1Race.addDate();
                F1Race.addDrivers(F1_DRIVERS);
                ArrayList<Integer> reservedPositions = new ArrayList<>();
                System.out.print("-------------------------------------\nPlease enter the positions achieved for the "
                        + F1_DRIVERS.size() + " drivers below");
                for (int i = 0; i < F1_DRIVERS.size(); i++) {
                    System.out.print("\n" + F1_DRIVERS.get(i).getName() + ": ");
                    int position = USER_INPUT.nextInt();
                    if (position < 1 || position > F1_DRIVERS.size() || reservedPositions.contains(position)) {
                        System.out.println("Invalid position entered");
                        return;
                    }
                    reservedPositions.add(position);
                    /* I used an enhanced switch statement to simplify my code
                     * I implemented it using a guide on this website: https://www.vojtechruzicka.com/java-enhanced-switch */
                    switch (position) {
                        case 1 -> {
                            F1_DRIVERS.get(i).incrementRaces();
                            F1_DRIVERS.get(i).addPoints(POINT_SCHEME[0][1]);
                            F1_DRIVERS.get(i).incrementFirstPositions();
                        }
                        case 2 -> {
                            F1_DRIVERS.get(i).incrementRaces();
                            F1_DRIVERS.get(i).addPoints(POINT_SCHEME[1][1]);
                            F1_DRIVERS.get(i).incrementSecondPositions();
                        }
                        case 3 -> {
                            F1_DRIVERS.get(i).incrementRaces();
                            F1_DRIVERS.get(i).addPoints(POINT_SCHEME[2][1]);
                            F1_DRIVERS.get(i).incrementThirdPositions();
                        }
                        case 4, 5, 6, 7, 8, 9, 10 -> {
                            F1_DRIVERS.get(i).incrementRaces();
                            F1_DRIVERS.get(i).addPoints(POINT_SCHEME[position - 1][1]);
                        }
                        default -> F1_DRIVERS.get(i).incrementRaces();
                    }
                    F1Race.addFinalPosition(position);
                }
                F1_RACES.add(F1Race);
                System.out.println("Successfully added race");
            } catch (InputMismatchException mismatchException) {
                System.out.println("Invalid value entered");
            }
        }
    }

    /**
     * Saves all the program data into two text files
     */
    public void saveProgramData() {
        if (F1_DRIVERS.isEmpty()) {
            System.out.println("There are no drivers in the championship");
        } else {
            try {
                PrintWriter DriverData = new PrintWriter("src/oop_coursework/DriverData.txt");
                PrintWriter RaceData = new PrintWriter("src/oop_coursework/RaceData.txt");
                for (Formula1Driver f1_driver : F1_DRIVERS) {
                    DriverData.print(f1_driver.getName() + " ");
                    DriverData.print(f1_driver.getLocation() + " ");
                    DriverData.print(f1_driver.getTeam() + " ");
                    DriverData.print(f1_driver.getNumberOfFirstPositions() + " ");
                    DriverData.print(f1_driver.getNumberOfSecondPositions() + " ");
                    DriverData.print(f1_driver.getNumberOfThirdPositions() + " ");
                    DriverData.print(f1_driver.getNumberOfPoints() + " ");
                    DriverData.print(f1_driver.getNumberOfRaces() + "\n");
                }
                if (F1_RACES.isEmpty()) {
                    System.out.println("Successfully saved driver data (there are no races in the championship)");
                } else {
                    for (Race f1_race : F1_RACES) {
                        RaceData.print(f1_race.getDate() + " ");
                        RaceData.print(f1_race.getNumberOfDrivers() + " ");
                        for (int j = 0; j < f1_race.getNumberOfDrivers(); j++) {
                            RaceData.print(f1_race.getName(j) + " ");
                            RaceData.print(f1_race.getFinalPosition(j) + " ");
                        }
                        RaceData.print("\n");
                    }
                    System.out.println("Successfully stored driver and race data");
                }
                DriverData.close();
                RaceData.close();
            } catch (IOException ioException) {
                System.out.println("Unexpected error occurred: " + ioException);
            }
        }
    }

    /**
     * Loads all the program data from two text files
     */
    public void loadProgramData() {
        try {
            File DriverData = new File("src/oop_coursework/DriverData.txt");
            File RaceData = new File("src/oop_coursework/RaceData.txt");
            Scanner DriverDataScanner = new Scanner(DriverData);
            Scanner RaceDataScanner = new Scanner(RaceData);
            while (DriverDataScanner.hasNext()) {
                Formula1Driver F1driver = new Formula1Driver(DriverDataScanner.next(), DriverDataScanner.next(), DriverDataScanner.next());
                F1driver.setNumberOfFirstPositions(Integer.parseInt(DriverDataScanner.next()));
                F1driver.setNumberOfSecondPositions(Integer.parseInt(DriverDataScanner.next()));
                F1driver.setNumberOfThirdPositions(Integer.parseInt(DriverDataScanner.next()));
                F1driver.setNumberOfPoints(Integer.parseInt(DriverDataScanner.next()));
                F1driver.setNumberOfRaces(Integer.parseInt(DriverDataScanner.next()));
                F1_DRIVERS.add(F1driver);
            }
            while (RaceDataScanner.hasNext()) {
                Race F1Race = new Race();
                F1Race.setDate(RaceDataScanner.next());
                F1Race.setNumberOfDrivers(Integer.parseInt(RaceDataScanner.next()));
                for (int i = 0; i < F1Race.getNumberOfDrivers(); i++) {
                    F1Race.setRaceName(RaceDataScanner.next());
                    F1Race.addFinalPosition(Integer.parseInt(RaceDataScanner.next()));
                }
                F1_RACES.add(F1Race);
            }
            DriverDataScanner.close();
            RaceDataScanner.close();
        } catch (IOException ioException) {
            System.out.println("Unexpected error occurred" + ioException);
        }
    }

    /**
     * Launches the graphical user interface part of the program
     */
    public void launchGUI() {
        SwingGUI swingGUI = new SwingGUI();
        swingGUI.startGUI();
    }

    /**
     * @return the list of all drivers
     */
    public static ArrayList<Formula1Driver> getF1_DRIVERS() {
        return F1_DRIVERS;
    }

    /**
     * @return the list of all races
     */
    public static ArrayList<Race> getF1_RACES() {
        return F1_RACES;
    }
}
