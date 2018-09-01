import java.util.*;

public class QuadraticEquation{
    public static void main(String[] args) {
        // initialize scanner
        Scanner input = new Scanner(System.in);

        //initialize vars
        // double a = 1.0, b = 3, c = 1;
        System.out.printf("%nInput three numbers:%n");
        double a = input.nextDouble();
        double b = input.nextDouble();
        double c = input.nextDouble();
        double r1 = (-b + Math.pow(Math.pow(b, 2) - (4 * a * c), 0.5)) / (2 * a);
        double r2 = (-b - Math.pow(Math.pow(b, 2) - (4 * a * c), 0.5)) / (2 * a);
        double discriminant = (Math.pow(b, 2) - (4 * a * c));

        if (discriminant > 0) {
            System.out.printf("%nThe equation has two roots %f and %f%n", r1, r2);                
        } else if (discriminant == 0) {
            System.out.printf("%nThe equation has one root %f%n", r2);
        } else {
            System.out.printf("%nThe equation has no real roots%n");
        }
    }    
}