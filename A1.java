
/**********************************************************************File: A1.java
Student Number: 210600534
Family Name: Gilani
Given Name: Umar

Marking Template:

Appropriate style:
	Variable Naming                    _____/5
	Indentation and Layout             _____/5
    	Comments                           _____/5

Proper design of functions and coding      _____/15

Proper use of polymorphism + inheritance   _____/20 (by inspection)

Code Compiles?				   	_____(yes/no)
Successful execution of test cases	   _____/50

Total					   _____/100

The submission will receive at most 15 marks if the submission does not compile or at most 50 marks if the execution 
on test casess is not successful.
   
*/


/** 
	This is the test driver for Assignment 1.
	It has one main method which must be implemented. If you wish, you may add any variables
	or static helper methods to make the code more clear.
*/
/********************************************************************
		inputs
		-------------

		java A1 zonePostcode.txt  		
		l4j 33 
		j8q 33
		quit
		------------

		l4j - post code of destination
		33 - weight of the parcel		

		***********************************************************************/

import java.io.FileNotFoundException;
import java.util.Scanner;

public class A1 {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args)  
	{
		// This code will read in the filenames from the command 	
		// line using the args array
		String postCodeFile  = args[0];		

		// Set up a Scanner object for Input		
		Scanner input = new Scanner(System.in);
		
		// You can now use input.next() to read a String.	

	    String line = null;
	    boolean done = false;
	    if(!input.hasNextLine())
	    {  done = true;
	    }
	    else
	    {  line = input.nextLine();
	    }
	    if(!done && line.length() >= 4 && line.substring(0,4).equals("quit"))
	    {  done = true;
	    }
	    while(!done)
	    {  
	        Scanner inl = new Scanner(line);
	        String postCode = "";
	        int weight;
	        if(inl.hasNext())
	        {	
	        	postCode = inl.next();
	        	if(inl.hasNext())
		        {
		        	weight = inl.nextInt();		        	       		
		        	
			        ServiceZone zone = null;
			        try {   
                          ZoneMap Map = new ZoneMap(postCodeFile); // building obejct
			              zone= Map.getValidZone(postCode); // find zone 
			              double ShippingCost;
                          if(zone==null){
                          System.out.println("This PostCode is out of service"); // no zone available for the postcode enter
                          }else{
                          
                          if(weight>75){System.out.println("This is too heavy");}// over 75bls , cannot be delivered
                          else{
                          ShippingCost=zone.getShippingCost(weight);   // call Shipping Cost method
			              System.out.printf("The shipping cost is "+ "%.2f",ShippingCost);  // 2 digits
				          System.out.println(); 
				          }
                          }
                                      

 					
				        
					} catch (FileNotFoundException e) {
						System.out.println(postCodeFile + "The system cannot find the file specified");
					}	
		        }
	        }
	        if(!input.hasNextLine())
	         {  done = true;
	         }
	         else
	         {  line = input.nextLine();
	         }
	         if(!done && line.length() >= 4 && line.substring(0,4).equals("quit"))
	         {  done = true;
	         }
	        
	    }
	    

	}

}
