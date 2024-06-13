package com.crisp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class RadishSortTest {

  public static void main(String[] args) {
    List<Radish> radishes = new ArrayList<>();

    System.out.println("Original List");
    radishes.add(new Radish("red", 1.5, 2.5, 5));
    radishes.add(new Radish("black", 1.0, 0.0, 0));
    radishes.add(new Radish("white", 2.7, 5.5, 0));
    radishes.add(new Radish("pink", 0.9, 0.0, 6));
    dump(radishes);

    System.out.println("Sort by Natural Order defined in Radish using Comparable");
    radishes.sort(null); // passing null means natural order
    dump(radishes);

//    System.out.println("Sort by color via RadishColorComparator");
//    radishes.sort(new RadishColorComparator());
    System.out.println("Sort by color via Lambda as the comparator");
    radishes.sort((r1, r2) -> r1.getColor().compareTo(r2.getColor()));
    dump(radishes);

//    System.out.println("Sort by Guys On Top by RadishGuysOnTopComparator");
//    radishes.sort(new RadishGuysOnTopComparator());

    System.out.println("sort by guysOnTop via Lambda as the comparator");
    radishes.sort((r1, r2) -> Integer.compare(r1.getGuysOnTop(), r2.getGuysOnTop()));
    dump(radishes);

    System.out.println("Sort by tailLength via anonymous Comparator class");
    radishes.sort((r1,r2) -> Double.compare(r1.getTailLength(), r2.getTailLength()));
    dump(radishes);

  }

  private static void dump(List<Radish> radishList) {
    for (Radish r : radishList) {
      System.out.println(r);
    }
    System.out.println();
  }

}