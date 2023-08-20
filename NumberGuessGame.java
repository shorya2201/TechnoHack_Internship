import java.util.*;

public class NumberGuessGame {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Generate the number
        int number = 1 + (int) (100 * Math.random());// 100 indicates the upper bound & 1 indicates lower bound

        int i, guess;

        // This indicates the number of trials we are giving to player
        System.out.println("Enter the Number of Trials : ");
        int trials = sc.nextInt();

        System.out.println("A number is guessed between 1 to 100 , Guess a number in " + trials + " trials.");

        for (i = 0; i < trials; i++) {
            System.out.println("Guess a Number: ");
            guess = sc.nextInt();
            if (guess == number) {
                System.out.println("Congratulations! You have Successfully Guessed the Number!! ");
                break; 
                // Exits the loop
            } else if (guess < number) {
                System.out.println("The Number is Greater than " + guess);
            } else if (guess > number) {
                System.out.println("The Number is Smaller than " + guess);
            }
        }

        if (i == trials) { 
            // If trials are exhausted and player loses
            System.out.println("You have exhausted " + trials + " trials.");
            System.out.println("You Lose !! The Correct number was " + number);
        }
    }
}
