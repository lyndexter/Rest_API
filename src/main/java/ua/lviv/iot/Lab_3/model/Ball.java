package ua.lviv.iot.Lab_3.model;

public class Ball extends Toy {
	private Type type;

	public Ball(double priceInUAH, int ageGroup, Size size, Type type) {
		super(priceInUAH, ageGroup, size);
		this.type = type;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

}
