/*

* Program       : F_Mallmart.cpp

* Purpose       : To introduce us to a simple Java program.

* Programmer    : F DAngelo

* Date          : 8/13/2014

*/

import java.util.Scanner;

public class F_Mallmart
{
	public static void main(String[] args)

	{
		Scanner scannerObj = new Scanner(System.in);

		String inputValue = "";

		double cost = 0.0 ;

		double markupRate = 0.0 ;

		double markupAmt = 0.0 ;

		double price = 0.0 ;

		System.out.print("\n\nEnter a cost for this item: ") ;

		inputValue = scannerObj.nextLine();

		cost = Double.parseDouble(inputValue);

		System.out.print("\nEnter a markup rate for this item: ") ;

		inputValue = scannerObj.nextLine();

		markupRate = Double.parseDouble(inputValue);

		markupAmt = cost * markupRate ;

		price = cost + markupAmt ;

		System.out.print("\n\nThe price for this item is " + price + "\n\n") ;

	}

}
			
