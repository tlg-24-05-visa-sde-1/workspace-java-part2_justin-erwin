package com.duckrace.app;

import com.duckrace.Board;
import com.duckrace.Reward;

import java.util.Scanner;

import static com.duckrace.Reward.*;

/*
 * Application controller.  Directs overall flow of the application and prompts user for inputs,
 * then "passes" those inputs into the System (makes method calls on board).
 */
public class DuckRaceApp {
    private final Board board = new Board();  //our new board is born - we pass the board user input and call methods
    private final Scanner scanner = new Scanner(System.in);  //opposite of System.out - it's the console for input

    //call private methods that do "jobs" - won't contain much logic
    public void execute() {
        welcome();
        showBoard();
        int id = promptForId();  //we get back an id from this prompt
        Reward reward = promptForReward(); //we get back a Reward
        updateBoard(id, reward);  //we've got the two things we need to update the board, id and reward, & we pass them into system
        showBoard();  //show updatedBoard
    }

    private void updateBoard(int id, Reward reward) {
        board.update(id, reward);
    }

    private Reward promptForReward() {
        Reward reward = null;

        boolean validInput = false;
        while (!validInput) {
            System.out.print("Please enter [D]ebit card or [P]rizes: ");  //print not println
            String input = scanner.nextLine().trim().toUpperCase();  //upperCase it to accept lowercase d or p too;
            if (input.matches("D|P")) { //if input matches D or P - (DON"T put Spaces for readability b/c you'll be looking for the spaces too)
                validInput = true;
                reward = (input.equals("D") ? DEBIT_CARD : PRIZES);  //ternary operator - our static import lets us just say PRIZES instead of Reward.PRIZES
/*                if (input.equals("D")) {
                    reward = Reward.DEBIT_CARD;    //make reward equal Reward.DEBIT_CARD or Reward.PRIZES
                }
                else {
                    reward = Reward.PRIZES;
                }*/
            }
        }
        return reward;
    }

    private int promptForId() {  //be defensive and make sure we get valid input
        int id = 0;
        boolean validInput = false;
        while (!validInput) { //valid input is false
            System.out.print("Please enter id of the winner [1-16]: ");  //Emit the prompt text - don't hardcode the 16
            String input = scanner.nextLine().trim();  //Blocks for input , i.e., waits for the Enter key  - We take in userInput from console and save to variable
            //ONLY USE .nextLine()!!  - returns string and .trim() will trim off leading or trailing whitespace.  ALWAYS trim().
            if (input.matches("\\d{1,2}")) { // regex - any digit, one or two times - users can enter 0-99
                id = Integer.parseInt(input);  //this is safe to do at this point (no exception) b/c we know we have Integers
                if (id >= 1 && id <= 16) {  //don't hardcode the 16 in project (write a method in board to get maxId to get size of studentIdMap)
                    validInput = true;  //make valid input true to stop while loop
                }
            }
        }
        return id;
    }

    private void showBoard() {
        board.show();  //calls the show() method on our board object
    }

    private void welcome() {
        System.out.println("\n");
        System.out.println("- - - - - - -    - -    - - -    - - - -    - - - -    - - - - - - - - - - -");
        System.out.println("W E L C O M E    T O    T H E    D U C K    R A C E    A P P L I C A T I O N");
        System.out.println("- - - - - - -    - -    - - -    - - - -    - - - -    - - - - - - - - - - -");
        System.out.println("\n");


    }
}
