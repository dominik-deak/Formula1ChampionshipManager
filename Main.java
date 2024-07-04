package oop_coursework;

import java.util.Scanner;

/**
 * Main class of the program
 * @author Dominik Deak - w1778659
 */
public class Main {

    private static final Scanner userInput = new Scanner(System.in);

    /**
     * Main method of the program
     * Automatically loads the program data
     * Starts a console menu and displays the options for the user
     * Upon selecting an option, calls the appropriate methods
     */
    public static void main(String[] args) {
        Formula1ChampionshipManager F1Manager = new Formula1ChampionshipManager();
        // Automatically loading the data when starting the program
        F1Manager.loadProgramData();
        System.out.println("-------------------------------------\nWelcome to the Formula 1 championship");
        boolean menuLoop = true;
        while (menuLoop) {
            /* I used a Java text block instead of string concatenation to simplify my code
            * I implemented it using a guide on this website: https://docs.oracle.com/en/java/javase/13/text_blocks/index.html */
            System.out.print("""
                    -------------------------------------
                    Press 1 to add a new driver and constructor team to the championship
                    Press 2 to delete a driver and their constructor team from the championship
                    Press 3 to change a the constructor team of a driver
                    Press 4 to display the statistics of a driver
                    Press 5 to display a table of all drivers and their statistics
                    Press 6 to add a completed race to the championship
                    Press 7 to save the championship data into the program
                    Press 8 to launch a graphical interface for the program
                    Press 9 to exit the program
                    Enter option:\s""");
            String menuChoice = userInput.next();
            /* I used an enhanced switch statement to simplify my code
            * I implemented it using a guide on this website: https://www.vojtechruzicka.com/java-enhanced-switch */
            switch (menuChoice) {
                case "1" -> F1Manager.createDriver();
                case "2" -> F1Manager.deleteDriver();
                case "3" -> F1Manager.changeDriverTeam();
                case "4" -> F1Manager.displayDriverStatistics();
                case "5" -> F1Manager.displayDriverTable();
                case "6" -> F1Manager.addRace();
                case "7" -> F1Manager.saveProgramData();
                case "8" -> F1Manager.launchGUI();
                case "9" -> menuLoop = false;
                default -> System.out.println("Invalid option");
            }
        }
    }
}
