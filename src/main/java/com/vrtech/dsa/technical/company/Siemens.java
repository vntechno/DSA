package com.vrtech.dsa.technical.company;

import java.util.LinkedHashMap;
import java.util.Set;

public class Siemens {

	public static void main(String[] args) {
		// ROUND 1
		// Q 2 first non-repeated character of the string
		// Q 1 String input="abcdeab";

		// ROUND 2 tech

		/*
		 * Q3 Input: Apr 19 13:04:46 1205 0069 2 MT Data. Seq: 0, Data:, 0, 0, 0, 0 Apr
		 * 19 13:04:46 1205 0069 2 MT Data. Seq: 1, Data:, 0, 0, 28, -5 Apr 19 13:04:46
		 * 1205 0069 2 MT Data. Seq: 2, Data:, 0, 1, 56, -10
		 * 
		 * Output: Sequence : 0 Position: 0 Velocity: 0 Payload: 0 Shaft: 0
		 * 
		 * Sequence : 1 Position: 0 Velocity: 0 Payload: 28 Shaft: -5
		 * 
		 * Sequence : 2 Position: 0 Velocity: 1 Payload: 56 Shaft: -10
		 * 
		 * 
		 * 
		 */

		 /* Q 5
		 input -----------output
		 ninty night      99
		 three hundred and ten- 310
		 */
		 
		//Springboot App

		// Q 4  Rest client/post/ui app/ curl cmd----->filter---> Controller---->Service ----->Repository------>DB
		String input = "first non-repeated character of the string";

		String[] words = input.split(" ");
		StringBuilder br = new StringBuilder();
		for (String word : words) {
			String rev = reverse(word);
			br.append(rev).append(" ");
		}

		System.out.println(br);

		// System.out.println(firstNonRepeated(input));

	}

	public static String reverse(String word) {

		if (word != null) {
			char[] chars = word.toCharArray();
			for (int i = 0, j = chars.length - 1; i < j; i++, j--) {
				char temp = chars[i];
				chars[i] = chars[j];
				chars[j] = temp;
			}
			return new String(chars);
		}

		return null;
	}

	public static Character firstNonRepeated(String input) {

		if (input != null) {
			char chars[] = input.toCharArray();

			LinkedHashMap<Character, Integer> freqMap = new LinkedHashMap<Character, Integer>();

			for (char c : chars) {

				if (freqMap.containsKey(c)) {
					freqMap.put(c, freqMap.get(c) + 1);
				} else {
					freqMap.put(c, 1);
				}
			}

			Set<Character> keys = freqMap.keySet();

			for (Character key : keys) {

				int value = freqMap.get(key);

				if (value == 1) {
					return key;
				}
			}
		}
		return null;
	}

}
