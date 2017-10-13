package be.pxl.computerstore.hardware;

public class HardDisk extends ComputerPart{
	
	private int volume;

	public HardDisk(String vendor, String name, double price, int volume) {
		super(vendor, name, price);
		this.volume = volume;
	}

	
}
