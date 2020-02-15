package ua.lviv.iot.Lab_3.launcher;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ua.lviv.iot.Lab_3.manager.ToysManager;
import ua.lviv.iot.Lab_3.model.Size;
import ua.lviv.iot.Lab_3.model.Toy;

class ToysManagerTest extends BaseToysManagerTest {

	private ToysManager toysManager;

	@BeforeEach
	void setUp() throws Exception {
		toysManager = new ToysManager();
		toysManager.addToys(toyCars);
	}

	@Test
	public void testFindBySize() {
		List<Toy> result = toysManager.findBy(Size.SMALL);
		assertEquals(3, result.size());
	}

	@Test
	public void testFindByPrice() {
		List<Toy> result = toysManager.findBy(300.0);
		assertEquals(1, result.size());
	}

	@Test
	public void testFindByageGroup() {
		List<Toy> result = toysManager.findBy(6);
		assertEquals(2, result.size());
	}

}
