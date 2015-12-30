package com.thoughtworks.tddintro.rover2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
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

    public void parse(String fileName) {
        Scanner fileScanner;

        try {
            fileScanner = new Scanner(new BufferedReader(new FileReader(fileName)));
        }
        catch(FileNotFoundException e) {
            return;
        }

        parseGrid(fileScanner);

        while(fileScanner.hasNextLine()) {
            String roverString = fileScanner.nextLine();
            parseRover(roverString);

            fileScanner.nextLine();
        }


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


    private void parseGrid(Scanner fileScanner) {
        int xMax = fileScanner.nextInt();
        int yMax = fileScanner.nextInt();
        map = new GridMap(xMax, yMax);
        fileScanner.nextLine();
    }

    private void parseRover(String roverString) {
        Scanner lineScanner;
        lineScanner = new Scanner(roverString);
        int xPos = lineScanner.nextInt();
        int yPos = lineScanner.nextInt();
        Rover.Orientation orientation = Rover.Orientation.valueOf(lineScanner.next());
        rovers.add(new Rover(xPos, yPos, orientation));
    }
}
