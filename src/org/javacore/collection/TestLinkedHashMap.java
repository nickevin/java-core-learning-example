package org.javacore.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
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

		String[] sa = new String[] { "a", "b" };
		new ArrayList<String>();

		List<String> strList = new ArrayList<String>();
		strList.add("string1");
		strList.add("string2");
		strList.add("string3");
		strList.add("string4");
		strList.add("string5");
		strList.add("string6");

		// 操作方式1：while（Iterator）；报错
		Iterator<String> it = strList.iterator();
		while (it.hasNext()) {
			String s = it.next();
			if ("string2".equals(s)) {
				strList.remove(s);
			}
		}

	}
}
