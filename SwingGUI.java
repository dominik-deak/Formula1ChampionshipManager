package oop_coursework;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static oop_coursework.Formula1ChampionshipManager.POINT_SCHEME;

/**
 * The Java Swing class that creates and handles the graphical user interface
 * @author Dominik Deak - w1778659
 */
public class SwingGUI {

    JFrame mainFrame;
    JPanel mainPanel;
    /* I created a default table model for my table, so I can update the data dynamically using vectors
    * I implemented this using a guide on this website: https://www.tutorialspoint.com/how-to-create-defaulttablemodel-which-is-an-implementation-of-tablemodel */
    DefaultTableModel tableModel;
    JTable dataTable;
    JScrollPane scrollPane;

    /**
     * Holds the sorted drivers
     */
    private ArrayList<Formula1Driver> sortedDrivers;

    /**
     * Used to update the table data shown
     */
    private Object[][] tableData;

    /**
     * Table columns for the drivers
     */
    private final String[] DRIVER_COLUMNS = {"Name", "Location", "Team",
            "First positions", "Second positions", "Third positions", "Points", "Races"};

    /**
     * Table columns for the races
     */
    private final String[] RACE_COLUMNS = {"Date", "Name", "Final position"};

    /**
     * Starts the graphical user interface
     * Adds all the JComponents
     */
    public void startGUI() {
        // Creating the frame
        mainFrame = new JFrame("Formula 1 championship");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainPanel = new JPanel();
        mainFrame.setContentPane(mainPanel);

        // Buttons
        JButton driverTableButton = new JButton("Display table");
        JButton sortByPointsButton = new JButton("Sort by points ascending");
        JButton sortByFirstPositionButton = new JButton("Sort by first positions");
        JButton generateRandomRaceButton = new JButton("Generate race");
        JButton generateRandomPositionsRaceButton = new JButton("Generate with random positions");
        JButton displayRacesByDateButton = new JButton("Sort races by date");
        JButton searchDriverRacesButton = new JButton("Search driver races");

        // Labels, fields
        JLabel driverFieldLabel = new JLabel("Enter driver name:");
        JTextField driverField = new JTextField(20);

        // Adding lambda expressions again, using this guide: https://www.w3schools.com/java/java_lambda.asp
        driverTableButton.addActionListener(e -> displayTableByPointsDescending());
        sortByPointsButton.addActionListener(e -> sortByPointsAscending());
        sortByFirstPositionButton.addActionListener(e -> sortByFirstPositionsDescending());
        generateRandomRaceButton.addActionListener(e -> generateRandomRace());
        generateRandomPositionsRaceButton.addActionListener(e -> generateRandomPositionsRace());
        displayRacesByDateButton.addActionListener(e -> displayRacesByDate());
        searchDriverRacesButton.addActionListener(e -> searchDriverRaces(driverField));

        // Tables
        tableModel = new DefaultTableModel();
        dataTable = new JTable(tableModel);
        scrollPane = new JScrollPane(dataTable);

        // Adding content
        mainPanel.add(driverTableButton);
        mainPanel.add(sortByPointsButton);
        mainPanel.add(sortByFirstPositionButton);
        mainPanel.add(generateRandomRaceButton);
        mainPanel.add(generateRandomPositionsRaceButton);
        mainPanel.add(displayRacesByDateButton);
        mainPanel.add(driverFieldLabel);
        mainPanel.add(driverField);
        mainPanel.add(searchDriverRacesButton);
        mainPanel.add(scrollPane);

        // Showing the frame
        mainFrame.setSize(1100, 500);
        mainFrame.setResizable(false); //Disables resizing
        mainFrame.setLocationRelativeTo(null); // Centers frame on screen
        mainFrame.setVisible(true);
    }

