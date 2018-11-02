
/*
 * Class    : PayManager.java
 *
 * Purpose  : HW9 - Exceptions and Text IO Output
 *            10979 CIS131 Prog & Problem Solv II
 *
 * Developer: E de la Montaña
 *
 * Date     : 10/25/2018
 * 
 */

import java.io.File;
import java.util.InputMismatchException;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PayManager {
  public static void main(String[] args) {
    final String FILE_NAME = "payroll.dat";

    Scanner inputFile = null;
    ArrayList<String> outputData = new ArrayList<>();

    try {
      inputFile = new Scanner(new File(FILE_NAME));
      readData(inputFile, FILE_NAME, outputData);
      displayData(outputData);

    } catch (FileNotFoundException ex) {
      System.out.println("\n *** Exception occured while opening " + FILE_NAME + " -- " + ex.getMessage() + " ***");

      System.exit(-1);
    }
  }

  private static void readData(Scanner inputFile, final String FILE_NAME, ArrayList<String> outputData) {
    int employeeID;
    String lastName;
    String firstName;
    double hours;
    double payRate;

    while (inputFile.hasNext()) {
      try {
        employeeID = inputFile.nextInt();
        lastName = ProperName(inputFile.next());
        firstName = ProperName(inputFile.next());
        hours = inputFile.nextDouble();
        payRate = inputFile.nextDouble();
        outputData.add(calcPay(employeeID, lastName, firstName, hours, payRate));

      } catch (InputMismatchException ex) {
        System.out
            .println("\n *** Data in " + FILE_NAME + "doesn't match expected format -- " + ex.toString() + " ***");
        inputFile.close();

        System.exit(-1);
      }
    }

    inputFile.close();
  }

  private static String calcPay(int employeeID, String lastName, String firstName, Double hours, Double payRate) {

    final double REGULAR_HOURS = 40;
    final double OT_MULTIPLIER = 1.5;
    double regularHours = hours >= REGULAR_HOURS ? REGULAR_HOURS : hours;
    double regularPay = regularHours * payRate;
    double overtimeHours = hours <= REGULAR_HOURS ? 0 : hours - REGULAR_HOURS;
    double overtimePay = overtimeHours * payRate * OT_MULTIPLIER;
    double totalPay = regularPay + overtimePay;

    return String.format("💰  %d\t\t%10s, %-7s\t   %2.1f\t\t $%7.2f\t $%8.2f\t $%8.2f\t$%8.2f  💰\n", employeeID,
        lastName, firstName, hours, payRate, regularPay, overtimePay, totalPay);
  }

  private static void displayData(ArrayList<String> outputData) {
    String moneyBag = "💰";
    String headerText = String.format("%s %s\t%10s, %-10s\t%s\t%s\t%s\t%s\t%s  %s", moneyBag, "Emp ID", "Name: Last",
        "First", "Hours Worked", "Hourly Rate", "Regular Pay", "Overtime Pay", "Total Pay", moneyBag);
    String bills = "";
    for (int i = 0; i <= headerText.length() / 6; i++)
      bills += "💵💴💶💷";
    String moneyLine = String.format("%s%s%s", moneyBag, bills, moneyBag);
    String dataLines = "";
    for (String dataLine : outputData) {
      dataLines += dataLine;
    }
    System.out.printf("%s\n%s\n%s\n%s%s\n", moneyLine, headerText, moneyLine, dataLines, moneyLine);

  }

  private static String ProperName(String str) {
    return str.substring(0, 1).toUpperCase() + str.substring(1);
  }
}