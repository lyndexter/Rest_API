package ua.lviv.iot.Lab_3.model;

public class Cube extends Toy {
	private String color;
	private String filler;
	public Cube(double priceInUAH, int ageGroup, Size size, String color, String filler) {
		super(priceInUAH, ageGroup, size);
		this.color = color;
		this.filler = filler;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getFiller() {
		return filler;
	}
	public void setFiller(String filler) {
		this.filler = filler;
	}

}
