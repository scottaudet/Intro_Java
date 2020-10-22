//Scott Audet
//Product class

package a8;

public class Product {
	
	private String name = "";			//name of product
	private int stockAmount = 0;		//number of product
	private double unitPrice = 0.0;		//unit price of product
	
	//default constructor
	public Product() {
		name = "";
		stockAmount = 0;
		unitPrice = 0.00;
	}
	
	//parameterized constructor
	public Product(String name, int amount, double price) {
		this.name = name;
		this.stockAmount = amount;
		this.unitPrice = price;
	}

	//access/modify methods
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStockAmount() {
		return stockAmount;
	}

	public void setStockAmount(int stockAmount) {
		this.stockAmount = stockAmount;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	

}
