public class ServiceZone3 extends ServiceZone {
	private double ExtraCost;
	private double ShippingCost; 
	
	
public ServiceZone3(double BaseRate, double Rate20, double Rate75, double fuelSurcharge)
{
	super(BaseRate,Rate20,Rate75,fuelSurcharge); //  super class
}
public double getExtraCost(int weight)//calculate extra cost per extra pound
{
   ExtraCost=0;
   if(weight>FREE_WEIGHT && weight<=WEIGHT_LIMIT){
   ExtraCost=(1+Math.ceil((weight-FREE_WEIGHT)/5))*getRate20();}// 10<weight<20
   else if(weight>WEIGHT_LIMIT && weight<= WEIGHT_BEYOND_SERVICE){
   ExtraCost=(1+Math.ceil((weight-FREE_WEIGHT)/10))*getRate75();}//20<weight<75
   return ExtraCost;
 }


public double getShippingCost(int weight)
{
  ShippingCost=0;
  if(weight<=FREE_WEIGHT){ShippingCost=getMinimumCost();}
  else{ShippingCost=getMinimumCost()+getExtraCost(weight);}
  return ShippingCost;
 }
 }
