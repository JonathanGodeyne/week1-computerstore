package be.pxl.computerstore.hardware;

import be.pxl.computerstore.util.Computable;
import be.pxl.computerstore.util.TooManyPeripheralsException;

public class ComputerSystem implements Computable {
	private Processor processor;
	private ComputerCase computerCase;
	private Peripheral[] peripherals = new Peripheral[3];
	static int MAX_PERIPHERAL;

	public ComputerSystem() {
		MAX_PERIPHERAL = 0;
	}

	public Processor getProcessor() {
		return processor;
	}

	public void setProcessor(Processor processor) {
		this.processor = processor;
	}

	public ComputerCase getComputerCase() {
		return computerCase;
	}

	public void setComputerCase(ComputerCase computerCase) {
		this.computerCase = computerCase;
	}

	public Peripheral[] getPeripherals() {
		return peripherals;
	}

	public void addPeripheral(Peripheral peripheral) throws TooManyPeripheralsException {
		if (MAX_PERIPHERAL > 2) {
			throw new TooManyPeripheralsException();
		} else {
			peripherals[MAX_PERIPHERAL] = peripheral;
			MAX_PERIPHERAL++;
		}
	}

	public void removePeripheral(String articleNumber) {
		Peripheral[] peripheralsHelp = new Peripheral[3];
		int peripheralsHelpIndex = 0;
		for (int index = 0; index < 3; index++) {
			if (peripherals[index] != null && peripherals[index].getArticleNumber() != articleNumber) {
				peripheralsHelp[peripheralsHelpIndex] = peripherals[index];
				peripheralsHelpIndex++;
			}
		}
		peripherals = peripheralsHelp;
		MAX_PERIPHERAL--;
	}

	public int getNumberOfPeripherals() {
		int counter = 0;
		for (int i = 0; i < peripherals.length; i++)
			if (peripherals[i] != null) {
				counter++;
			}
		return counter;
	}

	public double totalPriceExcl() {
		double priceExcl;
		priceExcl = processor.getPrice() + computerCase.getPrice();
		for (Peripheral peripheral : peripherals) {
			if (peripheral != null) {
				priceExcl = priceExcl + peripheral.getPrice();
			}
		}
		return priceExcl;
	}

	public double totalPriceIncl() {
		double btw = BTW;
		double result = this.totalPriceExcl() * ((100 + btw) / 100);
		return result;
	}

	public String toString() {
		int index = 1;
		StringBuilder builder = new StringBuilder();
		builder.append("Computercase: \n").append(computerCase.toString()).append("\n");
		builder.append("Processor: \n").append(processor.toString()).append("\n");
		for (Peripheral peripheral : peripherals) {
			if (peripheral != null) {
				builder.append("Randapparaat ").append(index).append(":\n").append(peripheral.toString()).append("\n");
				index++;
			}
		}
		builder.append("TOTAAL EXCL.: ").append(this.totalPriceExcl()).append("\n");
		builder.append("TOTAAL INCL.: ").append(this.totalPriceIncl()).append("\n");

		String text = builder.toString();
		return text;
	}

}
