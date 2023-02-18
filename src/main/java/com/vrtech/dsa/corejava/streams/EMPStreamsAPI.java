package com.vrtech.dsa.corejava.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class EMPStreamsAPI {

	public static void main(String[] args) {

		List<Employee> emplist = new ArrayList<>();

		emplist.add(new Employee(1, "mano", 22, 5000, "CS"));
		emplist.add(new Employee(5, "sarvesh", 32, 15000, "Math"));
		emplist.add(new Employee(6, "sam", 1, 25000, "CS"));
		emplist.add(new Employee(7, "tom", 12, 35000, "Math"));
		emplist.add(new Employee(2, "govind", 2, 500, "Science"));
		emplist.add(new Employee(2, "govind", 2, 500, "Science"));

		ArrayList<Employee> emp = (ArrayList<Employee>) emplist.stream()
				.sorted(Comparator.comparing(Employee::getEmpno)).collect(Collectors.toList());
								
		for (Employee employee : emp) {
			System.out.println(employee.getEmpno() + "," + employee.getName() + "," + employee.getAge() + " , "
					+ employee.getSalary());
		}

		ArrayList<Employee> emp1 = (ArrayList<Employee>) emplist.stream()
				.sorted(Comparator.comparing(Employee::getEmpno)).filter((obj1) -> obj1.age > 12)
				.collect(Collectors.toList());

		System.out.println("=====================================");
		for (Employee employee : emp1) {
			System.out.println(employee.getEmpno() + "," + employee.getName() + "," + employee.getAge() + " , "
					+ employee.getSalary());
		}

		Map<String, Long> emp2 = emplist.stream().sorted(Comparator.comparing(Employee::getName)).distinct()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));

		Map<String, List<Employee>> output = new HashMap<String, List<Employee>>();

		Consumer<Employee> consumer = (Employee e) -> {
			if (output.containsKey(e.getDepartment())) {
				List<Employee> emps = output.get(e.getDepartment());
				emps.add(e);
				output.put(e.getDepartment(), emps);
			} else {
				List<Employee> emps = new ArrayList<Employee>();
				emps.add(e);
				output.put(e.getDepartment(), emps);
			}
		};

		emplist.stream().map(e -> e).forEach(consumer);
		System.out.println(output);

		
		System.out.println("=====================================");

		Map<String, List<Employee>> emp3 = emplist.stream().sorted(Comparator.comparing(Employee::getName)).distinct()
				.collect(Collectors.groupingBy(Employee::getDepartment));
		Map<String, List<Employee>> emps = emplist.stream().collect(Collectors.groupingBy(Employee::getDepartment));
		emplist.stream().map(e->e.department).distinct().count();
		System.out.println("distinct dept no -->"+ emplist.stream().map(e->e.department).distinct().toList());
        System.out.println("distinct cnt -->"+ emplist.stream().map(e->e.department).distinct().count());
        System.out.println(emps);
		Comparator<Employee> byname = (obj1, obj2) -> obj1.name.compareTo(obj2.name);
		Comparator<Employee> byage = (obj1, obj2) -> obj1.age.compareTo(obj2.age);

		List<Employee> emp4 = emplist.stream().filter(obj -> obj.age > 4).sorted(byname.thenComparing(byage))
				.collect(Collectors.toList());

		System.out.println("=====================================");

		for (Employee employee : emp4) {
			System.out.println(employee.getEmpno() + "," + employee.getName() + "," + employee.getAge() + " , "
					+ employee.getSalary());
		}

		Map<String, Integer> budget = new HashMap<>();
		budget.put("clothes", 120);
		budget.put("grocery", 150);
		budget.put("transportation", 100);
		budget.put("utility", 130);
		budget.put("rent", 1150);
		budget.put("miscellneous", 90);
		System.out.println("map before sorting: " + budget);

		Map<String, Integer> sorted = budget.entrySet().stream().sorted(Map.Entry.comparingByKey())
				.collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e1, LinkedHashMap::new));
		System.out.println("map after sorting by values: " + sorted);

	}

}
