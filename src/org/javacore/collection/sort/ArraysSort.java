package org.javacore.collection.sort;

import java.util.Arrays;

/**
 * @author aopfilter@163.com
 * @see http://www.mkyong.com/java/java-object-sorting-example-comparable-and-comparator/
 *
 */
public class ArraysSort {

	public static void main(String[] args) {
		String[] fruits = new String[] { "Pineapple", "Apple", "Orange", "Banana" };

		Arrays.sort(fruits);

		int i = 0;
		for (String temp : fruits) {
			System.out.println("fruits " + ++i + " : " + temp);
		}
	}

}
