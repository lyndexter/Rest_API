package ua.lviv.iot.spring.rest.model;

public class CarWithRemoteControl extends Car {

    private int batteryCapacityInMah;

    public CarWithRemoteControl(double priceInUAH, int ageGroup, Size size, String color,
            int doorCount, int lengthInMM, int batteryCapacityInMah) {
        super(priceInUAH, ageGroup, size, color, doorCount, lengthInMM,
                TypeOfToy.CARWITHREMOUTCONTROL);
        this.batteryCapacityInMah = batteryCapacityInMah;
    }

    public String getHeaders() {
        return super.getHeaders() + "," + "batteryCapacityInMah";
    }

    public String toCSV() {
        return super.toCSV() + "," + getBatteryCapacityInMah();
    }

    public int getBatteryCapacityInMah() {
        return batteryCapacityInMah;
    }

    public void setBatteryCapacityInMah(int batteryCapacityInMah) {
        this.batteryCapacityInMah = batteryCapacityInMah;
    }

}
