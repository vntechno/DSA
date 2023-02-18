package com.vrtech.dsa.technical.company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Employee{
	
	private String name ;
	private int sal;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	public Employee(String name, int sal) {
		super();
		this.name = name;
		this.sal = sal;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", sal=" + sal + "]";
	}
	
	
}

public class Coforge {
	
	public static void main(String[] args) {
		
		List<Employee> emps=new ArrayList<Employee>();
		emps.add(new  Employee("vivek", 20000));
		emps.add(new  Employee( "vikash", 21000));
		emps.add(new  Employee("virat", 22000));
		emps.add(new  Employee("vishal", 250000));
		
		Comparator<Employee> salComparator=(Employee e1,Employee e2)->{
			  
			return e2.getSal()-e1.getSal();
		};
		
		System.out.println(emps.stream().map(e->e).sorted(salComparator).collect(Collectors.toList()).get(2));
		
		
		
		
		
	}

}
