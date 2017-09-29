package be.pxl.computerstore.hardware;

import be.pxl.computerstore.util.Dimension;

public class ComputerCase extends ComputerPart {

	private Dimension dimension;
	private double weight;

	public ComputerCase(String vendor, String name, double price) {
		super(vendor,name, price);
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
	
	public String toString() {
		String result = super.toString();
		result = result
				+"\n"+"Width = "+dimension.getWidth()+"mm"
				+"\n"+"Height = "+dimension.getHeight()+"mm"
				+"\n"+"Depth = "+dimension.getDepth()+"mm"
				+"\n"+"Weight = "+weight+"kg";
		return result;
	}
}
