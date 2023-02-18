package com.vrtech.dsa.technical.company;

import java.util.Arrays;

public class Digit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "My name is vikash";
		//out =="vikash is name my"
		
		System.out.println(reverse( str," "));
		
		Digit t=new Digit();
		t.reverse(str, str);

	}
	
	public static String reverse(String str,String dilimeter) {		
	
		if(str!=null&&str.length()>0) {			
			String [] words=str.split(dilimeter);			
			for(int i=0,j=words.length-1;i<j;i++,j--) {				
				String temp=words[i];
				words[i]=words[j];
				words[j]=temp;
			}		
			
		  return Arrays.toString(words).replaceAll(",", " ");
			
		}
		
		
		
		
		return null;
	}

}
