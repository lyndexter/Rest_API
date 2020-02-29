package ua.lviv.iot.lab3.launcher;

import static org.junit.jupiter.api.Assertions.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;

import org.junit.jupiter.api.Test;

import ua.lviv.iot.lab3.model.Toy;
import ua.lviv.iot.lab3.writter.ToyWriter;

class ToyWriterTest extends BaseToysManagerTest {
    ToyWriter toyWriter = new ToyWriter();

    @Test
    void WriteToFileTest() throws IOException {
        toyWriter.setTextWriter(new FileWriter("info.csv"));
        toyWriter.writeToFile(toyCars);
    }

    @Test
    void StringWriterTest() throws IOException {
        String expectedResult = "";

        toyWriter.setTextWriter(new StringWriter());
        toyWriter.writeToFile(toyCars);

        for (Toy toy : toyCars) {
            expectedResult += toy.getHeaders() + "," + toy.toCSV() + "\n";
        }
        assertEquals(expectedResult, toyWriter.toString());
    }

}
