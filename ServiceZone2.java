public class ServiceZone2 extends ServiceZone { //  inheritance from super class.
private double ExtraCost;
private double ShippingCost; 
	
	
public ServiceZone2(double BaseRate, double Rate20, double Rate75, double fuelSurcharge)
{
	super(BaseRate,Rate20,Rate75,fuelSurcharge);//  super class
}
public double getExtraCost(int weight)//calculate extra cost per extra pound
{
   ExtraCost=0; // reset ExtraCost
   if(weight>FREE_WEIGHT && weight<=WEIGHT_LIMIT){
   ExtraCost=(1+Math.ceil((weight-FREE_WEIGHT)/5))*getRate20();}// 10<weight<20
   else if(weight>WEIGHT_LIMIT && weight<= WEIGHT_BEYOND_SERVICE){
   ExtraCost=(1+Math.ceil((weight-FREE_WEIGHT)/5))*getRate75();}//20<weight<75
   return ExtraCost;
 }


public double getShippingCost(int weight) // over write the method
{
  ShippingCost=0;  // reset getShippingCost
  if(weight<=FREE_WEIGHT){ShippingCost=getMinimumCost();}// if < 10bls , MinimumCost is charged
  else{ShippingCost=getMinimumCost()+getExtraCost(weight);}// if >10 bls , MinimumCost +extra cost.
  return ShippingCost;
 }
 }