/*
 * Class	:	HW3MethodsAndMethodOverloading.java
 *
 * Purpose 	:	HW3 Methods and Method Overloading
 * 				10979 CIS131 Prog & Problem Solv II 
 *
 * Developer:	E de la Montaña
 *
 * Date		:	9/16/2018
 */

 import java.util.*;

public class HW3MethodsAndMethodOverloading {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        try {

            // for testing only, comment or delete in final
            /* double startingAnnualInterestRate = 2.25;
            double endingAnnualInterestRate = 4.3587;
            double interestRateIncrement = 2.1547;
            int firstTermYears = 15;
            int lastTermYears = 25;
            int termIncrementYears = 5;
            double loanAmount = 250987;
            double endingAnnualInterestRate10000 = endingAnnualInterestRate * 10000;
            double startingAnnualInterestRate10000 = startingAnnualInterestRate * 10000;
            double interestRateIncrement10000 = interestRateIncrement * 10000;
            boolean userComplete = true; */
            
            
            // uncomment to run
            double startingAnnualInterestRate = -1.0;
            double endingAnnualInterestRate = -1.0;
            double interestRateIncrement = -50.0;
            double endingAnnualInterestRate10000 = endingAnnualInterestRate * 10000;
            double startingAnnualInterestRate10000 = startingAnnualInterestRate * 10000;
            double interestRateIncrement10000 = interestRateIncrement * 10000;
            int firstTermYears = -1;
            int lastTermYears = -1;
            int termIncrementYears = 0;
            double loanAmount = -1.0;
            boolean userComplete = false;
            int yearIterationLimit = 6;
            
            while (!userComplete) {
                while (startingAnnualInterestRate < 0.0001 || startingAnnualInterestRate > 99.999) {
                    System.out.printf("%nEnter the starting annual interest rate as a percent (n.nnn)%n%n --> ");
                    if (input.hasNextDouble()/* || input.hasNextInt() */) {
                        startingAnnualInterestRate = input.nextDouble();
                        if (startingAnnualInterestRate < 0.0001 || startingAnnualInterestRate > 99.999) {
                            // clear the trailing newline WT%$#!!!!!!!!!
                            input.nextLine();
                            System.out.printf("%n%8.3f is not valid!%n", startingAnnualInterestRate);
                        }
                    } else {
                        String str = input.nextLine().toString();
                        System.out.printf("%n\"%s\" is not valid!%n", str);
                    }
                }
                while (endingAnnualInterestRate < startingAnnualInterestRate || endingAnnualInterestRate > 99.999) {
                    System.out.printf("%nEnter the ending annual interest rate as a percent (n.nnn)%n%n --> ");
                    if (input.hasNextDouble()/* || input.hasNextInt() */) {
                        endingAnnualInterestRate = input.nextDouble();
                        if (endingAnnualInterestRate < startingAnnualInterestRate
                                || endingAnnualInterestRate > 99.999) {
                            // clear the trailing newline WT%$#!!!!!!!!!
                            input.nextLine();
                            System.out.printf("%n%8.3f is not valid!%n", endingAnnualInterestRate);
                        }
                    } else {
                        String str = input.nextLine().toString();
                        System.out.printf("%n\"%s\" is not valid!%n", str);
                    }
                }

                while (interestRateIncrement > 25 || interestRateIncrement <= 0.000) {
                    System.out.printf("%nEnter the annual interest rate increment as a percent (n.nnn)%n%n --> ");
                    if (input.hasNextDouble()/* || input.hasNextInt() */) {
                        interestRateIncrement = input.nextDouble();
                        if (interestRateIncrement > 25 || interestRateIncrement <= 0.000) {
                            // clear the trailing newline WT%$#!!!!!!!!!
                            input.nextLine();
                            System.out.printf("%n%8.3f is not valid!%n", interestRateIncrement);
                        }
                    } else {
                        String str = input.nextLine().toString();
                        System.out.printf("%n\"%s\" is not valid!%n", str);
                    }
                }

                while (firstTermYears < 1 / 12 || firstTermYears > 100) {
                    System.out.printf("%nEnter the first term in years for calculating payments%n%n --> ");
                    if (input.hasNextInt()) {
                        firstTermYears = input.nextInt();
                        if (firstTermYears < 1 / 12 || firstTermYears > 100) {
                            // clear the trailing newline WT%$#!!!!!!!!!
                            input.nextLine();
                            System.out.printf("%n%d is not valid!%n", firstTermYears);
                        }
                    } else {
                        String str = input.nextLine().toString();
                        System.out.printf("%n\"%s\" is not valid!%n", str);
                    }
                }

                while (lastTermYears < 1 / 12 || lastTermYears < firstTermYears || lastTermYears > 100) {
                    System.out.printf("%nEnter the last term in years for calculating payments%n%n --> ");
                    if (input.hasNextInt()) {
                        lastTermYears = input.nextInt();
                        if (lastTermYears < 1 / 12 || lastTermYears < firstTermYears || lastTermYears > 100) {
                            // clear the trailing newline WT%$#!!!!!!!!!
                            input.nextLine();
                            System.out.printf("%n%d is not valid!%n", lastTermYears);
                        }
                    } else {
                        String str = input.nextLine().toString();
                        System.out.printf("%n\"%s\" is not valid!%n", str);
                    }
                }

                while (termIncrementYears < 1) {
                    System.out.printf("%nEnter the term increment in years%n%n --> ");
                    if (input.hasNextInt()) {
                        termIncrementYears = input.nextInt();
                        if (termIncrementYears < 1) {
                            // clear the trailing newline WT%$#!!!!!!!!!
                            input.nextLine();
                            System.out.printf("%n%d is not valid!%n", termIncrementYears);
                        }
                    } else {
                        String str = input.nextLine().toString();
                        System.out.printf("%n\"%s\" is not valid!%n", str);
                    }
                }

                while (loanAmount < 1 || loanAmount > 1000000) {
                    System.out.printf("Enter the loan amount between 0 and 999999%n%n --> ");
                    if (input.hasNextDouble()/* || input.hasNextInt() */) {
                        loanAmount = input.nextDouble();
                        userComplete = true;
                        if (loanAmount < 1 || loanAmount > 1000000) {
                            // clear the trailing newline WT%$#!!!!!!!!!
                            input.nextLine();
                            System.out.printf("%n%6.2f is not valid!%n", loanAmount);
                            userComplete = false;
                        }
                    } else {
                        String str = input.nextLine().toString();
                        System.out.printf("%n\"%s\" is not valid!%n", str);
                    }
                }
            }

