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

    public static double[][] data = new double[numMonths][numFactors];
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
            a401k[index] = sc.nextInt();
            index++;
        }
        sc.close();
        index = 0;

        sc = new Scanner(fileCoupons);
        while(sc.hasNextInt()) {
            coupons[index] = sc.nextInt();
            index++;
        }
        sc.close();
        index = 0;

        sc = new Scanner(fileDiscounts);
        while(sc.hasNextInt()) {
            discounts[index] = sc.nextInt();
            index++;
        }
        sc.close();
        index = 0;

        sc = new Scanner(fileInflation);
        while(sc.hasNextInt()) {
            inflation[index] = sc.nextInt();
            index++;
        }
        sc.close();
        index = 0;

        sc = new Scanner(fileInvesting);
        while(sc.hasNextInt()) {
            investing[index] = sc.nextInt();
            index++;
        }
        sc.close();
        index = 0;

        sc = new Scanner(fileLoans);
        while(sc.hasNextInt()) {
            loans[index] = sc.nextInt();
            index++;
        }
        sc.close();
        index = 0;

        sc = new Scanner(fileMercedes);
        while(sc.hasNextInt()) {
            mercedes[index] = sc.nextInt();
            index++;
        }
        sc.close();
        index = 0;

        sc = new Scanner(fileMortgage);
        while(sc.hasNextInt()) {
            mortgage[index] = sc.nextInt();
            index++;
        }
        sc.close();
        index = 0;

        sc = new Scanner(fileRealEstate);
        while(sc.hasNextInt()) {
            real_estate[index] = sc.nextInt();
            index++;
        }
        sc.close();
        index = 0;

        sc = new Scanner(fileStockMarket);
        while(sc.hasNextInt()) {
            stock_market[index] = sc.nextInt();
            index++;
        }
        sc.close();
        index = 0;

        sc = new Scanner(fileStudentLoans);
        while(sc.hasNextInt()) {
            student_loans[index] = sc.nextInt();
            index++;
        }
        sc.close();
        index = 0;

        sc = new Scanner(fileUnemployment);
        while(sc.hasNextInt()) {
            unemployment[index] = sc.nextInt();
            index++;
        }
        sc.close();
        index = 0;

        sc = new Scanner(fileValueUSDollar);
        while(sc.hasNextInt()) {
            value_of_us_dollar[index] = sc.nextInt();
            index++;
        }
        sc.close();
        index = 0;

        sc = new Scanner(fileWelfare);
        while(sc.hasNextInt()) {
            welfare[index] = sc.nextInt();
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

        for (int i = 0; i < numMonths; i++) {
            data[i][0] = a401k[i];
            data[i][1] = coupons[i];
            data[i][2] = discounts[i];
            data[i][3] = inflation[i];
            data[i][4] = investing[i];
            data[i][5] = loans[i];
            data[i][6] = mercedes[i];
            data[i][7] = mortgage[i];
            data[i][8] = real_estate[i];
            data[i][9] = stock_market[i];
            data[i][10] = student_loans[i];
            data[i][11] = unemployment[i];
            data[i][12] = value_of_us_dollar[i];
            data[i][13] = welfare[i];
        }

    }

    private void attempt2() {
        // turn all indeces into 50/x in order to put them between 0 and 2
        // so lower indeces reduce pi value
        double[][] x = data;
        for (int i = 0; i < numFactors; i++) {
            for (int j = 0; j < numMonths; j++) {
                x[j][i] = 50/x[j][i];
            }
        }

        int[] y = {0} + djiaChange;
        
		// 512 iterations training (arbitrary number)
		for (int k = 0; k<513; k++) {
			int mistakes = 0;
			double likelihood = 0;
			int[] Ti = new int[numFactors]; // java inits to zero
			double[] newPies = new double[numFactors];
			
			// T=179 samples of data 
			for (int t = 0; t < numMonths; t++) {
				// P(Y=1|X=x) = 1- product (1-pi)^xi
				double product = 1;
				// 14 X and Z nodes
				for (int n = 0; n < numFactors; n++) {
					// product = (1-pi)^x
					product *= Math.pow(1-pi[n], x[t][n]); 
					// it also contributes to Ti
					Ti[n]++;

				} // end of iterting through all X nodes
				
				double prob = 1-product;
				for (int n = 0; n < numFactors; n++) {
					newPies[n] += y[t]*x[t][n]*pi[n] / prob;
				}

				if (y[t] == 0) {
					if (prob >= 0.5)
						mistakes++;
				}
				if (y[t] == 1) {
					if (prob < 0.5) {
						mistakes++;
					}
				}
				
				// likelihood to add = logP(Y=yt|X=xt)
				if (y[t] == 0) 
					likelihood += Math.log(product);
				else
					likelihood += Math.log(prob);
			} // end of single sample
			// update all the p's
			for (int a = 0; a < 23; a++) {
				newPies[a] /= Ti[a];
			}
			pi = newPies;
			
			likelihood /= 267;
			
			for (int b = 0; b < 10; b++) {
				if (k == (Math.pow(2, b))) {
					System.out.println(k + "\t" + mistakes + "\t" + likelihood);
				}
			}
		} // end of all iterations
		System.out.println("\n");
		for (int b = 0; b < 23; b++) {
			System.out.println((b+1) + "\t" + pi[b]);
		}
    }

    public static void main(String[] args) throws FileNotFoundException{

        fillData();
        attempt2();

        
    }
}
