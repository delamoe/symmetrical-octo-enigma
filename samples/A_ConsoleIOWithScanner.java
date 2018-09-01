/*
 * Class    : ConsoleIOWithScanner.java
 *
 * Purpose  : To demonstrate using Scanner to obtain keyboard input.
 *            This example has limitations; it uses next() which cannot handle String values containing spaces.
 *
 * Developer: F DAngelo
 *
 * Date     : 6/8/2014
 */


import java.util.Scanner;
import java.util.InputMismatchException;
/**
 *
 * @author fmdangelo
 */
public class A_ConsoleIOWithScanner 
{

    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        
        double doubleValue = 0.0 ;

	    double doubleValue2 = 0.0 ;
        
        int intValue = 0 ;

	    int intValue2 = 0 ;
        
        String stringValue = "" ;

	    String stringValue2 = "" ;
        
        try
        {
            System.out.print("\nEnter an integer : ");
            intValue = input.nextInt(); // Use nextInt method to read an int from the Scanner object.
            
            System.out.print("\nEnter a double : ");
            doubleValue = input.nextDouble(); // Use nextDouble method to read a double from the Scanner object.
            
            System.out.print("\nEnter a string : ");
            stringValue = input.next();     // Use next method to read a String. 
                                            // It doesn't handle Strings containing spaces.

	    System.out.print("\nEnter another integer : ");
            intValue2 = input.nextInt(); // Use nextInt method to read an int from the Scanner object.

	    System.out.print("\nEnter another double : ");
            doubleValue2 = input.nextDouble(); // Use nextDouble method to read a double from the Scanner object.

	    System.out.print("\nEnter another string : ");
            stringValue2 = input.next();     // Use next method to read a String. 
                                            // It doesn't handle Strings containing spaces.
            
            System.out.printf("%n%nYou entered an int %d, a double %12.4f, a String %s, another int %d, another double %12.4f and another String %s %n%n", 
                                intValue, doubleValue, stringValue, intValue2, doubleValue2, stringValue2 );

	
        }
        
        catch (InputMismatchException ex)
        {
            System.out.println("\nInput value read from the console doesn't match its data type, " + ex.getMessage() + ".\n" );
        }
    }
    
}
