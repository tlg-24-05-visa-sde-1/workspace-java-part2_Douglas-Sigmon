package com.duckrace;

import java.util.Collection;

class DuckRacerTest {
  public static void main(String[] args) {
    DuckRacer racer1 = new DuckRacer(1,"Amir");
    racer1.win(Reward.DEBIT_CARD);
    racer1.win(Reward.DEBIT_CARD);
    racer1.win(Reward.PRIZES);
    racer1.win(Reward.DEBIT_CARD);

    System.out.println(racer1);

    System.out.println();


  }
}