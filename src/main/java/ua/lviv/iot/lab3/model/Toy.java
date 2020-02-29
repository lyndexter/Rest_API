package ua.lviv.iot.lab3.model;

public abstract class Toy {
    private double priceInUAH;
    private int ageGroup;
    private Size size;
    private TypeOfToy typeOfToy;

    public Toy(double priceInUAH, int ageGroup, Size size) {
        this.priceInUAH = priceInUAH;
        this.ageGroup = ageGroup;
        this.size = size;
    }

    public String getHeaders() {
        return "priceInUAH" + "," + "ageGroup" + "," + "size" + "," + "typeOfToy";
    }

    public String toCSV() {
        return getPriceInUAH() + "," + getAgeGroup() + "," + getSize() + "," + getTypeOfToy();
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

    public TypeOfToy getTypeOfToy() {
        return typeOfToy;
    }

    public void setTypeOfToy(TypeOfToy typeOfToy) {
        this.typeOfToy = typeOfToy;
    }

}
