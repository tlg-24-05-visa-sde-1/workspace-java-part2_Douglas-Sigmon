package jeopardy.ranked;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class JavaJeopardyRankedResults {

  final static String filePath = "results.txt";
  Map<String, Integer> jeopardyResults = new HashMap<String, Integer>();

  public static void main(String[] args) {
    Map<String, Integer> mapFromFile = hashMapFromTextFile();
//    dump(mapFromFile);
    dump(sortByValue(mapFromFile));

  }

  private static Map<String, String> rankedResults(Map<String, String> map) {
    Map <String, String> rankedMap = null;
    List<String> values = new ArrayList<>();

    for (Map.Entry<String, String> entry : map.entrySet()) {
       values.add(entry.getValue());
    }
    return rankedMap;
  }

  public static Map<String, Integer> sortByValue(Map<String, Integer> hm)
  {
    // Create a list from elements of HashMap
    List<Map.Entry<String, Integer> > list =
        new LinkedList<Map.Entry<String, Integer> >(hm.entrySet());

    // Sort the list using lambda
    Collections.sort(list, (o1,o2) -> o2.getValue().compareTo(o1.getValue()));

//        new Comparator<Map.Entry<String, Integer> >() {
//      public int compare(Map.Entry<String, Integer> o1,
//          Map.Entry<String, Integer> o2)
//      {
//        return (o1.getValue()).compareTo(o2.getValue());
//      }
//    });

    // put data from sorted list to hashmap
    HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
    for (Map.Entry<String, Integer> aa : list) {
      temp.put(aa.getKey(), aa.getValue());
    }
    return temp;
  }

  private static Map<String, Integer> hashMapFromTextFile() {
    Map<String, Integer> map = new HashMap<>();
    File file = new File(filePath);
    try(BufferedReader reader =  new BufferedReader(new FileReader(file)) ) {

      //create File object

      //create bufferedReader object from file
      String line = null;

      //read file line by line
      while ((line = reader.readLine()) != null) {
        //split line by ,
        String[] tokens = line.split(",");

        //first token is name, second token is number
        String name = tokens[0];
        Integer number = Integer.parseInt(tokens[1]);

        //put name and number in Hashmap if they are not empty
        if (!"".equals(name) && !"".equals(number)) {
          map.put(name, number);
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return map;
  }

  static void dump(Map<String, Integer> jeopardyResults) {
    for (Map.Entry<String, Integer> entry : jeopardyResults.entrySet()) {
      String key = entry.getKey();
      System.out.println(key + ": " + entry.getValue());
    }
  }

}