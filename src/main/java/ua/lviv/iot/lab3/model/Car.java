package ua.lviv.iot.lab3.model;

public abstract class Car extends Toy {
    private String color;
    private int doorCount;
    private int lengthInMM;

    public Car(double priceInUAH, int ageGroup, Size size, String color, int doorCount,
            int lengthInMM, TypeOfToy typeOfToy) {
        super(priceInUAH, ageGroup, size);
        this.color = color;
        this.doorCount = doorCount;
        this.lengthInMM = lengthInMM;
        super.setTypeOfToy(typeOfToy);
    }

    public String getHeaders() {
        return super.getHeaders() + "," + "color" + "," + "doorCount" + "," + "lengthInMM";
    }

    public String toCSV() {
        return super.toCSV() + "," + getColor() + "," + getDoorCount() + "," + getLengthInMM();
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
