/*
     * Class	:	HW5OneDimArraySynchronizedWithTwoDimArray.java
     *
     * Purpose 	:	HW 5 One Dim Array Synchronized with Two Dim Array.java
     * 				10979 CIS131 Prog & Problem Solv II 
     *
     * Developer:	E de la Montaña
     *
     * Date		:	9/23/2018
     */

public class HW5OneDimArraySynchronizedWithTwoDimArray {
    public static void main(String[] args) {
        int[] employeeIdArray = new int[6];
        double[][] payrollArray = new double[2][6];
        populateEmployeeIds(employeeIdArray);
        populatePayrollArray(payrollArray);
        printResult(employeeIdArray, payrollArray, calculateWages(employeeIdArray, payrollArray));
    }

    public static void populateEmployeeIds(int[] arr) {
        // this seems odd, wouldn't it be better to just
        // instantiate the array with the data in the first place?
        int[] ids = { 100, 200, 300, 400, 500, 600 };
        /* arr = ids; // result in { 0,0,0,0,0,0 } */
        /* arr[0] = ids; // HW5OneDimArraySynchronizedWithTwoDimArray.java:25:
                         // error: incompatible types: int[] cannot be converted
                         // to int arr[0] = ids; */
        /*  If I instantiate a 2d array in the main:
            (int[][] employeeIdArray = new int[1][6];)
            then arr[0] = ids; works fine.*/
        for (int i = 0; i < arr.length; i++) {
            arr[i] = ids[i];
        }
    }

    public static void populatePayrollArray(double[][] arr) {
        // this seems odd, wouldn't it be better to just
        // instantiate the array with the data in the first place?
        double[] hoursWorked = { 50.00, 15.00, 48.00, 40.00, 40.00, 45.00 };
        double[] payRate = { 25.00, 15.00, 27.00, 25.00, 23.00, 10.00 };
        // Why can assign the primitive to values in the 2d array but not in the 1d array
        arr[0] = hoursWorked;
        arr[1] = payRate;
    }

    public static double[][] calculateWages(int[] ids, double[][] hoursAndRates) {
        double[][] wagesArray = new double[ids.length][3];
        // I explored ways to accomplish using a nested loop
        // but each attempt required more code than this
        for (int i = 0; i < wagesArray.length; i++) {
            wagesArray[i][0] = hoursAndRates[0][i] > 40 ? 40 * hoursAndRates[1][i]
                    : hoursAndRates[0][i] * hoursAndRates[1][i];
            wagesArray[i][1] = hoursAndRates[0][i] > 40 ? (hoursAndRates[0][i] - 40) * hoursAndRates[1][i] * 1.5 : 0;
            wagesArray[i][2] = wagesArray[i][0] + wagesArray[i][1];
        }
        return wagesArray;
    }

    public static void printResult(int[] ids, double[][] hoursAndRates, double[][] wagesArray) {
        System.out.printf("\n☺\t\t Hours\t\t\t  Regular\t  Overtime\t   Total   ☺"
                + "\n☺ Employee ID\tWorked\tPay Rate\t Gross Pay\t Gross Pay\t Gross Pay ☺"
                + "\n☺ ☺  ☺ ☺  ☺ ☺  ☺ ☺  ☺ ☺  ☺ ☺  ☺ ☺  ☺ ☺  ☺  ☺  ☺ ☺  ☺ ☺  ☺ ☺  ☺ ☺  ☺ ☺  ☺ ☺  ☺ ☺  ☺ ☺");
        for (int i = 0; i < wagesArray.length; i++) {
            System.out.printf("\n☺% d\t\t%4.2f\t$% 4.2f\t\t$%, 9.2f\t$%, 9.2f\t$%, 9.2f ☺", ids[i],
                    hoursAndRates[0][i], hoursAndRates[1][i], wagesArray[i][0], wagesArray[i][1], wagesArray[i][2]);
        }
        System.out.printf("\n☺ ☺  ☺ ☺  ☺ ☺  ☺ ☺  ☺ ☺  ☺ ☺  ☺ ☺  ☺ ☺  ☺  ☺  ☺ ☺  ☺ ☺  ☺ ☺  ☺ ☺  ☺ ☺  ☺ ☺  ☺ ☺  ☺ ☺\n");
    }
}