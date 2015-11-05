package org.javacore.collection;

import java.util.HashSet;
import java.util.Set;

public class TestOOM {

	public static void main(String[] args) {
		String a = "a";
		String b = new String("b");
		System.out.println(a == b);

		Set<Person> set = new HashSet<Person>();
		Person p1 = new Person("a", "pwd1", 25);
		Person p2 = new Person("b", "pwd2", 26);
		Person p3 = new Person("c", "pwd3", 27);
		set.add(p1);
		set.add(p2);
		set.add(p3);

		System.out.println("TestOOM.main()" + p1.hashCode());
		System.out.println("TestOOM.main()" + p2.hashCode());
		System.out.println("TestOOM.main()" + p3.hashCode());

		System.out.println(set.size());

		p3.setAge(2);
		System.out.println("TestOOM.main()" + p3.hashCode());

		set.remove(p3);

		set.add(p3);
		for (Person person : set) {
			System.out.println(person);
		}
	}
}

class Person {

	private String name;
	private String password;
	private int age;

	public Person(String name, String password, int age) {
		this.name = name;
		this.password = password;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());

		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}

}
