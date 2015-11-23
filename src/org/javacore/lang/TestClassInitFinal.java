package org.javacore.lang;

class TestClassInit22 {

	public int ii = print("父类实例变量");

	static {
		print("父类静态代码块");
	}

	public static int i = print("父类静态变量");

	{
		print("父类实例代码块");
	}

	public TestClassInit22() {
		System.out.println("父类构造方法");
	}

	public static int print(String str) {
		System.out.println(str + "初始化");

		return i;
	}
}

public class TestClassInitFinal extends TestClassInit22 {

	{
		print("子类实例代码块");
	}
	public int ii = print("子类实例变量");
	public static int i = print("子类静态变量");

	static {
		print("子类静态代码块");
	}

	public TestClassInitFinal() {
		super();
		System.out.println("子类构造方法");
	}

	public static int print(String str) {
		System.out.println(str + "初始化");
		return i;
	}

	public static void main(String args[]) {
		new TestClassInitFinal();
	}
}