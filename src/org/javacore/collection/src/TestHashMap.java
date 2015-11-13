package org.javacore.collection.src;

import org.javacore.collection.sort.Fruit;

public class TestHashMap {

	public static void main(String[] args) {
		HashMap<Fruit, String> fruits = new HashMap<Fruit, String>(8);
		fruits.put(new Fruit("Pineapple", "Pineapple description", 70), "A");
		fruits.put(new Fruit("Apple", "Apple description", 100), "B");
		fruits.put(new Fruit("Orange", "Orange description", 80), "C");
		fruits.put(new Fruit("Banana", "Banana description", 90), "D");
		// System.out.println("TestHashMap.main()" + fruits.put(new Fruit("Banana", "Banana description", 90), "E"));
		// 有重复key， put 后则返回老的value

		HashMap.Entry[] table = fruits.table;
		for (int idx = 0; idx < table.length; idx++) {
			System.out.println("TestHashMap.main()" + idx + "  " + table[idx]);

			HashMap.Entry next = null;
			while (table[idx] != null && (next = table[idx].next) != null) {
				System.out.println("TestHashMap.main()" + idx + "  " + next);

				table[idx].next = next.next; // 为了让 while 中的 (next = table[idx].next) 继续循环
			}
		}

		// for (Iterator<Map.Entry<Fruit, String>> it = fruits.entrySet().iterator(); it.hasN();) {
		// Entry<Fruit, String> item = it.n();
		// System.out.println(item.getKey() + " " + item.getValue());
		// item.getKey();
		// }

		System.out.println();

		// for (int i = 0; i < 128; i++) {
		// System.out.println("TestHashMap.main()" + (new Random().hashCode() & 128 - 1));
		// }

	}
}
