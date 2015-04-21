# amextest
README document for American Express Tax Test:
Assumption #1: Although the problem statement is “Write an application that prints out the receipt details for these shopping
baskets”, the intent is to process the input strings by calculating taxes, the print the output strings from the results.
Otherwise I could just print out the input strings and output strings from the problem statement.

Assumption #2: The input strings must come from some catalog of items that are for sale. Each item in the catalog will also
have information about item type, and if the item was imported. Each of the items has to have a description string that is
unique. Otherwise, detecting the type of each order from the description string is very error prone.

Assumption #3: The Catalog of items exists before this test is started. In this code it is initialized from a list of hard
coded items, but that list could come from a file or a database or multiple locations.

The application is deployed as an executable jar file called AmexTest.jar. To run this jar you use the command
java –jar AmexTest.jar. A java runtime compatible with this application (1.6 or greater) must be installed on the test
machine. Also, the Classpath variable must be set up correctly.

NOTE: I believe the last output (#3) is incorrect. The Imported box of chocolates has a price of $11.25.
If you use a calculator, multiply that number by .05 you get .5625 which rounds to the nearest .05 gives you a tax of .55.
That would give you a total of 11.80 however the test description has 11.85 and the tax is high by .05 also.

