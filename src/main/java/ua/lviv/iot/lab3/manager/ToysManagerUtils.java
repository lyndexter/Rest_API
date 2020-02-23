package ua.lviv.iot.Lab3.manager;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import ua.lviv.iot.lab3.model.SortType;
import ua.lviv.iot.lab3.model.Toy;
import ua.lviv.iot.lab3.model.TypeOfToy;

public class ToysManagerUtils {

	// static inner class
	private static final PriceComparator PRICE_COMPARATOR = new PriceComparator();

	public static void sortByPrice(List<Toy> toys, SortType sortType) {

		toys.sort(sortType == SortType.ASCENDING ? PRICE_COMPARATOR : PRICE_COMPARATOR.reversed());
	}

	static class PriceComparator implements Comparator<Toy> {

		@Override
		public int compare(Toy o1, Toy o2) {
			return (int) (o1.getPriceInUAH() - o2.getPriceInUAH());
		}

	}

	public static void sortBySize(List<Toy> toys, SortType sortType) {
		// anonymous class
		Comparator<Toy> sizeComparator = new Comparator<Toy>() {

			@Override
			public int compare(Toy o1, Toy o2) {
				return o1.getSize().ordinal() - o2.getSize().ordinal();
			}

		};
		toys.sort(sortType == SortType.ASCENDING ? sizeComparator : sizeComparator.reversed());
	}

	// inner class
	public static void sortByAgeGroup(List<Toy> toys, SortType sortType, Comparator<Toy> ageComparator) {
		toys.sort(sortType == SortType.ASCENDING ? ageComparator : ageComparator.reversed());
	}

	public class AgeComparator implements Comparator<Toy> {

		@Override
		public int compare(Toy o1, Toy o2) {
			return o1.getAgeGroup() - o2.getAgeGroup();
		}

	}

	public static void sortByTypeOfToyInABC(List<Toy> toys, SortType sortType) {
		Comparator<Toy> typeComparator = (o1, o2) -> o1.getTypeOfToy().toString()
				.compareTo(o2.getTypeOfToy().toString());
		toys.sort(sortType == SortType.ASCENDING ? typeComparator : typeComparator.reversed());
	}

	public static List<Toy> sortByType(List<Toy> toys, SortType sortType, TypeOfToy typeOfToy) {
		return toys.stream().filter(toy -> toy.getTypeOfToy() == typeOfToy).collect(Collectors.toList());
	}
}
