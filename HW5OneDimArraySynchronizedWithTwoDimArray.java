/*
 * Class	:	HW5OneDimArraySynchronizedWithTwoDimArray.java
 *
 * Purpose 	:	HW 5 One Dim Array Synchronized with Two Dim Array.java
 * 				10979 CIS131 Prog & Problem Solv II 
 *
 * Developer:	E de la Montaña
 *
 * Date		:	9/30/2018
 */
public class HW5OneDimArraySynchronizedWithTwoDimArray {
    public static void main(String[] args) {
        // Declare the employee and payroll arrays in the main method.
        int[] employeeIdArray = new int[6];
        double[][] payrollArray = new double[6][6];
        // Pass the employee array into a method that populates it with hardcoded employee IDs.
        populateEmployeeIDs(employeeIdArray, 100);
        // Pass the payroll array into a method that populates it with hardcoded hours worked and pay rates.
        // Remember that Java passes arrays by reference, so you don’t need to return an array.
        // Whatever changes a method makes to an array passed in as a parameter happen to the original array in the method that invokes it.
        populatePayrollarray(payrollArray);
        // After returning to main, pass the payroll array into another method that loops through it, calculates gross regular pay (based on 40 hours or less) for each employee and stores this value in the array’s gross regular pay column.
        // This method will also calculate gross overtime pay (based on hours over 40) for each employee and add regular pay and overtime pay to total gross pay. Again, calculate overtime pay as 1.5 * pay rate * hours over 40.
        // calculateWages(payrollArray);
        printResult(calculateWages(employeeIdArray, payrollArray));
        
    }
    public static void populateEmployeeIDs(int[] arr, int startID) {
        for (int i = 0 ; i < arr.length ; i ++ ) {
            arr[i] = (i + 1) * startID;
        }
    }
    public static void populatePayrollarray(double[][] arr) {
        double[] hoursWorked = {50.00, 15.00, 48.00, 40.00, 40.00, 45.00};
        double[] payRate = {25.00, 15.00, 27.00, 25.00, 23.00, 10.00};
        for (int i = 0 ; i < arr.length ; i ++ ) {
            arr[0][i] = hoursWorked[i];
            arr[1][i] = payRate[i];
        }
    }
    public static double[][] calculateWages(int[] ids, double[][] hoursAndRates) {
        double[][] wagesArray = new double[6][6];
        for (int i = 0; i < wagesArray.length; i++) {
            // for (int column = 0 ; column < wagesArray[i].length ; column ++ ) {
            wagesArray[i][0] = ids[i];
            wagesArray[i][1] = hoursAndRates[0][i];
            wagesArray[i][2] = hoursAndRates[1][i];
            wagesArray[i][3] = hoursAndRates[0][i] > 40 ? 40 * hoursAndRates[1][i] : hoursAndRates[0][i] * hoursAndRates[1][i];
            wagesArray[i][4] = hoursAndRates[0][i] > 40 ? (hoursAndRates[0][i] - 40) * hoursAndRates[1][i] * 1.5 : 0;
            wagesArray[i][5] = wagesArray[i][3] + wagesArray[i][4];

            // }
        }
        return wagesArray;
    }

    public static void printResult(double[][] wagesArray) {
        String printString = "";
        System.out.printf("%n|\t\t Hours\t\t\t Regular\t Overtime\t Total    |"
                + "%n| Employee ID\tWorked\tPay Rate\tGross Pay\tGross Pay\tGross Pay |"
                + "%n|---------------------------------------------------------------------------------|");
        for (int row = 0; row < wagesArray.length; row++) {
            // for (int column = 0; column < wagesArray[i].length; column++) {
                printString += String.format("%n|% 4.0f\t\t% 4.2f\t$% 4.2f\t\t$% 8.2f\t$% 8.2f\t$% 8.2f |",
                wagesArray[row][0], wagesArray[row][1], wagesArray[row][2], wagesArray[row][3], wagesArray[row][4], wagesArray[row][5]);
            // }
        }
        System.out.printf(
                "%s%n|---------------------------------------------------------------------------------|%n",
                printString);
    }
        
        /* 
        Avoid these common overtime errors:
        Calculating overtime pay using the total number of hours worked instead of just the number of hours above 40
        Forgetting to multiply overtime by 1.5
        After returning to main, pass both arrays into a display method which will output the employee’s ID, hours worked, pay rate, regular gross pay, overtime gross pay and total gross pay. Produce a well-aligned table like the following:
        
        |                 Hours               Regular     Overtime    Total   |
        |Employee ID     Worked  Pay Rate    Gross Pay   Gross Pay   Gross Pay|
        |---------------------------------------------------------------------|
        |100              50.00   25.00       1000.00     375.00      1375.00 |
        |200              15.00   15.00        225.00       0.00       225.00 |
        |300              48.00   27.00       1080.00     324.00      1404.00 |
        |400              40.00   25.00       1000.00       0.00      1000.00 |
        |500              40.00   23.00        920.00       0.00       920.00 |
        |600              45.00   10.00        400.00      75.00       475.00 |
        |---------------------------------------------------------------------|

        It takes some persistence to do this, but it can be done.
        Just upload the Java source code file which does not need to be compressed.

        */
}