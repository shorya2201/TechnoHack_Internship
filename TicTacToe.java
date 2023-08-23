import java.util.*;

public class TicTacToe {
    /*
     * Making variables static as we want to change only once and reflect it
     * everywhere
     */

    static String[] board;// creates a string array which will act as a board
    static String turn;// stores X and O to display player turns

    static String checkWinner() {

        for (int i = 0; i < 8; i++) {
            String line = null;
            // checks all winning combinations i.e. diagonals , vert , horiz.
            switch (i) {
                case 0:
                    line = board[0] + board[1] + board[2];
                    break;
                case 1:
                    line = board[3] + board[4] + board[5];
                    break;
                case 2:
                    line = board[6] + board[7] + board[8];
                    break;
                case 3:
                    line = board[0] + board[3] + board[6];
                    break;
                case 4:
                    line = board[1] + board[4] + board[7];
                    break;
                case 5:
                    line = board[2] + board[5] + board[8];
                    break;
                case 6:
                    line = board[0] + board[4] + board[8];
                    break;
                case 7:
                    line = board[2] + board[4] + board[6];
                    break;
            }

            // Verifying on basis of above comb. which player won
            if (line.equals("XXX")) {
                return "X";
            }

            else if (line.equals("OOO")) {
                return "O";
            }
        }

        // If all slots are filled and no one wins then returns draw
        for (int a = 0; a < 9; a++) {
            if (Arrays.asList(board).contains(String.valueOf(a + 1))) {
                break;
            } else if (a == 8) {
                return "draw";
            }
        }

        // Display which player turn it is
        System.out.println(turn + "'s turn to enter a slot to place " + turn + "in: ");
        return null;

    }

    static void printBoard() {
        System.out.println("|---|---|---|");
        System.out.println("| " + board[0] + " | " + board[1] + " | " + board[2] + " |");
        System.out.println("|---|---|---|");
        System.out.println("| " + board[3] + " | " + board[4] + " | " + board[5] + " |");
        System.out.println("|---|---|---|");
        System.out.println("| " + board[6] + " | " + board[7] + " | " + board[8] + " |");
        System.out.println("|---|---|---|");

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        board = new String[9];// creates a 3x3 board
        turn = "X";
        String winner = null;
        for (int a = 0; a < 9; a++) {// player enter chances
            board[a] = String.valueOf(a + 1);
        }

        System.out.println("Welcome To 3x3 TicTacToe!!");
        printBoard();

        System.out.println("X will Play First , Enter a slot number to enter X in: ");

        while (winner == null) {
            int numInput;

            try {
                numInput = sc.nextInt();
                if (!(numInput > 0 && numInput <= 9)) {
                    System.out.println("Invalid Input ; Re-enter slot number: ");
                    continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input ; Re-enter slot number: ");
                continue;
            }
            // tracks player chances (X or O)
            if (board[numInput - 1].equals(String.valueOf(numInput))) {
                board[numInput - 1] = turn;

                if (turn.equals("X")) {
                    turn = "O";
                } else {
                    turn = "X";
                }

                printBoard();
                winner = checkWinner();

            } else {
                System.out.println("Slot already taken ; Please enter another slot number: ");
            }
        }

        if (winner.equalsIgnoreCase("draw")) {
            System.out.println("It's a Draw , Do a Rematch Again!!");
        } else {
            System.out.println("Congratulations " + winner + " is the winner !! Thanks for playing :)");
        }
        sc.close();

    }
}