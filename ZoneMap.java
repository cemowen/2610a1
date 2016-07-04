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
				{					
					zone1 = in.readLine().split(",");
				}
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
	public ServiceZone getValidZone(String postCode)
	{
		
 		//Provide code to implement this method

	}
	
