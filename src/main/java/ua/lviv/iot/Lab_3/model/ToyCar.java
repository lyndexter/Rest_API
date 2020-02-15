package ua.lviv.iot.Lab_3.model;

public class ToyCar extends Car {
	private String material;

	public ToyCar(double priceInUAH, int ageGroup, Size size, String color, int doorCount, int lengthInMM,
			String material) {
		super(priceInUAH, ageGroup, size, color, doorCount, lengthInMM);
		this.material = material;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

}