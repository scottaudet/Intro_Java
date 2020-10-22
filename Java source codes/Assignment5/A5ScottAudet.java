import java.util.Scanner;
import java.io.*;

public class A5ScottAudet {

	public static void main(String[] args) throws IOException {
		
		//retrieve file from mac desktop
		Scanner filescan = new Scanner(new FileReader("/Users/scottaudet/Desktop/bookorders.txt"));
		//printer instance
		PrintWriter printer = new PrintWriter(new File("bookOrderReport.txt"));
		
		String courseName = "";		//course title
		String ISBN = "";			//book ISBN number
		String course = "";			//course code
		int booksToOrder = 0;		//number of books to order
		
		//printed header to file
		printer.println("Book Order Program by Scott Audet\n");
		printer.println(String.format("%-55s %-20s %-10s %-14s %-10s", "Title",
		"ISBN", "Course", "Enrollment", "# to Order"));

		//loop for each course instance in .txt file
		while (filescan.hasNext()) {
			
			courseName = filescan.nextLine();
			
			ISBN = filescan.nextLine();
			ISBN = stripDashes(ISBN);
			
			course = filescan.nextLine();
			
			int enroll = Integer.parseInt(filescan.nextLine());
			
		//method call	
			booksToOrder = numberToOrder(course, enroll);
			
		//print conditional
			if (isValid(ISBN)) {
				printer.println(String.format("%-55s %-20s %-10s %-14d %-10d", 
					courseName, ISBN, course, enroll, booksToOrder));
			}
			else 
				printer.println(String.format("%-55s %-20s %-10s %-14d %-10d", 
						courseName, "INVALID ISBN", course, enroll, booksToOrder));
		}
		//scanner and printer close methods
		filescan.close();
		printer.close();
	}

	
	
	
	public static String stripDashes(String s) {		//PRE: string of ISBN
		Scanner line = new Scanner(s);					//POST: string with
		String newNumber = "";							//		dashes removed
		
		while (line.hasNext()) {
			line.useDelimiter("-");
			newNumber += line.next();
		}
		line.close();
		return newNumber;
	}
	
	public static boolean isValid(String s) {			//PRE:	string of digits
		Scanner line = new Scanner(s);					//		with no hyphen
		int digit1;										//POST:	return true is s
		int digit2;										//		is a valid ISBN;
		int sum = 0;									//		else false
		String testCheckDigit;
		String checkDigit;
		
		if (s.length() != 13) {
			line.close();
			return false;
		}
		
		for (int k = 0; k < s.length()-1; k++) {
			if (!Character.isDigit(s.charAt(k))) {
				line.close();
				return false;
			}
		}
		
		for (int k = 0; k < 12; k += 2) {
			digit1 = Character.getNumericValue((s.charAt(k)));
			digit2 = Character.getNumericValue(s.charAt(k+1));
			sum += (digit1 * 1) + (digit2 * 3);
		}
		
		testCheckDigit = Integer.toString(10 - (sum % 10));
		checkDigit = s.substring(s.length()-1, s.length());
		
		line.close();
		return testCheckDigit.equals(checkDigit);
	}
	
	public static int numberToOrder(String course, int enroll) {
															//PRE: valid course		
		String k = course;									//code and integer	
		int e = enroll;										
		int toOrder = 0;									//POST: return the number
															//of books to orders as max
		switch(k) {											//of current and historical
		case "COS103":										//enrollment		
			toOrder = (e > 50) ? e : 50;
			break;
		case "COS120":
			toOrder = (e > 48) ? e : 48;
			break;
		case "COS125":
			toOrder = (e > 110) ? e : 110;
			break;
		case "COS213":
			toOrder = (e > 96) ? e : 96;
			break;
		case "COS220":
			toOrder = (e > 100) ? e : 100;
			break;
		case "COS221":
			toOrder = (e > 40) ? e : 40;
			break;
		case "COS235":
			toOrder = (e > 85) ? e : 85;
			break;
		case "COS312":
			toOrder = (e > 45) ? e : 45;
			break;
		case "COS331":
			toOrder = (e > 50) ? e : 50;
			break;
		}
			
		return toOrder;
	}


}