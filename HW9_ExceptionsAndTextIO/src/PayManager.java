
/*
 * Class    : PayManager.java
 *
 * Purpose  : HW9 - Exceptions and Text IO Output
 *            10979 CIS131 Prog & Problem Solv II
 *
 * Developer: E de la Montaña
 *
 * Date : 10/23/2018
 */

import java.io.File;
import java.util.InputMismatchException;
import java.util.List;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PayManager {
  public static void main(String[] args) {
    final String FILE_NAME = "payroll.dat";
   
    Scanner inputFile = null;

    try {
      inputFile = new Scanner(new File(FILE_NAME));

    } catch (FileNotFoundException ex) {
      System.out.println("\n *** Exception occured while opening " + FILE_NAME + " -- " + ex.getMessage() + " ***");

      System.exit(-1);
    }
    readData(inputFile, FILE_NAME);

  }

  static void readData(Scanner inputFile, final String FILE_NAME) {
    int employeeID;
    String lastName;
    String firstName;
    double hours;
    double payRate;

    while (inputFile.hasNext()) {
      try {
        employeeID = inputFile.nextInt();
        lastName = inputFile.next();
        firstName = inputFile.next();
        hours = inputFile.nextDouble();
        payRate = inputFile.nextDouble();

        displayData(calcPay(employeeID, lastName, firstName, hours, payRate));

      } catch (InputMismatchException ex) {
        System.out
            .println("\n *** Data in " + FILE_NAME + "doesn't match expected format -- " + ex.toString() + " ***");
        inputFile.close();

        System.exit(-1);
      }
    }

    inputFile.close();
  }

  static String calcPay(int employeeID, String lastName, String firstName, Double hours, Double payRate) {

    final double OT_MULTIPLIER = 1.5;
    double regularHours = hours >= 40 ? 40 : hours;
    double regularPay = regularHours * payRate;
    double overtimeHours = hours <= 40 ? 0 : hours - 40;
    double overtimePay = overtimeHours * payRate * OT_MULTIPLIER;
    double totalPay = regularPay + overtimePay;

    return String.format("%d\t%8s, %-6s\t$%7.2f\t$%7.2f\t$%8.2f\t$%8.2f\t$%8.2f%n", employeeID, lastName, firstName,
        hours, payRate, regularPay, overtimePay, totalPay);
  }

  static void displayData(String str) {
    System.out.printf("%s", str);

  }
}