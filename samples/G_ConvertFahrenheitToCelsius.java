/* Class     : G_ConvertFahrenheitToCelsius
 * Purpose   : To demonstrate:
 * 				- Obtaining String input from Scnner object using its nextLine() method
 * 				- Converting String input to a double using Double.valueOf
 * 				- Performing a calculation
 * 				- Converting a double to a String
 * 				- Appending a number of Strings to a StringBuffer
 * 				- Displaying results using a pre-buit String
 * 
 * Programmer: F D'Angelo
 * Created   : 5/25/2013
 */

import java.util.Scanner;

public class G_ConvertFahrenheitToCelsius 
{
	public static void main(String[] args) 
	{
		Scanner scannerObj = new Scanner(System.in);
		
		String inputValue = new String();
		
		// Get input

		System.out.print("\n\nEnter a temperature in degrees Fahrenheit: ") ;
		
		inputValue = scannerObj.nextLine();
		
		double fahrenheitTemp = Double.valueOf(inputValue)  ; // We could have used Double.parseDouble(inputValue).
		
		double celsiusTemp = (5.0/9.0) * (fahrenheitTemp - 32.0) ; // notice using .0 to force Java to promote the results to a double.

		String outputMsg = "\n\n" + Double.toString(fahrenheitTemp) + " in degrees Fahrenheit is " + 
					Double.toString(celsiusTemp) + " in degrees Celsius.\n\n" ;
		
		System.out.print(outputMsg); // We're using a pre-constructed String.
	}
}


