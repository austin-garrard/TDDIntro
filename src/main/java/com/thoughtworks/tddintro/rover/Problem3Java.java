package com.thoughtworks.tddintro.rover;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Problem3Java
 * Provides the solution to problem three of the ThoughtWorks
 * coding assignment.
 *
 * @author Austin Garrard
 * @version 1.0
 */
public class Problem3Java
{

    /**
     * Runs the solution on the provided input.
     *
     * @param args A text file structured as detailed in the problem prompt.
     */
    public static void main(String[] args)
    {
        if(args.length != 1)
        {
            System.out.println("Usage:\n\t$ Problem3Java [InputFile]");
            return;
        }

        String fileName = args[0];
        RoverFileParser parser = new RoverFileParser(fileName);
        if(parser.wasParseFailure()) {
            return;
        }

        GridMap map = parser.getMap();
        ArrayList<Rover> roverList = parser.getRoverList();
        ArrayList<String> commandsList = parser.getCommandsList();

        RoverController roverController = new RoverController(map, roverList);
        if (roverController.executeCommands(commandsList)) {
            return;
        }

        for(Rover rover : roverList)
        {
            System.out.println(rover.toString());
        }
    }




}