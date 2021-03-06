package org.javacore.collection.sort;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author aopfilter@163.com
 * @see http://www.mkyong.com/java/java-object-sorting-example-comparable-and-comparator/
 * 
 */
public class ArraysSortComparator {

	public static void main(String[] args) {
		Fruit[] fruits = new Fruit[4];

		Fruit pineappale = new Fruit("Pineapple", "Pineapple description", 70);
		Fruit apple = new Fruit("Apple", "Apple description", 100);
		Fruit orange = new Fruit("Orange", "Orange description", 80);
		Fruit banana = new Fruit("Banana", "Banana description", 90);

		fruits[0] = pineappale;
		fruits[1] = apple;
		fruits[2] = orange;
		fruits[3] = banana;

		Arrays.sort(fruits, new FruitNameComparator());
		// Arrays.sort(fruits);

		int i = 0;
		for (Fruit temp : fruits) {
			System.out.println("fruits " + ++i + " : " + temp.getFruitName() + ", Quantity : " + temp.getQuantity());
		}
	}

}
