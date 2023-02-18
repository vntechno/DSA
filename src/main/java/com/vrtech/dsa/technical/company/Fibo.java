package com.vrtech.dsa.technical.company;

public class Fibo {
	
	public static void main(String[] args) {
		
		//Write a java program to create Fibonacci series of 'n' numbers.
		// fib(3)  -> 0 1 1 
		// fib(5)  -> 0 1 1 2 3 
		// fib(6)  -> 0 1 1 2 3 5  
		// fib(10) -> 0 1 1 2 3 5 8 13 21 34
		
		fib(10);
		
	}
	
	public static void fib(int n) {		
		int a=0,b=1,cnt=0;		
		while(cnt<n) {			
			System.out.print(" "+a);
			int t=a+b;
			a=b;
			b=t;
			cnt++;			
		}		
	}

}
