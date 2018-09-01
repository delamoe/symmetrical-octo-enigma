/*
 * Class	:	KeepSafeParking.java
 *
 * Purpose 	:	HW1 Basics and Control Statements
 * 				10979 CIS131 Prog & Problem Solv II 
 *
 * Developer:	E de la Montaña
 *
 * Date		:	8/26/2018
 */

import java.util.Scanner;
		
public class KeepSafeParking {

	public static void main(String[] args){	
		String day = "Error";						// initialized to an incorrect day value in order to use a while loop for validation
		
		int arrival = 2599;							// initialized to an incorrect value in order to start a while loop for validation
		
		int depart = -99;							// initialized to an incorrect value in order to start a while loop for validation
		
		int chargePeriod = 15;						// hardcoded to make it easy to change later
		
		double chargePeriods = 0;					// zero is as good as any initialization
		
		int maxCharge = 15;							// hardcoding makes it easy to change later
		
		double rate = 1.25;							// hardcoding makes it easy to change later
		
		double charge = 0.00;
		
		Scanner scan = new Scanner(System.in);
		
		try 										// using try to enable closing the Scanner with finally at program completion
		{
			while (day.equals("Error")) 
				{
				System.out.print("Please enter the day of the week : ");	// should result in a three letter day code
																			//	user can enter three letter or fully spelled days
				day = scan.nextLine();
				
				switch (day.toLowerCase()) {								// set input value to lower case in order to more easily parse day values
					case "mon": day = "Mon"; break;							// this whole bit of logic should be broken out into a separate reusable												//	component
					case "tue": day = "Tue"; break;
					case "wed": day = "Wed"; break;
					case "thu": day = "Thu"; break;
					case "fri": day = "Fri"; break;
					case "sat": day = "Sat"; break;
					case "sun": day = "Sun"; break;
					default: System.out.print("Please use three letter day abbreviation: Mon, Tue, Wed, Thu, Fri, Sat or Sun\n");
											// a helpful statement for the user
							day = "Error";	// reset day var to keep the while loop going
						break;		
				}
			}
			
			if (day.startsWith("S"))		// set the weekend rate using the entered and validated day value
				rate = 0.50;

											// the initialized arrival value will start the loop which exits when a correct value is entered
			while (							// arrival should be an integer validated between 0 (0000) and 2358
				  ((arrival % 100) > 59) 		// arrival minutes cannot be greater than 59
				|| (arrival > 2358)			// arrival hours cannot be greater than 2358 (one minute is minimum charge)
				|| (arrival < 0)) 			// arrival hours cannot be less than zero
				{ 
				System.out.print("Please enter the vehicle’s arrival time as HHMM : ");
				arrival = scan.nextInt();	// java is accepting numbers with leading zeros without any errors, find out why
				}
				
			while (
					(depart <= arrival)		// departure time must be greater than arrival 
				|| ((depart % 100) > 59)	// departure minutes cannot be greater than 59
				|| ( depart > 2400))		// departure hours cannot be reater than 2400
				{
				System.out.print("Please enter the vehicle’s departure time as HHMM : ");
				depart = scan.nextInt();
				if (depart <= arrival) {
					System.out.print("Make certain the the departure time is later than arrival.\n");
					}
				}				

			int arrivalMinutes = arrival % 100;								// the remainder of arrival divied by 100 results in the minutes
						
			int arrivalHours = ((arrival - arrivalMinutes) / 100) * 60;		// subtracting the minutes from the hours and results in whole hours
																				// multiplying by 60 results in minutes
			int departMinutes = depart % 100;
			
			int departHours = ((depart - departMinutes) / 100) * 60;
			
			int duration = (departHours + departMinutes)					// the *Hours values here have already been converted to minutes
						- (arrivalHours + arrivalMinutes);						// duration is the difference between them
			
			chargePeriods = ((duration % chargePeriod) > 0)					// if there is a remainder then add one more period
				? (int) (duration / chargePeriod) + 1						// typecasting will strip the floating point (round down)
				: (int) (duration / chargePeriod);								// so add one more after converting to int
																			// if no remainder then only a zero is stripped
			
			charge = ((chargePeriods * rate) < maxCharge)					// assign the amount charge only if is less than $15
				? (chargePeriods * rate)										// otherwise use maxcharge
				: maxCharge;			
		
			// System.out.print("Day of Week: " + day + 
			// 				"\nParking duration in minutes: " + duration + 
			// 				", rate: $" + rate + 
			// 				"\nAmount charged: $" + charge + "\n");
			
			System.out.printf("%nDay of Week: %s %nParking duration in minutes: %d, rate: $%-2.2f%nAmount charged: $%-2.2f%n%n", day, duration, rate, charge);
		}
		finally 
		{
			scan.close();													// fixed "Resource leak: 'scan' is never closed" error
		}
	}
}


