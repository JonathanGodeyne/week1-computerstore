package be.pxl.computerstore.hardware;

public class Keyboard extends Peripheral{
	private KeyboardLayout keyboardLayout;
	public Keyboard(String vendor, String name, double price, KeyboardLayout keyboardLayout) {
		super(vendor, name, price);
		this.keyboardLayout = keyboardLayout;

	}

}
