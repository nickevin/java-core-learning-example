package org.javacore.lang;

/**
 * @author aopfilter@163.com
 * @see http://www.cnblogs.com/iceAeterNa/p/4876747.html
 * 
 */
public class TestClassInit implements Cloneable {

	public static int k = 0;
	public static TestClassInit t1 = new TestClassInit("静态变量 t1");
	public static TestClassInit t2 = new TestClassInit("静态变量 t2");
	public static int i = print("静态变量 i");
	public static int n = 99;

	public int j = print("实例变量");

	{
		print("实例块");
	}

	static {
		print("静态块");
	}

	public TestClassInit(String str) {
		System.out.println((++k) + ": 构造方法 " + str + "    i=" + i + "  n=" + n);
		++n;
		++i;
	}

	public static int print(String str) {
		System.out.println((++k) + ":" + str + "   i=" + i + "   n=" + n);
		++n;
		return ++i;
	}

	public static void main(String[] args) {
		TestClassInit TestClassInit = new TestClassInit("init");
	}
}
