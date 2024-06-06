package com.entertainment.client;

import com.entertainment.Television;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

class TelevisionClient {

  public static void main(String[] args) {

    //examine == and equals method
    Television tvA = new Television("Sony", 50);
    Television tvB = new Television("Sony", 50);
    Television tvC = new Television("Sony", 52);
    Television tvD = new Television("Sony", 12);

    System.out.println("== method works comparing Objects: " + (tvA == tvB));
    System.out.println(".equals method works comparing Objects: " + (tvA.equals(tvB)));
    System.out.println();

    Set<Television> tvs = new TreeSet<>();
    tvs.add(tvA);
    tvs.add(tvB);
    tvs.add(tvC);
    tvs.add(tvD);
    System.out.println();
    for (Television tv : tvs) {
      System.out.println(tv);
    }
  }

}