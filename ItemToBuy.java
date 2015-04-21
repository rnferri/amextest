
/********************
 * 
 * 
 * @author Rich Ferri
 * @class : ItemToBuy used to encapsulate the details of purchasing an ItemToSell object.
 *
 */
public class ItemToBuy 
{
	public ItemToSell itemReference;
	private int numberItems;
	private double taxToPay;		// This is total tax rounded

	/****************************
	 * 
	 * @param its : The ItemToSell object that defines the product
	 * @param numItems : Number of items to be  purchased
	 * @constructor saves a reference to ItemToSell object, the number of
	 *                   of items being purchased and calculates the total
	 *                   tax for this purchase.
	 */
	public ItemToBuy(ItemToSell its, int numItems)
	{
		itemReference = its;
		numberItems = numItems;
		// retrieve the amount of tax to pay by multiplying tax per item by
		// the number of items, then round it and store in taxToPay
		double amount = its.getTaxPerItem() * numberItems;
		taxToPay = ((double) (long) (amount * 20 + 0.5)) / 20;
		
		// TODO Auto-generated constructor stub
	}
	public int getNumberItems()
	{
		return numberItems;
		
	}
	
	public double getTaxToPay()
	{
		return taxToPay;
	}
	
	public String getDescription()
	{
		return itemReference.getDescription();
	}
	
	public double getPurchaseCost()
	{
		return (itemReference.getCostPerUnit() * numberItems);
	}
	
	public double getCostPerUnit()
	{
		return itemReference.getCostPerUnit();
	}
	

}
Enter file contents here
