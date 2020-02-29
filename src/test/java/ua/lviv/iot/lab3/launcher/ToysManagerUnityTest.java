package ua.lviv.iot.lab3.launcher;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import ua.lviv.iot.lab3.manager.ToysManagerUtils;
import ua.lviv.iot.lab3.model.Size;
import ua.lviv.iot.lab3.model.SortType;
import ua.lviv.iot.lab3.model.Toy;
import ua.lviv.iot.lab3.model.TypeOfToy;

class ToysManagerUnityTest extends BaseToysManagerTest {

	@Test
	public void testSortByPrice() {
		ToysManagerUtils.sortByPrice(toyCars, SortType.ASCENDING);
		assertEquals(300, toyCars.get(0).getPriceInUAH());
		assertEquals(320, toyCars.get(1).getPriceInUAH());
		assertEquals(400, toyCars.get(2).getPriceInUAH());
		assertEquals(3000, toyCars.get(3).getPriceInUAH());
	}

	@Test
	public void testSoråBySize() {
		ToysManagerUtils.sortBySize(toyCars, SortType.ASCENDING);
		assertEquals(Size.SMALL, toyCars.get(0).getSize());
		assertEquals(Size.SMALL, toyCars.get(1).getSize());
		assertEquals(Size.SMALL, toyCars.get(2).getSize());
		assertEquals(Size.SMALL, toyCars.get(3).getSize());
	}

	ToysManagerUtils toysManagerUtils = new ToysManagerUtils();
	ToysManagerUtils.AgeComparator ageComparator = toysManagerUtils.new AgeComparator();

	@Test
	public void testSortAgeGroup() {
		ToysManagerUtils.sortByAgeGroup(toyCars, SortType.ASCENDING, ageComparator);
		assertEquals(4, toyCars.get(0).getAgeGroup());
		assertEquals(5, toyCars.get(1).getAgeGroup());
		assertEquals(6, toyCars.get(2).getAgeGroup());
		assertEquals(6, toyCars.get(3).getAgeGroup());
	}

	@Test
	public void testSortByTypeOfToyInABC() {
		ToysManagerUtils.sortByTypeOfToyInABC(toyCars, SortType.ASCENDING);
		assertEquals(TypeOfToy.BALL, toyCars.get(0).getTypeOfToy());
		assertEquals(TypeOfToy.TOYCAR, toyCars.get(1).getTypeOfToy());
		assertEquals(TypeOfToy.TOYCAR, toyCars.get(2).getTypeOfToy());
		assertEquals(TypeOfToy.TOYCAR, toyCars.get(3).getTypeOfToy());
	}

	@Test
	public void testSortByType() {
		final TypeOfToy TYPE_OF_TOY = TypeOfToy.TOYCAR;
		List<Toy> result = ToysManagerUtils.sortByType(toyCars, SortType.ASCENDING, TYPE_OF_TOY);
		assertEquals(TYPE_OF_TOY, result.get(0).getTypeOfToy());
		assertEquals(TYPE_OF_TOY, result.get(1).getTypeOfToy());
		assertEquals(TYPE_OF_TOY, result.get(2).getTypeOfToy());
		assertEquals(TYPE_OF_TOY, result.get(3).getTypeOfToy());
	}

}
