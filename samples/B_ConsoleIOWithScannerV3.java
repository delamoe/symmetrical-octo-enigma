/*
 * Class    : B_ConsoleIOWithScannerV3.java
 *
 * Purpose  : To demonstrate using Scanner to obtain keyboard input.
 *            This example uses nextLine() to clear newlines or enter characters from the input stream.
 *
 *	      Notice that it catches NumberFormatException, which does not require an import, instead of InputMismatchException.;
 *
 * Developer: F DAngelo
 *
 * Date     : 9/1/2015
 */


import java.util.Scanner;

/**
 *
 * @author fmdangelo
 */
public class B_ConsoleIOWithScannerV3 
{

    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);

	String inputValue = "" ;
        
        double doubleValue = 0.0 ;

	double doubleValue2 = 0.0 ;
        
        int intValue = 0 ;

	int intValue2 = 0 ;
        
        String stringValue = "" ;

	String stringValue2 = "" ;
        
        try
        {
            System.out.print("\nEnter an integer : ");
            intValue = input.nextInt(); // Use nextLine method to read a String from the Scanner object.
	    input.nextLine(); // clear newline or enter character
            
            System.out.print("\nEnter a double : ");
            doubleValue = input.nextDouble(); // Use nextLine method to read a String from the Scanner object.
	    input.nextLine(); // clear newline or enter character

            System.out.print("\nEnter a string : ");
            stringValue = input.nextLine(); // Use nextLine method to read a String. 
                                            // It handles Strings containing spaces.

	    System.out.print("\nEnter another integer : ");
            intValue2 = input.nextInt(); // Use nextLine method to read a String from the Scanner object
            //intValue2 = Integer.parseInt( inputValue) ; // Use the parseInt method of the Integer class to convert the String to an int.
	    input.nextLine(); // clear newline or enter character

	    System.out.print("\nEnter another double : ");
            doubleValue2 = input.nextDouble(); // Use nextLine method to read a String from the Scanner object.
	    input.nextLine(); // clear newline or enter character

	    System.out.print("\nEnter another string : ");
            stringValue2 = input.nextLine();     // Use next method to read a String. 
                                                // It handles Strings containing spaces.
            
            System.out.printf("%n%nYou entered an int %d, a double %12.4f, a String %s, another int %d, another double %12.4f and another String %s %n%n", 
                                intValue, doubleValue, stringValue, intValue2, doubleValue2, stringValue2 );

	
        }
        
        catch (NumberFormatException ex)
        {
            System.out.println("\nInput value, " + inputValue + " read from the console doesn't match its data type, " + ex.getMessage() + ".\n" );
        }
    }
    
}
