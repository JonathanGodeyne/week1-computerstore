package be.pxl.computerstore.hardware;

import java.util.Random;

public abstract class ComputerPart {
	public String vendor;
	public String name;
	public double price;
	public String articleNumber;
	static int number;

	public ComputerPart(String vendor, String name, double price) {
		this.vendor = vendor;
		this.name = name;
		this.price = price;
		number = number++;
		this.articleNumber = FirstArticleNumber(vendor);
	}

	private String FirstArticleNumber(String vendor2) {
		String articleNumberVendor = vendor;
		String numberString = String.format("%05d", number);

		while (articleNumberVendor.length() < 3) {
			articleNumberVendor = articleNumberVendor + "X";
		}
		articleNumberVendor = (articleNumberVendor.substring(0, 3)).toUpperCase();

		Random randomNumber = new Random();
		int last1 = randomNumber.nextInt(9) + 1;
		int last2 = randomNumber.nextInt(9) + 1;
		int last3 = randomNumber.nextInt(9) + 1;
		String uniqueNumber = last1 + "" + last2 + "" + last3;

		StringBuilder builder = new StringBuilder();
		builder.append(articleNumberVendor);
		builder.append("-");
		builder.append(numberString);
		builder.append("-");
		builder.append(uniqueNumber);
		String result = builder.toString();
		return result;
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

	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ArticleNumber = ").append(articleNumber).append("\n");
		builder.append("Vendor = ").append(vendor).append("\n");
		builder.append("Name = ").append(name).append("\n");
		builder.append("Price = ").append(price).append("\n");
		String text = builder.toString();
		return text;
	}

	public String getShortDescription() {
		String result;
		String className = this.getClass().getSimpleName();
		if (className.matches("Keyboard|GamingController|Monitor|Mouse|WebCam")) {
			result = this.getArticleNumber() + " * " + className + " * " + this.getName() + " * " + this.getPrice()
					+ "€";
		} else

		{
			result = this.getArticleNumber() + " * " + this.getName() + " * " + this.getPrice() + "€";
		}

		return result;
	}
}
