package com.thoughtworks.tddintro.rover;
/**
 * Rover
 * Represents a robotic Mars rover. A Rover has a 2D position,
 * an orientation, and belongs to a GridMap.
 *
 * @author Austin Garrard
 * @version 1.0
 */
public class Rover
{

    /**
     * Cardinal orientations.
     */
    public enum Orientation
    {
        N("N"), E("E"), S("S"), W("W");

        private String text;

        private Orientation(String text)
        {
            this.text = text;
        }

        @Override
        public String toString()
        {
            return text;
        }
    }

    int xPos;
    int yPos;
    Orientation orientation;
    GridMap map;

    /**
     * Constructs a Rover with a starting position, a starting
     * orientation, and a GridMap.
     *
     * @param xPos The x-coordinate of the starting position.
     * @param yPos The y-coordinate of the starting position.
     * @param orientation The starting orientation.
     * @param map The GridMap this Rover belongs to.
     */
    public Rover(int xPos, int yPos, Orientation orientation, GridMap map)
    {
        this.xPos = xPos;
        this.yPos = yPos;
        this.orientation = orientation;
        this.map = map;
    }

    /**
     * Returns the  x-coordinate of the current position.
     *
     * @return The current x-coordinate
     */
    public int getXPos()
    {
        return xPos;
    }

    /**
     * Returns the y-coordinate of the current position.
     *
     * @return The current y-coordinate
     */
    public int getYPos()
    {
        return yPos;
    }

    /**
     * Returns the current orientation.
     *
     * @return The current orientation.
     */
    public Orientation getOrientation()
    {
        return orientation;
    }

    /**
     * Sets the map of the Rover.
     *
     * @param map The map to associate the Rover with.
     */
    public void setMap(GridMap map)
    {
        this.map = map;
    }

    /**
     * Moves the Rover one unit forward. The Rover will not be
     * moved if it does not belong to a GridMap or if the position
     * in front of it is not valid.
     *
     * @return Whether the Rover was successfully moved.
     */
    public boolean move()
    {
        if(map == null)
        {
            return false;
        }

        int xPos = this.xPos;
        int yPos = this.yPos;

        switch(this.orientation)
        {
            case N: yPos++; break;
            case E: xPos++; break;
            case S: yPos--; break;
            case W: xPos--; break;
        }

        if(map.isValid(xPos, yPos))
        {
            this.xPos = xPos;
            this.yPos = yPos;
            return true;
        }

        return false;
    }

    /**
     * Rotates the Rover to an adjacent cardinal direction.
     * The Rover will not be rotated if an invalid direction is given.
     *
     * @return Whether the Rover was successfully rotated.
     */
    public boolean rotate(char direction)
    {
        int curValue = this.orientation.ordinal();

        if(direction == 'L')
        {
            this.orientation = curValue > 0 ? Orientation.values()[--curValue] : Orientation.W;
        }
        else if(direction == 'R')
        {
            this.orientation = curValue < 3 ? Orientation.values()[++curValue] : Orientation.N;
        }
        else
        {
            return false;
        }

        return true;
    }

    /**
     * Returns the current position and orientation of the Rover as a String.
     *
     * @return The current position and orientation of the Rover as a String.
     */
    @Override
    public String toString()
    {
        return String.format("%d %d %s", this.xPos, this.yPos, this.orientation.toString());
    }
}