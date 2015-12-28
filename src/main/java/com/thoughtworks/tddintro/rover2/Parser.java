package com.thoughtworks.tddintro.rover2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import java.util.ArrayList;
import java.util.List;

public class Parser {

    private GridMap map;
    private List<Rover> rovers;

    public Parser() {
        map = null;
        rovers = new ArrayList<>();
    }

    public void parse(String fileName) {
        Scanner fileScanner;

        try {
            fileScanner = new Scanner(new BufferedReader(new FileReader(fileName)));
        }
        catch(FileNotFoundException e) {
            return;
        }

        int xMax = fileScanner.nextInt();
        int yMax = fileScanner.nextInt();
        map = new GridMap(xMax, yMax);
    }

    public GridMap getGridMap() {
        return map;
    }

    public List<Rover> getRovers() {
        return rovers;
    }
}
