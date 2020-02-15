package ua.lviv.iot.Lab_3.launcher;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ua.lviv.iot.Lab_3.manager.ToysManagerUtils;
import ua.lviv.iot.Lab_3.model.Size;
import ua.lviv.iot.Lab_3.model.SortType;
import ua.lviv.iot.Lab_3.model.TypeOfToy;

class ToysManagerUnityTest extends BaseToysManagerTest {

	@Test
	public void testSortGoodsByPrice() {
		ToysManagerUtils.sortByPrice(toyCars, SortType.ASCENDING);
		assertEquals(300, toyCars.get(0).getPriceInUAH());
		assertEquals(320, toyCars.get(1).getPriceInUAH());
		assertEquals(400, toyCars.get(2).getPriceInUAH());
		assertEquals(3000, toyCars.get(3).getPriceInUAH());
	}

	@Test
	public void testSortGoodsBySize() {
		ToysManagerUtils.sortBySize(toyCars, SortType.ASCENDING);
		assertEquals(Size.SMALL, toyCars.get(0).getSize());
		assertEquals(Size.SMALL, toyCars.get(1).getSize());
		assertEquals(Size.SMALL, toyCars.get(2).getSize());
		assertEquals(Size.LARGE, toyCars.get(3).getSize());
	}

	@Test
	public void testSortGoodsAgeGroup() {
		ToysManagerUtils.sortByAgeGroup(toyCars, SortType.ASCENDING);
		assertEquals(4, toyCars.get(0).getAgeGroup());
		assertEquals(4, toyCars.get(1).getAgeGroup());
		assertEquals(5, toyCars.get(2).getAgeGroup());
		assertEquals(6, toyCars.get(3).getAgeGroup());
	}

	@Test
	public void testSortGoodsByType() {
		ToysManagerUtils.sortByType(toyCars, SortType.ASCENDING, TypeOfToy.TOYCAR);
		assertEquals("class ua.lviv.iot.Lab_3.model.ToyCar", toyCars.get(0).getClass().toString());
		assertEquals("class ua.lviv.iot.Lab_3.model.ToyCar", toyCars.get(1).getClass().toString());
		assertEquals("class ua.lviv.iot.Lab_3.model.ToyCar", toyCars.get(2).getClass().toString());
		assertEquals("class ua.lviv.iot.Lab_3.model.ToyCar", toyCars.get(3).getClass().toString());
	}
}
