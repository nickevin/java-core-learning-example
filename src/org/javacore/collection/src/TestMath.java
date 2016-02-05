package org.javacore.collection.src;

public class TestMath {

  public static void main(String[] args) {
    int len = 8; // power of 2
    int hashcode = 2077172191;

    System.out.println(hashcode % len);
    System.out.println(hashcode & len - 1);
  }

}
