import java.util.*;

public class HW3MethodsAndMethodOverloading {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        try {

            double startingAnnualInterestRate = -1.0;
            double endingAnnualInterestRate = -1.0;
            double annualInterestRateIncrement = -50.0;
            int firstTermYears = -1;
            int lastTermYears = -1;
            int termIncrementYears = 0;
            double loanAmount = -1.0;
            boolean userComplete = false;

            while (!userComplete) {
                while (startingAnnualInterestRate < 0.0001 || startingAnnualInterestRate > 99.999) {
                System.out.printf("%nEnter the starting annual interest rate as a percent (n.nnn)%n%n --> ");
                if (input.hasNextDouble()/*  || input.hasNextInt() */) {
                    startingAnnualInterestRate = input.nextDouble();
                    if(startingAnnualInterestRate < 0.0001 || startingAnnualInterestRate > 99.999) {
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
                    if (input.hasNextDouble()/*  || input.hasNextInt() */) {
                        endingAnnualInterestRate = input.nextDouble();
                        if(endingAnnualInterestRate < startingAnnualInterestRate || endingAnnualInterestRate > 99.999) {
                            // clear the trailing newline WT%$#!!!!!!!!!
                            input.nextLine();
                            System.out.printf("%n%8.3f is not valid!%n", endingAnnualInterestRate);
                        }
                    } else {
                        String str = input.nextLine().toString();
                        System.out.printf("%n\"%s\" is not valid!%n", str);
                    }
                }

                while (annualInterestRateIncrement > 25 || annualInterestRateIncrement < -25 || annualInterestRateIncrement == 0.000) {
                    System.out.printf("%nEnter the annual interest rate increment as a percent (n.nnn)%n%n --> ");
                    if (input.hasNextDouble()/*  || input.hasNextInt() */) {
                        annualInterestRateIncrement = input.nextDouble();
                        if(annualInterestRateIncrement > 25 || annualInterestRateIncrement < -25 || annualInterestRateIncrement == 0.000) {
                            // clear the trailing newline WT%$#!!!!!!!!!
                            input.nextLine();
                            System.out.printf("%n%8.3f is not valid!%n", annualInterestRateIncrement);
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
                        if(firstTermYears < 1 / 12 || firstTermYears > 100) {
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
                        if(lastTermYears < 1 / 12 || lastTermYears < firstTermYears || lastTermYears > 100) {
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
                        if(termIncrementYears < 1) {
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
                    if (input.hasNextDouble()/*  || input.hasNextInt() */) {
                        loanAmount = input.nextDouble();
                        userComplete = true;
                        if(loanAmount < 1 || loanAmount > 1000000) {
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


            
            String rowString = String.format("%nInterest%n  Rate\t");
            // String padding = "";
            
            for (int i = firstTermYears; i <= lastTermYears; i += termIncrementYears) {
                rowString += String.format("\t%d Years", i);
            }

            for (double i = startingAnnualInterestRate; i <= endingAnnualInterestRate; i += annualInterestRateIncrement) {
                rowString += String.format("%n%7.4f\t", i);
                double mir = i / 12 / 100;
                for (int j = firstTermYears; j <= lastTermYears; j += termIncrementYears) {
                    int mtp = j * 12;
                    // padding = calcPayment(mir, mtp, loanAmount) > 10000 ? "" : " ";
                    rowString += String.format("\t%8.2f", calcPayment(mir, mtp, loanAmount)/* , padding */);
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
