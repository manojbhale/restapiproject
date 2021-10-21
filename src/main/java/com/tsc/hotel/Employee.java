package com.tsc.hotel;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Employee {

	private int id;

	private String empName;

	private int age;

	private Address address;

	public Employee() {

	}

	public Employee(int id, String empName, Address address) {
		this.id = id;
		this.empName = empName;
		this.address = address;
	}

	@Override
	public int hashCode() {
		// System.out.println("hascode excuted..");
		return empName.hashCode() + address.getStreet().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}

		if (obj instanceof Employee) {
			Employee emp = (Employee) obj;
			if (empName.equals(emp.empName) && address.getStreet().equals(emp.getAddress().getStreet())) {
				return true;
			} else {
				return false;
			}
		}
		return false;

	}

	@Override
	public String toString() {
		return "Employee [empName=" + empName + ", age=" + age + "]";
	}

}
