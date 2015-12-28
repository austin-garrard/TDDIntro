package com.thoughtworks.tddintro.rover2;

import org.junit.Test;
import org.junit.Before;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import static org.mockito.Mockito.*;

public class RoverControllerTest {

    @Before
    public void setUp() {
        GridMap map = new GridMap(10, 10);

        List<Rover> initialRovers = new ArrayList<>();
        initialRovers.add(new Rover(1, 1, Rover.Orientation.N));
        initialRovers.add(new Rover(5, 5, Rover.Orientation.W));
        initialRovers.add(new Rover(9, 2, Rover.Orientation.S));

        List<Rover> emptyRovers = new ArrayList<>();

    }

    @Test
    public void shouldStoreAMap() {

    }

    @Test
    public void shouldStoreRoversThatAreWithinTheBoundsOfTheMap () {

    }

    @Test
    public void shouldStoreRoversThatHaveUniqueCoordinates() {

    }

    @Test
    public void shouldMoveARoverOneUnitForwardInTheDirectionItIsFacingWhenAMoveCommandIsExecuted() {

    }

    @Test
    public void shouldRotateARoverClockwiseWhenARotateRightCommandIsGiven() {

    }

    @Test
    public void shouldRotateARoverCounterclockwiseWhenARotateLeftCommandIsGiven() {

    }

    @Test
    public void shouldExecuteAMoveCommandIfTheResultingCoordinatesAreWithinTheBoundsOfTheMap() {

    }

    @Test
    public void shouldExecuteAMoveCommandIfTheResultingCoordinatesAreUnique() {

    }


    @Test
    public void shouldStoreCommandsThatHaveBeenExecuted() {

    }

}
