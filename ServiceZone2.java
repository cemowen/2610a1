
public class ServiceZone2 extends ServiceZone {
	
	private double extraCost;
	protected double shippingCost;
	
	//constructor
	public ServiceZone2(double baseRate, double rate20, double rate75, double fuelSurcharge){
		super(baseRate, rate20, rate75, fuelSurcharge);
	}
	
	public void getExtraCost(int weight){
		extraCost = 0.0;
		if(weight>FREE_WEIGHT && weight<=WEIGHT_LIMIT)
			extraCost = ((weight-10)/5)*rate20;
		else if(weight>WEIGHT_LIMIT && weight<=WEIGHT_BEYOND_SERVICE)
			extraCost = ((weight-10)/5)*rate75;
	}
	
	public double getShippingCost(int weight){
		if(weight <= WEIGHT_BEYOND_SERVICE && weight > 0)
			shippingCost = getMinimumCost()+extraCost;	
		else 
			shippingCost = getMinimumCost();
		return shippingCost;
	}

}
