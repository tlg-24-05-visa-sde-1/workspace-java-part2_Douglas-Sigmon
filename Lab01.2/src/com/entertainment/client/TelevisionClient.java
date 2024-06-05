package com.entertainment.client;

import com.entertainment.Television;
import java.util.HashSet;
import java.util.Set;

class TelevisionClient {

  public static void main(String[] args) {

    //examine == and equals method
    Television tvA = new Television("Sony", 51);
    Television tvB = new Television("Sony", 51);

    System.out.println(tvA.hashCode());
    System.out.println(tvB.hashCode());

    System.out.println("== method works comparing Objects: " + (tvA == tvB));
    System.out.println(".equals method works comparing Objects: " + (tvA.equals(tvB)));
    System.out.println();

    Set<Television> tvs = new HashSet<>();
    tvs.add(tvA);
    tvs.add(tvB);
    System.out.println(tvs);
  }

}