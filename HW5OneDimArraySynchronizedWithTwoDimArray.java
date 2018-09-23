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
        printResult(calculateWages(employeeIdArray, payrollArray));
    }

    public static void populateEmployeeIds(int[] arr) {
        int[] ids = { 100, 200, 300, 400, 500, 600 };
        for (int i = 0; i < arr.length; i++) {
            arr[i] = ids[i];
        }
    }

    public static void populatePayrollArray(double[][] arr) {
        double[] hoursWorked = { 50.00, 15.00, 48.00, 40.00, 40.00, 45.00 };
        double[] payRate = { 25.00, 15.00, 27.00, 25.00, 23.00, 10.00 };
        arr[0] = hoursWorked;
        arr[1] = payRate;
    }

    public static double[][] calculateWages(int[] ids, double[][] hoursAndRates) {
        double[][] wagesArray = new double[ids.length][6];
        for (int i = 0; i < wagesArray.length; i++) {
            wagesArray[i][0] = ids[i];
            wagesArray[i][1] = hoursAndRates[0][i];
            wagesArray[i][2] = hoursAndRates[1][i];
            wagesArray[i][3] = hoursAndRates[0][i] > 40 ? 40 * hoursAndRates[1][i]
                    : hoursAndRates[0][i] * hoursAndRates[1][i];
            wagesArray[i][4] = hoursAndRates[0][i] > 40 ? (hoursAndRates[0][i] - 40) * hoursAndRates[1][i] * 1.5 : 0;
            wagesArray[i][5] = wagesArray[i][3] + wagesArray[i][4];
        }
        return wagesArray;
    }

    public static void printResult(double[][] wagesArray) {
        System.out.printf("%n🖇\t\t Hours\t\t\t Regular\t Overtime\t Total     🖇"
                + "%n🖇 Employee ID\tWorked\tPay Rate\t Gross Pay\t Gross Pay\t Gross Pay 🖇"
                + "%n🖇----------------------------------------------------------------------------------🖇");
        for (int i = 0; i < wagesArray.length; i++) {
            System.out.printf("%n🖇% 4.0f\t\t%4.2f\t$% 4.2f\t\t$%, 9.2f\t$%, 9.2f\t$%, 9.2f 🖇", wagesArray[i][0],
                    wagesArray[i][1], wagesArray[i][2], wagesArray[i][3], wagesArray[i][4], wagesArray[i][5]);
        }
        System.out.printf("%n🖇----------------------------------------------------------------------------------🖇%n");
    }
}
/*
delamoe@Delamo-Lenovo:~/symmetrical-octo-enigma$ javac HW5OneDimArraySynchronizedWithTwoDimArray.java
delamoe@Delamo-Lenovo:~/symmetrical-octo-enigma$ java HW5OneDimArraySynchronizedWithTwoDimArray

🖇                Hours                   Regular         Overtime        Total    🖇
🖇 Employee ID   Worked  Pay Rate        Gross Pay       Gross Pay       Gross Pay 🖇
🖇 〰〰〰〰〰〰〰〰〰〰〰〰〰〰〰〰〰〰〰〰〰〰〰〰〰〰〰〰〰〰〰〰〰〰〰〰〰〰〰〰🖇
🖇 100            50.00  $ 25.00         $ 1,000.00      $   375.00      $ 1,375.00🖇
🖇 200            15.00  $ 15.00         $   225.00      $     0.00      $   225.00🖇
🖇 300            48.00  $ 27.00         $ 1,080.00      $   324.00      $ 1,404.00🖇
🖇 400            40.00  $ 25.00         $ 1,000.00      $     0.00      $ 1,000.00🖇
🖇 500            40.00  $ 23.00         $   920.00      $     0.00      $   920.00🖇
🖇 600            45.00  $ 10.00         $   400.00      $    75.00      $   475.00🖇
🖇 〰〰〰〰〰〰〰〰〰〰〰〰〰〰〰〰〰〰〰〰〰〰〰〰〰〰〰〰〰〰〰〰〰〰〰〰〰〰〰〰🖇
*/