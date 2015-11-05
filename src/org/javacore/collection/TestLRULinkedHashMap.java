package org.javacore.collection;

import java.util.Iterator;
import java.util.Map;

public class TestLRULinkedHashMap {

	public static void main(String[] args) {
		Map<Integer, Integer> map = new LRULinkedHashMap<Integer, Integer>(4);
		map.put(9, 3);
		map.put(7, 4);
		map.put(5, 9);
		map.put(3, 4);
		map.put(6, 6);

		map.get(7);
		map.get(6);

		// 总共put了5个元素，超过了指定的缓存最大容量
		for (Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator(); it.hasNext();) {
			System.out.println(it.next().getKey());
		}
	}

}
