//Scott Audet
//Array of student records

package A7;

import java.util.Scanner;
import java.io.*;
import java.text.DecimalFormat;

public class A7ScottAudet {

	public static void main(String[] args) throws IOException {
		Student [] students = new Student [24];		//Student array of 24
		String first = "";							//Student object first name
		String last = "";							//Student object last name
		String ID = "";								//Student object ID
		int midGrade = 0;							//Student object midterm score
		int finGrade = 0;							//Student object final score
		int k = 0;									//counter instance
		double midMean = 0.0;						//midterm mean
		double finMean = 0.0;						//final mean
		double midStdDev = 0.0;						//midterm std deviation
		double finStdDev = 0.0;						//final std deviation
		String userCode = "";						//user entered code to search
		
		//scanner instances for mac file and user input
		Scanner scan = new Scanner(new FileReader("/Users/scottaudet/Desktop/grades.txt"));
		Scanner userScan = new Scanner(System.in);
		
		//decimal point formatter
		DecimalFormat fmt = new DecimalFormat("#.##");
		
		//loop to collect object information then assign new object to array
		while (scan.hasNext()) {
			ID = scan.next();
			last = scan.next();
			first = scan.next();
			scan.next();
			scan.next();
			midGrade = scan.nextInt();
			finGrade = scan.nextInt();
			
			students[k] = new Student(ID, last, first, midGrade, finGrade);
			k++;
		}
		scan.close();
		
		//grades.txt output - curve scores, and student codes
		System.out.println("Scott Audet's class");
		System.out.println();
		System.out.println(String.format("%-15s %-15s %-15s %-15s %-15s",  "Student Code",
				"MidTerm Score", "MidTerm Letter", "Final Score", "Final Letter"));
		
		midMean = mean(students, 'M');					//mean function call for mid
		finMean = mean(students, 'F');					//mean function call for final
		midStdDev = stddev(students, 'M', midMean);		//std dev call for mid
		finStdDev = stddev(students, 'F', finMean);		//std dev call for final
		
		//loop to format and print student code and report
		for (k = 0; k < students.length; k++) {
			String printCode = students[k].getNameCode();
			int printMid = students[k].getMidtermGrade();
			char midLetter = letter(students[k].getMidtermGrade(), midMean, midStdDev);
			String printMidLetter = Character.toString(midLetter);
			int printFin = students[k].getFinalGrade();
			char finLetter = letter(students[k].getFinalGrade(), finMean, finStdDev);
			String printFinLetter = Character.toString(finLetter);
			
			System.out.println(String.format("%-20s %-17d %-13s %-15d %-17s", printCode, 
					printMid, printMidLetter, printFin, printFinLetter));
		}
		
		//mean and standard deviation outputs
		System.out.println();
		System.out.println("Midterm mean: " + fmt.format(midMean));
		System.out.println("MidTerm standard deviation: " + fmt.format(midStdDev));
		System.out.println("Final mean: " + fmt.format(finMean));
		System.out.println("Final standard deviation: " + fmt.format(finStdDev));
		System.out.println();
		
		//user input for interactive portion
		System.out.println("Please enter a student code(quit to exit): ");
		userCode = userScan.next();
		
		//check-loop for user entry...type quit to exit
		do {
			
			int i = 0;
			i = search(students, userCode);
			
			if (i == -1)
				System.out.println("Did not find: " + userCode);
			else {
			System.out.println(students[i].getName() + " has midterm " + students[i].getMidtermGrade() +
					" with grade " + letter(students[i].getMidtermGrade(), midMean, midStdDev) + 
					" and final exam " + students[i].getFinalGrade() + " with grade " +
					letter(students[i].getFinalGrade(), finMean, finStdDev));
			}
			
			userCode = userScan.next();
			
		} while (!userCode.toLowerCase().equals("quit"));
		
		userScan.close();
	}
	
	// PRE: c is 'M' for midterm and 'F' for final exam
	public static double mean(Student[] g, char c) {
		double sum = 0;
		if (c == 'M') {
			for (int k = 0; k < g.length; k++) {
				sum += g[k].getMidtermGrade();
			}
		}
		else {
			for (int k = 0; k < g.length; k++) {
				sum += g[k].getFinalGrade();
			}
		}
		return sum/g.length;
	}
	// POST: return the arithmetic average of values in array


	// PRE: c is 'M' for midterm and 'F' for final exam, 0 <= m <= 100
	public static double stddev(Student g[ ], char c, double m) {
		double sum = 0;
		if (c == 'M') {
			for (int k = 0; k < g.length; k++) {
				sum += Math.pow((g[k].getMidtermGrade() - m), 2);
			}
		}
		else {
			for (int k = 0; k < g.length; k++) {
				sum += Math.pow((g[k].getFinalGrade() - m), 2);
			}
		}
		return Math.sqrt(sum / (g.length - 1));
	}
	// POST: return the standard deviation of values in array with mean m

	// PRE: 0 <= score, m, s <= 100
	public static char letter(int score, double m, double s) {
		if (score < m - (1.5 * s))
			return 'F';
		else if ((m - 1.5 * s <= score) && (score < m - 0.5 * s))
			return 'D';
		else if ((m - 0.5 * s <= score) && (score < m + 0.5 * s))
			return 'C';
		else if ((m + 0.5 * s <= score) && (score < m + 1.5 * s))
			return 'B';
		else
			return 'A';
	}
	// POST: return letter grade for score with mean m and standard deviation s

	public static int search (Student [ ] g, String code) {
		int index = -1;
		for (int k = 0; k < g.length; k++) {
			if (g[k].getNameCode().equals(code))
				index = k;
		}
		return index;
	}
	// POST:  return index of first occurrence of code or –1 if not found


}
