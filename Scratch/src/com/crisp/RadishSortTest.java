package com.crisp;

import java.util.ArrayList;
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

    System.out.println("Sort by color via RadishColorComparator");
    radishes.sort(new RadishColorComparator());
    dump(radishes);

    System.out.println("Sort by Guys On Top by RadishGuysOnTopComparator");
    radishes.sort(new RadishGuysOnTopComparator());
    dump(radishes);

  }

  private static void dump(List<Radish> radishList) {
    for (Radish r : radishList) {
      System.out.println(r);
    }
    System.out.println();
  }

}