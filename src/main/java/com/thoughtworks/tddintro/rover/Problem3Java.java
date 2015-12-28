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
        if (parseRover(fileName, roverList, commandsList)) return;


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

    private static boolean parseRover(String fileName, ArrayList<Rover> roverList, ArrayList<String> commandsList) {
        Scanner fileScanner;
        GridMap map;
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