    /**
     * Displays all the drivers and their statistics in descending order of points
     */
    public void displayTableByPointsDescending() {
        if (!Formula1ChampionshipManager.getF1_DRIVERS().isEmpty()) {
            sortedDrivers = new ArrayList<>(Formula1ChampionshipManager.getF1_DRIVERS());
            sortedDrivers.sort((o1, o2) -> {
                int compareValue = Integer.compare(o1.getNumberOfPoints(), o2.getNumberOfPoints());
                if (compareValue == 0) {
                    return Integer.compare(o1.getNumberOfFirstPositions(), o2.getNumberOfFirstPositions());
                }
                return compareValue;
            });
            Collections.reverse(sortedDrivers);
            tableData = new Object[sortedDrivers.size()][8];
            for (int i = 0; i < sortedDrivers.size(); i++) {
                tableData[i][0] = sortedDrivers.get(i).getName();
                tableData[i][1] = sortedDrivers.get(i).getLocation();
                tableData[i][2] = sortedDrivers.get(i).getTeam();
                tableData[i][3] = sortedDrivers.get(i).getNumberOfFirstPositions();
                tableData[i][4] = sortedDrivers.get(i).getNumberOfSecondPositions();
                tableData[i][5] = sortedDrivers.get(i).getNumberOfThirdPositions();
                tableData[i][6] = sortedDrivers.get(i).getNumberOfPoints();
                tableData[i][7] = sortedDrivers.get(i).getNumberOfRaces();
            }
            /* I populated the existing JTable with vectors
             * I implemented this using a guide on this website: https://stackhowto.com/how-to-populate-jtable-with-a-vector */
            tableModel.setDataVector(tableData, DRIVER_COLUMNS);
        }
    }

    /**
     * Displays all the drivers and their statistics in ascending order of points
     */
    public void sortByPointsAscending() {
        if (!Formula1ChampionshipManager.getF1_DRIVERS().isEmpty()) {
            sortedDrivers = new ArrayList<>(Formula1ChampionshipManager.getF1_DRIVERS());
            sortedDrivers.sort((o1, o2) -> {
                int compareValue = Integer.compare(o1.getNumberOfPoints(), o2.getNumberOfPoints());
                if (compareValue == 0) {
                    return Integer.compare(o1.getNumberOfFirstPositions(), o2.getNumberOfFirstPositions());
                }
                return compareValue;
            });
            tableData = new Object[sortedDrivers.size()][8];
            for (int i = 0; i < sortedDrivers.size(); i++) {
                tableData[i][0] = sortedDrivers.get(i).getName();
                tableData[i][1] = sortedDrivers.get(i).getLocation();
                tableData[i][2] = sortedDrivers.get(i).getTeam();
                tableData[i][3] = sortedDrivers.get(i).getNumberOfFirstPositions();
                tableData[i][4] = sortedDrivers.get(i).getNumberOfSecondPositions();
                tableData[i][5] = sortedDrivers.get(i).getNumberOfThirdPositions();
                tableData[i][6] = sortedDrivers.get(i).getNumberOfPoints();
                tableData[i][7] = sortedDrivers.get(i).getNumberOfRaces();
            }
            tableModel.setDataVector(tableData, DRIVER_COLUMNS);
        }
    }

    /**
     * Displays all the drivers and their statistics in descending order of first positions
     */
    public void sortByFirstPositionsDescending() {
        if (!Formula1ChampionshipManager.getF1_DRIVERS().isEmpty()) {
            sortedDrivers = new ArrayList<>(Formula1ChampionshipManager.getF1_DRIVERS());
            sortedDrivers.sort((o1, o2) -> {
                int compareValue = Integer.compare(o1.getNumberOfFirstPositions(), o2.getNumberOfFirstPositions());
                if (compareValue == 0) {
                    return Integer.compare(o1.getNumberOfPoints(), o2.getNumberOfPoints());
                }
                return compareValue;
            });
            Collections.reverse(sortedDrivers);
            tableData = new Object[sortedDrivers.size()][8];
            for (int i = 0; i < sortedDrivers.size(); i++) {
                tableData[i][0] = sortedDrivers.get(i).getName();
                tableData[i][1] = sortedDrivers.get(i).getLocation();
                tableData[i][2] = sortedDrivers.get(i).getTeam();
                tableData[i][3] = sortedDrivers.get(i).getNumberOfFirstPositions();
                tableData[i][4] = sortedDrivers.get(i).getNumberOfSecondPositions();
                tableData[i][5] = sortedDrivers.get(i).getNumberOfThirdPositions();
                tableData[i][6] = sortedDrivers.get(i).getNumberOfPoints();
                tableData[i][7] = sortedDrivers.get(i).getNumberOfRaces();
            }
            tableModel.setDataVector(tableData, DRIVER_COLUMNS);
        }
    }

