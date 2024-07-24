package com.duckrace.app;

import com.duckrace.Board;
import com.duckrace.Reward;

import java.util.Locale;
import java.util.Scanner;

/*
 * Application controller
 * It conducts the overall flow of the app, does all user prompting
 * and passes user provided info into the backend model
 */

public class DuckRaceApp {
    private final Scanner scanner = new Scanner(System.in);
    private final Board board = new Board();

    public void execute() {
        welcome();
        showBoard();
        int id = promptForId();
        Reward reward = promptForReward();
        updateBoard(id, reward);
        showBoard();
    }

    private void updateBoard(int id, Reward reward) {
        board.update(id, reward);
    }

    private Reward promptForReward() {
        Reward reward = null;
        Boolean validInput = false;

        while (!validInput) {
            System.out.print("Please enter [D]ebit card or [P]rizes: ");
            String input = scanner.nextLine().trim().toUpperCase();
            System.out.println();

            if (input.matches("D|P")) {
                reward = (input.equals("D")) ? Reward.DEBIT_CARD: Reward.PRIZES; // using ternary
                System.out.println();
                validInput = true;
            }
        }

        return reward;
    }

    private int promptForId() {
        int id = 0;
        boolean validInput = false;

        while (!validInput) {
            System.out.print("Please enter id of the winner [1-11]: ");
            String input = scanner.nextLine().trim(); // BLOCKs for [Enter], trims off leading whitespace
            System.out.println();

            if (input.matches("\\d{1,2}")) { // now you can safely parseInt()
                id = Integer.parseInt(input);

                if (id >= 1 && id <= 11) { // you got valid input // TODO dont hardcode 11
                    validInput = true;
                }
            }
        }

        return id;
    }

    private void showBoard() {
        board.show();
    }

    private void welcome() {
        System.out.println("""
                \n
                    -----------------
                    Welcome  to  the
                    D U C K  R A C E!
                    -----------------""");
    }
}