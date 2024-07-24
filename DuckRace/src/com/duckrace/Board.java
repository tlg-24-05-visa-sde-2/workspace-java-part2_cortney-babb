package com.duckrace;

import java.io.IOException;
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

public class Board {
    // fields
    private final Map<Integer,String> studentIdMap = loadStudentIdMap();
    private final Map<Integer,DuckRacer> racerMap  = new TreeMap<>();

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
    }

    // FOR TESTING ONLY
    void dumpStudentIdMap() {
        System.out.println(studentIdMap);
    }

    // TODO - render the data as we see it in the "real" application
    // see Session 5 in Java Part 1 manual, formatted output (justify)
    public void show() {
        if (racerMap.isEmpty()) {
            System.out.println("\nThere are no results to show.\n");
        } else {
            Collection<DuckRacer> racers = racerMap.values();

            // print title and column heading
            String header = """
                    \t\tDuck Race Results
                    \t\t=================
                    
                    id\t\tname\t\twins\trewards
                    ==\t\t====\t\t====\t=======
                    """;

            for (DuckRacer racer : racers) {
                System.out.printf("%s%s\t\t%s\t\t%s\t\t%s",
                        header, racer.getId(), racer.getName(), racer.getWins(), racer.getRewards());
                System.out.println();
            }
        }
    }

    private Map<Integer, String> loadStudentIdMap() {
        Map<Integer, String> map = new HashMap<>();

        // read all lines from CSV file, process each one into an integer and a string
        // checked exception
        try {
            List<String> lines = Files.readAllLines(Path.of("conf/student-ids.csv"));

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