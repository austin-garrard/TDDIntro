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

    @Before
    public void setUp() {
        GridMap map = new GridMap(10, 10);

        List<Rover> rovers = new ArrayList<>();
        //valid rovers
        rovers.add(new Rover(1, 1, Rover.Orientation.N));
        rovers.add(new Rover(5, 5, Rover.Orientation.W));
        rovers.add(new Rover(9, 2, Rover.Orientation.S));
        //invalid rovers: boundaries
        rovers.add(new Rover(-1, 1, Rover.Orientation.N));
        rovers.add(new Rover(999, 5, Rover.Orientation.N));
        rovers.add(new Rover(3, -4, Rover.Orientation.N));
        rovers.add(new Rover(6, 1337, Rover.Orientation.N));
        //invalid rovers: unique coordinates
        rovers.add(new Rover(1, 1, Rover.Orientation.N));
        rovers.add(new Rover(5, 5, Rover.Orientation.N));
        rovers.add(new Rover(9, 2, Rover.Orientation.N));

        roverController = new RoverController(map);
        roverController.addRovers(rovers);

    }

    @Test
    public void shouldStoreRoversThatAreWithinTheBoundariesOfTheMap () {
        assertThat(roverController.numRovers(), is(3));
    }

    @Test
    @Ignore
    public void shouldStoreRoversThatHaveUniqueCoordinates() {

    }

    @Test
    @Ignore
    public void shouldMoveARoverOneUnitForwardInTheDirectionItIsFacingWhenAMoveCommandIsExecuted() {

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
