package com.thoughtworks.tddintro.rover2;


import java.util.ArrayList;
import java.util.List;

public class RoverController {

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
        if(validCoordinates(rover.getXPos(), rover.getYPos())) {
            rovers.add(rover);
        }
    }

    public void moveRover(Rover rover) {
        int deltaX = 0;
        int deltaY = 0;
        switch(rover.getOrientation()) {
            case N: deltaY++; break;
            case E: deltaX++; break;
            case S: deltaY--; break;
            case W: deltaX--; break;
        }

        rover.setXPos(rover.getXPos() + deltaX);
        rover.setYPos(rover.getYPos() + deltaY);
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

    private boolean validCoordinates(int xPos, int yPos) {
        return coordinatesAreWithinBoundaries(xPos, yPos)
                && coordinatesAreUnique(xPos, yPos);
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
