package ua.lviv.iot.lab3.model;

public class Doll extends Toy {
    private String colorOfEyes;
    private String phrase;

    public void tell(String phrase) {
        System.out.println(phrase);
    }

    public Doll(double priceInUAH, int ageGroup, Size size, String colorOfEyes, String phrase) {
        super(priceInUAH, ageGroup, size);
        this.colorOfEyes = colorOfEyes;
        this.phrase = phrase;
        super.setTypeOfToy(TypeOfToy.DOLL);
    }

    public String getHeaders() {
        return super.getHeaders() + "," + "colorOfEyes" + "," + "phrase";
    }

    public String toCSV() {
        return super.toCSV() + "," + getColorOfEyes() + "," + getPhrase();
    }

    public String getColorOfEyes() {
        return colorOfEyes;
    }

    public void setColorOfEyes(String colorOfEyes) {
        this.colorOfEyes = colorOfEyes;
    }

    public String getPhrase() {
        return phrase;
    }

    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }

}
