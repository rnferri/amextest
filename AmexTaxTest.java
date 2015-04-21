import java.util.*;
/**********************
 * @classname AmexTaxTest
 * 
 * @author Rich Ferri
 *
 * @function : This class defines variables, initializes data, Runs tax test and prints
 *             the test input/output. 
 *  @itemsForSale : A hashmap which contains all of the items that are for sale in the form
 *  of ItemToSell objects with key of description.
 *  
 *  @constant strings and String arrays are used to provide a data driven input to
 *             RunTest().
 *     
 */
public class AmexTaxTest 
{
	public enum ProdType {
		BOOKS, FOOD, MEDICAL, OTHER
	}
	public static final String BOOK1="book";
	public static final String MUSIC1="music CD";
	public static final String CHOCOLATE1="chocolate bar";
	public static final String[] FIRSTTESTS = {BOOK1 + "!1",MUSIC1 + "!1",CHOCOLATE1 + "!1"};
	
	public static final String CHOCOLATE2="imported box of chocolates";
	public static final String PERFUME2="imported bottles of perfume";
	public static final String[] SECONDTEST = {CHOCOLATE2 + "!1",PERFUME2 + "!2"};
	
	public static final String IMPPERF3="imported bottle of perfume";
	public static final String PERF3="bottle of perfume";
	public static final String HEADACHE3="packet of headache pills";
	public static final String IMPCHOCALATE3="box of imported chocalates";	
	
	public static final String[] THIRDTEST = {IMPPERF3 + "!1",PERF3 + "!1",HEADACHE3 + "!1",IMPCHOCALATE3 + "!1"};
	
	Map<String, ItemToSell> itemsForSale; //= new HashMap<String, ItemToSell>();
	public static void main(String[] args) 
	{
		 System.out.println("AmexTest");
		 AmexTaxTest Att = new AmexTaxTest();
		 Att.RunTest(FIRSTTESTS,1);
		 Att.RunTest(SECONDTEST,2);
		 Att.RunTest(THIRDTEST,3);

	}
	
	/******************************
	 * @author : Richard Ferri
	 * @methodname : RunTest
	 * @param testDescriptions : Is an array of strings that drives the test the format
	 *             of the array is TestDescription!number purchased. The TestDescription
	 *             is used as a key into itemsForSale to retrieve the ItemToSell object.
	 * @param testnum : The index of the test (1,2,3)
	 * @procedure : This method runs one set of tests at a time based upon the contents
	 *              of the array of Strings testDescriptions. Each string in the array
	 *              contains the description of the ItemToSell object. Using this the 
	 *              ItemToSell objects for this test are retrieved. From this object
	 *              the ItemToBuy objects are initialized and added to the boughtItems
	 *              array. From this array the input strings andoutput strings are
	 *              derived and printed.
	 *  @itemsForSale is a hashmap of all of the ItemForSale objects that have been
	 *  initialized for this application. From this ItemForSale objects are retrieved
	 *  based on description.          
	 */
	public void RunTest(String [] testDescriptions, int testnum)
	{
		List<ItemToBuy> boughtItems = new ArrayList<ItemToBuy>();
		for (String td : testDescriptions)
		{
			// The test description array is in the format description!numberof items
			// This is split into part[0] and parts[1] which is description and
			// number of items, respectively
			String[] parts = td.split("!");

			int numtobuy = Integer.parseInt(parts[1]);
//	    	 ItemsForSale is a hashMap containing all the ItemToSell objects that have been
//			initialized in this system. The next line retrieves the correct object from
//			that map based upon the description of the item. (That is the ey in the map)	
//          since the initializatrion and the use of these objects is in this code, 
//			every description should be the key to an object in the map.
	    	  ItemToSell itts = itemsForSale.get(parts[0]);
	    	  if( itts == null)
	    	  {
	    		  // if the object is not in map, there is a problem
	    		  System.out.println("Item is null for description = " + td);
	    	  }
	    	  else
	    	  {
	    		  // If the item is in the list, then add it to the list of items
	    		  // to be processed in this test. 
	    		  ItemToBuy ittb = new ItemToBuy(itts,numtobuy);
	    		  boughtItems.add(ittb);
	    	  }
	    	
		}
		
		System.out.println("INPUT " + testnum + "\n");
		for(ItemToBuy ib: boughtItems)
		{
			//format the string so that it has only two significant digits after decimal
			String printstr = String.format("%.2f",ib.getCostPerUnit() );
			System.out.println(ib.getNumberItems() + "  " + ib.getDescription() + " at " + printstr );
		}
		System.out.println("\nOUTPUT " + testnum + "\n");
		double totTax = 0;
		double totSale = 0;
		for(ItemToBuy ib: boughtItems)
		{
			String printstr = String.format("%.2f",( ib.getPurchaseCost() + ib.getTaxToPay()) );
			System.out.println(ib.getNumberItems() + "  " + ib.getDescription() + " at " + printstr );
			totTax += ib.getTaxToPay();
			totSale +=ib.getPurchaseCost() + ib.getTaxToPay();
		}
		String taxStr =String.format("%.2f",totTax );
		System.out.println("Sales Taxes: " + taxStr);
		String totStr = String.format("%.2f",totSale );
		System.out.println("TotAL: " + totStr);
	}
	
