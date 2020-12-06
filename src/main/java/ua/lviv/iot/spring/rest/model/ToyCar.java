package ua.lviv.iot.spring.rest.model;

import javax.persistence.Entity;

@Entity
public class ToyCar extends Car {
    private String title;
    private String description;
    private String image;
    private String material;
    private Integer rate;
    private Integer numberMarks;
    private Integer wanted;
    private Integer bought;

    public ToyCar(double priceInUAH, int ageGroup, Size size, String color, int doorCount,
            int lengthInMM, TypeOfToy typeOfToy, String title, String description, String image,
            String material, Integer rate, Integer wanted, Integer bought, Integer numberMarks) {
        super(priceInUAH, ageGroup, size, color, doorCount, lengthInMM, TypeOfToy.TOYCAR);
        this.title = title;
        this.description = description;
        this.image = image;
        this.material = material;
        this.rate = rate;
        this.wanted = wanted;
        this.bought = bought;
        this.numberMarks=numberMarks;
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

    public ToyCar() {
        super(0, 0, null, null, 0, 0, null);
        this.material = null;
    }

    public Integer getBought() {
        return bought;
    }

    public void setBought(Integer bought) {
        this.bought = bought;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public Integer getWanted() {
        return wanted;
    }

    public void setWanted(Integer wanted) {
        this.wanted = wanted;
    }

    public Integer getNumberMarks() {
        return numberMarks;
    }

    public void setNumberMarks(Integer numberMarks) {
        this.numberMarks = numberMarks;
    }

}
