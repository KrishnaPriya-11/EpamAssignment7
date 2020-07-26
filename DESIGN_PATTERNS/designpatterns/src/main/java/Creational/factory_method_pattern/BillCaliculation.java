package Creational.factory_method_pattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BillCaliculation {
	public static void main(String args[])throws IOException{  
	       
		try {
	      System.out.print("Enter the name of plan: ");  
	      BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
	  
	      String planName=br.readLine();  
	      System.out.print("Enter the number of units consumed: ");  
	      int units=Integer.parseInt(br.readLine());
	      
		
	      
	  
	      Plan p = null ;
	      if(planName.equalsIgnoreCase("Domestic"))
	    	  p=new Domestic();
	      else if(planName.equalsIgnoreCase("Commericial"))
	    	  p=new Commericial();
	      else
	      { 
	    	  System.out.println("Invalid input");
	    	  System.out.println("Please choose Domestic or Commercial");
	      	System.exit(0);
	      }
	      
	       System.out.print("Bill amount for "+planName+" of  "+units+" units is: ");  
	           p.getRate();  
	           p.calculateBill(units); 
	}
	catch (Exception e) {
	
		System.out.println("Invalid input");
	}
	}

}
