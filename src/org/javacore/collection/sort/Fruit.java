package org.javacore.collection.sort;

import java.util.Comparator;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Fruit implements Comparable<Fruit> {

	private String fruitName;
	private String fruitDesc;
	private int quantity;

	@Override
	public int compareTo(Fruit o) {
		int compareQuantity = o.getQuantity();

		return this.quantity - compareQuantity;
	}

	// public static Comparator<Fruit> FruitNameComparator = new Comparator<Fruit>() {
	//
	// public int compare(Fruit fruit1, Fruit fruit2) {
	//
	// String fruitName1 = fruit1.getFruitName().toUpperCase();
	// String fruitName2 = fruit2.getFruitName().toUpperCase();
	//
	// return fruitName1.compareTo(fruitName2);
	//
	// // descending order
	// // return fruitName2.compareTo(fruitName1);
	// }
	// };
}
