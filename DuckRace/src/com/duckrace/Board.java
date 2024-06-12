package com.duckrace;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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
  private static final String STUDENT_ID_FILE_PATH = "conf/student-ids.csv";

  private final Map<Integer, String> studentIdMap = loadStudentIdMap();
  private final Map<Integer, DuckRacer> racerMap = new TreeMap<>();

  //prevents the instantiation from outside.
  private Board() {
  }

  /*
   * Read from binary file data/board.dat or create new Board (if file not there).
   * NOTE: new Board object only created the *very first time* the app is run.
   */
  public static Board getInstance() {
    Board board = null;
    if (Files.exists(Path.of(DATA_FILE_PATH))) {
      try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(DATA_FILE_PATH))) {
        board = (Board) in.readObject();
      } catch (Exception e) {
        e.printStackTrace();
      }
    } else { //only happens the very first time we run the app
      board = new Board();
    }
    return board;
  }

  //TESTING PURPOSES ONLY
  public int maxId() {
    return studentIdMap.size();
  }

  void dumpStudentIDMap() {
    System.out.println(studentIdMap);
  }

  public void showRacerMap() {
    if (racerMap.isEmpty()) {
      System.out.println("There are currently no Winners");
    } else {
      Collection<DuckRacer> racers = racerMap.values();
      for (DuckRacer racer : racers) {
        System.out.println(racer);
      }

    }
  }

  /*
   *  Updates the board (racerMap) by making a DuckRacer win.
   * This could mean fetching an existing DuckRacer from racerMap,
   * or we might need to create a new DuckRacer, put it in the map,
   * then make it win.
   */
  public void update(int id, Reward reward) {
    DuckRacer racer;
    if (racerMap.containsKey(id)) {
      racer = racerMap.get(id);
    } else {
      racer = new DuckRacer(id, studentIdMap.get(id));
      racerMap.put(id, racer);
    }
    racer.win(reward);
    save();
  }

  /*
   * Writes 'this' Board object to binary file data/board.dat.
   * In more detail, we are using Java's built-in Object Serialization facility
   * to write the state of this object to the file.
   */
  private void save() {
    try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(DATA_FILE_PATH))) {
      out.writeObject(this); //write "me" im a board object to the file.
    } catch (Exception e) {
      e.printStackTrace();
    }
  }


  //Populates sutdentIdeMpa from file conf/student-ids.csv
  private Map<Integer, String> loadStudentIdMap() {
    Map<Integer, String> map = new HashMap<>();
    try {
      List<String> lines = Files.readAllLines(Path.of(STUDENT_ID_FILE_PATH));
      // for each line(String), we need to split it into "tokens"
      for (String line : lines) {
        String[] tokens = line.split(",");
        map.put(Integer.valueOf(tokens[0]), tokens[1]);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return map;
  }


}