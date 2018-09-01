import java.util.*;

public class Lottery{
    public static void main(String[] args) {
        /*
    Suppose you want to develop a program to play lottery. The program randomly generates a
    lottery of a two-digit number, prompts the user to enter a two-digit number, and determines
    whether the user wins according to the following rules:
        1. If the user input matches the lottery number in the exact order, the award is $10,000.
        2. If all digits in the user input match all digits in the lottery number, the award is $3,000.
        3. If one digit in the user input matches a digit in the lottery number, the award is $1,000.
    Note that the digits of a two-digit number may be 0 . If a number is less than 10 , we assume
    the number is preceded by a 0 to form a two-digit number. For example, number 8 is treated
    as 08 and number 0 is treated as 00 in the program. Listing 3.8 gives the complete program.
    */
        // create scanner
        Scanner input = new Scanner(System.in);
        int userGuess = -1;
        String award = "";
        // generate random two digit number
        int lottery = (int) (Math.random() * 100);
        // first digit
        int firstLotteryDigit = lottery / 10;
        // second digit
        int secondLotteryDigit = lottery % 10;
        
        // check value of lottery and first and second digits
        // System.out.printf("%nlottery = %d%nfirstLotteryDigit = %d%nsecondLotteryDigit = %d%n", lottery, firstLotteryDigit, secondLotteryDigit);

        while ((userGuess > 99) || (userGuess < 0)){
            System.out.print("Enter your two digit guess: ");
            userGuess = input.nextInt();            
        }

        // first userGuess digit
        int firstUserGuessDigit = userGuess / 10;
        // second userGuess digit
        int secondUserGuessDigit = userGuess % 10;

        if (    firstLotteryDigit == firstUserGuessDigit
            &&  secondLotteryDigit == secondUserGuessDigit){
            //1. If input matches in exact order, award is $10,000.
            award = "$10,000";
        } else if (
                firstLotteryDigit == secondUserGuessDigit
            &&  secondLotteryDigit == firstUserGuessDigit){
            // 2. If input matches all digits, the award is $3,000.
            award = "$3,000";
        } else if (
                firstLotteryDigit == firstUserGuessDigit
            ||  secondLotteryDigit == secondUserGuessDigit
            ||  firstLotteryDigit == secondUserGuessDigit
            ||  secondLotteryDigit == firstUserGuessDigit){
            // 3. If input matches one digit, the award is $1,000.
            award = "$1,000";
        } else award = "nothing";
        
        System.out.printf("%nThe lottery number is %d%d, your guess is %d%d%nYou win %s!%n"
            ,firstLotteryDigit, secondLotteryDigit, firstUserGuessDigit, secondUserGuessDigit, award);
    }
}