/*
** Program	: MainDriver.java
**
** Purpose	: To declare and instantiate objects of various derived clases of a common base class. 
**
**			  In this example, the various derived classes -- HourlyEmployee, SalaryEmployee and 
**			  CommissionEmployee -- inherit the attributes and methods of the base Employee class, 
**			  then add their own specialized attributes and methods for handling them. They also
**			  have their own overridden versions of the toString method. 
**
**			  Note that we've declared the base class, Employee, as abstract because it makes no sense
**			  to create an object of the Employee since it is too abstract. How would we calculate
**			  pay for a generic employee? We know how to do it for salary, hourly and commission
**			  employees.
**
			  In order for polymorphism to work, it needs to have abstract methods which its derived classes 
**			  must override or empty methods which they can override if they need to. Study the base and 
**			  derived classes carefully.
**
**
** F. D'Angelo
**/

import java.util.Vector;

public class MainDriver implements GlobalConstants
{
	public static void main(String[] args)
	{
		// Here we declare and instantiate an empty vector of the base class.

		Vector<Employee> employeeVector = new Vector<Employee>();

		// Polymorphism: declare an object as belonging to a base class,
		// but instantiate it as a member of a derived class.

    		Employee empOne = new  SalaryEmployee("jones", "samantha", 5000, BIWEEKLY);

		empOne.setBonus(250);

    		empOne.calcPay();

    		employeeVector.add( empOne) ;

    		Employee empTwo = new HourlyEmployee ("worker", "ima", 12.00, HOURLY) ;

    		empTwo.setHoursWorked( 40);

    		empTwo.calcPay();

    		employeeVector.add( empTwo) ;

    		Employee empThree = new HourlyEmployee ("striver", "steve", 10.00, HOURLY) ;

    		empThree.setHoursWorked( 50);

    		empThree.calcPay();

    		employeeVector.add( empThree) ;

    		Employee empFour = new CommissionEmployee("sells", "sue", 500.00, BIWEEKLY_PLUS_COMMISSION) ;

    		empFour.setCommissionBase(25000.00);

    		empFour.setCommissionRate(.05);

    		empFour.setCommissionAmount();

    		empFour.calcPay();

    		employeeVector.add( empFour) ;

		// When Java executes the toString method below, it will invoke the 
		// overridden version related to the derived class, not the base class.
		// Think of the following statement as saying:
		// for each Employee object, which we named emp, in the employeeVector

		for ( Employee emp: employeeVector)
		{
			System.out.println(emp.toString() + "\n") ;
		}
	}
}
