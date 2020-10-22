//Scott Audet
//Cubic and quadratic root finding application

package a10;

import java.util.Scanner;

public class A10ScottAudet {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		double [] coef = new double [4];		//coefficients up to cubic root
		double root1;							//quadratic root 1
		double root2;							//quadratic root 2
		double lower = 0.0;						//lower bound of interval
		double upper = 0.0;						//upper bound of interval
		double determ = 0.0;					//determinant of quadratic function
		double iRoot; double rRoot;				//iterative and recursive roots
		double a; double b; double c; double d;	//coefficient assignments from array
		
		System.out.println("Scott Audet");
		
		//loop to assign coefficients defined by user
		System.out.print("Enter coefficients a, b, c, d, of equation ax^3 + bx^2 + cx + d: ");
		for (int x = 0; x < 4; x++) {
			coef[x] = scan.nextDouble();
		}
		System.out.println();
		
		//assignment of lower and upper bounds by user
		System.out.print("Enter lower x and upper x: ");
		lower = scan.nextDouble();
		upper = scan.nextDouble();
		System.out.println();
		
		scan.close();
		
		a = coef[0];
		b = coef[1];
		c = coef[2];
		d = coef[3];
		
		//if quadratic function use quadratic formula to find roots
		if (a == 0) {

			determ = Math.pow(c, 2) - 4 * b * d;
			root1 = (-c + Math.sqrt(determ))/(2 * b);
			root2 = (-c - Math.sqrt(determ))/(2 * b);
			
			if ((root1 >= lower) && (root1 <= upper))
				System.out.println("Root is approximately: " + root1);
			if ((root2 >= lower) && (root2 <= upper))
				System.out.println("Root is approximately: " + root2);
		}
		
		//if cubic function use Bisect Method to find root approximation
		else {
			rRoot = BisectMethods.rbisect(coef, lower, upper);
			System.out.println();
			iRoot = BisectMethods.ibisect(coef, lower, upper);
			System.out.println();
			System.out.println("The recursive root is approximately: " + rRoot);
			System.out.println();
			System.out.println("The iterative root is approximately: " + iRoot);
		}

	}

}
