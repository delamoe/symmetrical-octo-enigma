import java.util.*;

public class LeapYear{
    public static void main(String[] args){
        //Create a scanner
        Scanner input = new Scanner(System.in);
        
        System.out.print("\nEnter a year: ");
        int year = input.nextInt();
        
        // a leap year is (divisable by 4 and not divisible by 100) or (divisable by 400)
        boolean isLeapYear = (
            (year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0)
            );

        // assign string value from boolean using ternary operator
        String answer = isLeapYear ? "is" : "is not";

        System.out.printf("%n%d %s a leap year.%n", year, answer);
    }
}

/*
    * delamoe@Delamo-Lenovo:~/eclipse-workspace/Exercises$ java LeapYear
    * 
    * Enter a year: 2008
    * 
    * 2008 is a leap year.
    * delamoe@Delamo-Lenovo:~/eclipse-workspace/Exercises$ java LeapYear
    * 
    * Enter a year: 1900
    * 
    * 1900 is not a leap year.
    * delamoe@Delamo-Lenovo:~/eclipse-workspace/Exercises$ java LeapYear
    * 
    * Enter a year: 2002
    * 
    * 2002 is not a leap year.
*/