import java.util.*;

public class HW2Repetition {
    public static void main(String[] args) {
        // Initialize Scanner class
        Scanner input = new Scanner(System.in);

        // Create product database
        // A multidimensional array to hold the product id,
        // desriptions and prices separately but with the same index
        // (maybe this is better done with an object instead???)
        String[][] productID = { { "1", "2", "3" },
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
                System.out.printf("%n%n     |-----------------------------------------|");
                System.out.printf("%n     | ID\tDescription\t\tPrice  |");
                System.out.printf("%n     |-----------------------------------------|");
                for (int i = 0; i <= productID.length; i++) {
                    System.out.printf("%n     | %s\t%s:\t$ %3.2f |", productID[0][i], productID[1][i], productPrice[i]);
                }
                System.out.printf("%n     |-----------------------------------------|%n");

                // Request customer to select type of bulb
                confirmItem = "";
                continueShopping = "";
                while (tempID < 1 || tempID > 3) {
                    // prompt user...
                    System.out.printf(
                            "%nPlease select a light bulb by entering the product ID 1, 2 or 3.%n\tEnter ID here: ");
                    // check in an int was entered
                    if (input.hasNextInt()) {
                        // if so assign it
                        tempID = input.nextInt();
                        // clear the trailing newline WT%$#!!!!!!!!!
                        input.nextLine();
                        // check if tempID is within params,
                        if (!(tempID < 4 && tempID > 0)) {
                            System.out.printf("%n%d is not valid!%n", tempID);
                        }
                    } else {
                        String str = input.nextLine().toString();
                        System.out.printf("%n\"%s\" is not valid!%n", str);
                    }
                }
                // correct input to match the array indices
                --tempID;

                // Request customer select quantity of selected bulb
                do {
                    System.out.printf(
                            "%nPlease enter the number of %ss you would like to purchase.%n\tEnter QTY here: ",
                            productID[1][tempID]);
                    // if the user does not enter an int
                    while (!input.hasNextInt()) {
                        // assign the entered line as a string
                        String str = input.next();
                        System.out.printf("\"%s\" is not a valid quantity.\n", str);
                        System.out.printf(
                                "%nPlease enter the number of %ss you would like to purchase.%n\tEnter QTY here: ",
                                productID[1][tempID]);
                        // not the kind of repetition your looking for
                    }
                    tempQty = input.nextInt();
                } while (tempQty < 1);

                plural = tempQty > 1 ? "s" : ""; // add an "s" to qty's bigger than 1

                input.nextLine(); // This clears the remaining line break left by .nextInt

                // Request customer confirmation of selection
                // with a regex to validate the response
                while (!confirmItem.matches("[ynYN]")) {
                    System.out.printf(
                            "%nYou have selected %d %s%s. Please confirm by entering Y or cancel with N.%n\tConfirm order here: ",
                            tempQty, productID[1][tempID], plural);
                    confirmItem = input.nextLine();
                    // validate for yYnN
                    if (confirmItem.matches("[yY]")) {
                        // add item to cart
                        cart[0][cartIndex] = tempID;
                        // add qty to cart
                        cart[1][cartIndex] = tempQty;
                        // iterate cart index so that items are not overwritten
                        cartIndex++;
                        System.out.printf("%nYou have added %d %s%s to your cart.", tempQty, productID[1][tempID],
                                plural);
                    // verify operation completed / canceled
                    } else if (confirmItem.matches("[nN]")) {
                        System.out.printf("%nYou have NOT added %d %s%s to your cart.", tempQty, productID[1][tempID],
                                plural);
                    }
                }

                tempID = -1; // reset for the next order
                tempQty = 0; // reset for the next order

                // Request customer to continue shopping
                // will only accept y or Y or n or N for input, y or Y closes this loop and returns to the outer loop
                while (!continueShopping.matches("[ynYN]")) {
                    System.out.printf("%nWould you like to continue shopping?%n\tEnter Y or N Here: ");
                    continueShopping = input.nextLine();
                    
                    if (continueShopping.matches("[nN]")) {
                        // n or N closes this and the outer loop and sends the customer to checkout
                        finishedShopping = true;
                    }
                }
                // count items in the cart and total all items
                // iterate through cart items, cart index = line items
                for (int i = 0; i <= (cartIndex - 1); i++) {
                    
                    // add all qtys together for total products ordered
                    cartTotalItems += cart[1][i];
                    
                    // calculate and add together extended prices
                    subTotal += (cart[1][i] * productPrice[cart[0][i]]);
                }

                // Calc discounts: 10% for buying 5 to 7 bulbs, 15% for buying 8 or 9, and 20%
                // for 10 or more.
                // nested ternary operators calculate the discount
                discount = cartTotalItems > 9 ? 0.20 : cartTotalItems > 7 ? 0.15 : cartTotalItems > 4 ? 0.10 : 0.00;
                
                // Shipping and handling is $5.00 for orders costing less than $15.00.
                // Eligibility for free shipping is determined after discounts have been applied.
                shippingCost = subTotal == 0 ? 0 : (subTotal - (subTotal * discount)) < 15 ? 5 : 0;
                
                grandTotal = (subTotal - (subTotal * discount) + shippingCost);

                String cartOrShipment = !finishedShopping ? "shopping cart" : "shipment";

                // Print cart update or invoice header, depending on finishedShopping state
                System.out.printf("%n%n   Your %s contains %d item%s.", cartOrShipment, cartTotalItems, plural);
                
                // If items in cart, print line items and extended prices
                if (subTotal > 0) {
                    System.out.printf("%n | Qty\tDescription\t\tPrice\t    Total |");
                    System.out.printf("%n |------------------------------------------------|");
                    for (int i = 0; i <= (cartIndex - 1); i++) {
                        System.out.printf("%n | %s\t%s\t$%4.2f\t$%8.2f |"
                        , cart[1][i], productID[1][cart[0][i]], productPrice[cart[0][i]], (cart[1][i] * productPrice[cart[0][i]]));
                    }
                    System.out.printf("%n |------------------------------------------------|");
                }

                // if shopping done, print invoice
                if (finishedShopping && subTotal > 0) {
                    System.out.printf("%n |------------------------------------------------|");
                    System.out.printf("%n | Price of products\t\t\t$%8.2f |", subTotal);
                    System.out.printf("%n | Discount %d%%\t\t\t\t$%8.2f |",(int) (discount * 100), subTotal * discount);
                    System.out.printf("%n | Net purchase amount\t\t\t$%8.2f |", subTotal - subTotal * discount);
                    System.out.printf("%n | Shipping cost\t\t\t$%8.2f |", shippingCost);
                    System.out.printf("%n | Total\t\t\t\t$%8.2f |", grandTotal);
                    System.out.printf("%n |------------------------------------------------|%n");
                }
                // cartTotalItems and subTotal will be recalculated in next iteration
                subTotal = cartTotalItems = 0;
            }
        }

        finally {
            input.close();
        }
    }
}
