/*
 * Class    : B_ConsoleIOWithScannerV2.java
 *
 * Purpose  : To demonstrate using Scanner to obtain keyboard input.
 *            This example reads all input as Strings using nextLine() which can handle String values containing spaces.
 *            Then it converts String input to int or double using the parse methods of the Integer and Double classes.
 *
 *	      Notice that it catches NumberFormatException, which does not require an import, instead of InputMismatchException.;
 *
 * Developer: F DAngelo
 *
 * Date     : 6/8/2014
 */


import java.util.Scanner;

/**
 *
 * @author fmdangelo
 */
public class B_ConsoleIOWithScannerV2 
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
            inputValue = input.nextLine(); // Use nextLine method to read a String from the Scanner object.
	    intValue = Integer.parseInt( inputValue) ; // Use the parseInt method of the Integer class to convert the String to an int.
            
            System.out.print("\nEnter a double : ");
            inputValue = input.nextLine(); // Use nextLine method to read a String from the Scanner object.
	    doubleValue = Double.parseDouble( inputValue) ; // Use the parseDouble method of the Double class to convert the String to a double.

            System.out.print("\nEnter a string : ");
            stringValue = input.nextLine(); // Use nextLine method to read a String. 
                                            // It handles Strings containing spaces.

	    System.out.print("\nEnter another integer : ");
            inputValue = input.nextLine(); // Use nextLine method to read a String from the Scanner object.
	    intValue2 = Integer.parseInt( inputValue) ; // Use the parseInt method of the Integer class to convert the String to an int.

	    System.out.print("\nEnter another double : ");
            inputValue = input.nextLine(); // Use nextLine method to read a String from the Scanner object.
	    doubleValue2 = Double.parseDouble( inputValue) ; // Use the parseDouble method of the Double class to convert the String to a double.

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
