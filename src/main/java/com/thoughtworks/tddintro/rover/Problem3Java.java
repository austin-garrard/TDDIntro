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

        /** INIT **/
        String fileName = args[0];
        ArrayList<Rover> roverList = new ArrayList<>();
        ArrayList<String> commandsList = new ArrayList<>();
        if (RoverFileParser.parseRover(fileName, roverList, commandsList)) return;


        /** GIVE COMMANDS TO THE ROVERS **/
        for(int i = 0; i < roverList.size(); i++)
        {
            Rover rover = roverList.get(i);
            String commands = commandsList.get(i);
            for(int c = 0; c < commands.length(); c++)
            {
                char command = commands.charAt(c);
                //rotate
                if(command == 'L' || command == 'R')
                {
                    if(!rover.rotate(command))
                    {
                        System.out.println("Invalid rotate command. Terminating.");
                        return;
                    }
                }
                //move
                else if(command == 'M')
                {
                    if(!rover.move())
                    {
                        System.out.println("Invalid move command. Terminating.");
                        return;
                    }
                }
                //invalid
                else
                {
                    System.out.format("Invalid input file '%s'. Terminating.\n", fileName);
                    return;
                }
            }
        }


        /** PRINT THE FINAL STATE **/
        for(Rover rover : roverList)
        {
            System.out.println(rover.toString());
        }
    }


}