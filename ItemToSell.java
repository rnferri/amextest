/*****************
 * 
 * @author Rich Ferri
 * @description : This is a class which contains data that describes the items that can be
 *                purchased in this application. It also contains methods to retrieve the
 *                data items for use in other pplications.
 *
 */
public class ItemToSell 
{
	private AmexTaxTest.ProdType itemType;
	private double costPerUnit;
	private boolean imported;
	private String description;
	
	public static final double TAXRATE=.1;
	public static final double IMPORTTAX=.05;
		
	/******************
	 * 
	 * @param type : The product type of BOOK,MEDICAL,FOOD andother
	 * @param cost : The cost of one item
	 * @param impstat : Whether this is an imported item
	 * @param desc : Item Description
	 * @constructor : Just saves the data associated with this class.
	 */
	ItemToSell(AmexTaxTest.ProdType type, double cost, boolean impstat, String desc)
	{
		itemType=type;
		costPerUnit=cost;
		imported=impstat;
		description=desc;
		//.out.println(description + " : " + ItemType + " : " + CostPerUnit + " : " + imported);
				
	}
	public String getDescription()
	{
		return description;
	}
	
	public double getCostPerUnit()
	{
		return costPerUnit;
	}
	
	/*********************
	 * @name getTaxPerItem()
	 * @author : Rich Ferri
	 * @return : tax for this ItemToSell
	 * @procedure : This method calculates tax based upon product type and import status.
	 *          If imported is true,  5% tax is added. If the product is not BOOKS or MEDICAL o
	 *          or FOOD a 10% tax is added.
	 */
	public double getTaxPerItem()
	{
		 double tax = 0.0;

		if(itemType != AmexTaxTest.ProdType.BOOKS && itemType != AmexTaxTest.ProdType.FOOD && itemType != AmexTaxTest.ProdType.MEDICAL)
		{
			tax += costPerUnit * TAXRATE;
		}
		if(imported == true) 
		{
			tax += costPerUnit * IMPORTTAX;
		}
		return tax;
	}

}
