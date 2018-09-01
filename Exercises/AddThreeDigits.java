import java.util.*;

public class AddThreeDigits{
    public static void main(String[] args) {
        // initialize scanner
        Scanner input = new Scanner(System.in);

       try {
            int[] digits = new int[3];

            for (int i = 0; i < 3; i++) {
                // initialize three random ints
                digits[i] = (int) (Math.random() * 10);
            }
            
            System.out.printf("%nWhat is the sum of %d + %d + %d?%n",digits[0], digits[1], digits[2]);

            int response = input.nextInt();
            int sum = (digits[0] + digits[1] + digits[2]);

            if (response == sum){
                System.out.printf("%n%d is the correct answer. Good Job!%n", sum);
            } else {
                System.out.printf("%d is not the correct sum. The correct answer is %d%n", response, sum);
            }
        }

        finally {
            input.close();
        }
    }    
}