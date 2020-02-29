package ua.lviv.iot.lab3.model;

public class ToyCar extends Car {
    private String material;

    public ToyCar(double priceInUAH, int ageGroup, Size size, String color, int doorCount,
            int lengthInMM, String material) {
        super(priceInUAH, ageGroup, size, color, doorCount, lengthInMM, TypeOfToy.TOYCAR);
        this.material = material;
    }

    public String getHeaders() {
        return super.getHeaders() + "," + "material";
    }

    public String toCSV() {
        return super.toCSV() + "," + getMaterial();
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

}