            int yearIterations = ((lastTermYears - firstTermYears) / termIncrementYears) + 1;

            int incrementAddOne = ((endingAnnualInterestRate10000 - startingAnnualInterestRate10000)
                    % interestRateIncrement10000 != 0.0 ? 1 : 0);
            int interestIterations = (int) (((endingAnnualInterestRate - startingAnnualInterestRate)
                    / interestRateIncrement) + incrementAddOne);
            interestIterations = interestIterations < 1 ? 1 : interestIterations;

            String rowString = String.format(
                    "%nPayments calculated on a $%,6.2f loan from %6.4f%% to %6.4f%% interest and from %d to %d years.",
                    loanAmount, startingAnnualInterestRate, endingAnnualInterestRate, firstTermYears, lastTermYears);
            if (yearIterations < yearIterationLimit) {
                rowString += String.format(
                        "%nThe total cost of the loan at maturity is shown in [brackets] (to the nearest dollar.)");
            }

            rowString += String.format("%n%n Interest%n   Rate\t");
            
            // String padding = "";
            int currentTerm1 = 0;
            for (int i = 0; i <= yearIterations && currentTerm1 < lastTermYears; i++) {
                currentTerm1 = firstTermYears + termIncrementYears * i >= lastTermYears ? lastTermYears
                        : firstTermYears + termIncrementYears * i;
                rowString += String.format("\t  %d  Years", currentTerm1);
                if (yearIterations < yearIterationLimit) {
                    rowString += String.format("    [$  Total]");
                }
            }

            for (int i = 0; i <= interestIterations; i++) {
                double interestRate = startingAnnualInterestRate10000 + interestRateIncrement10000 * i > endingAnnualInterestRate10000
                        ? endingAnnualInterestRate
                        : startingAnnualInterestRate + interestRateIncrement * i;
                rowString += String.format("%n%7.4f%%", interestRate);
                double mir = interestRate / 12 / 100;
                int currentTerm2 = 0;
                for (int j = 0; j <= yearIterations && currentTerm2 < lastTermYears; j++) {
                    currentTerm2 = firstTermYears + termIncrementYears * j >= lastTermYears ? lastTermYears
                            : firstTermYears + termIncrementYears * j;
                    int mtp = currentTerm2 * 12;
                    // padding = calcPayment(mir, mtp, loanAmount) > 10000 ? "" : " ";
                    rowString += String.format("\t $%,10.2f", calcPayment(mir, mtp, loanAmount)/* , padding */);
                    if (yearIterations < yearIterationLimit) {
                        rowString += String.format(" [$%,10.0f]", calcPayment(mir, mtp, loanAmount) * mtp);
                    }

                }
                // System.out.printf("%n%n=====> DEBUGGER j = %d DEBUGGER <=====%n%n", j);
            }

            System.out.printf("%s%n", rowString);

        } finally {
            input.close();
        }
    }

    static double calcPayment(double mir, double mtp, double loan) {

        double annuityFactor = (mir * Math.pow((1 + mir), mtp)) / (Math.pow((1 + mir), mtp) - 1);

        double payment = loan * annuityFactor;

        return payment;
    }
}