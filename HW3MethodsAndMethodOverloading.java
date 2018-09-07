import java.util.*;

public class HW3MethodsAndMethodOverloading {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        try {

            double startingAnnualInterestRate = -1.0;
            double endingAnnualInterestRate = -1.0;
            double annualInterestRateIncrement = -50.0;
            double loanAmount = -1.0;
            int firstTermYears = -1;
            int lastTermYears = -1;
            int termIncrementYears = 0;

            // while (input.hasNextInt()) {
                while (startingAnnualInterestRate < 0 || startingAnnualInterestRate > 99.999) {
                System.out.printf("%nEnter the starting annual interest rate as a percent (n.nnn) : %n");
                startingAnnualInterestRate = input.nextDouble();
                }

                while (endingAnnualInterestRate < 0 || endingAnnualInterestRate > 99.999) {
                    System.out.printf("%nEnter the ending annual interest rate as a percent (n.nnn) : %n");
                endingAnnualInterestRate = input.nextDouble();
                }

                while (annualInterestRateIncrement > 25 || annualInterestRateIncrement < -25) {
                    System.out.printf("%nEnter the annual interest rate increment as a percent (n.nnn): %n");
                annualInterestRateIncrement = input.nextDouble();
                }

                while (firstTermYears < 1 / 12 || firstTermYears > 100) {
                    System.out.printf("%nEnter the first term in years for calculating payments : %n");
                firstTermYears = input.nextInt();
                }

                while (lastTermYears < 1 / 12 || lastTermYears > 100) {
                    System.out.printf("%nEnter the last term in years for calculating payments : %n");
                lastTermYears = input.nextInt();
                }

                while (termIncrementYears < 1) {
                    System.out.printf("%nEnter the term increment in years : %n");
                termIncrementYears = input.nextInt();
                }

                while (loanAmount < 1) {
                    System.out.printf("Enter the loan amount : %n");
                loanAmount = input.nextDouble();
                }
            // }


            
            String rowString = String.format("%nInterest%n  Rate\t");
            String padding = "";
            
            for (int k = firstTermYears; k <= lastTermYears; k += termIncrementYears) {
                rowString += String.format("\t%d Years", k);
            }

            for (double i = startingAnnualInterestRate; i <= endingAnnualInterestRate; i += annualInterestRateIncrement) {
                rowString += String.format("%n%7.4f\t", i);
                double mir = i / 12 / 100;
                for (int j = firstTermYears; j <= lastTermYears; j += termIncrementYears) {
                    int mtp = j * 12;
                    padding = calcPayment(mir, mtp, loanAmount) > 10000 ? "" : " ";
                    rowString += String.format("\t%s%-8.2f", padding, calcPayment(mir, mtp, loanAmount));
                }
                
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
