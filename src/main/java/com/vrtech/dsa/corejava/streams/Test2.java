package com.vrtech.dsa.corejava.streams;

public class Test2 {
	
	public static void main(String[] args) {
		
		String input ="abcdefghijklmnopqrstuvwxyz";
		
		int j=0,k=1;
		StringBuilder br =new StringBuilder();
		 while(j<input.length()) {			 
			  if(k%3==0) {
			  }else {
				  br.append(input.charAt(j));
			  }	
			  j++;
			  k++;
		 }
		
		System.out.println(br.toString());	
		
	}

}
