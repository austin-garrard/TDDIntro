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

    @Test
    public void shouldUpdateXPosition() {
        rover.setXPos(65);
        assertThat(rover.getXPos(), is(65));
        rover.setXPos(-1);
        assertThat(rover.getXPos(), is(-1));
    }

    @Test
    public void shouldUpdateYPosition() {
        rover.setYPos(65);
        assertThat(rover.getYPos(), is(65));
        rover.setYPos(-1);
        assertThat(rover.getYPos(), is(-1));
    }

    @Test
    public void shouldUpdateOrientation() {
        rover.setOrientation(Rover.Orientation.E);
        assertThat(rover.getOrientation(), is(Rover.Orientation.E));
    }
}
