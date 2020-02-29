package ua.lviv.iot.lab3.writter;

import java.io.IOException;
import java.io.Writer;
import java.util.List;
import ua.lviv.iot.lab3.model.Toy;

public class ToyWriter {
    private Writer textWriter;

    public void setTextWriter(Writer textWriter) {
        this.textWriter = textWriter;
    }

    public void writeToFile(List<Toy> toys) throws IOException {
        for (Toy toy : toys) {
            textWriter.write(toy.getHeaders() + "," + toy.toCSV());
            textWriter.write("\n");
        }
        textWriter.flush();
    }

    @Override
    public String toString() {
        return textWriter.toString();
    }

}
