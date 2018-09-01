/*
HW2 Repetition (100 pts.):

Create a merchandise order application that enables a user to order products from an online company.
This company, Brighter Lights, sells only three products – 13, 18 and 23 watt compact florescent light bulbs.
Here are the company’s sales policies:

1. Prices per bulb are: 13 watt bulb $1.50, 18 watt $3.00, 23 watt $4.00.
2. Discounts are available: 10% for buying 5 to 7 bulbs, 15% for buying 8 or 9, and 20% for 10 or more.
    Discounts are applied for any combination of bulbs. For instance, buying 2 13 watt bulbs, 2 18 watt bulbs and 1 23 watt bulb qualifies for the discount.
3. Shipping and handling is $5.00 for orders costing less than $15.00.
    Eligibility for free shipping is determined after discounts have been applied.

A customer may order one item or several items of the same type or a combination of different items.
To the extent possible, avoid using “magic” numbers in your programs, for instance, using a hard coded value like 0.10 or 5 is a magic number.
It’s better to create named constants that describe what these values represent rather than have unlabeled numbers in your code.
The application must perform the following tasks:
    Display a list of the available products showing a product ID, product descriptions and prices.
    Ask the user which product he/she wants to buy. The user will enter a product ID.
    Ask the user to enter the quantity of the product needed.
    Ask the user if he/she wants to buy another product. Accept ‘y’ or ‘Y’ for yes and ‘n’ or ‘N’ for no.
    If the user enters some other character, tell him/her it’s invalid and give them another chance to re-enter it.
    Figure out how to change the case of a character so that you only need to make one comparison, for instance, check only ‘y’ by lowercasing the input.
    When the user signals the end of an order by entering ‘n’ or ‘N’, the program will display the data for each product ordered, for instance:

        Product 1   :   13 watt bulb    unit price    :    $1.50 quantity   : 3   extended price    :   $ 4.50
        Product 3   :   23 watt bulb    unit price    :    $4.00 quantity   : 3   extended price    :   $12.00

        Price of products                                                                           :   $16.50
        Discount                                                                                    :   $ 1.65
        Net purchase amount                                                                         :   $14.85
        Shipping cost                                                                               :   $ 5.00
        Total                                                                                       :   $19.85

Use your expertise with printf to align the output nicely.
Create a test plan to include that handles a variety of scenarios – one product ordered, several of the same product, a number of different products, an order qualifying for free
shipping and one that doesn’t, etc.
You will upload your test file and your Java file compressed together in a zip or 7z file.
Be sure to use the assignment naming convention for your compressed file, for instance,
DAngelo HW2.zip. */