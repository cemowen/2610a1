
public class ServiceZone1 extends ServiceZone {
		
		private double extraCost;
		protected double shippingCost;
		
		//constructor
		public ServiceZone1(double baseRate, double rate20, double rate75, double fuelSurcharge){
			super(baseRate, rate20, rate75, fuelSurcharge);
		}
		
		//extra charge for package over 10lb
		public void getExtraCost(int weight){
			extraCost = 0.0;
			if(weight>FREE_WEIGHT && weight<=WEIGHT_LIMIT)
				extraCost = (weight-10)*rate20;
			else if(weight>WEIGHT_LIMIT && weight<=WEIGHT_BEYOND_SERVICE)
				extraCost = (weight-10)*rate75;			
		}
		
		//total shipping cost
		public double getShippingCost(int weight){
			if(weight <= WEIGHT_BEYOND_SERVICE && weight > 0)
				shippingCost = getMinimumCost()+extraCost;			
			else 
				shippingCost = getMinimumCost();
			return shippingCost;			
		}


}
