package com.vrtech.dsa.technical.company;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class StudentTest {
	
	public static void main(String[] args) {	
		
		List<Student> studs=new ArrayList<>();		
		studs.stream().filter(e->e.getAge()>15).collect(Collectors.toList());
		
		
	}

}
