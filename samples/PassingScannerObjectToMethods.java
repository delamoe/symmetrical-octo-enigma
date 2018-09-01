/**********************************************************************
* File Name:	PassingScannerObjectToMethods.java
* Author: 	FMD
* Date: 	9/5/14
*
* Purpose: 	As this partial program shows, you can declare and instantiate 
*		a Scanner object, like any other object, once in main and pass 
*		it to the other methods that need it.
*
**********************************************************************/

import java.util.*;

public class PassingScannerObjectToMethods 
{
  public static void main(String[] args)
  {

    //create instance of scanner class
    Scanner input = new Scanner(System.in);

    //declare variables

    double dWeight, dCost;

    int iDistance;
      
    //call functions to prompt user for weight and distance

    dWeight = getWeight(input); 	// pass Scanner object to getWeight.

    iDistance = getDistance(input); 	// pass Scanner object to getDistance.
    
    // etc., etc.

  }//end of main module
  
  

  public static double getWeight(Scanner input) // getWeight receives Scanner object as parameter.
  {
    
    // etc. etc.

  }
  
  public static int getDistance(Scanner input) // getDistance receives Scanner object as parameter.
  {    
    // etc., etc.

  }
  
