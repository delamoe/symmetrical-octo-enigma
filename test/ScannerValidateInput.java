/* import java.util.Scanner;

public class ScannerValidateInput {
    public static void main(String[] args) {
        ScannerValidateInput demo = new ScannerValidateInput();
        demo.validatePositiveNumber();
    }

    private void validatePositiveNumber() {
        Scanner scanner = new Scanner(System.in);

        int number;
        try {
            do {
                System.out.print("Please enter 1, 2 or 3: ");
                while (!scanner.hasNextInt()) {
                    String input = scanner.next();
                    System.out.printf("\"%s\" is not a valid number.\n", input);
                    System.out.print("Please enter 1, 2 or 3: ");
                }
                number = scanner.nextInt();
            } while (number < 1 || number > 3);
        }

        finally {
            scanner.close();
        }

        System.out.printf("You have entered a valid number %d.\n", number);
    }
} */
/* import java.util.Scanner;

public class ScannerValidateInput {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int number;
        do {
            System.out.print("Please enter 1, 2 or 3: ");
            while (!input.hasNextInt()) {
                String str = input.next();
                System.out.printf("\"%s\" is not a valid number.\n", str);
                System.out.print("Please enter 1, 2 or 3: ");
            }
            number = input.nextInt();
        } while (number < 1 || number > 3);

        System.out.printf("You have entered a valid number %d.\n", number);
    }
} */

import java.util.Scanner;

public class ScannerValidateInput {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
String confirmItem = "";
while (!confirmItem.matches("[ynYN]")) {
            System.out.printf("%nEnter Y 0r N");
            confirmItem = input.nextLine().toLowerCase();
            if (!confirmItem.matches("[ynYN]")) {
                System.out.printf("\"%s\" is not a valid response.%nPlease enter Y or N: ", confirmItem);
            } else if (confirmItem.matches("[yY]")) {
                System.out.printf("%nYES");
            } else if (confirmItem.matches("[nN]")) {
                System.out.printf("%nNO");
            }
            // 
        } 
        // System.out.println();
    }
}