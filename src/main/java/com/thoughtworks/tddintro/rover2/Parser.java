package com.thoughtworks.tddintro.rover2;


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

    }

    public GridMap getGridMap() {
        return map;
    }

    public List<Rover> getRovers() {
        return rovers;
    }
}
