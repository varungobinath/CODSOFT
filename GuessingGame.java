import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random rand = new Random();
        char playAgain;

        System.out.println("\n\tWelcome to the Game of \"Guess the Number\"");
        do{
            int hidden_no = rand.nextInt(100-1+1)+1;
            int attempts = 0;

            while(attempts < 5){
                System.out.print("\nGuess the number (between 1 and 100) : ");
                int user_no = in.nextInt();

                if(user_no == hidden_no){
                    System.out.println("Congratulations! Yor guessed the correct number "+user_no+" in "+attempts+" attempts");
                    break;
                }else if(user_no < hidden_no){
                    System.out.println("Too Low. "+(5-attempts-1)+" attempts left.");
                }else{
                    System.out.println("Too High. "+(5-attempts-1)+" attempts left.");
                }
                attempts++;
                if(attempts==5){
                    System.out.println("Sorry, You've run out of attempts. The correct number was "+hidden_no);
                }
            }
            System.out.print("\ndo you want to play again?(y/n) : ");
            playAgain = in.next().toLowerCase().charAt(0);
        }while(playAgain=='y');

    }
}
