/**
 * 
 * This class is the general class which provide all the implementation
 * of the general methods to get the shipping cost. In the different 
 * zones, the shipping costs are calculated differently. Therefore, the 
 * getShippingCost() method needs to be defined specificly for each 
 * zone.
 */
public abstract class ServiceZone 
{
	
	final int FREE_WEIGHT = 10;
	final int WEIGHT_LIMIT = 20;
	final int WEIGHT_BEYOND_SERVICE = 75;
	protected double baseRate; 
	protected double rate20; //rate per extra pound between free weight and 20lb
	protected double rate75; //rate per extra pound between 20lb and 75lb
	protected double fuelSurcharge;
	
	/**
	 * @param baseRate
	 * @param rate20
	 * @param rate75
	 * @param fuelSurcharge
	 */
	public ServiceZone(double baseRate, double rate20, double rate75, double fuelSurcharge)
	{
		this.baseRate = baseRate;
		this.rate20 = rate20;
		this.rate75 = rate75;
		this.fuelSurcharge = fuelSurcharge;
	}
	
	/**
	 * @return the shipping cost within the free weight
	 */
	public double getMinimumCost()
	{
		 //Provide code to implement this method
		return baseRate + fuelSurcharge;

	}

	/**
	 * @return the base rate
	 */
	public double getBaseRate() {
		return baseRate;
	}

	/**
	 * 
	 * @return rate per extra pound between free weight and 20lb
	 */
	public double getRate20() 
	{ 
		return rate20; 
	}



	/**
	 * @return rate per extra pound between 20lb to 75lb
	 */
	public double getRate75() {
		return rate75;
	}

	/**
	 * @return fuel surcharge
	 */
	public double getFuelSurcharge() {
		return fuelSurcharge;
	}


	/**
	 * @param weight
	 * @return shipping cost at the weight
	 */
	public abstract double getShippingCost(int weight);

}