    /**
     * Generates and adds a random completed race
     * Automatically updates all driver statistics
     */
    public void generateRandomRace() {
        if (!Formula1ChampionshipManager.getF1_DRIVERS().isEmpty()) {
            Race F1Race = new Race();
            F1Race.addDate();
            F1Race.addDrivers(Formula1ChampionshipManager.getF1_DRIVERS());
            ArrayList<Integer> reservedPositions = new ArrayList<>();
            Random randomNumber = new Random();
            int randomFinalPosition;
            for (int i = 0; i < Formula1ChampionshipManager.getF1_DRIVERS().size(); i++) {
                do {
                    /* I used the random class to generate random integers between a set range
                    * I used a guide on this website: https://mkyong.com/java/java-generate-random-integers-in-a-range */
                    randomFinalPosition = randomNumber.nextInt((Formula1ChampionshipManager.getF1_DRIVERS().size() + 1) - 1) + 1;
                } while (reservedPositions.contains(randomFinalPosition));
                reservedPositions.add(randomFinalPosition);
                addStatistics(i, randomFinalPosition);
                F1Race.addFinalPosition(randomFinalPosition);
            }
            Formula1ChampionshipManager.getF1_RACES().add(F1Race);
            displayTableByPointsDescending();
        }
    }

    /**
     * Generates and adds a completed race with random starting positions
     * Uses probability to calculate the first position based on the starting positions
     * Automatically updates all driver statistics
     */
    public void generateRandomPositionsRace() {
        if (!Formula1ChampionshipManager.getF1_DRIVERS().isEmpty()) {
            Race F1Race = new Race();
            F1Race.addDate();
            F1Race.addDrivers(Formula1ChampionshipManager.getF1_DRIVERS());
            ArrayList<Integer> reservedStartingPositions = new ArrayList<>();
            ArrayList<Integer> reservedFinalPositions = new ArrayList<>();
            Random randomNumber = new Random();
            int randomStartingPosition;
            int randomFinalPosition;
            int numberToBeat;
            for (int i = 0; i < F1Race.getNumberOfDrivers(); i++) {
                do {
                    randomStartingPosition = randomNumber.nextInt((F1Race.getNumberOfDrivers() + 1) - 1) + 1;
                } while (reservedStartingPositions.contains(randomStartingPosition));
                reservedStartingPositions.add(randomStartingPosition);
                F1Race.addStartingPosition(randomStartingPosition);
            }
            for (int i = 0; i < F1Race.getNumberOfDrivers(); i++) {
                if (reservedFinalPositions.contains(1)) {
                    do {
                        randomFinalPosition = randomNumber.nextInt((F1Race.getNumberOfDrivers() + 1) - 1) + 1;
                    } while (reservedFinalPositions.contains(randomFinalPosition) || randomFinalPosition == 1);
                    reservedFinalPositions.add(randomFinalPosition);
                    addStatistics(i, randomFinalPosition);
                    F1Race.addFinalPosition(randomFinalPosition);
                } else if ((reservedFinalPositions.size() == F1Race.getNumberOfDrivers() - 1) && (!reservedFinalPositions.contains(1))) {
                    addStatistics(i, 1);
                    F1Race.addFinalPosition(1);
                    reservedFinalPositions.add(1);
                } else {
                    numberToBeat = randomNumber.nextInt(101 - 1) + 1;
                    switch (F1Race.getStartingPosition(i)) {
                        case 1 -> {
                            if (numberToBeat < 40) {
                                addStatistics(i, 1);
                                F1Race.addFinalPosition(1);
                                reservedFinalPositions.add(1);
                            } else {
                                do {
                                    randomFinalPosition = randomNumber.nextInt((F1Race.getNumberOfDrivers() + 1) - 1) + 1;
                                } while (reservedFinalPositions.contains(randomFinalPosition) || randomFinalPosition == 1);
                                reservedFinalPositions.add(randomFinalPosition);
                                addStatistics(i, randomFinalPosition);
                                F1Race.addFinalPosition(randomFinalPosition);
                            }
                        }
                        case 2 -> {
                            if (numberToBeat < 30) {
                                addStatistics(i, 1);
                                F1Race.addFinalPosition(1);
                                reservedFinalPositions.add(1);
                            } else {
                                do {
                                    randomFinalPosition = randomNumber.nextInt((F1Race.getNumberOfDrivers() + 1) - 1) + 1;
                                } while (reservedFinalPositions.contains(randomFinalPosition) || randomFinalPosition == 1);
                                reservedFinalPositions.add(randomFinalPosition);
                                addStatistics(i, randomFinalPosition);
                                F1Race.addFinalPosition(randomFinalPosition);
                            }
                        }
                        case 3, 4 -> {
                            if (numberToBeat < 10) {
                                addStatistics(i, 1);
                                F1Race.addFinalPosition(1);
                                reservedFinalPositions.add(1);
                            } else {
                                do {
                                    randomFinalPosition = randomNumber.nextInt((F1Race.getNumberOfDrivers() + 1) - 1) + 1;
                                } while (reservedFinalPositions.contains(randomFinalPosition) || randomFinalPosition == 1);
                                reservedFinalPositions.add(randomFinalPosition);
                                addStatistics(i, randomFinalPosition);
                                F1Race.addFinalPosition(randomFinalPosition);
                            }
                        }
                        case 5, 6, 7, 8, 9 -> {
                            if (numberToBeat < 2) {
                                addStatistics(i, 1);
                                F1Race.addFinalPosition(1);
                                reservedFinalPositions.add(1);
                            } else {
                                do {
                                    randomFinalPosition = randomNumber.nextInt((F1Race.getNumberOfDrivers() + 1) - 1) + 1;
                                } while (reservedFinalPositions.contains(randomFinalPosition) || randomFinalPosition == 1);
                                reservedFinalPositions.add(randomFinalPosition);
                                addStatistics(i, randomFinalPosition);
                                F1Race.addFinalPosition(randomFinalPosition);
                            }
                        }
                        default -> {
                            do {
                                randomFinalPosition = randomNumber.nextInt((F1Race.getNumberOfDrivers() + 1) - 1) + 1;
                            } while (reservedFinalPositions.contains(randomFinalPosition) || randomFinalPosition == 1);
                            reservedFinalPositions.add(randomFinalPosition);
                            addStatistics(i, randomFinalPosition);
                            F1Race.addFinalPosition(randomFinalPosition);
                        }
                    }
                }
            }
            Formula1ChampionshipManager.getF1_RACES().add(F1Race);
            displayTableByPointsDescending();
        }
    }

