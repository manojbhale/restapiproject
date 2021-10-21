package com.tsc.hotel;

public class DemoHashCode {

	public static void main(String[] args) {

		Employee emp1 = new Employee(1, "manoj", new Address("kalani bagh", "Dewas"));
		Employee emp2 = new Employee(2, "raju", new Address("kalani bagh", "Dewas"));
		Employee emp3 = new Employee(3, "manoj", new Address("kalani bagh", "Dewas"));

		System.out.println(emp1.hashCode());
		System.out.println(emp2.hashCode());
		System.out.println(emp3.hashCode());
		System.out.println("******************");
		System.out.println(emp1 == emp2);
		System.out.println(emp1 == emp3);

		System.out.println("*****************************************");

		System.out.println(emp1.equals(emp2));
		System.out.println(emp1.equals(emp3));
	}

}
