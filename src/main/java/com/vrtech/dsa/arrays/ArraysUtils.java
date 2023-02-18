package com.vrtech.dsa.arrays;

public class ArraysUtils {
	
  public static void print(int[]arr) {
	  System.out.println();
	  for (int i : arr) {
		System.out.print(i);
	}
  }
  
  
  public static void alternateSwap(int[]arr,int size) {
	  for(int i=0;i<size;i=i+2) {
		  if(i+1<size) {
			  int temp=arr[i];
			  arr[i]=arr[i+1];
			  arr[i+1]=temp;
		  }
	  }	  
  }
  
  public static void main(String[] args) {
	  int even[]= {1,2,3,4};
	  int odd[]= {1,2,3,4,5};
	  ArraysUtils.alternateSwap(even, 4);
	  ArraysUtils.print(even);
	  ArraysUtils.alternateSwap(odd, 5);
	  ArraysUtils.print(odd);		
}

}