    /**
     * Displays all the races
     * Orders the list by dates ascending
     */
    public void displayRacesByDate() {
        if (!Formula1ChampionshipManager.getF1_RACES().isEmpty()) {
            ArrayList<Race> sortedRaces = new ArrayList<>(Formula1ChampionshipManager.getF1_RACES());
            /* I used the Comparator.comparing method to simplify my code
            * I implemented it using a guide on this website: https://javadevcentral.com/java-comparator-comparing */
            sortedRaces.sort(Comparator.comparing(Race::getDate));
            int totalDrivers = 0;
            for (Race sortedRace : sortedRaces) {
                totalDrivers += sortedRace.getNumberOfDrivers();
            }
            tableData = new Object[totalDrivers][3];
            /* I used the DateTimeFormatter class to format the dates
            * I implemented it using a guide on this website: https://www.w3schools.com/java/java_date.asp */
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy MMM dd HH:mm:ss");
            int lineCounter = 0;
            for (Race sortedRace : sortedRaces) {
                tableData[lineCounter][0] = sortedRace.getDate().format(dateFormatter);
                for (int j = 0; j < sortedRace.getNumberOfDrivers(); j++) {
                    tableData[lineCounter][1] = sortedRace.getName(j);
                    tableData[lineCounter][2] = sortedRace.getFinalPosition(j);
                    lineCounter++;
                }
            }
            tableModel.setDataVector(tableData, RACE_COLUMNS);
        }
    }

