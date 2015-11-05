package org.javacore.collection.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsSortComparator {

	public static void main(String[] args) {
		List<Fruit> fruits = new ArrayList<Fruit>() {
			private static final long serialVersionUID = 1L;

			{
				add(new Fruit("Pineapple", "Pineapple description", 70));
				add(new Fruit("Apple", "Apple description", 100));
				add(new Fruit("Orange", "Orange description", 80));
				add(new Fruit("Banana", "Banana description", 90));
			}
		};

		// Collections.sort(fruits);
		Collections.sort(fruits, new FruitNameComparator());

		int i = 0;
		for (Fruit temp : fruits) {
			System.out.println("fruits " + ++i + " : " + temp);
		}
	}
}
