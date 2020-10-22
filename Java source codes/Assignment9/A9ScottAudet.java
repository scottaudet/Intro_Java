//Scott Audet
//Forest burn simulator

import java.util.*;

public class A9ScottAudet {

	public static void main(String[] args) {
		Scanner user = new Scanner(System.in);		//user input scanner
		int size = 0;								//user defined edge size
		double density = 0.0;						//user defined tree density
		Random ran = new Random();					//random number generator
		String [][] forest;							//Double array of forest
		double tree = 0.0;							//tree num defined by ran

		
		do {
			
			//user defined inputs - size and density
			do {
			System.out.print("Please enter a forest size between 10 and 30: ");
			size = user.nextInt();
			} while ((size < 10) || (size > 30));
			
			forest = new String [size][size];
			
			do {
			System.out.print("Enter a forest density percentage between 0.20 and 0.80: ");
			density = user.nextDouble();
			} while ((density < 0.20) || (density > 0.80));
			
			System.out.println();
			
			//loop to create forest array at desired size and density
			for (int r = 0; r < size; r++) {
				for (int c = 0; c < size; c++) {
					tree = ran.nextFloat();
					if (tree < density) {
						forest[r][c] = " T ";
					}
					else {
						forest[r][c] = " . ";
					}
				}
			}
			
			display(forest, size);
			
			burn(forest, size);
	
			System.out.println("Press any key to continue...");
		
		} while (!user.next().equals("Q"));
		
		user.close();
	}
	
	//PRE: String 2D array of forest and array size
	public static void display(String[][]a, double size) {
			
		double area = size * size;
		double treeCount = 0.0;
			
		//print forest array, T representing a planted tree
		for (int r = 0; r < size; r++) {
			for(int c = 0; c < size; c++) {
				if(a[r][c].equals(" T "))
					treeCount++;
				System.out.print(a[r][c]);
			}
			System.out.println();
		}
			
		System.out.println("Percent populated: " + treeCount/area);
		System.out.println();
			
	}
	//POST: Print planted tree model and report population %
		
	//PRE: string 2D array of T representing a planted tree and array size
	public static void burn(String[][]a, int size) {
		
		double burnCount = 0.0;			//number of trees burned
		boolean burnThrough = false;	//if fire burned through forest
		double area = size * size;
		
		System.out.println("The final forest:");
		
		//ignites first row
		for(int c = 0; c < size; c++) {
			if (a[0][c].equals(" T "))
				a[0][c] = " B ";
				
		}
		
		//burns trees within proximity to other tree
		for(int r = 0; r < size - 1; r++) {
			for(int c = 1; c < size - 1; c++) {
				if(a[r][c].equals(" B ")) {
					if(a[r + 1][c - 1].equals(" T ")) {
						a[r + 1][c - 1] = " B ";
						burnCount++;
					}
					if(a[r + 1][c].equals(" T ")) {
						a[r + 1][c] = " B ";
						burnCount++;
					}
					if(a[r + 1][c + 1].equals(" T ")) {
						a[r + 1][c + 1] = " B ";
						burnCount++;
					}
				}	
			}
		}
		
		//check if last rowed burned
		for(int c = 0; c < size; c++) {
			if (a[size - 1][c].equals(" B "))
				burnThrough = true;
		}
		
		for (int r = 0; r < size; r++) {
			for(int c = 0; c < size; c++) {
				System.out.print(a[r][c]);
			}
			System.out.println();
		}
		
		System.out.println("Percent burned: " + burnCount/area);
		if (burnThrough)
			System.out.println("Fire burned through");
		else
			System.out.println("Fire burned out.");
		System.out.println();
	}
	//POST: Print a burned forest model, reporting burned through status and burn %
	
	

}
