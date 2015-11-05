package org.javacore.collection;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class TestLinkedHashMap {

	public static void main(String[] args) {
		LinkedHashMap<Integer, Integer> map = new LinkedHashMap<Integer, Integer>(10, 0.75f, true);
		map.put(9, 9);
		map.put(7, 7);
		map.put(5, 5);
		map.put(3, 3);

		for (Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator(); it.hasNext();) {
			System.out.println(it.next().getKey());
		}

		System.out.println();

		map.get(7);
		
		for (Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator(); it.hasNext();) {
			System.out.println(it.next().getKey());
		}

	}
}
