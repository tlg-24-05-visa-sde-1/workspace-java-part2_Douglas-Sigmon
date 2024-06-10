package com.duckrace.app;

import com.duckrace.Board;
import com.duckrace.Reward;
import java.util.Scanner;
import static com.duckrace.Reward.*;

/*
 * Application Controller. Directs overall flow of the application,
 * and prompts user for inputs, then "passes" those inputs into the System.
 */

public class DuckRaceApp {

  private final Board board = new Board();
  private final Scanner scanner = new Scanner(System.in);

  public void execute() {
    welcome();
    showBoard();
    int id = promptForWinnerId();
    Reward reward = promptForReward();
    updateBoard(id, reward);
    showBoard();


  }

  private void updateBoard(int id, Reward reward) {
    board.update(id, reward);
  }

  private Reward promptForReward() {
    Reward reward = null;

    boolean validInput = false;
    while (!validInput) {
      System.out.print("Enter Reward [D]ebit or [P]rizes: ");
      String input = scanner.nextLine().trim().toUpperCase();
      if (input.matches("D|P")) {
        validInput = true;
        reward = (input.equals("D") ? DEBIT_CARD : PRIZES);
      }
    }
    return reward;
  }

  private int promptForWinnerId() {
    int id = 0;

    boolean validInput = false;
    while (!validInput) {
      //dont hardcode the 16;
      System.out.print("Enter ID of the winner[1-16]");
      String input = scanner.nextLine()
          .trim(); //BLOCKS for input i.e.. the Enter Key // trim takes any leading or trailing white space. ALWAYS TRIM
      if (input.matches("\\d{1,2}")) { //any digit one or two times 1,10,25,65,valid {101 not valid}
        id = Integer.parseInt(input);
        if (id >= 1 && id <= board.maxId()) { //dont hardcode the 16
          validInput = true;
        } else {
          System.out.println("Invalid ID [1-16]");
        }
      }
    }
    return id;
  }

  private void showBoard() {
    System.out.println("The Winners are Shown Here:");
    board.showRacerMap();
    System.out.println();
  }

  private void welcome() {
    System.out.println("\n");
    System.out.println("Welcome to DuckRace!\n");
  }

}