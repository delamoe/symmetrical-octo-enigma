import java.util.*;

import javax.swing.text.TabableView;

public class ComputeTax{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int status = -1;

        int[] taxLimits ={}
        , singleTaxLimits = {8350,33950,82250,171550,372950}
        , marriedJointTaxLimits = {16700,67900,137050,208850,372950}
        , marriedSeparateTaxLimits = {8350,33950,68525,104425,186475}
        , headOfHouseTaxLimits = {11950,45500,117450,190200,372950};

        double[] taxRates = {0.10,0.15,0.25,0.28,0.33,0.35};

        String[] taxRateNames = {"Single","Married Filing Jointly or Qualifying Widow(er)","Married Filing Separately","Head of Household"};

        try {
        
        while (status < 0 || status > 3){
            System.out.printf("Choose one of the following:%n\t0 - %s%n\t1 - %s%n\t2 - %s%n\t3 - %s%n\t"
            ,taxRateNames[0], taxRateNames[1], taxRateNames[2], taxRateNames[3]);
            status = input.nextInt();
        }

        System.out.printf("%nYou have chosen %s%nEnter your income.%n", taxRateNames[status]);
        double income = input.nextDouble();
        System.out.printf("%nYou entered $%8.2f%n", income);
        double tax = 0.0;
        switch (status) {
            case 0: taxLimits = singleTaxLimits;
                break;            
            case 1: taxLimits = marriedJointTaxLimits;
                break;            
            case 2: taxLimits = marriedSeparateTaxLimits;
                break;
            case 3: taxLimits = headOfHouseTaxLimits;
                break;       
           default:
               break;
       }

//       if (status == 0) {
//           taxLimits = singleTaxLimits;
//        } else if (status == 1) {
//            taxLimits = marriedJointTaxLimits;
//        } else if (status == 2) {
//            taxLimits = marriedSeparateTaxLimits;
//        } else if (status == 3) {
//            taxLimits = headOfHouseTaxLimits;
//        }

        if (income <= taxLimits[0]) {
            tax =
              income * taxRates[0];
        } else if (income <= taxLimits[1]) {
            tax =
              (taxLimits[0])              * taxRates[0]
            + (income-taxLimits[0]) * taxRates[1];
        } else if (income <= taxLimits[2]) {
            tax =
              (taxLimits[0])              * taxRates[0]
            + (taxLimits[1]-taxLimits[0]) * taxRates[1]
            + (income-taxLimits[1]) * taxRates[2];
        } else if (income <= taxLimits[3]) {
            tax =
              (taxLimits[0])              * taxRates[0]
            + (taxLimits[1]-taxLimits[0]) * taxRates[1]
            + (taxLimits[2]-taxLimits[1]) * taxRates[2]
            + (income-taxLimits[2]) * taxRates[3];
        } else if (income <= taxLimits[4]) {
            tax =
              (taxLimits[0])              * taxRates[0]
            + (taxLimits[1]-taxLimits[0]) * taxRates[1]
            + (taxLimits[2]-taxLimits[1]) * taxRates[2]
            + (taxLimits[3]-taxLimits[2]) * taxRates[3]
            + (income-taxLimits[3]) * taxRates[4];
        } else if (income > taxLimits[4]) {
            tax =
              (taxLimits[0])              * taxRates[0]
            + (taxLimits[1]-taxLimits[0]) * taxRates[1]
            + (taxLimits[2]-taxLimits[1]) * taxRates[2]
            + (taxLimits[3]-taxLimits[2]) * taxRates[3]
            + (taxLimits[4]-taxLimits[3]) * taxRates[4]
            + (income-taxLimits[4])       * taxRates[5];
        } else {tax = 34404;}

        System.out.printf("%nYour tax is $%8.2f%n",tax);
        
        }
        finally {
        input.close();
    }
       
    }
}