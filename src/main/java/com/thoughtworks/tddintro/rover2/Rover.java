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

    private int xPos;
    private int yPos;
    private Orientation orientation;


}
