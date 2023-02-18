package com.vrtech.dsa.corejava.streams;

public class Employee {
	Integer empno;
	String name;
	Integer age;
	double salary;
	String department;

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Integer getEmpno() {
		return empno;
	}

	public void setEmpno(Integer empno) {
		this.empno = empno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Employee(Integer empno, String name, Integer age, double salary, String department) {
		super();
		this.empno = empno;
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [empno=" + empno + ", name=" + name + ", age=" + age + ", salary=" + salary + ", department="
				+ department + "]";
	}


}
