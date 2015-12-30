package com.thoughtworks.tddintro.rover2;

import java.io.BufferedReader;
import java.util.Scanner;

import java.util.ArrayList;
import java.util.List;

public class Parser {

    private GridMap map;
    private List<Rover> rovers;
    private List<String> commands;

    public Parser() {
        map = null;
        rovers = new ArrayList<>();
        commands = new ArrayList<>();
    }

    public void parse(BufferedReader file) {
        Scanner fileScanner = new Scanner(file);

        String gridString = fileScanner.nextLine();
        parseGrid(gridString);

        while(fileScanner.hasNextLine()) {
            String roverString = fileScanner.nextLine();
            parseRover(roverString);

            String commandsString = fileScanner.nextLine();
            parseCommands(commandsString);
        }
    }

    private void parseGrid(String gridString) {
        Scanner scanner = new Scanner(gridString);
        int xMax = scanner.nextInt();
        int yMax = scanner.nextInt();
        map = new GridMap(xMax, yMax);
    }

    private void parseRover(String roverString) {
        Scanner scanner;
        scanner = new Scanner(roverString);
        int xPos = scanner.nextInt();
        int yPos = scanner.nextInt();
        Rover.Orientation orientation = Rover.Orientation.valueOf(scanner.next());
        rovers.add(new Rover(xPos, yPos, orientation));
    }

    private void parseCommands(String commandsString) {
        commands.add(commandsString);
    }

    public GridMap getGridMap() {
        return map;
    }

    public List<Rover> getRovers() {
        return rovers;
    }

    public List<String> getCommands() {
        return commands;
    }



}
