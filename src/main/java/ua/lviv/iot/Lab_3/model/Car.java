package ua.lviv.iot.Lab_3.model;

public abstract class Car extends Toy {
	private String color;
	private int doorCount;
	private int lengthInMM;

	public Car(double priceInUAH, int ageGroup, Size size, String color, int doorCount, int lengthInMM) {
		super(priceInUAH, ageGroup, size);
		this.color = color;
		this.doorCount = doorCount;
		this.lengthInMM = lengthInMM;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getDoorCount() {
		return doorCount;
	}

	public void setDoorCount(int doorCount) {
		this.doorCount = doorCount;
	}

	public int getLengthInMM() {
		return lengthInMM;
	}

	public void setLengthInMM(int lengthInMM) {
		this.lengthInMM = lengthInMM;
	}

}
