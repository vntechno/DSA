package com.vrtech.dsa.technical.company;

public class Sapient {

	public static void main(String[] args) {
		Sapient sapient = new Sapient();
		System.out.println("Without recursion--->" + sapient.reverse("vikash"));
		System.out.println("With recursion--->" + sapient.reversing("vikash"));
	}

	public String reversing(String input) {

		if (input == null || input.length() == 0)
			return input;

		return reversing(input.substring(1)) + input.charAt(0);

	}

	public String reverse(String input) {
		if (input != null) {
			char[] chars = input.toCharArray();

			for (int i = 0, j = chars.length - 1; i < j; i++, j--) {
				char temp = chars[i];
				chars[i] = chars[j];
				chars[j] = temp;
			}

			return new String(chars);
		}
		return null;
	}

}
