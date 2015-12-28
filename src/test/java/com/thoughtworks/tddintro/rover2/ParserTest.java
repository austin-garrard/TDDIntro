package com.thoughtworks.tddintro.rover2;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.Before;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ParserTest {

    @Test
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

}
