package com.thoughtworks.tddintro.rover;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Parses a Rover file containing the initial positions of several rovers,
 * as well as the commands to issue to each rover.
 *
 * @author Austin Garrard
 * @version 1.0
 */
public class RoverFileParser {



    private ArrayList<Rover> roverList;
    private ArrayList<String> commandsList;
    GridMap map;
    boolean parseFailure;

    public RoverFileParser(String fileName) {
        roverList = new ArrayList<>();
        commandsList = new ArrayList<>();
        parseFailure = parseRover(fileName);
    }

    public ArrayList<Rover> getRoverList() {
        return roverList;
    }

    public ArrayList<String> getCommandsList() {
        return commandsList;
    }

    public GridMap getMap() {
        return map;
    }

    public boolean wasParseFailure() {
        return parseFailure;
    }


    private boolean parseRover(String fileName) {
        Scanner fileScanner;
        Scanner lineScanner;
        try
        {
            fileScanner = new Scanner(new BufferedReader(new FileReader(fileName)));

            //read the grid
            int xMax = fileScanner.nextInt();
            int yMax = fileScanner.nextInt();
            if(xMax < 0 || yMax < 0)
            {
                System.out.println("Invalid grid dimenstions. Terminating.");
                return true;
            }
            map = new GridMap(xMax, yMax);

            fileScanner.nextLine();
            while(fileScanner.hasNextLine())
            {
                //read the rover
                lineScanner = new Scanner(fileScanner.nextLine());
                int xPos = lineScanner.nextInt();
                int yPos = lineScanner.nextInt();
                Rover.Orientation orientation = Rover.Orientation.valueOf(lineScanner.next());
                Rover rover = new Rover(xPos, yPos, orientation, map);
                roverList.add(rover);
                if(!map.addRover(rover))
                {
                    System.out.println("Invalid starting position. Terminating.");
                    return true;
                }

                //read the commands
                commandsList.add(fileScanner.nextLine());
            }

        }
        catch(IOException e)
        {
            System.out.format("Invalid input file '%s'. Terminating.\n", fileName);
            return true;
        }
        catch(InputMismatchException e)
        {
            System.out.format("Invalid input file '%s'. Terminating.\n", fileName);
            return true;
        }
        catch(NoSuchElementException e)
        {
            System.out.format("Invalid input file '%s'. Terminating.\n", fileName);
            return true;
        }
        return false;
    }
}
