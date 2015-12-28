package com.thoughtworks.tddintro.rover2;

import org.junit.Test;
import org.junit.Before;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class RoverTest {

    private int initialXPos, initialYPos;
    private Rover.Orientation initialOrientation;
    private Rover rover;

    @Before
    public void setup() {
        initialXPos = 1;
        initialYPos = 123;
        initialOrientation = Rover.Orientation.N;
        rover = new Rover(initialXPos, initialYPos, initialOrientation);
    }

    @Test
    public void shouldStoreInitialPositionAndOrientation() {
        assertThat(rover.getXPos(), is(initialXPos));
        assertThat(rover.getYPos(), is(initialYPos));
        assertThat(rover.getOrientation(), is(initialOrientation));
    }
}
