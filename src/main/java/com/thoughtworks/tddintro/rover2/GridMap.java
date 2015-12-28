package com.thoughtworks.tddintro.rover2;

/**
 * Stores information about an environment to be traversed by Rovers
 */
public class GridMap {

    public GridMap(int xMax, int yMax) {
        this.xMax = xMax;
        this.yMax = yMax;
    }

    public int getXMax() {
        return xMax;
    }

    public int getYMax() {
        return yMax;
    }

    private int xMax;
    private int yMax;
}
