package com.vrtech.dsa.technical.company;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EPAM {

	public static void main(String[] args) {

		String input = "eeeeaAb";
		System.out.println(freq(input));		
		List<Integer> list1 = Arrays.asList(2, 222, 22, 234, 22, 345, 678, 435, 432);
		list1.stream()
		     .map(e -> String.valueOf(e))
		     .filter(e -> e.startsWith("2"))
		     .map(Integer::valueOf)
			 .collect(Collectors.toList())
			 .forEach(System.out::println);
	}

	public static Character freq(String input) {

		if (input != null) {
			int[] freq = new int[256];

			for (int i = 0; i < input.length(); i++) {
				freq[(input.charAt(i))]++;
			}
			for (int i = 0; i < input.length(); i++) {
				if (freq[(input.charAt(i))] == 1)
					return input.charAt(i);

			}
		}
		return null;
	}

}
