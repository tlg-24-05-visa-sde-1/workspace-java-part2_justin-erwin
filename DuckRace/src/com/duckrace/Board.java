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
 * Map<Integer,DuckRacer> racerMap;     //this is a common data structure, a lookup key and an object
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

public class Board implements Serializable {  //grants permission to save state of Board objects - anything else we want
    //want to write will also have to be Serializable (so here we have to have DuckRacer implement Serializable too)
    private static final String DATA_FILE_PATH = "data/board.dat";
    private static final String STUDENTS_ID_FILE_PATH = "conf/student-ids.csv";

    /*
     * Read from binary file data/board.dat or create new Board (if file not there) -
     * we create a new dir. called data to put the file in when created.
     * NOTE: new Board object only created the *very fist time* the app is run.
     */
    public static Board getInstance() {
        Board board = null;

        if (Files.exists(Path.of(DATA_FILE_PATH))) {  //path is relative to DuckRacer module
            //what we initialize in () after try will close automatically too - "Try with Resources"
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(DATA_FILE_PATH))) {
                board = (Board) in.readObject();   //downcast to board
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {  //this only happens the very first time we run the app, b/c the file doesn't exist.
            board = new Board();
        }
        return board;
    }

    private final Map<Integer, String> studentIdMap = loadStudentIdMap();
    private final Map<Integer, DuckRacer> racerMap = new TreeMap<>();  //use TreeMap b/c it add based on natural order

    //ctor - Prevent instantiation from outside - write a private ctor so nothing else can say new Board();
    private Board() {
    }

    /*
     * updates the winner board (Racer Map) by making a DuckRacer win
     * This could mean fetching an existing DuckRacer from racerMap
     * ,or we might need to create a new DuckRacer, put it in the map and make it win.
     * Either way, it needs to win().
     */
    public void update(int id, Reward reward) {  //takes in the id of the winner and the desired Reward
        DuckRacer racer = null;
        if (racerMap.containsKey(id)) {  //fetch existing DuckRacer
            racer = racerMap.get(id);
        } else {      //create new DuckRacer with new
            racer = new DuckRacer(id, studentIdMap.get(id));  //creates a new DuckRacer with id and looks up name String from studentIdMap
            racerMap.put(id, racer);  //easy to forget this step - put racer in racerMap
        }
        racer.win(reward);  //call win on DuckRacer racer
        save();
    }

    /*
     * Writes 'this' Board object to binary file data/board.dat
     * used by update()
     * In more detail, we are using Java's built-in Object Serialization facility
     * to write the state of this object to the file (data/board.dat)
     */
    private void save() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(DATA_FILE_PATH))) {
            out.writeObject(this); //write "me" (I am a Board object) to the file as bytes (dust)
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * This shows the data to the human user.
     *
     * TODO: make it pretty, as close to the "real" board that we show in clas as possible.
     *  print headings
     */
    public void show() {  //two state for show, if racerMap is empty print "...no results" else show the board
        if (racerMap.isEmpty()) {
            System.out.println("There are currently no results to show");
        } else {
            Collection<DuckRacer> racers = racerMap.values(); //make a collection of only the map values
            System.out.println("id    name    wins    rewards");
            System.out.println("__    ____    ____    _______");
            for (DuckRacer racer : racers) {
                System.out.println(racer.getId() + "    " + racer.getName() + "    " + racer.getWins() + "    " + racer.getRewards());  //toString() automatically called
                //try to make it pretty with souf (Java 1 session 5)
            }
        }
    }

    //TESTING PURPOSES ONLY
    void dumpStudentIdMap() {
        System.out.println(studentIdMap);
    }


    /*
     * Populates studentIdMap from file conf/student-ids.csv.
     * //read file by each line, strip comma and put each "row" in the map with a for loop;
     */
    private Map<Integer, String> loadStudentIdMap() {
        Map<Integer, String> map = new HashMap<>();  //use HashMap b/c it doesn't need to be in order
        try {
            List<String> lines = Files.readAllLines(Path.of(STUDENTS_ID_FILE_PATH));//provide path to readAllLines with Path.of
            //for each line (String), we need to split it into "tokens" based on the comma
            //i.e. "1" and "Amir", we can use split()
            for (String line : lines) {
                String[] tokens = line.split(",");  //this returns an array for each line - ["1", "Amir"]
                //our map is made of an Integer and a String so we need to convert the 1st string to an Integer
                Integer id = Integer.valueOf(tokens[0]);  //converts String to Integer
                String name = tokens[1];
                map.put(id, name);  //put each item into the map
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

}