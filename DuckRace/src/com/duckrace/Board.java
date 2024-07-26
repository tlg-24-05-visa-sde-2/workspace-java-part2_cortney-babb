package com.duckrace;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

/*
 * This is a lookup table of ids to student names.
 * When a duck wins for the first time, we need to find out who that is.
 * This lookup table could be hardcoded with the data, or we could read the data 
 * in from a file, so that no code changes would need to be made for each cohort.
 *
 * Map<Integer,String> studentIdMap;
 * 
 * Integer    String
 * =======    ======
 *    1       John
 *    2       Jane
 *    3       Danny
 *    4       Armando
 *    5       Sheila
 *    6       Tess
 * 
 *
 * We also need a data structure to hold the results of all winners.
 * This data structure should facilitate easy lookup, retrieval, and storage.
 *
 * Map<Integer,DuckRacer> racerMap;
 *
 * Integer    DuckRacer
 * =======    =========
 *            id    name     wins   rewards
 *            --    ----     ----   -------
 *    5        5    Sheila     2    PRIZES, PRIZES
 *    6        6    Tess       1    PRIZES
 *   13       13    Zed        3    PRIZES, DEBIT_CARD, DEBIT_CARD
 *   17       17    Dom        1    DEBIT_CARD
 */

public class Board implements Serializable {
    private static final String DATA_FILE_PATH = "data/board.dat";
    private static final String CONF_FILE_PATH = "conf/student-ids.csv";
    /*
     * If data/board.dat exists, the application has been run before at least once.
     * Therefore, recreate the board object from that binary file
     *
     * Else, if file is not there, this is the first time app has been run.
     * Therefore, create and return new board
     */
    public static Board getInstance() {
        Board board = null;

        if (Files.exists(Path.of(DATA_FILE_PATH))) {
            // reads binary file if it exists
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(DATA_FILE_PATH))) {
                board = (Board) in.readObject(); // downcasts object to board
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            board = new Board(); // else create new board
        }
        return board;
    }

    // fields
    private final Map<Integer,String> studentIdMap = loadStudentIdMap();
    private final Map<Integer,DuckRacer> racerMap  = new TreeMap<>();

    // private constructor, prevents instantiation from outside - only getInstance
    private Board() {
    }

    // action methods

    /*
     * Updates the board (racerMap) by making a DuckRacer win() - Needs id and reward
     * this could mean fetching (get(5)) an existing DuckRacer from racerMap - contains
     * or we might need to create a "new DuckRacer", put() it in the map
     * and then make it win()
     * either way it needs to win()
     */
    public void update(int id, Reward reward) {
        DuckRacer racer = null;

        if(racerMap.containsKey(id)) {
            // get() DuckRacer at that id and call win()
            racer = racerMap.get(id);
        } else {
            String name = studentIdMap.get(id);
            // create "new DuckRacer()" with that id
            racer = new DuckRacer(id, name);
            // put() that DuckRacer in the map and call win()
            racerMap.put(id, racer);
        }
        racer.win(reward);

        save();
    }

    // TODO - render the data as we see it in the "real" application
    // see Session 5 in Java Part 1 manual, formatted output (justify)
    public void show() {
        if (racerMap.isEmpty()) {
            System.out.println("\nThere are no results to show.\n");
        } else {
            Collection<DuckRacer> racers = racerMap.values();

            // print title and column heading once
            System.out.println("""
                \t\tDuck Race Results
                \t\t=================
                
                id\t\tname\t\twins\trewards
                ==\t\t====\t\t====\t=======
                """);

            // print each racer's information
            for (DuckRacer racer : racers) {
                System.out.printf("%d\t\t%s\t\t%d\t\t%s\n",
                        racer.getId(), racer.getName(), racer.getWins(), racer.getRewards());
            }
        }
    }


    private void save() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(DATA_FILE_PATH))) {
            out.writeObject(this); // write "me" to binary file, I am a board object
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Map<Integer, String> loadStudentIdMap() {
        Map<Integer, String> map = new HashMap<>();

        // read all lines from CSV file, process each one into an integer and a string
        // checked exception
        try {
            List<String> lines = Files.readAllLines(Path.of(CONF_FILE_PATH));

            // for each line, split string into "tokens" => 1 Bullen
            for (String line : lines) {
                String[] tokens = line.split(","); // "1" and "Bullen"
                Integer id = Integer.valueOf(tokens[0]);
                String name = tokens[1];
                map.put(id, name);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }
}