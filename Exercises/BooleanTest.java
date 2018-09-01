import java.util.*;

public class BooleanTest{
    public static void main(String[] args) {
        
        int x = 1;
        System.out.printf("3.18:%n");
        System.out.printf("(true)   && (3 > 4)   = %s%n",     (true)      &&     (3 > 4));
        System.out.printf("!(x > 0) && (x > 0)   = %s%n",     !(x > 0)    &&     (x > 0));
        System.out.printf("(x > 0)  || (x < 0)   = %s%n%n",   (x > 0)     ||     (x < 0));
        System.out.printf("(x != 0) || (x == 0)  = %s%n",    (x != 0)    ||     (x == 0));
        System.out.printf("(x >= 0) || (x < 0)   = %s%n",     (x >= 0)    ||     (x < 0));
        System.out.printf("(x != 1) == !(x == 1) = %s%n",   (x != 1)    ==     !(x == 1));

        System.out.printf("%n3.19:%n");
        // An expression that evaluates to true if 1 < num < 100
        int num = 45;
        System.out.printf("1 < %d < 100 = %s%n", num, (1 < num) && (num < 100));
        // An expression that evaluates to true if 1 < num2 < 100 OR num2 is negative
        int num2 = -1;
        System.out.printf("1 < %d < 100 or %d is negative = %s%n", num2, num2, (1 < num2 && num2 < 100) || (num2 < 0));

        System.out.printf("%n3.20:%n");
        // Write a boolean expression for |x-5| < 4.5
        System.out.printf("|x-5| < 4.5 = %s%n", (Math.abs(x-5) < 4.5));
        // Write a boolean expression for |x-5| > 4.5
        System.out.printf("|x-5| > 4.5 = %s%n", (Math.abs(x-5) > 4.5));

        System.out.printf("%n3.25:%n");
        int age = 15;
        System.out.printf("Write a boolean expression that evaluates to true if 13 < age < 18%n13 < %d < 18 = %s%n", age, (age > 13 && age < 18));

        System.out.printf("%n3.26:%n");
        int weight = 200, weight2 = 35, height = 150, height2 = 45;
        System.out.printf("Write a boolean expression that evaluates to true if weight > 50 OR height > 60%n");
        System.out.printf("%d > 50 or %d > 60 = %s%n", weight, height, (weight > 50 || height > 60));
        System.out.printf("%d > 50 or %d > 60 = %s%n", weight2, height2, (weight2 > 50 || height2 > 60));
        System.out.printf("%d > 50 or %d > 60 = %s%n", weight2, height, (weight2 > 50 || height > 60));
        System.out.printf("%d > 50 or %d > 60 = %s%n", weight, height2, (weight > 50 || height2 > 60));

        System.out.printf("%n3.27:%n");
        System.out.printf("Write a boolean expression that evaluates to true if weight > 50 AND height > 60%n");
        System.out.printf("%d > 50 and %d > 60 = %s%n", weight, height, (weight > 50 && height > 60));
        System.out.printf("%d > 50 and %d > 60 = %s%n", weight2, height2, (weight2 > 50 && height2 > 60));
        System.out.printf("%d > 50 and %d > 60 = %s%n", weight2, height, (weight2 > 50 && height > 60));
        System.out.printf("%d > 50 and %d > 60 = %s%n", weight, height2, (weight > 50 && height2 > 60));

        System.out.printf("%n3.28:%n");
        System.out.printf("Write a boolean expression that evaluates to true if weight > 50 OR height > 60 but not both%n");
        System.out.printf("%d > 50 exclusive or %d > 60 = %s%n", weight, height, (weight > 50 ^ height > 60));
        System.out.printf("%d > 50 exclusive or %d > 60 = %s%n", weight2, height2, (weight2 > 50 ^ height2 > 60));
        System.out.printf("%d > 50 exclusive or %d > 60 = %s%n", weight2, height, (weight2 > 50 ^ height > 60));
        System.out.printf("%d > 50 exclusive or %d > 60 = %s%n", weight, height2, (weight > 50 ^ height2 > 60));
    }
}