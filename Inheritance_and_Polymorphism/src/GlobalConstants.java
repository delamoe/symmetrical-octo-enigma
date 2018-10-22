/*
** Program	: GlobalConstants.java
**
** Purpose	: To declare and assign values to global finalatns used by various classes.
**
** F. D'Angelo
**/

public interface GlobalConstants
{
	final int UNASSIGNED = 0;
	final int HOURLY = 1;
	final int WEEKLY = 2;
	final int BIWEEKLY = 3;
	final int MONTHLY = 4;
	final int BIWEEKLY_PLUS_COMMISSION = 5;

	final String[] PAY_PERIOD_DESC = { "UNASSIGNED", "HOURLY", "WEEKLY", "BIWEEKLY", "MONTHLY", "BIWEEKLY_PLUS_COMMISSION" };

	final int REGULAR_HOURS = 40;

	final double OVERTIME_FACTOR = 1.5 ;
}
