package be.pxl.computerstore.hardware;

public class Processor extends ComputerPart {

	private double clockspeed;

	public Processor(String vendor, String name, double price, double clockspeed) {
		super(vendor, name, price);
		this.clockspeed = CheckClockspeed(clockspeed);
	}

	public double getClockspeed() {
		return clockspeed;
	}

	public void setClockspeed(double clockspeed) {

		this.clockspeed = CheckClockspeed(clockspeed);
	}

	private double CheckClockspeed(double clockspeed) {
		if (clockspeed >= 0.7) {
			return clockspeed;
		} else {
			return 0.7;
		}
	}

}
