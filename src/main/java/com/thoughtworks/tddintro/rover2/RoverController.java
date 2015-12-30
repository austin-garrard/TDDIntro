package com.thoughtworks.tddintro.rover2;


import java.util.ArrayList;
import java.util.List;

public class RoverController {

    public enum Flag {
        SUCCESS, COORD_OUT_OF_BOUNDS, COORD_NOT_UNIQUE
    }

    private GridMap map;
    private List<Rover> rovers;

    public RoverController(GridMap map) {
        this.map = map;
        this.rovers = new ArrayList<>();
    }

    public void addRovers(List<Rover> rovers) {
        for(Rover rover : rovers) {
            this.addRover(rover);
        }
    }

    public void addRover(Rover rover) {
        Flag result = validCoordinates(rover.getXPos(), rover.getYPos());
        if(result == Flag.SUCCESS) {
            rovers.add(rover);
        }
    }

    public Flag executeCommands(Rover rover, String commands) {
        for(int i = 0; i < commands.length(); i++) {
            char command = commands.charAt(i);

            if(command == 'L') {
                rotateRoverLeft(rover);
            }
            else if(command == 'R') {
                rotateRoverRight(rover);
            }
            else if(command == 'M') {
                Flag result = moveRover(rover);
                if(result != Flag.SUCCESS)
                    return result;
            }
        }

        return Flag.SUCCESS;
    }

    public Flag moveRover(Rover rover) {
        int deltaX = 0;
        int deltaY = 0;

        switch(rover.getOrientation()) {
            case N: deltaY++; break;
            case E: deltaX++; break;
            case S: deltaY--; break;
            case W: deltaX--; break;
        }

        int newXPos = rover.getXPos() + deltaX;
        int newYPos = rover.getYPos() + deltaY;

        Flag result = validCoordinates(newXPos, newYPos);

        if(result == Flag.SUCCESS) {
            rover.setXPos(newXPos);
            rover.setYPos(newYPos);
        }

        return result;
    }

    public void rotateRoverRight(Rover rover) {
        switch(rover.getOrientation()) {
            case N: rover.setOrientation(Rover.Orientation.E); break;
            case E: rover.setOrientation(Rover.Orientation.S); break;
            case S: rover.setOrientation(Rover.Orientation.W); break;
            case W: rover.setOrientation(Rover.Orientation.N); break;
        }
    }

    public void rotateRoverLeft(Rover rover) {
        switch(rover.getOrientation()) {
            case N: rover.setOrientation(Rover.Orientation.W); break;
            case E: rover.setOrientation(Rover.Orientation.N); break;
            case S: rover.setOrientation(Rover.Orientation.E); break;
            case W: rover.setOrientation(Rover.Orientation.S); break;
        }
    }

    private Flag validCoordinates(int xPos, int yPos) {
        if(!coordinatesAreWithinBoundaries(xPos, yPos))
            return Flag.COORD_OUT_OF_BOUNDS;
        if(!coordinatesAreUnique(xPos, yPos))
            return Flag.COORD_NOT_UNIQUE;
        return Flag.SUCCESS;
    }

    private boolean coordinatesAreWithinBoundaries(int xPos, int yPos) {
        return xPos >= 0 && xPos <= this.map.getXMax() && yPos >= 0 && yPos <= this.map.getYMax();
    }

    private boolean coordinatesAreUnique(int xPos, int yPos) {
        for(Rover rover : rovers)
            if(rover.getXPos() == xPos && rover.getYPos() == yPos)
                return false;
        return true;
    }

    public int numRovers() {
        return this.rovers.size();
    }
}
