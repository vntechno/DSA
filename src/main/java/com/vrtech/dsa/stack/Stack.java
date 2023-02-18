package com.vrtech.dsa.stack;

public class Stack {

	private int data[];
	private int top = -1;
	private int size;

	public Stack(int size) {
		this.size = size;
		this.data = new int[size];
	}

	public boolean isEmpty() {
		return this.top == -1;
	}

	public void push(int value) {

		if (this.size - this.top > 1) {
			this.data[++top] = value;
		} else {
			System.out.println("Stack is full");
		}
	}

	public int pop() {

		if (!isEmpty()) {
			return data[top--];
		} else {
			System.out.println(" Stack is empty...");
		}
		return -1;
	}

	public int peek() {

		if (!isEmpty()) {
			if (this.top == size) {
				return data[top];
			}
			return data[top];
		} else {
			System.out.println(" Stack is empty...");
		}
		return -1;
	}

	public static void main(String[] args) {

		Stack stack = new Stack(5);

		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.push(6);

		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.peek());
	}

}
