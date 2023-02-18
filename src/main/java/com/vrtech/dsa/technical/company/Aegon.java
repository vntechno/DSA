package com.vrtech.dsa.technical.company;

import java.util.LinkedHashSet;

public class Aegon {
	
	public static void main(String[] args) {
		Aegon aegon=new Aegon();
		System.out.println(aegon.getFactorial(5));
		String[] userName = {"abc","XYZ", "", " ", "pqr","xyz"};
		String [] names=aegon.getUnique(userName);
		for (String string : names) {
			System.out.print(" "+string);
		}
		
	}
	
	public  int getFactorial(int num){	
	     if(num==0||num==1)
		        return 1;		 
		 return num*getFactorial(num-1);
	}
	
/*	convert string array to unique collection of valid strings.
	Valid strings should be not null, not blank, not empty and
	should be in uppercase with no duplicates 
	String[] userName = {"abc","XYZ", "", " ", "pqr","xyz"}; 
    expected output = {"ABC", "XYZ","PQR"}
	*/
	
	public String[] getUnique(String[] inputs){
		
		   if((inputs!=null)&&(inputs.length>0)){		
		    LinkedHashSet<String> set=new  LinkedHashSet<String>();			   
			   for(String value:inputs){
      
					if(value==null||value.equals("")){
					    continue;
					}else{
					  set.add(value.toUpperCase());
					}
			   }
			  
			  String[] output=new String[set.size()];
			  int cnt=0; 
			  for(String str:set){
			       output[cnt++]=str;
			  }
			
			    return output;
			}
		       return null; 
		}

}
