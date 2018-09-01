/*************************************************************************
 *  Program :  	S_PrintfDemo.java
 *  Purpose :  	To demonstrate how to use printf.
 *  Author  : 	F DAngelo
 *  Date    : 	September 24, 2013
 *************************************************************************/

public class S_PrintfDemo
{

    public static void main(String[] args) 
    {
        //declaring the variables

	String str = "Label : " ;

	int i1 = 123, i2 = 456 ;

	char c1 = 'x' ;

        double d1, d2, d3;
        
        d1 = 1.1 ;
        d2 = 2.22;
        d3 = 3.333;

        // Notice \t used to tab across the screen.
        // %8s   tells Java to display String in a space 8 characters wide.
        // %c    tells Java to display a character.
        // %4d   tells Java to display an int with 4 digits.
        // %5.1f tells Java to display a double or float with 5 digits total and 1 decimal place.
        // %5.2f tells Java to display a double or float with 5 digits total and 2 decimal places.
        // %5.3f tells Java to display a double or float with 5 digits total and 3 decimal places.
	// %n is a newline. Use it, not \n with printf.

        System.out.printf("\n\n str is %8s \t c1 is %c \t i1 is %4d \t i2 is %4d %n \t\t\t d1 is %5.1f \t d2 is %5.2f \t d3 is %5.3f %n", 
        		str, c1, i1, i2, d1, d2, d3 );
      }
  }