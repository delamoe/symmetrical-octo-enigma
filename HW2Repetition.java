import java.util.*;

public class HW2Repetition {
    public static void main(String[] args) {
        // Initialize Scanner class
        Scanner input = new Scanner(System.in);

        // Create product database
        // A multidimensional array to hold the product id,
        // desriptions and prices separately but with the same index
        // (maybe this is better done with an object instead???)
        String[][] productID = {
            { "1", "2", "3" },
            { "13 watt Light Bulb", "18 watt Light Bulb", "23 watt Light Bulb" } };
        // --- how to map from String to Double? --- //
        double[] productPrice = { 1.5, 3.0, 4.0 };

        // Initialize a boolean to false in order to allow closing the loop later
        boolean finishedShopping = false;
        
        // Initialize a multidimensional array to use as
        // a shopping cart to hold product ID and QTY
        int[][] cart = new int[15][15];
        
        // incrementing on each added line item
        int cartIndex = 0;

        // use in a for loop with quantity to get total items and extended prices
        int cartTotalItems = 0;

        // non-valid values to get the while loops started
        int tempID = -1;
        int tempQty = 0;
        String confirmItem = "";
        String continueShopping = "";

        // I thought I read that I could initialize these
        // without assigning values, but it is not working...
        double subTotal = 0, discount = 0, shippingCost = 0, grandTotal = 0;
        
        // when qty is > 1, this will add an "s" to the prouct names
        String plural = "";


        try {
            // this loop will run until the boolean is true
            while (!finishedShopping) {
                
                // the array only holds 15 items, the loop
                // close at this point
                if (cartIndex > 13)
                    finishedShopping = true;
                
                // Print out product catalog using printf and a for loop to populate the lines
                // A little printf decoration to make it pretty
                System.out.printf(
                        "%n|--------------------------------------|%n| ID\tDescription\t\tPrice  |%n|--------------------------------------|%n");
                for (int i = 0; i <= productID.length; i++) {
                    System.out.printf("| %s\t%s:\t$ %3.2f |%n", productID[0][i], productID[1][i], productPrice[i]);
                }
                System.out.printf("|--------------------------------------|%n");

                // Request customer to select type of bulb
                do {
                    // reset these for the next order placed
                    confirmItem = "";
                    continueShopping = "";
                    // prompt user...
                    System.out.printf(
                        "%nPlease select a light bulb by entering the product ID 1, 2 or 3.%n\tEnter ID here: ");
                    
                    // Attempting some input validation here.
                    // if the user does not enter an int
                    while (!input.hasNextInt()) { 
                        // assign the entered line as a string
                        String str = input.nextLine();
                        // and print out an error message, then re-prompt
                        System.out.printf(
                                "\"%s\" is not a valid number.\n%nPlease select a light bulb by entering the product ID 1, 2 or 3.%n\tEnter ID here: ",
                                str);
                        input.next();
                    }
                    while (tempID < 1 || tempID > 3) { // validate the entries to ensure it matched a product ID
                        tempID = input.nextInt();
                        if (tempID < 1 || tempID > 3) {
                            System.out.printf(
                                    "%d is not a valid number.\n%nPlease select a light bulb by entering the product ID 1, 2 or 3.%n\tEnter ID here: ",
                                    tempID);
                            input.next();
                        }
                    }
                } while (tempID < 1 || tempID > 3);
                tempID--; // correct to match the array indices

                // Request customer select quantity of selected bulb
                do {
                    System.out.printf(
                            "%nPlease enter the number of %ss you would like to purchase.%n\tEnter QTY here: ",
                            productID[1][tempID]);
                    while (!input.hasNextInt()) { // if the user does not enter an int
                        String str = input.next(); // assign the entered line as a string
                        System.out.printf("\"%s\" is not a valid quantity.\n", str); //
                        System.out.printf(
                                "%nPlease enter the number of %ss you would like to purchase.%n\tEnter QTY here: ",
                                productID[1][tempID]);
                        // not the kind of repetition your looking for
                    }
                    tempQty = input.nextInt(); // correct the product IDs to match the array indices
                } while (tempQty < 0); // validate the entries to ensure it matched a product ID

                plural = tempQty > 1 ? "s" : ""; // add an "s" to qty's bigger than 1

                // clear scanner
                input.nextLine(); // apparently there was an empty String hiding out in the scanner, I think this
                                  // clears it

                // Request customer confirmation of selection
                while (!confirmItem.matches("[ynYN]")) {
                    // allow customer to verify that the order is correct
                    System.out.printf(
                            "%nYou have selected %d %s%s. Please confirm by entering Y or cancel with N.%n\tConfirm order here: ",
                            tempQty, productID[1][tempID], plural);
                    confirmItem = input.nextLine().toLowerCase();
                    if (confirmItem.matches("[yY]")) { // validate for yY
                        cart[0][cartIndex] = tempID; // add item to cart
                        cart[1][cartIndex] = tempQty; // add qty to cart
                        cartIndex++; // iterate cart index so that it's not overwritten
                        System.out.printf("%nYou have added %d %s%s to your cart.", tempQty, productID[1][tempID],
                                plural);
                    } else if (confirmItem.matches("[nN]")) { // verify operation completed / canceled
                        System.out.printf("%nYou have NOT added %d %s%s to your cart.", tempQty, productID[1][tempID],
                                plural);
                    }
                }

                
                tempID = -1; // reset for the next order
                tempQty = 0; // reset for the next order

                // Request customer to continue shopping
                // add validation here
                while (!continueShopping.matches("[ynYN]")) { // will only accept y or Y or n or N for input, y or Y
                                                              // closes this loop and returns to the outer loop
                    System.out.printf("%nWould you like to continue shopping?%n\tEnter Y or N Here: ");
                    continueShopping = input.nextLine().toLowerCase();
                    if (continueShopping.matches("[nN]")) {
                        finishedShopping = true; // n or N closes the outer loop and send the customer to checkout
                    }
                }
                // count items in the cart and total all items
                for (int i = 0; i <= (cartIndex - 1); i++) { // iterate through cart items, cart index = line items
                    cartTotalItems += cart[1][i]; // add all qtys together for total products ordered
                    subTotal += (cart[1][i] * productPrice[cart[0][i]]); // calculate extended prices and add them
                                                                         // together
                }

                // Calc discounts: 10% for buying 5 to 7 bulbs, 15% for buying 8 or 9, and 20%
                // for 10 or more.
                // nested ternary operators calculate the discount
                discount = cartTotalItems > 9 ? 0.20 : cartTotalItems > 7 ? 0.15 : cartTotalItems > 4 ? 0.10 : 0.00;
                // Shipping and handling is $5.00 for orders costing less than $15.00.
                // Eligibility for free shipping is determined after discounts have been
                // applied.
                shippingCost = (subTotal - (subTotal * discount)) < 15 ? 5 : 0;
                // System.out.print(" DEBUGGER shippingCost = " + shippingCost);
                //
                grandTotal = (subTotal - (subTotal * discount) + shippingCost);
                System.out.printf(
                        "%n%nYour shopping cart contains %d item%s.%nQty\tDescription\t\tPrice\t    Total%n-------------------------------------------------",
                        cartTotalItems, plural);
                for (int i = 0; i <= (cartIndex - 1); i++) {
                    //
                    System.out.printf("%n%s\t%s\t$%4.2f\t$%8.2f", cart[1][i], productID[1][cart[0][i]],
                            productPrice[cart[0][i]], (cart[1][i] * productPrice[cart[0][i]]));
                }
                System.out.printf("%n-------------------------------------------------");
                
                // cartTotalItems will be recalculated in next iteration
                cartTotalItems = 0;
                if (finishedShopping) {
                    System.out.printf(
                        "%nPrice of products\t\t\t$%8.2f%nDiscount %2.0f%%\t\t\t\t$%8.2f%nNet purchase amount\t\t\t$%8.2f%nShipping cost\t\t\t\t$%8.2f%nTotal\t\t\t\t\t$%8.2f%n",
                        subTotal, discount * 100, subTotal * discount, subTotal - subTotal * discount, shippingCost,
                        grandTotal);
                    System.out.printf("-------------------------------------------------%n");
                }
            }
        }

        finally {
            input.close();
        }
    }
}
