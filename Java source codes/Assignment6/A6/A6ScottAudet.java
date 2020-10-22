//Scott Audet
//Box creation and shipping program

package A6;

import java.text.NumberFormat;
import java.util.Scanner;

public class A6ScottAudet {

	public static void main(String[] args) {
		Box shipBox = new Box();					//shipping Box instance
		Box globeBox = new Box();					//snow globe box instance
		
		final double PLASTIC_WRAP = 0.0012;			//wrap constant $/square in.
		final double PACKING_MATERIAL = 0.0023;		//filler constant $/cubic in.
		
		int shipLength = 0;							//shipping box L, inches
		int shipWidth = 0;							//shipping box W, inches
		int shipHeight = 0;							//shipping box H, inches
		int shipCount = 1;							//quantity of shipping boxes
		double shipSpace = 0.0;						//empty space per box, sq. in.
		double packingCost = 0.0;					//total filler cost, $
		double wrappingCost = 0.0;					//total wrap cost, $
		double totalCost = 0.0;						//total cost, $
		
		int globeLength = 0;						//globe box L, inches
		int globeWidth = 0;							//globe box W, inches
		int globeHeight = 0;						//globe box H, inches
		
		double boxCost = 0.0;						//cost per box, $, user defined
		int globeCount = 1;							//number of globes, user defined

		
		NumberFormat fmt = NumberFormat.getCurrencyInstance();
		
		//input
		
		Scanner input = new Scanner(System.in);
		
		//error checking loop to assign box size based on restrictions
		do {
			System.out.println("Enter length, width and height of shipping box:");

			shipLength = input.nextInt();
			shipWidth = input.nextInt();
			shipHeight = input.nextInt();

		} while ((shipLength % 4 != 0) || (shipWidth % 4 != 0) || (shipHeight % 4 != 0));

		shipBox.setDimensions(shipLength, shipWidth, shipHeight);
		
		//user defined box cost
		do {
			System.out.println("Enter box cost:");
			boxCost = input.nextDouble();
		} while (boxCost <= 0);
		
		//error checking loop to assign snow globe size, user defined
		do {
			System.out.println("Enter dimension of snow globe:");

			globeLength = input.nextInt();
			globeWidth = globeLength;
			globeHeight = globeLength;
			
		} while ((globeLength % 4 != 0) || (globeLength > shipLength) ||
				(globeLength > shipWidth) || (globeLength > shipHeight));
		
		globeBox.setDimensions(globeLength, globeWidth, globeHeight);
		
		System.out.println("Enter number of snow globes to ship (Enter 0 to quit)");
		globeCount = input.nextInt();
		
		//loop to run until sentinel, 0 is called
		do {
			
			//processing
		
			//loop to determine quantity of boxes needed
			while ((shipBox.volume() * shipCount) < (globeBox.volume() * globeCount)) {
				shipCount++;
			}
			
			//cost calculations, $
			shipSpace = (shipBox.volume() * shipCount) - (globeBox.volume() * globeCount);
			packingCost = shipSpace * PACKING_MATERIAL;
			wrappingCost = shipBox.area() * PLASTIC_WRAP * shipCount;
			totalCost = packingCost + wrappingCost + (boxCost * shipCount);
			
			//output
			
			System.out.println();
			System.out.println("Number of snow globes: " + globeCount);
			System.out.println("--------------------------------------");
			System.out.println("Number of shipping box(es) needed: " + shipCount);
			System.out.println("Cost of box(es): " + fmt.format((boxCost * shipCount)));
			System.out.println("Cost of packing material: " + fmt.format(packingCost));
			System.out.println("Cost of plastic wrap: " + fmt.format(wrappingCost));
			System.out.println("Total cost: " + fmt.format(totalCost));
			System.out.println();
			
			System.out.println("Enter number of snow globes to ship (Enter 0 to quit)");
			globeCount = input.nextInt();
			System.out.println();
		
		} while (globeCount != 0);
		
		input.close();				//close scanner instance
		System.exit(0);				//end program
		

	}

}
