import java.util.Scanner;

public class JavaTest
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);

        // int arrival = 2599;
        // String message = "Awesome";
        // String pattern = "\\d{3,4}";

        // while (((arrival % 100) > 59) || (!String.valueOf(arrival).matches(pattern))) { // the incorrect initialized value will start this loop, user exits when a correct value is entered
        //     System.out.print("Please enter the vehicle’s arrival time as HHMM : ");
        //     arrival = scan.nextInt(); // fix this for user input less than 3 characters
        //     }

              
        // System.out.print(message + "\n");

       double radius = 0.0;
       //final double pi = 3.14;

       while ((radius <= 0) && (!Pattern.matches("[0-9]+(\\.){0,1}[0-9]*", radius))) {
           System.out.print("Please type in the radius\n:");
           radius = scan.nextDouble();
        }
        double area = radius*radius*Math.PI;
        System.out.printf("\nThe area is %f square units\n", area);



    }
}