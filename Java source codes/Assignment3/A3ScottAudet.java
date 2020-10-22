//Scott Audet
//Evaluate ski productions

import java.util.Scanner;
import java.text.NumberFormat;
import java.text.DecimalFormat;


public class A3ScottAudet {

	public static void main(String[] args) {
		
		final double SKI_COEF = 1.23;			//acceptable ski coefficient
		final double RC_SKI = 21.99;			//RC ski part cost, USD
		final double ED_SKI = 24.99;			//ED ski part cost, USD
		int dataPoints;							//number of skis being entered
		int count = 0;							//number of skis processed
		
		String ski;								//ski entered by user
		String strSkiCo;						//String of coefficient
		double skiCo = 0;						//ski coefficient entered by user
		double frictionSum = 0;					//sum of friction coefficients
		int rejectedSum = 0;					//sum of rejected skis
		double rejectedTotalCost = 0;			//cost of all rejected skis
		Scanner scan = new Scanner(System.in);	//new scanner
		
		NumberFormat monFmt = NumberFormat.getCurrencyInstance();
		NumberFormat perFmt = NumberFormat.getPercentInstance();
		DecimalFormat dfmt = new DecimalFormat("#.##");
		
		System.out.println("Programmer: Scott Audet");
		System.out.println();
		
		//input
		
		//error checker that data points entered is greater than 0
		do {
			System.out.println("Please enter number of data points: ");
			dataPoints = scan.nextInt();
		} while (dataPoints < 0);
		
		//loop that iterates until all data points entered by user
		for (count = 0; count < dataPoints; count++) {
			
			
			do {
			System.out.println("Please enter a ski ID");
			ski = scan.next();
			} while (!(ski.contains("ED") || ski.contains("RC")));
			
			//requests ski coefficient if valid ski code
			//assigns to totals based on ski coefficient provided
			
			do {
				System.out.println("Please enter a friction coefficient for " +
				ski);
				strSkiCo = scan.next();
				skiCo = Double.parseDouble(strSkiCo);
				
				if (ski.contains("ED") && skiCo < SKI_COEF && skiCo > 0) {
					System.out.println("Component cost for " + ski + ": " +
					monFmt.format(ED_SKI));
					frictionSum += skiCo;
					
				} else if (ski.contains("RC") && skiCo < SKI_COEF && skiCo > 0) {
					System.out.println("Component cost for " + ski + ": " +
					monFmt.format(RC_SKI));
					frictionSum += skiCo;
					
				} else if (ski.contains("ED") && skiCo > SKI_COEF && skiCo > 0) {
					System.out.println("Component cost for " + ski + ": " +
					monFmt.format(ED_SKI) + "<--- REJECTED");
					frictionSum += skiCo;
					rejectedSum ++;
					rejectedTotalCost += ED_SKI;
					
				} else if (ski.contains("RC") && skiCo > SKI_COEF && skiCo > 0) {
					System.out.println("Component cost for " + ski + ": " +
					monFmt.format(RC_SKI) + "<--- REJECTED");
					frictionSum += skiCo;
					rejectedSum++;
					rejectedTotalCost += RC_SKI;
				} 
				
			} while (skiCo < 0);
			
			System.out.println();
		}
		
		scan.close();
		
		//output
		
		System.out.println("Number of Data Points: " + dataPoints);
		
		//calculates and prints friction coefficient average
		System.out.println("Average Friction Coefficeint: " + 
		dfmt.format(frictionSum/(double)dataPoints));
		
		System.out.println("Number of rejected skis: " + rejectedSum);
		
		//calculates and prints percentage of rejected skis from total data
		System.out.println("Percentage of rejected skis: " +
		perFmt.format((double)rejectedSum/(double)dataPoints));
		
		//converts total rejected ski cost to USD and prints
		System.out.println("Cost of rejected skis: " + 
		monFmt.format(rejectedTotalCost));
	}

}
