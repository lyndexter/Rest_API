package ua.lviv.iot.Lab_3.manager;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import ua.lviv.iot.Lab_3.model.Size;
import ua.lviv.iot.Lab_3.model.Toy;

public class ToysManager {
	private List<Toy> toys = new LinkedList<>();

	public void addToys(List<Toy> toys) {
		this.toys.addAll(toys);

	}

	public void addToy(Toy toy) {
		this.toys.add(toy);

	}

	public List<Toy> findBy(Size size) {
		List<Toy> result = new LinkedList<Toy>();
		for (Toy toy : toys) {
			if (toy.getSize() == size) {
				result.add(toy);
			}
		}
		return result;
	}

	public List<Toy> findBy(int ageGroup) {
		return this.toys.stream().filter(toy -> toy.getAgeGroup() == ageGroup).collect(Collectors.toList());
	}

	public List<Toy> findBy(double priceInUAH) {
		return this.toys.stream().filter(toy -> toy.getPriceInUAH() == priceInUAH).collect(Collectors.toList());
	}
}
