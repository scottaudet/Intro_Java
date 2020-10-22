
import java.util.Scanner;
import java.text.NumberFormat;

public class A2ScottAudet {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		//constants food prices and tax

		final double BEEF_MEAL = 12.95;
		final double CHICKEN_MEAL = 10.95;
		final double VEGAN_MEAL = 8.95;

		final double GRATUITY = 0.18;
		final double STATE_TAX = 0.065;

		//constants for room configurations
		
		//final int SEATING_ONE = 200;
		//final int SEATING_TWO = 150;
		//final int SEATING_THREE = 100;
		//final int SEATING_FOUR = 30;
		final double RENTAL_ONE  = 250.00;
		final double RENTAL_TWO = 200.00;
		final double RENTAL_THREE = 100.00;
		final double RENTAL_FOUR = 50.00;

		//assignments for order configurations
		
		int beefOrders, chickenOrders, veganOrders;
		int totalOrders = 0;
		double reserveRoom;
		double beefTotal = 0;
		double chickenTotal = 0;
		double veganTotal = 0;
		double foodTip = 0;
		double totalBill = 0;

		//Input

		System.out.println("Enter number of beef dinners: ");
		beefOrders = scan.nextInt();
		totalOrders += beefOrders;

		//flow controls that monitor party size and input values
		
		if (beefOrders < 0) {
			System.out.println("Invalid input");
			System.exit(0);
		}
		else if (totalOrders > 200) {
			System.out.println("No room available for requested size.");
			System.exit(0);
		}
		System.out.println("Enter number of chicken meals:");
		chickenOrders = scan.nextInt();
		totalOrders += chickenOrders;

		if (chickenOrders < 0) {
			System.out.println("Invalid input");
			System.exit(0);
		}
		else if (totalOrders > 200) {
			System.out.println("No room available for requested size.");
			System.exit(0);
		}
		
		System.out.println("Enter number of vegan meals:");
		veganOrders = scan.nextInt();
		totalOrders += veganOrders;

		if (veganOrders < 0) {
			System.out.println("Invalid input");
			System.exit(0);
		}
		else if (totalOrders > 200) {
			System.out.println("No room available for requested size.");
			System.exit(0);
		}
		
		scan.close();
		
		//processing
		
		//toggle required room size

			if (totalOrders <= 30) {
				reserveRoom = RENTAL_FOUR; 
			}
			else if (totalOrders <= 100) { 
				reserveRoom = RENTAL_THREE; 
			}
			else if (totalOrders <= 150) { 
				reserveRoom = RENTAL_TWO; 
			}
			else
				reserveRoom = RENTAL_ONE; 
				

		//price calculations
			
		totalBill += beefTotal = beefOrders * BEEF_MEAL;
		totalBill += chickenTotal = chickenOrders * CHICKEN_MEAL;
		totalBill += veganTotal = veganOrders * VEGAN_MEAL;
		totalBill += foodTip = totalBill * GRATUITY;
		totalBill += reserveRoom;
		totalBill += reserveRoom * STATE_TAX;

		//output
		
		NumberFormat fmt = NumberFormat.getCurrencyInstance();

		System.out.println();
		
		System.out.println("Catering by Scott");
		System.out.println("-------------------------------------------------");
		System.out.println(String.format("%-40s %-15d","Number in party: ", totalOrders));
		System.out.println(String.format("%-40s %15s","Room cost: ", fmt.format(reserveRoom)));
		System.out.println(String.format("%-40s %15s","Room tax: ", fmt.format(reserveRoom * STATE_TAX)));

		//flow control, if no orders, output is ignored
		
		if (beefOrders > 0) {
			System.out.println(String.format("%-40s %-15d", "Number of beef dinners: ", beefOrders));
			System.out.println(String.format("%-40s %15s", "Cost of beef dinners: ", fmt.format(beefTotal)));
		}
		if (chickenOrders > 0) {
			System.out.println(String.format("%-40s %-15d","Number of chicken dinners: ", chickenOrders));
			System.out.println(String.format("%-40s %15s","Cost of chicken dinners: ", 
			fmt.format(chickenTotal)));
		}
		if (veganOrders > 0) {
			System.out.println(String.format("%-40s %-15d","Number of vegan dinners: ", veganOrders));
			System.out.println(String.format("%-40s %15s","Cost of vegan dinners: ", fmt.format(veganTotal)));
		}
		System.out.println(String.format("%-40s %15s","Food gratuity: ", fmt.format(foodTip)));

		System.out.println("-------------------------------------------------");
		System.out.println(String.format("%-40s %15s","Total: ", fmt.format(totalBill)));
		
	}
}
