package be.pxl.computerstore.hardware;

import java.util.Random;

public abstract class ComputerPart {
	public String vendor;
	public String name;
	public double price;
	public String articleNumber;
	static int number;//random number maken en ophogen met 1

	public ComputerPart(String vendor, String name, double price) {
		this.vendor = vendor;
		this.name = name;
		this.price = price;

	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getArticleNumber() {
		return articleNumber;
	}

	public void setArticleNumber(String vendor) {
		while (vendor.length() < 3) {
			vendor = vendor + "X";
		}
		vendor = vendor.substring(0, 3);
		
		Random randomNumber = new Random();
		int uniqueNumber = randomNumber.nextInt(1000);
		String number = String.format("%05d", uniqueNumber);
		int last1 = randomNumber.nextInt(9)+1;
		int last2 = randomNumber.nextInt(9)+1;
		int last3 = randomNumber.nextInt(9)+1;
		
		
		this.articleNumber = vendor+"-"+number+"-"+;

	}
}
