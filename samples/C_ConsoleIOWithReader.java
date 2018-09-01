/*
 * Class    : ConsoleIOWithReader.java
 * Purpose  : To demonstrate using InputStreamReader and BufferedReader
 *            to obtain keyboard input.
 * Developer: F DAngelo
 * Date     : 2/26/2014
 */



import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
/**
 *
 * @author fmdangelo
 */
public class C_ConsoleIOWithReader 
{

    public static void main(String[] args) 
    {
        InputStreamReader isr = new InputStreamReader(System.in);
        
        BufferedReader br = new BufferedReader( isr);
        
        double doubleValue = 0.0 ;
        
        int intValue = 0 ;
        
        String stringValue = "" ;
        
        try
        {
            System.out.print("\nEnter an integer : ");
            intValue = Integer.parseInt(br.readLine()); // Must convert String returned by br.readLine() to int.
            
            System.out.print("\nEnter a double : ");
            doubleValue = Double.parseDouble(br.readLine()); // Must convert String returned by br.readLine() to double.
            
            System.out.print("\nEnter a string : ");
            stringValue = br.readLine(); // Since br.readLine() returns a String, there's no need to convert anything.
            
            System.out.printf("\n%nYou entered an int %d, a double %012.30f and a String %s %n\n", 
                                intValue, doubleValue, stringValue );
        }
        
        catch (IOException ex)
        {
            System.out.println("\nAn IOException occurred, " + ex.getMessage() + ", while reading input.\n" );
        }
        
        catch (NumberFormatException ex)
        {
            System.out.println("\nThe input doesn't match the data type, " + ex.getMessage() + ", while reading input.\n" );
        }
        
        finally
        {
            try
            {
                br.close();
            }
            
            catch( IOException ex)
            {
                System.out.println("\nError closing the Scanner object, " + ex.getMessage() + ", while reading input.\n" );
            }
        }
    }
    
}
