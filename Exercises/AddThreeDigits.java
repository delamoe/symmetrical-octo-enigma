import java.util.*;

public class AddThreeDigits{
    public static void main(String[] args) {
        // initialize scanner
        Scanner input = new Scanner(System.in);

       int[] array = new int[3];

        for (int i = 0; i < 3; i++) {
            // initialize three random ints
            array[i] = (int) (Math.random() * 10);
        }

        System.out.printf("%nWhat is %d + %d + %d?%n",array[0], array[1], array[2]);

        int answer = input.nextInt();

        String result = (answer == array[0] + array[1] + array[2]) ? "correct" : "incorrect";

        System.out.printf("%nYou have given the %s answer. ",result);
        if (result == "correct"){
            System.out.printf("Good Job!%n");
        } else {
            System.out.printf("The correct answer is %d%n",array[0] + array[1] + array[2]);
        }
    }    
}