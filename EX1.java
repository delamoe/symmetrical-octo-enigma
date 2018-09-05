/* EX 1 - Methods Exercise
Instructions
	

Fix the calcArea method shown below so that it will work with this invocation:

double areaOfRectangle = calcArea( side1, side2);

void calcArea( double length, double width )

{

      double area = length * width ;

} */

// The method needs to be called by a valid class
public class EX1 {
    // Every class needs a main method in order to function
    public static void main(String[] args) {
        // the parameters need assigned values
        double side1 = Math.rint(1 + Math.random() * 10),
                side2 = Math.rint(1 + Math.random() * 10);

        double areaOfRectangle = calcArea(side1, side2);
        // Without some output, the working method can't be seen to be working
        System.out.printf(
            "%nThe area of the rectangle with sides %2.0f & %-2.0f is %3.0f units\u00B2%n%n"
            , side1, side2, areaOfRectangle);

        // just for fun, use a method to print each rectangle
        System.out.printf("%s", drawRectangle((int)side1, (int)side2));
    }

    // return value type void cannot return a double
    // a modifier is required
    static double calcArea(double length, double width)

    {

        double area = length * width;
        // needs a return statement
        return area;

    }

    static String drawRectangle(int height, int width)
    {
        // initialize a counter to keep track of rows
        int count = 0;
        // and a string to return
        String rectangle = "";
        while (count < height) {
            for (int i = 0; i < width; i++) {
                if (i == 0 || count == height) {
                    rectangle += "\n* ";
                } else if (count == 0 || count == height - 1 || i == width - 1) {
                    rectangle += "* ";
                } else {
                    rectangle += "  ";
                }
                // System.out.printf("\ti = %d", i);
            }
            // System.out.printf("\tcount = %d", count);
            count++;
        }
        rectangle += "\n\n";
        return rectangle;
    }
}