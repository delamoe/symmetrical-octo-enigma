/*
** Program	: Employee.java
**
** Purpose	: To declare the properties and define the methods of the Employee base class.
**
** F. D'Angelo
**/

public abstract class Employee implements GlobalConstants
{
	// These attributes apply to all employees regardless of whether their ay is salary, hourly or commission.
	private String lastName;
	private String firstName;
	private double payRate;
	private int payPeriod ;
	private double pay;

	public Employee()
	{
    		setLastName( "" );
    		setFirstName( "" );
    		setPayRate( 0.0 );
    		setPayPeriod( UNASSIGNED );
	}

	public Employee(String lastName, String firstName, double payRate, int payPeriod)
	{
    		setLastName( lastName );
    		setFirstName( firstName );
    		setPayRate( payRate );
    		setPayPeriod( payPeriod );
	}

	public void setLastName(String lastName)
	{
    		this.lastName = lastName;
	}

	public void setFirstName(String firstName)
	{
    		this.firstName = firstName;
	}

	public void setPayRate(double payRate)
	{
    		this.payRate = payRate;
	}

	public void setPayPeriod(int payPeriod )
	{
    	this.payPeriod = payPeriod;
	}

	public void setPay(double pay)
	{
    		this.pay = pay; 
	}

	public String getLastName()
	{
    		return lastName;
	}

	public String getFirstName()
	{
    		return firstName;
	}

	public double getPayRate()
	{
		return payRate;
	}

	int getPayPeriod()
	{
		return payPeriod;
	}

	public double getPay()
	{
		return pay;
	}

	// abstract and empty methods needed for polymorphism

	public abstract void calcPay(); // abstract method - all derived classes must implement this method.

	public void setSalary( double dbl){}; // dbl is just a placholder parm for an abstract method.

	public void setBonus( double dbl){}; // empty method. derived classes that need to override it will override it.

	public void setCommissionRate( double dbl){}; // empty method. derived classes that need to override it will override it.

	public void setCommissionBase( double dbl){}; // empty method. derived classes that need to override it will override it.

	public void setCommissionAmount(){}; // empty method. derived classes that need to override it will override it.

	public void setHoursWorked( double dbl){}; // empty method. derived classes that need to override it will override it.

	// end of abstract and empty methods needed for polymorphism


	public String toString()
	{
    		StringBuffer strBuf = new StringBuffer("\nEmployee data: \n") ;
		strBuf.append("\nName              : " ); 
		strBuf.append(lastName );
		strBuf.append(", " );
		strBuf.append(firstName); 
		strBuf.append("\nPay rate          : " );
		strBuf.append(payRate); 
		strBuf.append("\nPay period        : "); 
		strBuf.append(PAY_PERIOD_DESC[payPeriod] );
		strBuf.append("\nTotal pay         : ");
		strBuf.append(pay); 
		strBuf.append("\n");

    		return strBuf.toString();
	}

}
