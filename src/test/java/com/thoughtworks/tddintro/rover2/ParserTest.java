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
    @Ignore
    public void testTest() {
        try {
            Scanner fileScanner = new Scanner(new BufferedReader(new FileReader("src/test/resources/RoverInput-Default.txt")));

            while(fileScanner.hasNextLine()) {
                System.out.println(fileScanner.nextLine());
            }
        }
        catch(java.io.FileNotFoundException e) {
            System.out.println("file not found");
        }
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
    @Ignore
    public void shouldReturnNullGridMapWhenErrorsOccurDuringParse() {

    }



}
