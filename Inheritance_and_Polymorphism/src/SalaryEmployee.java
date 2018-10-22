/*
** Program	: SlaryEmployee.h
**
** Purpose	: To declare the proerties and methods of the SalaryEmployee class which is derived from the Employee base class.
**
** F. D'Angelo
**/

class SalaryEmployee extends Employee
{
	private double salary;
	private double bonus ; // salary employees may get an annual bonus.

	public SalaryEmployee(String lastName, String firstName, double payRate, int payPeriod)
	{
    		super( lastName,  firstName,  payRate,  payPeriod); // Pass these parameters to the Employee constructor.
		setSalary( payRate);
		setBonus(0.0);
	}

	public void setSalary(double salary)
	{
		this.salary = getPayRate(); // for salary employees, payRate s salary.
	}

	public double getSalary()
	{
		return getPayRate(); // for salary employees, payRate s salary.
	}


	public void setBonus(double bonus)
	{
		this.bonus = bonus;
	}


	public double getBonus()
	{
		return bonus;
	}

	// no need to override this because Employee handles it. double getPay()

	public void calcPay()
	{
		setPay(salary + bonus); // for a salary employee, pay is salary plus bonus. pay is private in Employee.
						// payRate has private access in Employee.
	}

	public String toString()
	{
		// Include the base class toString to display base class variables.
        	StringBuffer strBuf = new StringBuffer(super.toString());
		strBuf.append("\nPay period salary : " );
		strBuf.append(salary);
		strBuf.append("\nPay period bonus  : " );
		strBuf.append(bonus);
		strBuf.append( "\n") ;
 
    		return strBuf.toString() ;

	}
}

