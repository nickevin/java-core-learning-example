package org.javacore.collection.sort;

import java.util.Comparator;

public class FruitNameComparator implements Comparator<Fruit> {

	public int compare(Fruit fruit1, Fruit fruit2) {

		String fruitName1 = fruit1.getFruitName().toUpperCase();
		String fruitName2 = fruit2.getFruitName().toUpperCase();

		return fruitName1.compareTo(fruitName2);

		// descending order
		// return fruitName2.compareTo(fruitName1);
	}
}
