/*
** Program	: HourlyEmployee.java
**
** Purpose	: To declare the properties and define the methods of the HourlyEmployee class which is derived from the Employee base class.
**
** F. D'Angelo
**/

class HourlyEmployee extends Employee
{
    	private double hoursWorked = 0.0 ;
    	private double regularPay = 0.0 ;
	private double overtimePay = 0.0 ;

	public HourlyEmployee(String lastName, String firstName, double payRate, int payPeriod) 
    	{ 
		super( lastName,  firstName,  payRate,  payPeriod); // pass these parms to the Employee constructor
	}

	public void setHoursWorked(double hoursWorked)
	{
    		this.hoursWorked = hoursWorked ;
	}

	public double getHoursWorked()
	{
    		return hoursWorked ;
	}

	public void calcPay()
	{
    		if (hoursWorked <= REGULAR_HOURS )
    		{
        		regularPay = hoursWorked * getPayRate() ; // payRate has private access in Employee; we must use a public method to retrieve it.
			overtimePay = 0.0;
    		}

    		else
    		{
			regularPay = (REGULAR_HOURS * getPayRate());
			overtimePay = (OVERTIME_FACTOR * getPayRate() * (hoursWorked - REGULAR_HOURS));
    		}

		setPay(regularPay + overtimePay); // 
	}

	public String toString()
	{
		// Include the base class toString to display base class variables.
        	StringBuffer strBuf = new StringBuffer(super.toString());
		strBuf.append("\nHours worked      : "); 
		strBuf.append(hoursWorked); 
		strBuf.append("\nRegular pay       : ");
		strBuf.append( regularPay );
		strBuf.append("\nOvertime pay      : ");
		strBuf.append( overtimePay);
		strBuf.append("\n") ;

    		return strBuf.toString() ;

	}

}
