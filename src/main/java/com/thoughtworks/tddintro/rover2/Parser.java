package com.thoughtworks.tddintro.rover2;

import java.io.BufferedReader;
import java.util.*;

public class Parser {

    public enum Flag {
        SUCCESS, INVALID_GRID, INVALID_ROVER, INVALID_COMMAND
    }

    private GridMap map;
    private List<Rover> rovers;
    private List<String> commands;

    public Parser() {
        map = null;
        rovers = new ArrayList<>();
        commands = new ArrayList<>();
    }

    public Flag parse(BufferedReader file) {
        Scanner fileScanner = new Scanner(file);
        Flag result;

        String gridString = fileScanner.nextLine();
        result = parseGrid(gridString);
        if(result != Flag.SUCCESS)
            return result;

        while(fileScanner.hasNextLine()) {
            String roverString = fileScanner.nextLine();
            parseRover(roverString);

            String commandsString = fileScanner.nextLine();
            parseCommands(commandsString);
        }

        return Flag.SUCCESS;
    }

    private Flag parseGrid(String gridString) {
        Scanner scanner = new Scanner(gridString);
        int xMax, yMax;

        try {
            xMax = scanner.nextInt();
            yMax = scanner.nextInt();
        }
        catch(InputMismatchException ime) {
            //no integer found
            return Flag.INVALID_GRID;
        }
        catch(NoSuchElementException nse) {
            //input exhausted
            return Flag.INVALID_GRID;
        }
        catch(IllegalStateException ime) {
            //Scanner is closed
            return Flag.INVALID_GRID;
        }

        if(xMax < 1 || yMax < 1)
            return Flag.INVALID_GRID;

        map = new GridMap(xMax, yMax);
        return Flag.SUCCESS;
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
