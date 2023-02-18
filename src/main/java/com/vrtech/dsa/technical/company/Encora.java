package com.vrtech.dsa.technical.company;

import java.util.ArrayList;
import java.util.List;

public class Encora {

	
	public static void main(String[] args) {
		
		int[] array = {1,0,11,0,6,0,8,0,9,0,10};
		int temp[]=new int[array.length];
		//{1,11,6,8,9,10,0,0,0,0,0}
		int i=0,cnt=0,j=0;
		while(i<array.length) {
			if(array[i]==0) {
				cnt++;
			}else {
				temp[j++]=array[i];
			}	
			i++;
		}
		
		i=0;
		while(i<cnt&&j<array.length) {
			temp[j++]=0;
			
		}
		
		for (int k : temp) {
			System.out.print(k+", ");
		}


	}
	
	public void procees(int[] array) {
		List<Integer> zeroList=new ArrayList<Integer>();
		List<Integer> original=new ArrayList<Integer>();
		
		int i=0;
		while(i<array.length) {			
			if(array[i]==0) {
				zeroList.add(array[i]);
			}else {
				original.add(array[i]);
			}
			i++;
		}		
		original.addAll(zeroList);
		System.out.println(original);
	}
	
}
