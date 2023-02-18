//package com.vrtech.dsa.technical.company;
//
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//
//public class HP {
//	
////	Write the logic to get the longest common prefix among an array of strings.
////	Eg.
////	Input: strs = [""town"",""token"",""tower""]
////	Output: ""to""
////
////	If there is no common prefix found among the array of strings, just return null.
//	
//	
//	
//	//Count pairs in an array or list with given sum . Pairs refer to 2 numbers when added providing the given result.
//	// . eg : Input:  arr[] = {1, 5, 7, -1, 5}, sum = 6
//	
//	
//	
//	
//
//	
//	
//	
//	public static void main(String[] args) {
//
//	   System.out.println(reverse(102));
//	   int arr[] = {1, 5, 7, -1, 5}, sum = 6;
//	   
//	   System.out.println("sum pair cnt-->"+sumPairs(arr,sum));
//	   
//		String s1 = "abc";
//		String s2 = "abc";
//		String s3 = new String("abc");
//
//		System.out.println("s1 == s2 ? " + (s1 == s2)); 
//		System.out.println("s1 == s3 ? " + (s1 == s3));
//		System.out.println("s1 equals s3 ? " + (s1.equals(s3)));
//		
//		
////		try{ 
////			 throw new Exception();
////			 
////			}catch(Exception e)
////			{
////			 return 2;
////			}
////			finally{
////				return 3;
////				
////			}
//		
//		F f=()->{System.out.println("h");};
//		f.a();
//		
//		
//	}
//	
//	public static int reverse(int num) {
//		int rev=0;		
//		while(num>0) {
//			
//			int rem=num%10;			
//			rev=rev*10+rem;
//			num=num/10;		
//			
//		}
//		return rev;
//	}
//	
//	public static  int sumPairs(int[] arr,int sum) {		
//		int cnt=0;
//		for (int i = 0; i < arr.length; i++) {
//			
//			   for (int j = i+1; j < arr.length; j++) {
//				
//				      if(sum==(arr[i]+arr[j]))
//				    	  cnt++;				
//			}			
//		}		
//		return cnt;		
//	}
//
//}
//@FunctionalInterface
//interface A{
//	abstract void a();
//    void  cc();
//}
//
//@FunctionalInterface
//interface C{
//	abstract void a();
//}
//
//@FunctionalInterface
//interface F extends A,C{
//	abstract void a();
//}
