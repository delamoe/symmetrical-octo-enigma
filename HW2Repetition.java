import java.util.*;

public class HW2Repetition{
    public static void main(String[] args) {
        // Initialize Scanner class
        Scanner input = new Scanner(System.in);
        
        // Create product database
        // A multidimensional array to hold the product id and desriptions separately but with the same index
        String[][] productID = {
            {
                "1",
                "2",
                "3"
            },
            {
                "13 watt Light Bulb",
                "18 watt Light Bulb",
                "23 watt Light Bulb"
            }
        };
        // indexes in this array correspond to the product id and name array
        double[] productPrice = {
            1.5,
            3.0,
            4.0
        };

        // Initialize a boolean to false in order to allow closing the loop 
        boolean finishedShopping = false;
        // Initialize a multidimensional array to use as the shopping cart to hold product ID and QTY
        int[][] cart = new int[15][15];
        int cartIndex = 0; // incrementing will allow me to count only the updated indexes in the cart
        int cartTotalItems = 0; // I'll be able to multiply within each (for) loop and add each items extended price upon iteration
        int tempID = -1; // a non-valid entry to get the while loop started
        int tempQty = 0; // a non-valid entry to get the while loop started
        double subTotal = 0, discount = 0, shippingCost = 0, grandTotal = 0; // will need these later
        String plural = ""; // when qty is > 1, this will add an "s" to the prouct names
        String confirmItem = ""; // a non-valid entry to get the while loop started
        String continueShopping = ""; // a non-valid entry to get the while loop started

        try { 
            while (!finishedShopping){
                // this loop will run until the boolean is true
                // Will keep asking for orders until user says no or cart is at maximum (15) 
                
                // Print out product catalog using printf and a for loop to populate the lines
                // A little decoration to make it pretty
                System.out.printf("%n|--------------------------------------|%n| ID\tDescription\t\tPrice  |%n|--------------------------------------|%n");
                for (int i = 0; i <= productID.length; i++){
                    System.out.printf("| %s\t%s:\t$ %3.2f |%n",productID[0][i], productID[1][i], productPrice[i]);
                }
                System.out.printf("|--------------------------------------|%n");

                // Request customer select type of bulb          
                do {
                    confirmItem = ""; // reset these for the next order placed 
                    continueShopping = ""; // reset these for the next order placed
                    System.out.printf("%nPlease select a light bulb by entering the product ID 1, 2 or 3.%n\tEnter ID here: ");
                    while (!input.hasNextInt()) { // if the user does not enter an int
                        String str = input.nextLine(); // assign the entered line as a string 
                        System.out.printf("\"%s\" is not a valid number.\n%nPlease select a light bulb by entering the product ID 1, 2 or 3.%n\tEnter ID here: ", str);  // not the kind of repetition your looking for, I know...
                    }
                    while (tempID < 1 || tempID > 3) { // validate the entries to ensure it matched a product ID
                        tempID = input.nextInt();
                        if (tempID < 1 || tempID > 3) {
                            System.out.printf("%d is not a valid number.\n%nPlease select a light bulb by entering the product ID 1, 2 or 3.%n\tEnter ID here: ", tempID);
                        }
                    }
                } while (tempID < 1 || tempID > 3 );
                tempID--; // correct to match the array indices
                
                // Request customer select quantity of selected bulb
                do {
                    System.out.printf("%nPlease enter the number of %ss you would like to purchase.%n\tEnter QTY here: ", productID[1][tempID]);
                    while (!input.hasNextInt()) { // if the user does not enter an int
                        String str = input.next(); // assign the entered line as a string 
                        System.out.printf("\"%s\" is not a valid quantity.\n", str); //
                        System.out.printf("%nPlease enter the number of %ss you would like to purchase.%n\tEnter QTY here: ", productID[1][tempID]);
                        // not the kind of repetition your looking for
                    }
                    tempQty = input.nextInt(); // correct the product IDs to match the array indices
                } while (tempQty < 0); // validate the entries to ensure it matched a product ID
                
                plural = tempQty > 1 ? "s" : ""; // add an "s" to qty's bigger than 1 

                // clear scanner
                input.nextLine(); // apparently there was an empty String hiding out in the scanner, I think this clears it
                
                // Request customer confirmation of selection
                while (!confirmItem.matches("[ynYN]")) {
                    // allow customer to verify that the order is correct
                    System.out.printf("%nYou have selected %d %s%s. Please confirm by entering Y or cancel with N.%n\tConfirm order here: ", tempQty, productID[1][tempID], plural);
                    confirmItem = input.nextLine().toLowerCase();
                    if (confirmItem.matches("[yY]")) { // validate for yY
                        cart[0][cartIndex] = tempID; // add item to cart
                        cart[1][cartIndex] = tempQty; // add qty to cart
                        cartIndex++; // iterate cart index 
                        System.out.printf("%nYou have added %d %s%s to your cart.", tempQty, productID[1][tempID] ,plural);
                    } else if (confirmItem.matches("[nN]")) { // verify operation completed / canceled
                        System.out.printf("%nYou have NOT added %d %s%s to your cart.", tempQty, productID[1][tempID] ,plural); 
                    }
                }

                if (cartIndex > 14) finishedShopping = true; // the array only holds 15 items, the sale will complete autonatically at this point
                tempID = -1; // reset for the next order
                tempQty = 0; // reset for the next order
                
                for (int i = 0; i <= (cartIndex-1); i++){ // iterate through cart items, cart index = line items
                    cartTotalItems += cart[1][i]; // add all qtys together for total products ordered
                }
                System.out.printf("%n%nYour shopping cart contains %d item%s.%nQty\tDescription\t\tPrice\t    Total%n-------------------------------------------------", cartTotalItems, plural);
                for (int i = 0; i <= (cartIndex-1); i++){
                    // 
                    System.out.printf("%n%s\t%s\t$%4.2f\t$%8.2f",cart[1][i], productID[1][cart[0][i]], productPrice[cart[0][i]], (cart[1][i] * productPrice[cart[0][i]]));
                }
                System.out.printf("%n-------------------------------------------------");
                cartTotalItems = 0;
                
                // Request customer to continue shopping
                while (!continueShopping.matches("[ynYN]")) {  // will only accept y or Y or n or N  for input, y or Y closes this loop and returns to the outer loop
                    System.out.printf("%nWould you like to continue shopping?%n\tEnter Y or N Here: ");
                    continueShopping = input.nextLine().toLowerCase();
                    if (continueShopping.matches("[nN]")) {
                        finishedShopping = true; // n or N closes the outer loop and send the customer to checkout
                    }
                }
            }
        }

        finally {
            input.close();
        }

        // count items in the cart and total all items
        for (int i = 0; i <= (cartIndex-1); i++){ // iterate through cart items, cart index = line items
            cartTotalItems += cart[1][i]; // add all qtys together for total products ordered
            subTotal += (cart[1][i] * productPrice[cart[0][i]]); // calculate extended prices and add them together
        }
        
        // Calc discounts: 10% for buying 5 to 7 bulbs, 15% for buying 8 or 9, and 20% for 10 or more.
        discount = cartTotalItems > 9 ? 0.20 : cartTotalItems > 7 ? 0.15 : cartTotalItems > 4 ? 0.10 : 0.00; // nested ternary operators calculate the discount
        // Shipping and handling is $5.00 for orders costing less than $15.00. Eligibility for free shipping is determined after discounts have been applied.
        shippingCost = (subTotal-(subTotal * discount)) < 15 ? 5 : 0; 
        // System.out.print(" DEBUGGER shippingCost = " + shippingCost);
        // 
        grandTotal = (subTotal-(subTotal * discount) + shippingCost);
        System.out.printf("%n%nYour shopping cart contains %d item%s.%nQty\tDescription\t\tPrice\t    Total%n-------------------------------------------------", cartTotalItems, plural);
        for (int i = 0; i <= (cartIndex-1); i++){
            // 
            System.out.printf("%n%s\t%s\t$%4.2f\t$%8.2f",cart[1][i], productID[1][cart[0][i]], productPrice[cart[0][i]], (cart[1][i] * productPrice[cart[0][i]]));
        }
        System.out.printf("%n-------------------------------------------------");
        System.out.printf("%nPrice of products\t\t\t$%8.2f%nDiscount %2.0f%%\t\t\t\t$%8.2f%nNet purchase amount\t\t\t$%8.2f%nShipping cost\t\t\t\t$%8.2f%nTotal\t\t\t\t\t$%8.2f%n", subTotal, discount * 100, subTotal * discount, subTotal-subTotal * discount, shippingCost, grandTotal);
        System.out.printf("-------------------------------------------------%n");
    }
}

