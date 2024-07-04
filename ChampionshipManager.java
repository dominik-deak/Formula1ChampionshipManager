package oop_coursework;

import java.util.Scanner;

/**
 * The interface with empty methods that are implemented
 * @author Dominik Deak - w1778659
 */
public interface ChampionshipManager {

    /**
     * Scanner used throughout the program for user input
     */
    Scanner USER_INPUT = new Scanner(System.in);

    void createDriver();

    void deleteDriver();

    void changeDriverTeam();

    void displayDriverStatistics();

    void displayDriverTable();

    void addRace();

    void saveProgramData();

    void loadProgramData();

    void launchGUI();
}
