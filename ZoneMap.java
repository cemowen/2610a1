import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;



/**
 * This class finds the zone where the input post code belongs to
 *
 */
public class ZoneMap 
{

	private String[] zone1, zone2, zone3;
	
	/**
	 * @param fileName
	 * @throws FileNotFoundException
	 * 
	 * Constructor to initialise the zone arrays with zone post codes
	 */
	@SuppressWarnings("deprecation")
	
	public ZoneMap(String fileName) throws FileNotFoundException
	{
		FileInputStream fstream = new FileInputStream(fileName);
		DataInputStream in = new DataInputStream(fstream); 
		try {
			while(in.available()!=0)
			{
		
				String line = in.readLine();

				if(line.toLowerCase().startsWith("zone1"))				
				     zone1 = in.readLine().split(",");
				
				else if(line.toLowerCase().startsWith("zone2"))
					zone2 = in.readLine().split(",");
				else if(line.toLowerCase().startsWith("zone3"))
					zone3 = in.readLine().split(",");				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
	/**
	 * @param postCode input post code
	 * @return the zone number where the post code belongs to
	 * 
	 * Checks each member of all the zone arrays to see which zone 
	 * the post code is contained. Return null if none of the zones contain 
	 * this post code.
	 */
	public ServiceZone getValidZone(String postCode){
		
		ServiceZone  serviceZone= null; // serviceZone object
		
		ServiceZone1 serviceZone1= new ServiceZone1(9.25,0.18,0.17,11.01); // set up serviceZone1 object
		
		ServiceZone2 serviceZone2= new ServiceZone2(10.16,1.5,1.2,14.77); // set up serviceZone2 object
	    
		ServiceZone3 serviceZone3= new ServiceZone3(11.62,2.1,2.9,16.05); // set up serviceZone3 object
 		
		
		String start;
		String end;
		int result1;
		int result2;
		int length;
		
		String PostCode=postCode.substring(0,3).toLowerCase(); // convert to 3 lower case code.
        
		if(serviceZone==null){
		for (int i=0;i<zone1.length;i++){
		 
	     start=zone1[i].substring(0,3).toLowerCase(); // read start code
		 end=zone1[i].substring(4).toLowerCase(); // read end code (ex L3E)
		 
		 result1=PostCode.compareTo(start); // compare
		 result2=PostCode.compareTo(end);// compare
		 
		 if(result1>=0 && result2<=0){ serviceZone=serviceZone1;} // pass if PostCode is in the range
		 if(serviceZone==serviceZone1){break;}  // for efficiency
		}
		}
		
		if(serviceZone==null){  // for efficiency
		for (int m=0;m<zone2.length;m++){
		 
		 start=zone2[m].substring(0,3).toLowerCase();  //to lower case
		 end=zone2[m].substring(4).toLowerCase();		
		
		 result1=PostCode.compareTo(start); // take limits of range
		 result2=PostCode.compareTo(end);
		 if(result1>=0 && result2<=0){serviceZone=serviceZone2;}//compare
		 if(serviceZone==serviceZone2){break;}  // for efficiency
		}
		}
		
		if(serviceZone==null){
		for (int o=0;o<zone3.length;o++){ //handle special case
		  
		length=zone3[o].length();
		
		if(length<4){start=zone3[o].substring(0,3).toLowerCase();
		result1=PostCode.compareTo(start);
		
		if(result1==0){serviceZone=serviceZone3;}
		if(serviceZone==serviceZone3){break;} //handle special case -when there is no range
		 }else{
		 
		 start=zone3[o].substring(0,3).toLowerCase();
		 end=zone3[o].substring(4).toLowerCase();
		 
		 
		 result1=PostCode.compareTo(start);
		 result2=PostCode.compareTo(end);
		
		 if(result1>=0 && result2<=0){serviceZone=serviceZone3;}
		 if(serviceZone==serviceZone3){break;} }
		 }
		}
		
	
		
		return serviceZone ; //return null or servicezone 

	}
	}
	
