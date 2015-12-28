package com.thoughtworks.tddintro.rover2;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.Before;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import static org.mockito.Mockito.*;

public class RoverControllerTest {

    private RoverController roverController;
    private Rover myRover;
    private List<Rover> rovers;

    @Before
    public void setUp() {
        GridMap map = new GridMap(10, 10);

        rovers = new ArrayList<>();
        //valid rovers
        myRover = new Rover(5, 5, Rover.Orientation.W);
        rovers.add(myRover);
        rovers.add(new Rover(0, 0, Rover.Orientation.N));
        rovers.add(new Rover(10, 0, Rover.Orientation.S));
        rovers.add(new Rover(0, 10, Rover.Orientation.W));
        rovers.add(new Rover(10, 10, Rover.Orientation.E));



        roverController = new RoverController(map);
        roverController.addRovers(rovers);

    }

    @Test
    public void shouldStoreRoversThatAreWithinTheBoundariesOfTheMap () {
        //invalid rovers: outside of boundaries
        roverController.addRover(new Rover(-1, 1, Rover.Orientation.N));
        roverController.addRover(new Rover(11, 5, Rover.Orientation.N));
        roverController.addRover(new Rover(3, -4, Rover.Orientation.N));
        roverController.addRover(new Rover(6, 11, Rover.Orientation.N));

        assertThat(roverController.numRovers(), is(rovers.size()));
    }

    @Test
    public void shouldStoreRoversThatHaveUniqueCoordinates() {
        //invalid rovers: non-unique coordinates
        roverController.addRover(new Rover(0, 0, Rover.Orientation.N));
        roverController.addRover(new Rover(5, 5, Rover.Orientation.N));
        roverController.addRover(new Rover(10, 0, Rover.Orientation.N));

        assertThat(roverController.numRovers(), is(rovers.size()));
    }

    @Test
    public void shouldMoveARoverOneUnitNorthIfItIsFacingNorth() {
        int originalYPos = myRover.getYPos();

        myRover.setOrientation(Rover.Orientation.N);
        roverController.moveRover(myRover);

        assertThat(myRover.getYPos(), is(originalYPos+1));
    }

    @Test
    public void shouldMoveARoverOneUnitEastIfItIsFacingEast() {
        int originalXPos = myRover.getXPos();

        myRover.setOrientation(Rover.Orientation.E);
        roverController.moveRover(myRover);

        assertThat(myRover.getXPos(), is(originalXPos+1));
    }

    @Test
    public void shouldMoveARoverOneUnitSouthIfItIsFacingSouth() {
        int originalYPos = myRover.getYPos();

        myRover.setOrientation(Rover.Orientation.S);
        roverController.moveRover(myRover);

        assertThat(myRover.getYPos(), is(originalYPos-1));
    }

    @Test
    public void shouldMoveARoverOneUnitWestIfItIsFacingWest() {
        int originalXPos = myRover.getXPos();

        myRover.setOrientation(Rover.Orientation.W);
        roverController.moveRover(myRover);

        assertThat(myRover.getXPos(), is(originalXPos-1));
    }



    @Test
    @Ignore
    public void shouldRotateARoverClockwiseWhenARotateRightCommandIsGiven() {

    }

    @Test
    @Ignore
    public void shouldRotateARoverCounterclockwiseWhenARotateLeftCommandIsGiven() {

    }

    @Test
    @Ignore
    public void shouldExecuteAMoveCommandIfTheResultingCoordinatesAreWithinTheBoundariesOfTheMap() {

    }

    @Test
    @Ignore
    public void shouldExecuteAMoveCommandIfTheResultingCoordinatesAreUnique() {

    }


    @Test
    @Ignore
    public void shouldStoreCommandsThatHaveBeenExecuted() {

    }

}
