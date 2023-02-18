package com.vrtech.dsa.technical.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Emp {
	private String id;
	private Integer age;
	private Integer salary;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public Emp(String id, Integer age, Integer salary) {
		super();
		this.id = id;
		this.age = age;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Emp [id=" + id + ", age=" + age + ", salary=" + salary + "]";
	}

}

//class A {
//	void add(int x, long y) {
//	}
//
//	int  add(int x, long y) {
//	}
//}

class B {
	void add(int x, long y) {
	}

	void add(long x, int y) {
	}
}

class employeesAgeAndSalCamparator implements Comparator<Emp> {
	public int compare(Emp e1, Emp e2) {
		int diffAge = e1.getAge().compareTo(e2.getAge());
		if (diffAge != 0)
			return diffAge;
		return e1.getSalary() - e2.getSalary();
	}
}

public class GlobalLogic {

//	Employee id name age salary
//	sort by age and salary both
//	if two employees has same age --then sort by salary
//	if not--sort by age itself

	private static ArrayList<Emp> getUnsortedEmployeeList() {
		ArrayList<Emp> list = new ArrayList<>();
		list.add(new Emp("1", 20, 3000));
		list.add(new Emp("2", 25, 4000));
		list.add(new Emp("3", 20, 5000));
		list.add(new Emp("4", 25, 6000));
		list.add(new Emp("5", 26, 6600));
		list.add(new Emp("6", 27, 2000));
		list.add(new Emp("7", 28, 3000));
		return list;
	}

	public static void main(String[] args) {
		B b = new B();
		// b.add(1, 1);

		// Compare by first name and then last name
		Comparator<Emp> comparebyAgeANDSal = Comparator.comparing(Emp::getAge).thenComparing(Emp::getSalary);

		List<Emp> sortedEmployees = getUnsortedEmployeeList().stream().sorted(comparebyAgeANDSal)
				.collect(Collectors.toList());
		
		List<Emp> emps=getUnsortedEmployeeList();
				Collections.sort(emps, new employeesAgeAndSalCamparator());

		System.out.println(sortedEmployees);
		System.out.println(emps);
	}
}
