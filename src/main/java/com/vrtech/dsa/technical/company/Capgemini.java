package com.vrtech.dsa.technical.company;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.util.comparator.Comparators;


public class Capgemini {
	
	public static void main(String[] args) {
		
		String input ="aaacccddbb";
		//out-->acdb
		
		char[] chars=input.toCharArray();
		
		Capgemini main=new Capgemini();
		System.out.println(main.getDistinct(input));
		
			
	}
	
	
	public Set getDistinct(String input) {
		
		if(input!=null) {
			
			char[] chars=input.toCharArray();
			LinkedHashMap<Character, Integer> map=new LinkedHashMap<Character, Integer>();
			
			for(char c:chars) {
				
				if(map.containsKey(c)) {					
					   map.put(c, map.get(c)+1);
				}else {
					map.put(c, 1);
				}
			}
			
			return map.keySet();
		}
		
		return null;
	}

}
