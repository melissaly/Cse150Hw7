import java.util.*;
import java.io.*;
import java.lang.*;

public class project150{

    public static final int numMonths = 179;
    public static final int numFactors = 14;

    public static String[] dates = new String[numMonths];
    public static String[] months = new String[12];

    public static double[] a401k = new double[numMonths];
    public static double[] coupons = new double[numMonths];
    public static double[] discounts = new double[numMonths];
    public static double[] inflation = new double[numMonths];
    public static double[] investing = new double[numMonths];
    public static double[] loans = new double[numMonths];
    public static double[] mercedes = new double[numMonths];
    public static double[] mortgage = new double[numMonths];
    public static double[] real_estate = new double[numMonths];
    public static double[] stock_market = new double[numMonths];
    public static double[] student_loans = new double[numMonths];
    public static double[] unemployment = new double[numMonths];
    public static double[] value_of_us_dollar = new double[numMonths];
    public static double[] welfare = new double[numMonths];
    public static double[] djia = new double[numMonths];
    public static int[] djiaChange = new int[numMonths - 1];

    public static double[] pi = new double[numFactors];

    public static void fillMonths() {
        months[0] = "January";
        months[1] = "February";
        months[2] = "March";
        months[3] = "April";
        months[4] = "May";
        months[5] = "June";
        months[6] = "July";
        months[7] = "August";
        months[8] = "September";
        months[9] = "October";
        months[10] = "November";
        months[11] = "December";
    }

    public static void fillDates() {
        int year = 2004;
        for(int i = 0; i < 179; i++) {
            dates[i] = months[i % 12] + " " + year;
            if(((i+1) % 12) == 0) {
                year++;
            }
        }
    }

    public static void initializepi() {
        for(int i = 0; i < numFactors; i++) {
            if(i == 0 || i == 4 || i == 6 || i == 7 || i == 8 || i == 9 ) {
                pi[i] = 0.5;
            }
            else {
                pi[i] = -0.5;
            }
        }
    }

    public static void fillData() throws FileNotFoundException{

        fillMonths();
        fillDates();

        Scanner sc;
        File file401k = new File("data/401kParse.txt");
        File fileCoupons = new File("data/couponsParse.txt");
        File fileDiscounts = new File("data/discountsParse.txt");
        File fileInflation = new File("data/inflationParse.txt");
        File fileInvesting = new File("data/investingParse.txt");
        File fileLoans = new File("data/loansParse.txt");
        File fileMercedes = new File("data/mercedesParse.txt");
        File fileMortgage = new File("data/mortgageParse.txt");
        File fileRealEstate = new File("data/real_estateParse.txt");
        File fileStockMarket = new File("data/stock_marketParse.txt");
        File fileStudentLoans = new File("data/student_loansParse.txt");
        File fileUnemployment = new File("data/unemploymentParse.txt");;
        File fileValueUSDollar = new File("data/value_of_us_dollarParse.txt");;
        File fileWelfare = new File("data/welfareParse.txt");;
        File fileDJIA = new File("data/djiaParse.txt");

        int index = 0;
        sc = new Scanner(file401k);
        while(sc.hasNextInt()) {
            a401k[index] = sc.nextInt() / 100;
            index++;
        }
        sc.close();
        index = 0;

        sc = new Scanner(fileCoupons);
        while(sc.hasNextInt()) {
            coupons[index] = sc.nextInt() / 100;
            index++;
        }
        sc.close();
        index = 0;

        sc = new Scanner(fileDiscounts);
        while(sc.hasNextInt()) {
            discounts[index] = sc.nextInt() / 100;
            index++;
        }
        sc.close();
        index = 0;

        sc = new Scanner(fileInflation);
        while(sc.hasNextInt()) {
            inflation[index] = sc.nextInt() / 100;
            index++;
        }
        sc.close();
        index = 0;

        sc = new Scanner(fileInvesting);
        while(sc.hasNextInt()) {
            investing[index] = sc.nextInt() / 100;
            index++;
        }
        sc.close();
        index = 0;

        sc = new Scanner(fileLoans);
        while(sc.hasNextInt()) {
            loans[index] = sc.nextInt() / 100;
            index++;
        }
        sc.close();
        index = 0;

        sc = new Scanner(fileMercedes);
        while(sc.hasNextInt()) {
            mercedes[index] = sc.nextInt() / 100;
            index++;
        }
        sc.close();
        index = 0;

        sc = new Scanner(fileMortgage);
        while(sc.hasNextInt()) {
            mortgage[index] = sc.nextInt() / 100;
            index++;
        }
        sc.close();
        index = 0;

        sc = new Scanner(fileRealEstate);
        while(sc.hasNextInt()) {
            real_estate[index] = sc.nextInt() / 100;
            index++;
        }
        sc.close();
        index = 0;

        sc = new Scanner(fileStockMarket);
        while(sc.hasNextInt()) {
            stock_market[index] = sc.nextInt() / 100;
            index++;
        }
        sc.close();
        index = 0;

        sc = new Scanner(fileStudentLoans);
        while(sc.hasNextInt()) {
            student_loans[index] = sc.nextInt() / 100;
            index++;
        }
        sc.close();
        index = 0;

        sc = new Scanner(fileUnemployment);
        while(sc.hasNextInt()) {
            unemployment[index] = sc.nextInt() / 100;
            index++;
        }
        sc.close();
        index = 0;

        sc = new Scanner(fileValueUSDollar);
        while(sc.hasNextInt()) {
            value_of_us_dollar[index] = sc.nextInt() / 100;
            index++;
        }
        sc.close();
        index = 0;

        sc = new Scanner(fileWelfare);
        while(sc.hasNextInt()) {
            welfare[index] = sc.nextInt() / 100;
            index++;
        }
        sc.close();
        index = 0;
        
        sc = new Scanner(fileDJIA);
        while(sc.hasNextDouble()) {
            djia[index] = sc.nextDouble();
            index++;
        }
        sc.close();
        index = 0;

        initializepi();

        for(int i = 0; i < numMonths - 1; i++) {
            if(djia[i] < djia[i+1]) {
                djiaChange[i] = 1;
            }
            else {
                djiaChange[i] = 0;
            }
        }


    }

    public static void main(String[] args) throws FileNotFoundException{

        fillData();

        
    }
}