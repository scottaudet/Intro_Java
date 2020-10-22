import java.util.Scanner;
import java.io.*;

public class A4ScottAudet {

	public static void main(String[] args) throws IOException {
		
		//retrive file from mac desktop
		Scanner filescan = new Scanner(new FileReader("/Users/scottaudet/Desktop/weather.txt"));
		Scanner filescan2 = new Scanner(new FileReader("/Users/scottaudet/Desktop/averages.txt"));

		String townName = "";
		String date = "";
		double temp = 0.0;
		String windDirection = "";
		double windSpeed = 0.0;
		double windChill = 0.0;
		String reporter;
		String name;				//place holder to create reporter code
		char letter;
		
		String month;				//historical avg month
		String histTempStr;			//historical temp as string
		Double histTemp;			//histroical temp converted
		String testMonth = "";		//month entered in top section
		Double histDiff = 0.0;		//historical difference of testMonth
		
		double averageTemp = 0;		//sum to be calculated for average
		double maxTemp = 0;			//max temp entered
		double minTemp = 100;		//min temp entered

		int bangorCount = 0;		//total Bangor entries
		int oronoCount = 0;			//total Orono entries
		int calaisCount = 0;		//total Calais entries
		
		
		//initial print statement for txt header
		PrintWriter printer = new PrintWriter(new File("weatherout.txt"));
		printer.println("Weather watch by Scott Audet");
		printer.println();
		printer.println(String.format("%-10s %-10s %-10s %-15s %-15s %-15s %-10s",
				"Town", "Date", "Temp", "Direction", "Wind Speed", "Wind Chill",
				"Reporter"));
		
		//loop to print each entry line after it has been worked
		while(filescan.hasNext()) {
			
			String reporterCode = "";
			
			String line = filescan.nextLine();
			Scanner linescan = new Scanner(line);
			
		//inner loop to separate line into workable parts
			while(linescan.hasNext()) {
				townName = linescan.next();
				date = linescan.next();
				temp = linescan.nextDouble();
				windDirection = linescan.next();
				windSpeed = linescan.nextDouble();
				reporter = linescan.nextLine();
				reporter = reporter.trim();
				
				windChill = 35.74 + (0.6125 * temp) - (3.75 * Math.pow(windSpeed, 0.16))
						+ (0.4275 * temp * Math.pow(windSpeed, 0.16));
				
				averageTemp += temp;
				if (maxTemp < temp)
					maxTemp = temp;
				if (minTemp > temp)
					minTemp = temp;
				
				Scanner codeGen = new Scanner(reporter);
				while (codeGen.hasNext()) {
					name = codeGen.next();
					letter = name.charAt(0);
					reporterCode += letter;
				}
				
				switch (townName) {
				case "Bangor": bangorCount++; break;
				case "Orono": oronoCount++; break;
				case "Calais": calaisCount++; break;
				}

				codeGen.close();
				
			}
			printer.println(String.format("%-10s %-10s %-10.2f %-15s %-15.2f %-15.2f %-10s", 
					townName, date, temp, windDirection, windSpeed, windChill, reporterCode));
			
			linescan.close();
		}
		
		//weather.txt calculations and output to txt
		printer.println();
		
		printer.println(String.format("%-20s %-10.2f", "Average temperature:", 
				averageTemp/(double)(bangorCount + oronoCount + calaisCount)));
		printer.println(String.format("%-20s %-10.2f","Maximum temperature:", maxTemp));
		printer.println(String.format("%-20s %-10.2f", "Minimum temperature:", minTemp));
		
		printer.println();
		
		printer.println("Number of readings:");
		printer.println(String.format("%-10s %-10d", "Bangor:", bangorCount));
		printer.println(String.format("%-10s %-10d", "Orono:", oronoCount));
		printer.println(String.format("%-10s %-10d", "Calais:", calaisCount));
		
		date = date.substring(0, 2);
		
		//loop to determine month entered in weather.txt
		switch (date) {
		case "01": testMonth = "January"; break;
		case "02": testMonth = "February"; break;
		case "03": testMonth = "March"; break;
		case "04": testMonth = "April"; break;
		case "05": testMonth = "May"; break;
		case "06": testMonth = "June"; break;
		case "07": testMonth = "July"; break;
		case "08": testMonth = "August"; break;
		case "09": testMonth = "September"; break;
		case "10": testMonth = "October"; break;
		case "11": testMonth = "November"; break;
		case "12": testMonth = "December"; break;
		}
		
		printer.println();
		printer.println("Historical Averages");	//lower section header to txt
		
		//loop to manage historical data and calculate entry to type double
		while(filescan2.hasNext()) {
			month = filescan2.next();
			histTempStr = filescan2.nextLine();
			histTemp = Double.parseDouble(histTempStr.trim());
			
			printer.println(String.format("%-10s %-10.2f", month, histTemp));
			
			if (month.contentEquals(testMonth))
				histDiff = (averageTemp/(double)(bangorCount + oronoCount + 
						calaisCount) - histTemp);
		}
		
		//final output statement to txt
		printer.println();
		printer.println(String.format("The difference between this %s and historical is %.2f",
				testMonth, histDiff));
		
		//Scanner and PrintWriter close methods
		printer.close();
		filescan.close();
		filescan2.close();
	}
}
