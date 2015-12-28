package com.thoughtworks.tddintro.rover;

import java.util.ArrayList;
import java.util.List;

/**
 * Moves rovers around a map
 */
public class RoverController {

    private GridMap map;
    private List<Rover> roverList;

    public RoverController(GridMap map, List<Rover> roverList) {
        this.map = map;
        this.roverList = roverList;
    }

    public boolean executeCommands(List<String> commandsList) {
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
                        return true;
                    }
                }
                //move
                else if(command == 'M')
                {
                    if(!rover.move())
                    {
                        System.out.println("Invalid move command. Terminating.");
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
