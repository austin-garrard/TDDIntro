package com.thoughtworks.tddintro.rover2;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.Before;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ParserTest {

    private String defaultFileName;
    private Parser parser;

    @Before
    public void setUp() {
        defaultFileName = "src/test/resources/RoverInput-Default.txt";
        parser = new Parser();
    }



    @Test
    public void shouldReturnNullGridMapWhenNoFileHasBeenParsed() {
        GridMap map = parser.getGridMap();

        assertNull(map);
    }

    @Test
    public void shouldReturnEmptyRoverListWhenNoFileHasBeenParsed() {
        List<Rover> rovers = parser.getRovers();

        assertThat(rovers.size(), is(0));
    }

    @Test
    public void shouldReturnEmptyCommandsWhenNoFileHasBeenParsed() {
        List<String> commands = parser.getCommands();

        assertThat(commands.size(), is(0));
    }



    /** Correct behavior given expected input. Uses RoverInput-Default.txt **/

    @Test
    public void shouldReturnGridMapWhenFileHasBeenSuccessfullyParsed() {
        parser.parse(defaultFileName);

        GridMap map = parser.getGridMap();

        assertNotNull(map);
    }

    @Test
    public void shouldCorrectlyParseGridMapXMax() {
        parser.parse(defaultFileName);

        GridMap map = parser.getGridMap();

        assertThat(map.getXMax(), is(5));
    }

    @Test
    public void shouldCorrectlyParseGridMapYMax() {
        parser.parse(defaultFileName);

        GridMap map = parser.getGridMap();

        assertThat(map.getYMax(), is(10));
    }

    @Test
    public void shouldReturnRoverListWhenFileHasBeenSuccessfullyParsed() {
        parser.parse(defaultFileName);

        List<Rover> rovers = parser.getRovers();

        assertThat(rovers.size(), is(2));
    }

    @Test
    public void shouldCorrectlyParseFirstRoverStartingXPosition() {
        parser.parse(defaultFileName);

        List<Rover> rovers = parser.getRovers();

        assertThat(rovers.get(0).getXPos(), is(1));
    }

    @Test
    public void shouldCorrectlyParseFirstRoverStartingYPosition() {
        parser.parse(defaultFileName);

        List<Rover> rovers = parser.getRovers();

        assertThat(rovers.get(0).getYPos(), is(2));
    }

    @Test
    public void shouldCorrectlyParseFirstRoverStartingOrientation() {
        parser.parse(defaultFileName);

        List<Rover> rovers = parser.getRovers();

        assertThat(rovers.get(0).getOrientation(), is(Rover.Orientation.N));
    }

    @Test
    public void shouldCorrectlyParseSecondRoverStartingXPosition() {
        parser.parse(defaultFileName);

        List<Rover> rovers = parser.getRovers();

        assertThat(rovers.get(1).getXPos(), is(3));
    }

    @Test
    public void shouldCorrectlyParseSecondRoverStartingYPosition() {
        parser.parse(defaultFileName);

        List<Rover> rovers = parser.getRovers();

        assertThat(rovers.get(1).getYPos(), is(3));
    }

    @Test
    public void shouldCorrectlyParseSecondROverStartingOrientation() {
        parser.parse(defaultFileName);

        List<Rover> rovers = parser.getRovers();

        assertThat(rovers.get(1).getOrientation(), is(Rover.Orientation.E));
    }

    @Test
    public void shouldCorrectlyParseRoverCommands() {

    }




    @Test
    @Ignore
    public void shouldReturnNullGridMapWhenErrorsOccurDuringParse() {

    }



}
