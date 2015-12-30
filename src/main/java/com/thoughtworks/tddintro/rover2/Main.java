package com.thoughtworks.tddintro.rover2;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        if(args.length != 1) {
            System.out.println("Usage:\n\t$ Main [InputFile]");
            return;
        }

        FileReader file;
        file = getFileReader(args[0]);
        if (file == null)
            return;

        Parser parser = new Parser();
        Parser.Flag result = parser.parse(file);
        if (result != Parser.Flag.SUCCESS) {
            printResult(result);
            return;
        }

        GridMap gridMap = parser.getGridMap();
        List<Rover> rovers = parser.getRovers();
        List<String> commands = parser.getCommands();

        RoverController roverController = new RoverController(gridMap);
        roverController.addRovers(rovers);

        for(int i = 0; i < rovers.size(); i++) {
            roverController.executeCommands(rovers.get(i), commands.get(i));
        }

        for(Rover rover : rovers) {
            System.out.println(rover.toString());
        }
    }

    private static FileReader getFileReader(String fileName) {
        FileReader file;
        try {
            file = new FileReader(fileName);
        }
        catch(FileNotFoundException fnfe) {
            System.out.println("File Error: File not found.");
            return null;
        }
        return file;
    }

    private static void printResult(Parser.Flag result) {
        if(result == Parser.Flag.INVALID_GRID) {
            System.out.println("File error: Invalid grid dimensions.");
        }
        else if(result == Parser.Flag.INVALID_ROVER) {
            System.out.println("File error: Invalid rover starting position.");
        }
        else if (result == Parser.Flag.INVALID_COMMAND) {
            System.out.println("File error: Invalid command.");
        }
    }
}
