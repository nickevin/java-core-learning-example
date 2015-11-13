package org.javacore.collection.src;

import org.javacore.collection.sort.Fruit;

public class TestArrayList {

	public static void main(String[] args) {
		ArrayList<Fruit> fruits = new ArrayList<Fruit>(8);
		fruits.add(new Fruit("Pineapple", "Pineapple description", 70));
		fruits.add(new Fruit("Apple", "Apple description", 100));
		fruits.add(new Fruit("Orange", "Orange description", 80));
		fruits.add(new Fruit("Banana", "Banana description", 90));
	}
}
