package com.vrtech.dsa.technical.company;

import java.util.LinkedHashMap;
import java.util.Set;

public class Netcracker {

	// 1. permutation with ispolindron

	/*
	 * String input =abcba--true
	 * 
	 * aabbc-->abcba
	 * 
	 * a-2 b-2 c-1
	 * 
	 * 
	 * abbc a-1 b-2 c-1
	 */

	public boolean isPolindrone(String input) {

		if (input != null) {

			char[] chars = input.toCharArray();
			LinkedHashMap<Character, Integer> freqmap = new LinkedHashMap<Character, Integer>();
			for (char c : chars) {

				if (freqmap.containsKey(c)) {
					freqmap.put(c, freqmap.get(c) + 1);
				} else {
					freqmap.put(c, 1);
				}
			}

			// logic cal ispolindrome
			Set<Character> keys = freqmap.keySet();
			int existflag = 0;
			for (Character key : keys) {

				int value = freqmap.get(key);
				if (value % 2 == 1 && existflag == 1) {
					return false;
				} else if (value % 2 == 1 && existflag == 0) {
					existflag = 1;
				}

			}

		}
		return true;
	}

	// polidron
	public boolean isPolindron(String input) {
		if (input != null) {
			char[] chars = input.toCharArray();
			for (int i = 0, j = chars.length - 1; i < j; i++, j--) {
				if (chars[i] != chars[j])
					return false;
			}
		}
		return true;
	}

	class Node {

		private int data;
		Node next;

		public Node(int data) {
			this.data = data;
		}

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

		// getters and setters

	}

	class LinkedList {

		private Node head;

		public LinkedList() {
		}

		public void insertAtHead(int data) {

			Node n = new Node(data);

			if (this.head == null) {
				head = n;
			} else {
				n.setNext(n);
				this.head = n;

			}
		}

		public void insertInSorted(int data) {

			Node n = new Node(data);
			if (this.head == null) {
				head = n;
			} else {

				Node temp = this.head;
				Node prev = null;
				while (temp != null && data < temp.getData()) {
					prev = temp;
					temp = temp.getNext();
				}
				n.setNext(temp);
				prev.setNext(n);

			}
		}
	}

}
