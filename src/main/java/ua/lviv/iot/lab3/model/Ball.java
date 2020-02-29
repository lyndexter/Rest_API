package ua.lviv.iot.lab3.model;

public class Ball extends Toy {
    private Type type;

    public Ball(final double priceInUAH, final int ageGroup, final Size size, final Type type) {
        super(priceInUAH, ageGroup, size);
        this.type = type;
        super.setTypeOfToy(TypeOfToy.BALL);
    }

    public String getHeaders() {
        return super.getHeaders() + "," + "type";
    }

    public String toCSV() {
        return super.toCSV() + "," + getType();
    }

    public Type getType() {
        return type;
    }

    public void setType(final Type type) {
        this.type = type;
    }

}