    /**
     * Prompts the user to enter a name
     * Displays all the races for the driver with that name if they exist
     * @param textField the JTextField from where the method reads the user input
     */
    public void searchDriverRaces(JTextField textField) {
        if (!Formula1ChampionshipManager.getF1_RACES().isEmpty()) {
            ArrayList<Race> driverRaces = new ArrayList<>();
            /* I retrieved the user-entered value from the JTextField using a guide on this website:
            * https://www.delftstack.com/howto/java/get-value-from-jtextfield */
            String nameInput = textField.getText();
            boolean found = false;
            int driverIndex = 0;
            for (int i = 0; i < Formula1ChampionshipManager.getF1_RACES().size(); i++) {
                for (int j = 0; j < Formula1ChampionshipManager.getF1_RACES().get(i).getNumberOfDrivers(); j++) {
                    if (Formula1ChampionshipManager.getF1_RACES().get(i).getName(j).equals(nameInput)) {
                        found = true;
                        driverRaces.add(Formula1ChampionshipManager.getF1_RACES().get(i));
                        driverIndex = j;
                    }
                }
            }
            if (found) {
                tableData = new Object[driverRaces.size()][3];
                DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy MMM dd HH:mm:ss");
                for (int i = 0; i < driverRaces.size(); i++) {
                    tableData[i][0] = driverRaces.get(i).getDate().format(dateFormatter);
                    tableData[i][1] = nameInput;
                    tableData[i][2] = driverRaces.get(i).getFinalPosition(driverIndex);
                }
                tableModel.setDataVector(tableData, RACE_COLUMNS);
            }
        }
    }

    /**
     * Updates the statistics of drivers based on their final position in a race
     * @param index the index of the driver in the arraylist
     * @param finalPosition the final position of the driver in the race
     */
    public void addStatistics(int index, int finalPosition) {
        switch (finalPosition) {
            case 1 -> {
                Formula1ChampionshipManager.getF1_DRIVERS().get(index).incrementRaces();
                Formula1ChampionshipManager.getF1_DRIVERS().get(index).addPoints(POINT_SCHEME[0][1]);
                Formula1ChampionshipManager.getF1_DRIVERS().get(index).incrementFirstPositions();
            }
            case 2 -> {
                Formula1ChampionshipManager.getF1_DRIVERS().get(index).incrementRaces();
                Formula1ChampionshipManager.getF1_DRIVERS().get(index).addPoints(POINT_SCHEME[1][1]);
                Formula1ChampionshipManager.getF1_DRIVERS().get(index).incrementSecondPositions();
            }
            case 3 -> {
                Formula1ChampionshipManager.getF1_DRIVERS().get(index).incrementRaces();
                Formula1ChampionshipManager.getF1_DRIVERS().get(index).addPoints(POINT_SCHEME[2][1]);
                Formula1ChampionshipManager.getF1_DRIVERS().get(index).incrementThirdPositions();
            }
            case 4, 5, 6, 7, 8, 9, 10 -> {
                Formula1ChampionshipManager.getF1_DRIVERS().get(index).incrementRaces();
                Formula1ChampionshipManager.getF1_DRIVERS().get(index).addPoints(POINT_SCHEME[finalPosition - 1][1]);
            }
            default -> Formula1ChampionshipManager.getF1_DRIVERS().get(index).incrementRaces();
        }
    }
}
