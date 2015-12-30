package com.thoughtworks.tddintro.rover2;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.Before;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ParserTest {

    private String defaultFileName;
    private BufferedReader defaultFileReader;
    private Parser parser;

    @Before
    public void setUp() throws FileNotFoundException{
        defaultFileName = "src/test/resources/RoverInput-Default.txt";
        defaultFileReader = readerForFile(defaultFileName);
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



    /** Behavior given expected input. Uses RoverInput-Default.txt **/

    @Test
    public void shouldReturnGridMapWhenFileHasBeenSuccessfullyParsed() {
        parser.parse(defaultFileReader);

        GridMap map = parser.getGridMap();

        assertNotNull(map);
    }

    @Test
    public void shouldCorrectlyParseGridMapXMax() {
        parser.parse(defaultFileReader);

        GridMap map = parser.getGridMap();

        assertThat(map.getXMax(), is(5));
    }

    @Test
    public void shouldCorrectlyParseGridMapYMax() {
        parser.parse(defaultFileReader);

        GridMap map = parser.getGridMap();

        assertThat(map.getYMax(), is(10));
    }

    @Test
    public void shouldReturnRoverListWhenFileHasBeenSuccessfullyParsed() {
        parser.parse(defaultFileReader);

        List<Rover> rovers = parser.getRovers();

        assertThat(rovers.size(), is(2));
    }

    @Test
    public void shouldCorrectlyParseFirstRoverStartingXPosition() {
        parser.parse(defaultFileReader);

        List<Rover> rovers = parser.getRovers();

        assertThat(rovers.get(0).getXPos(), is(1));
    }

    @Test
    public void shouldCorrectlyParseFirstRoverStartingYPosition() {
        parser.parse(defaultFileReader);

        List<Rover> rovers = parser.getRovers();

        assertThat(rovers.get(0).getYPos(), is(2));
    }

    @Test
    public void shouldCorrectlyParseFirstRoverStartingOrientation() {
        parser.parse(defaultFileReader);

        List<Rover> rovers = parser.getRovers();

        assertThat(rovers.get(0).getOrientation(), is(Rover.Orientation.N));
    }

    @Test
    public void shouldCorrectlyParseSecondRoverStartingXPosition() {
        parser.parse(defaultFileReader);

        List<Rover> rovers = parser.getRovers();

        assertThat(rovers.get(1).getXPos(), is(3));
    }

    @Test
    public void shouldCorrectlyParseSecondRoverStartingYPosition() {
        parser.parse(defaultFileReader);

        List<Rover> rovers = parser.getRovers();

        assertThat(rovers.get(1).getYPos(), is(3));
    }

    @Test
    public void shouldCorrectlyParseSecondROverStartingOrientation() {
        parser.parse(defaultFileReader);

        List<Rover> rovers = parser.getRovers();

        assertThat(rovers.get(1).getOrientation(), is(Rover.Orientation.E));
    }

    @Test
    public void shouldReturnCommandsListWhenFileHasBeenSuccessfullyParsed() {
        parser.parse(defaultFileReader);

        List<String> commands = parser.getCommands();

        assertThat(commands.size(), is(2));
    }

    @Test
    public void shouldCorrectlyParseFirstRoverCommands() {
        parser.parse(defaultFileReader);

        List<String> commands = parser.getCommands();

        assertThat(commands.get(0), is("LMLMLMLMM"));
    }

    @Test
    public void shouldCorrectlyParseSecondRoverCommands() {
        parser.parse(defaultFileReader);

        List<String> commands = parser.getCommands();

        assertThat(commands.get(1), is("MMRMMRMRRM"));
    }



    /** Behavior under various error conditions **/
    @Test
    public void shouldNotifyCallerWhenInvalidGridIsParsed () {
        String gridString = "-5 10\n";
        String roverString = "1 2 N\n";
        String commandString = "LMLMLMLMM\n";
        BufferedReader bufferedReader = readerForString(gridString + roverString + commandString);

        Parser.Flag result = parser.parse(bufferedReader);

        assertThat(result, is(Parser.Flag.INVALID_GRID));
    }

    @Test
    public void shouldNotifyCallerWhenInvalidRoverIsParsed() {
        String gridString = "5 10\n";
        String roverString = "-1 2 N\n";
        String commandString = "LMLMLMLMM\n";
        BufferedReader bufferedReader = readerForString(gridString + roverString + commandString);

        Parser.Flag result = parser.parse(bufferedReader);

        assertThat(result, is(Parser.Flag.INVALID_ROVER));
    }

    @Test
    public void shouldNotifyCallerWhenInvalidCommandIsParsed() {
        String gridString = "5 10\n";
        String roverString = "1 2 N\n";
        String commandString = "AMLMLMLMM\n";
        BufferedReader bufferedReader = readerForString(gridString + roverString + commandString);

        Parser.Flag result = parser.parse(bufferedReader);

        assertThat(result, is(Parser.Flag.INVALID_COMMAND));
    }


    private BufferedReader readerForFile(String fileName) {
        try {
            return new BufferedReader(new FileReader(fileName));
        }
        catch(FileNotFoundException e) {
            return null;
        }
    }

    private BufferedReader readerForString(String string) {
        return new BufferedReader(new StringReader(string));
    }

}
