package com.thoughtworks.tddintro.rover;

import java.util.ArrayList;

/**
 * GridMap
 * Represents a 2D grid with references to Rovers in the grid.
 * Used by Rovers to check the validity of their actions.
 *
 * @author Austin Garrard
 * @version 1.0
 */
public class GridMap
{
    int xMax;
    int yMax;
    ArrayList<Rover> rovers;

    /**
     * Constructs a Gridmap with bounds.
     *
     * @param xMax The maximum x-coordinate (inclusive).
     * @param yMax The maximum y-coordinate (inclusive).
     */
    public GridMap(int xMax, int yMax)
    {
        this.xMax = xMax;
        this.yMax = yMax;
        this.rovers = new ArrayList<Rover>();
    }

    /**
     * Returns whether the given position can be moved to. A position
     * is valid if it is within the bounds of the grid and no rovers
     * currently occupy it.
     *
     * @param xPos The x-coordinate.
     * @param yPos The y-coordinate.
     * @return Whether the position is in bounds and no rovers currently
     * occupy it.
     */
    public boolean isValid(int xPos, int yPos)
    {
        if(xPos < 0 || xPos > xMax || yPos < 0 || yPos > yMax)
        {
            return false;
        }

        for( Rover rover : rovers )
        {
            if(xPos == rover.getXPos() && yPos == rover.getYPos())
            {
                return false;
            }
        }

        return true;
    }

    /**
     * Adds a Rover to the grid. The Rover will
     * not be added if its current position is not valid.
     *
     * @param rover The Rover object to add.
     * @return Whether the rover was added.
     */
    public boolean addRover(Rover rover)
    {
        if(rover != null && isValid(rover.getXPos(), rover.getYPos()))
        {
            rovers.add(rover);
            return true;
        }

        return false;
    }
}