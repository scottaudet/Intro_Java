//Scott Audet
//Inventory management program

package a8;

import java.util.Scanner;
import java.io.*;
import java.text.NumberFormat;

public class A8ScottAudet {

	public static void main(String[] args) throws IOException {
		
		//scanner instances for main
		Scanner scan = new Scanner(new FileReader("/users/scottaudet/Desktop/inventory.txt"));
		Scanner userScan = new Scanner(System.in);
		
		final int CAPACITY = 50;							//max size of array
		
		Product [] inventory = new Product [CAPACITY];		//new array Product
		String name;
		String userChoice = "";								//user input
		int amount;
		int size = 0;										//size of used array spaces
		double price;
		
		//loop to scan file values into array of Product objects
		while (scan.hasNext()) {
			name = scan.next();
			amount = scan.nextInt();
			price = Double.parseDouble(scan.nextLine());
			
			inventory[size] = new Product(name, amount, price);
			
			size++;
		}
		scan.close();
		
		//header and main menu output
		System.out.println("Inventory Manager");
		System.out.println("By Scott Audet");
		System.out.println();
		
		System.out.println("Please select a menu item:");
		System.out.println("E - Edit");
		System.out.println("I - Insert");
		System.out.println("R - Remove");
		System.out.println("D - Display table");
		System.out.println("Q - Quit");
		System.out.println();
		System.out.print("Enter a command: ");
		
		userChoice = userScan.next();
		
		//sentinel loop for user input and function call
		do {

			if (userChoice.equals("E")) {
				System.out.print("Enter item: ");
				name = userScan.next();
				edit(inventory, size, name);

			}
			else if (userChoice.equals("I")) {
				System.out.print("Enter new product ID, stock and unit price: ");
				name = userScan.next();
				amount = userScan.nextInt();
				price = userScan.nextDouble();
				size = insert(inventory, size, name, amount, price);
			}
			else if (userChoice.equals("R")) {
				System.out.print("Enter ID of product to be removed: ");
				name = userScan.next();
				size = remove(inventory, size, name);
			}
			else if (userChoice.equals("D")) {
				display(inventory, size);
			}
			
			System.out.println();
			System.out.print("Enter a command: ");
			userChoice = userScan.next();
			System.out.println();
			
		} while (!userChoice.equals("Q"));
		userScan.close();
	}
	
	//PRE: Product array, array size, item to be searched
	public static void edit(Product [] a, int size, String item) {
		Scanner editScan = new Scanner(System.in);
		
		boolean change = false;
		int k = 0;
		
		for(int i = 0; i < size; i++) {
			if (a[i].getName().equals(item)) {
				change = true;
				k = i;
			}
		}
		if (change) {
			System.out.print("Enter amount to (+) add or (-) subtract: ");
			int newAmount = editScan.nextInt();
			a[k].setStockAmount(a[k].getStockAmount() + newAmount);
			System.out.println("Item: " + a[k].getName() + " has new amount " +
					a[k].getStockAmount());
		}
		else {
			System.out.println("Item: " + item + " not found");
		}
		editScan.close();
	}
	//POST: Change is made to array element or item not found statement printed
	
	//PRE: Product array, array size, item, amount, unit price
	public static int insert(Product [] a, int size, String item, int newAmount, double newPrice) {
		boolean change = true;
		
		for(int i = 0; i < size; i++) {
			if (a[i].getName().equals(item)) {
				System.out.println("Item " + item + " already exists");
				change = false;
			}
		}
		
		if (change) {
			a[size] = new Product (item, newAmount, newPrice);
			size++;
			System.out.println("Item " + item + " is inserted");
		}
		return size;
	}
	//POST: Print if insertion was a success then returns increased size value
	
	public static int remove(Product [] a, int size, String item) {
		boolean change = false;
		
		for(int i = 0; i < size; i++) {
			if (a[i].getName().equals(item)) {
				a[i] = a[size -1];
				System.out.println("Item " + item + " removed");
				size--;
				change = true;
			}
		}
		if (!change) {
			System.out.println("Item " + item + " does not exist");
		}
		return size;
	}

	//PRE: Product array, array size
	public static void display(Product [] a, int size) {
		NumberFormat fmt = NumberFormat.getCurrencyInstance();
		double sum = 0.0;
		
		System.out.println(String.format("%-15s %-10s %-10s", "ID", "Stock", "Unit Price"));
		
		for(int i = 0; i < size; i++) {
			
			sum += a[i].getStockAmount() * a[i].getUnitPrice();
			System.out.println(String.format("%-15s %-10d %-10s", a[i].getName(),
					a[i].getStockAmount(), fmt.format(a[i].getUnitPrice())));
		}
		System.out.println("Total Inventory: " + fmt.format(sum));
	}
	//POST: Formatted table to array elements and total value
}

