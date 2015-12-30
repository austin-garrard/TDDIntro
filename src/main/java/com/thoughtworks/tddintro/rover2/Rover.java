package com.thoughtworks.tddintro.rover2;


public class Rover {

    public enum Orientation {
        N, E, S, W
    }

    public Rover(int xPos, int yPos, Orientation orientation) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.orientation = orientation;
    }

    public int getXPos() {
        return xPos;
    }

    public void setXPos(int xPos) {
        this.xPos = xPos;
    }

    public int getYPos() {
        return yPos;
    }

    public void setYPos(int yPos) {
        this.yPos = yPos;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    public String toString() {
        String me = String.format("%d %d ", xPos, yPos);
        if(orientation == Orientation.N)
            me += "N";
        if(orientation == Orientation.E)
            me += "E";
        if(orientation == Orientation.S)
            me += "S";
        if(orientation == Orientation.W)
            me += "W";
        return me;
    }

    private int xPos;
    private int yPos;
    private Orientation orientation;


}
