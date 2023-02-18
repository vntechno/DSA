package com.vrtech.dsa.convertor;
import java.util.LinkedHashMap;
public class WordToNum {
	final static LinkedHashMap<String, Long> allowedStringsMap = new LinkedHashMap<String, Long>();
	static {
		allowedStringsMap.put("and", 0l);
		allowedStringsMap.put("zero", 0l);
		allowedStringsMap.put("one", 1l);
		allowedStringsMap.put("two", 2l);
		allowedStringsMap.put("three", 3l);
		allowedStringsMap.put("four", 4l);
		allowedStringsMap.put("five", 5l);
		allowedStringsMap.put("six", 6l);
		allowedStringsMap.put("seven", 7l);
		allowedStringsMap.put("eight", 8l);
		allowedStringsMap.put("nine", 9l);
		allowedStringsMap.put("ten", 10L);
		allowedStringsMap.put("eleven", 11L);
		allowedStringsMap.put("twelve", 12L);
		allowedStringsMap.put("thirteen", 13L);
		allowedStringsMap.put("fourteen", 14L);
		allowedStringsMap.put("fifteen", 15L);
		allowedStringsMap.put("sixteen", 16L);
		allowedStringsMap.put("seventeen", 17L);
		allowedStringsMap.put("eighteen", 18L);
		allowedStringsMap.put("nineteen", 19L);
		allowedStringsMap.put("twenty", 20L);
		allowedStringsMap.put("thirty", 30L);
		allowedStringsMap.put("forty", 40L);
		allowedStringsMap.put("fifty", 50L);
		allowedStringsMap.put("sixty", 60L);
		allowedStringsMap.put("seventy", 70L);
		allowedStringsMap.put("eighty", 80L);
		allowedStringsMap.put("ninety", 90L);
		allowedStringsMap.put("hundred", 100L);
		allowedStringsMap.put("thousand", 1000L);
		allowedStringsMap.put("million", 1000000L);
		allowedStringsMap.put("billion", 1000000000L);
		allowedStringsMap.put("trillion", 1000000000000L);

	}

	private static long convertWordsToNums(String[] words) {
		long finalResult = 0;
		long intermediateResult = 0;
		for (String str : words) {
			str = str.toLowerCase().replaceAll("[^a-zA-Z\\s]", "");
			if (str.equalsIgnoreCase("and")) {
				continue;
			} else {
				Long val = allowedStringsMap.get(str);
				if (val >= 0 && val < 100) {
					intermediateResult += val;
				} else {
					intermediateResult *= val;
				}
			}
		}
		finalResult += intermediateResult;
		intermediateResult = 0;
		return finalResult;

	}
	public static void main(String[] args) {
		// Scanner sc=new Scanner(System.in);
		// System.out.println("Please enter numbers in words");
		String input = "three hundred and nine";
		String words[] = input.split(" ");
		System.out.println(convertWordsToNums(words));
	}

}
