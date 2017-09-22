package be.pxl.computerstore.hardware;

public class Processor {
	
	private String vendor;
	private String name;
	private double price;
	private double clockspeed;
	
	public Processor(String vendor, String name, double price, double clockspeed) {
		super();
		this.vendor = vendor;
		this.name = name;
		this.price = price;
		this.clockspeed = CheckClockspeed(clockspeed);
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

	public double getClockspeed() {
		return clockspeed;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setClockspeed(double clockspeed) {
		
		this.clockspeed = CheckClockspeed(clockspeed);
	}
	private double CheckClockspeed(double clockspeed) {
		if(clockspeed >= 0.7) {
			return clockspeed;
		}else {
			return 0.7;	
		}
	}
	
	
	

}
