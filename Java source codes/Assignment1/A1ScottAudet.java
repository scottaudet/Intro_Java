//Scott Audet
//Monthly salary and expenses for a student

import java.util.Scanner;

public class A1ScottAudet {

	public static void main(String[] args) {
		
		final double HOURLY_RATE = 15.50;																//hourly rate for work, dollars/hour
		final double CAR_PAYMENT = 325.75;																//monthly car payment, dollars
		int hoursWeekOne, hoursWeekTwo, hoursWeekThree, hoursWeekFour;									//hours per week, hours
		double rent;																					//monthly rent, dollars
		double utilities;																				//monthly utilities cost, dollars
		double transportation;																			//monthly transport costs, dollars
		double food;																					//monthly food costs, dollars
		double carPaymentPercent, rentPercent, utilitiesPercent, transportationPercent, foodPercent; 	//percent of total monthly expense
		double totalPay;																				//total monthly income, dollars
		double totalExpenses;																			//total monthly expenses, dollars
		double leftOver;																				//remaining funds, dollars
		Scanner scan = new Scanner(System.in);															//keyboard input
	
		//input section
		
		System.out.print("Enter the number of hours worked in week 1: ");
		hoursWeekOne = scan.nextInt();
		System.out.print("Enter the number of hours worked in week 2: ");
		hoursWeekTwo = scan.nextInt();
		System.out.print("Enter the number of hours worked in week 3: ");
		hoursWeekThree = scan.nextInt();
		System.out.print("Enter the number of hours worked in week 4: ");
		hoursWeekFour = scan.nextInt();
		
		System.out.println();
		
		System.out.print("Enter rent: ");
		rent = scan.nextDouble();
		System.out.print("Enter utilities: ");
		utilities = scan.nextDouble();
		System.out.print("Enter transportation: ");
		transportation = scan.nextDouble();
		System.out.print("Enter food cost: ");
		food = scan.nextDouble();
		scan.close();
		
		System.out.println();

		//processing section
		
		totalPay = HOURLY_RATE * (hoursWeekOne + hoursWeekTwo + hoursWeekThree + hoursWeekFour); 		//total pay computation
		totalExpenses = CAR_PAYMENT + rent + utilities + transportation + food;							//total expenses computation
		leftOver = totalPay - totalExpenses;															//totals difference
		
		carPaymentPercent = CAR_PAYMENT / totalExpenses * 100;											//expense percentages of total
		rentPercent = rent / totalExpenses * 100;
		utilitiesPercent = utilities / totalExpenses * 100;
		transportationPercent = transportation / totalExpenses * 100;
		foodPercent = food / totalExpenses * 100;
		
		//output section
		
		System.out.println("Budget chart for Scott");
		System.out.printf("%-22s %-15s %-15s %n", "Expense", "Amount $", "Percent %");
		System.out.printf("%-22s %-15.2f %-15.2f %n", "Car Payment", CAR_PAYMENT, carPaymentPercent);
		System.out.printf("%-22s %-15.2f %-15.2f %n", "Rent", rent, rentPercent);
		System.out.printf("%-22s %-15.2f %-15.2f %n", "Utilities", utilities, utilitiesPercent);
		System.out.printf("%-22s %-15.2f %-15.2f %n", "Transportation", transportation, transportationPercent);
		System.out.printf("%-22s %-15.2f %-15.2f %n", "Food", food, foodPercent);
		
		System.out.println();
		
		System.out.printf("%-22s %-15.2f %n", "Total Pay", totalPay);
		System.out.printf("%-22s %-15.2f %n", "Total Expense", totalExpenses);
		System.out.printf("%-22s %-15.2f %n", "Leftover Amount", leftOver);

	}

}
