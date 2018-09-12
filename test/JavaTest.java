import java.util.Scanner;

public class JavaTest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // int arrival = 2599;
        // String message = "Awesome";
        // String pattern = "\\d{3,4}";

        // while (((arrival % 100) > 59) || (!String.valueOf(arrival).matches(pattern)))
        // { // the incorrect initialized value will start this loop, user exits when a
        // correct value is entered
        // System.out.print("Please enter the vehicle’s arrival time as HHMM : ");
        // arrival = scan.nextInt(); // fix this for user input less than 3 characters
        // }

        // System.out.print(message + "\n");

        /*
         * double radius = 0.0; //final double pi = 3.14;
         * 
         * while ((radius <= 0) && (!Pattern.matches("[0-9]+(\\.){0,1}[0-9]*", radius)))
         * { System.out.print("Please type in the radius\n:"); radius =
         * scan.nextDouble(); } double area = radius*radius*Math.PI;
         * System.out.printf("\nThe area is %f square units\n", area);
         */



         double s =  2.0000;//1.9543;//
         double s10000 = s * 10000;
         double e =  4.0000;//3.2547;//
         double e10000 = e * 10000;
         double inc = .2000;// .1568;//
         double inc10000 = inc * 10000;
         int incrementInteger = (int) ( (e-s)/inc );
         int incrementAddOne =  (e10000-s10000)%inc10000 > 0 ? 1 : 0 ;

         System.out.printf("(e-s)/inc = %f%n(e-s)%%inc = %f%nactual incs = %d%n", (e-s)/inc, (e-s)%inc, incrementInteger + incrementAddOne);

    }
}