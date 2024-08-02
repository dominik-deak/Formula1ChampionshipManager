# Formula 1 Championship Management Application

## Overview

The Formula 1 Championship Management Application is a Java program designed to simulate and manage a Formula 1 racing car championship. This application uses object-oriented principles and Java Swing for GUI development, focusing on the manipulation and management of drivers, teams, races, and their statistics.

## Features

The application provides the following key features:

### Driver and Team Management

- **Create a New Driver:** Add new drivers to the championship, each associated with a unique constructor team (e.g., Ferrari, Mercedes).
- **Delete a Driver:** Remove a driver and their associated team from the championship.
- **Change Team Driver:** Replace the driver for an existing constructor team.

### Statistics and Display

- **Display Driver Statistics:** View detailed statistics for a selected driver, including races participated, positions achieved, and total points.
- **Display Driver Table:** Show all drivers and their teams in descending order of points. If points are tied, the driver with the most first-place wins is prioritized.

### Race Management

- **Add a Race:** Record the results of a race, including the date and positions achieved by each driver. Update all driver statistics and the championship table automatically.
- **Save and Load Data:** Persist all entered data to a file and restore it on subsequent runs to continue operations seamlessly.

### Graphical User Interface (GUI)

- **Driver Table GUI:** Display a sortable table of drivers and their statistics using Java Swing.
  - **Sort by Points:** Allow sorting the table by the total points won by drivers in ascending order.
  - **Sort by First Positions:** Allow sorting the table by the number of first-place finishes in descending order.
  
- **Random Race Generation:**
  - **Random Position Race:** Simulate a race with drivers placed randomly, updating the championship table automatically.
  - **Probabilistic Race Simulation:** Conduct a race where starting positions influence the probability of winning, with the driver starting in position 1 having the highest chance of winning.

- **Completed Races Display:** Show a list of all completed races, sorted by date, including both manually entered and randomly generated races.
- **Driver Race Search:** Search for and display all races in which a specific driver participated, including the dates and positions achieved.

## Implementation Details

- **Formula1ChampionshipManager Class:** Implements the `ChampionshipManager` interface and maintains the drivers and races.
- **Driver and Formula1Driver Classes:** Define the properties and behaviors of drivers, including statistics like race wins, total points, and team affiliation.
- **Graphical Interface:** Developed using Java Swing without drag-and-drop tools, ensuring all GUI components are manually coded.

## Usage

Upon starting the application, a console menu is provided with options to manage drivers, view statistics, and perform race operations. Additionally, the GUI can be launched to interact with the data in a visual format.

### Console Menu Options

- **Create a New Driver:** Add a driver to the championship.
- **Delete a Driver:** Remove a driver and their team.
- **Change Team Driver:** Replace an existing team driver.
- **Display Driver Statistics:** View statistics for a specific driver.
- **Display Driver Table:** List all drivers and teams ordered by points.
- **Add a Race:** Enter results for a new race and update statistics.
- **Save/Load Data:** Persist and restore championship data.

### Graphical User Interface

- **View and Sort Drivers:** Interact with the driver table using sorting options.
- **Generate Races:** Simulate races using random and probabilistic methods.
- **View Races:** Access and review all completed race details.
- **Search Races:** Find all races involving a specified driver.
