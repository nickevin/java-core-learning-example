package org.javacore.collection.map;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.javacore.collection.sort.Fruit;

public class TestExtConcurrentHashMap {

	public static void main(String[] args) {
		ExtConcurrentHashMap<Fruit, String> fruits = new ExtConcurrentHashMap<Fruit, String>(8);
		fruits.put(new Fruit("Pineapple", "Pineapple description", 70), "A");
		fruits.put(new Fruit("Apple", "Apple description", 100), "B");
		fruits.put(new Fruit("Orange", "Orange description", 80), "C");
		fruits.put(new Fruit("Banana", "Banana description", 90), "D");

		for (Iterator<Map.Entry<Fruit, String>> it = fruits.entrySet().iterator(); it.hasNext();) {
			Entry<Fruit, String> item = it.next();
			System.out.println(item.getKey() + " " + item.getValue());
			item.getKey();
		}

		System.out.println();

		// for (int i = 0; i < 128; i++) {
		// System.out.println("TestExtConcurrentHashMap.main()" + (new Random().hashCode() & 128 - 1));
		// }

	}
}
