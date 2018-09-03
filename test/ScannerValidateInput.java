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

/* public class ScannerValidateInput {
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
        
    }
} */

public class ScannerValidateInput {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int tempID = -1;
        int tempQty = 0;
        do {
            // confirmItem = ""; // reset these for the next order placed 
            // continueShopping = ""; // reset these for the next order placed
            System.out.printf("%nPlease select a light bulb by entering the product ID 1, 2 or 3.%n\tEnter ID here: ");
            while (!input.hasNextInt()) { // if the user does not enter an int
                String str = input.nextLine(); // assign the entered line as a string 
                System.out.printf("\"%s\" is not a valid number.\n", str); //
                System.out.printf("%nPlease select a light bulb by entering the product ID 1, 2 or 3.%n\tEnter ID here: ");
                // not the kind of repetition your looking for
            }
            while (input.nextInt() < 1 || input.nextInt() > 3) { // validate the entries to ensure it matched a product ID
                
                System.out.printf("%d is not a valid number.\n", input.nextInt()); //
                System.out.printf("%nPlease select a light bulb by entering the product ID 1, 2 or 3.%n\tEnter ID here: ");
                tempID = input.nextInt();
            }
        } while (tempID < 1 || tempID > 3 /* || !input.hasNextInt() */);
        tempID --; // correct to match the array indices
        
        // Request customer select quantity of selected bulb
        do {
            System.out.printf("%nPlease enter the number of %ss you would like to purchase.%n\tEnter QTY here: ", "productID[1][tempID]");
            while (!input.hasNextInt()) { // if the user does not enter an int
                String str = input.next(); // assign the entered line as a string 
                System.out.printf("\"%s\" is not a valid quantity.\n", str); //
                System.out.printf("%nPlease enter the number of %ss you would like to purchase.%n\tEnter QTY here: ", "productID[1][tempID]");
                // not the kind of repetition your looking for
            }
            while (tempQty < 1) {
                System.out.printf("\"%d\" is not a valid quantity.\n", tempQty); //
                System.out.printf("%nPlease enter the number of %ss you would like to purchase.%n\tEnter QTY here: ", "productID[1][tempID]");
                tempQty = input.nextInt();
            }
        } while (tempQty < 1); // validate the entries to ensure it matched a product ID
    }
}
