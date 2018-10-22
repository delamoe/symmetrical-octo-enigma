/*
** Program	: CommissionEmployee.java
**
** Purpose	: To declare the properties and define the methods of the CommissionEmployee 
**		  class which is derived from the Employee base class.
**
** F. D'Angelo
**/



class CommissionEmployee extends SalaryEmployee
{
	private double commissionRate ;

    	private double commissionBase ;

    	private double commissionAmount ;

	public CommissionEmployee()
    	{
		super( "",  "",  0.0,  0); // pass these parms into the SalaryEmployee constructor.
        	setSalary(0.0);
       		setBonus(0.0);
    	}

	public CommissionEmployee(String  lastName, String  firstName, double payRate, int payPeriod)
    	{
		super( lastName,  firstName,  payRate,  payPeriod); // pass these parms into the parent's constructor.
    	}
/*
	public void setSalary(double salary)
	{
    		super.setSalary(salary) ;
	}

	public void setBonus(double bonus)
	{
    		super.setBonus(bonus) ;
	}
*/
	public void setCommissionRate(double commissionRate)
	{
    		this.commissionRate = commissionRate ;
	}

	public void setCommissionBase(double commissionBase)
	{
    		this.commissionBase = commissionBase ;
	}

	public double getCommissionRate()
	{
    		return commissionRate ;
	}

	public double getCommissionBase()
	{
    		return commissionBase ;
	}

	public void setCommissionAmount()
	{
    		commissionAmount = commissionBase * commissionRate ;
	}

	public double getCommissionAmount()
	{
    		return commissionAmount ;
	}

	public void calcPay()
	{
    		setPay( getSalary() + commissionAmount) ;
	}

	public String  toString()
	{
		// Include the base class toString to display base class variables.
        	StringBuffer strBuf = new StringBuffer(super.toString());

		strBuf.append("\nCommission base   : " );
		strBuf.append(commissionBase);
		strBuf.append("\nCommission rate   : ");
		strBuf.append(commissionRate);
		strBuf.append("\nCommission amount : ");
		strBuf.append(commissionAmount);
		strBuf.append( "\n") ;
 
    		return strBuf.toString() ;
	}




}


