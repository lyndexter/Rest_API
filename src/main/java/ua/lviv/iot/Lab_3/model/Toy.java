package ua.lviv.iot.Lab_3.model;

public abstract class Toy {
	private double priceInUAH;
	private int ageGroup;
	private Size size;

	public Toy(double priceInUAH, int ageGroup, Size size) {
		this.priceInUAH = priceInUAH;
		this.ageGroup = ageGroup;
		this.size = size;
	}

	public double getPriceInUAH() {
		return priceInUAH;
	}

	public void setPriceInUAH(double priceInUAH) {
		this.priceInUAH = priceInUAH;
	}

	public int getAgeGroup() {
		return ageGroup;
	}

	public void setAgeGroup(int ageGroup) {
		this.ageGroup = ageGroup;
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

}
