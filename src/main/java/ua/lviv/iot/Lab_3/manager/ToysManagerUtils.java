package ua.lviv.iot.Lab_3.manager;

import java.util.Comparator;
import java.util.List;

import ua.lviv.iot.Lab_3.model.SortType;
import ua.lviv.iot.Lab_3.model.Toy;
import ua.lviv.iot.Lab_3.model.TypeOfToy;

public class ToysManagerUtils {

	public static void sortByPrice(List<Toy> toys, SortType sortType) {
		PriceComparator priceComparator = new PriceComparator();
		toys.sort(sortType == SortType.ASCENDING ? priceComparator : priceComparator.reversed());
	}

	public static void sortBySize(List<Toy> toys, SortType sortType) {
		SizeComparator sizeComparator = new SizeComparator();
		toys.sort(sortType == SortType.ASCENDING ? sizeComparator : sizeComparator.reversed());
	}

	public static void sortByAgeGroup(List<Toy> toys, SortType sortType) {
		AgeComparator ageComparator = new AgeComparator();
		toys.sort(sortType == SortType.ASCENDING ? ageComparator : ageComparator.reversed());
	}

	public static void sortByType(List<Toy> toys, SortType sortType, TypeOfToy typeOfToy) {
		TypeComparator typeComparator = new TypeComparator();
		toys.sort(sortType == SortType.ASCENDING ? typeComparator : typeComparator.reversed());
	}
}

class PriceComparator implements Comparator<Toy> {

	@Override
	public int compare(Toy o1, Toy o2) {
		return (int) (o1.getPriceInUAH() - o2.getPriceInUAH());
	}

}

class SizeComparator implements Comparator<Toy> {

	@Override
	public int compare(Toy o1, Toy o2) {
		return o1.getSize().ordinal() - o2.getSize().ordinal();
	}

}

class AgeComparator implements Comparator<Toy> {

	@Override
	public int compare(Toy o1, Toy o2) {
		return o1.getAgeGroup() - o2.getAgeGroup();
	}

}

class TypeComparator implements Comparator<Toy> {

	@Override
	public int compare(Toy o1, Toy o2) {
		return o1.getTypeOfToy().toString().compareTo(o2.getTypeOfToy().toString());
	}

}
