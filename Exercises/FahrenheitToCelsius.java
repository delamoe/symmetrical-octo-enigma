import java.util.Scanner;

public class FahrenheitToCelsius
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        double fahrenheit = -459.67;
        double celsius = 0.0;
        final String DEGREE  = "\u00b0";

        while ((fahrenheit <= -459.67)) {
            System.out.print("Please enter the temperature in Fahrenheit : ");
            fahrenheit = scan.nextDouble();
            
        }
        celsius = (fahrenheit-32)*5/9;
        // celsius = ((fahrenheit-32)*(5/9));
        System.out.printf("%n%3.1f%s fahrenheit is the same as %3.1f%s Celsius%n", fahrenheit, DEGREE, celsius, DEGREE);
    }
}

/*
    Why does celsius = (fahrenheit-32)*5/9; work but not celsius = ((fahrenheit-32)*(5/9));?
    It compiles and runs either way, but the second way always results in zero no matter what the input.
    For what it's worth, it works either way in JavaScript (node).
*/