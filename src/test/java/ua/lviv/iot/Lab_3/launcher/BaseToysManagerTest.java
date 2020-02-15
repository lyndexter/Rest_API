package ua.lviv.iot.Lab_3.launcher;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import ua.lviv.iot.Lab_3.model.Size;
import ua.lviv.iot.Lab_3.model.Toy;
import ua.lviv.iot.Lab_3.model.ToyCar;

class BaseToysManagerTest {
	protected List<Toy> toyCars;

	@BeforeEach
	public void createToyCars() {
		toyCars = new LinkedList<Toy>();
		toyCars.add(new ToyCar(400, 6, Size.SMALL, "yellow", 4, 150, "Metal"));
		toyCars.add(new ToyCar(3000, 6, Size.SMALL, "red", 4, 1000, "Aluminium"));
		toyCars.add(new ToyCar(300, 4, Size.SMALL, "green", 2, 150, "Plastic"));
		toyCars.add(new ToyCar(320, 5, Size.LARGE, "blue", 2, 150, "Plastic"));

	}
}
