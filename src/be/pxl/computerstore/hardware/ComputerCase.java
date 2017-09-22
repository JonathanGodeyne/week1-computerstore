package be.pxl.computerstore.hardware;

import be.pxl.computerstore.util.Dimension;

public class ComputerCase {
	
	private String vendor;
	private String name;
	private double price;
	private Dimension dimension;
	private double weight;

	public ComputerCase(String vendor, String name, double price) {
		super();
		this.vendor = vendor;
		this.name = name;
		this.price = price;
	}

	public Dimension getDimension() {
		return dimension;
	}

	public void setDimension(Dimension dimension) {
		this.dimension = dimension;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getVendor() {
		return vendor;
	}

	
	public String getName() {
		return name;
	}

	
	public double getPrice() {
		return price;
	}

	
	
	
}