	/*******************************
	 * Constructor which just calls initialization routine.
	 */
	AmexTaxTest()
	{
		
		InitializeItemsForSale();
	}
	
	/*****************************************************************f
	 * InitializeItemsForSale() : initialization method.
	 * Author : Richard Ferri
	 * Date: 04/16/2015
	 * Function : Initializes ItemForSale objects and adds each object to a hashmap
	 *            with the product description as key.
	 *  AmexTaxTest receives strings that describe a product, the price of the product
	 *  and implies type of product. Since most sales don't work this way, this method creates 
	 *  an ItemToSell object for each of the input strings in the spec. It adds properties
	 *  such as import and type so that this type of is not determined by random string 
	 *  searches.
	 *          This method initializes based upon inline text, but it could also work
	 *          from a database or a file.  
	 */
	private void InitializeItemsForSale()
	{
		// This line initializes the class variable to a HashMap initialization
		itemsForSale = new HashMap<String,ItemToSell>();
		ItemToSell itmts = new ItemToSell(AmexTaxTest.ProdType.BOOKS, 12.49,false,BOOK1);
		itemsForSale.put(itmts.getDescription() , itmts);
		itmts = new ItemToSell(AmexTaxTest.ProdType.OTHER, 14.99,false,MUSIC1);
		itemsForSale.put(itmts.getDescription() , itmts);
		itmts = new ItemToSell(AmexTaxTest.ProdType.FOOD, .85,false,CHOCOLATE1);
		itemsForSale.put(itmts.getDescription() , itmts);
		itmts = new ItemToSell(AmexTaxTest.ProdType.FOOD, 10.00,true,CHOCOLATE2);
		itemsForSale.put(itmts.getDescription() , itmts);
		itmts = new ItemToSell(AmexTaxTest.ProdType.OTHER, 47.25,true,PERFUME2);
		itemsForSale.put(itmts.getDescription() , itmts);
		itmts = new ItemToSell(AmexTaxTest.ProdType.OTHER, 27.99,true,IMPPERF3);
		itemsForSale.put(itmts.getDescription() , itmts);
		itmts = new ItemToSell(AmexTaxTest.ProdType.OTHER, 18.99,false,PERF3);
		itemsForSale.put(itmts.getDescription() , itmts);
		itmts = new ItemToSell(AmexTaxTest.ProdType.MEDICAL, 9.75,false,HEADACHE3);
		itemsForSale.put(itmts.getDescription() , itmts);
		itmts = new ItemToSell(AmexTaxTest.ProdType.FOOD, 11.25,true,IMPCHOCALATE3);
		itemsForSale.put(itmts.getDescription() , itmts);
	}

}
