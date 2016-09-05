package pjc1;

/** A class that maintains a shopping cart for an online store.
 @author Frank M. Carrano
 @version 4.0
 */
public class OnlineShopper
{
    public static void main(String[] args)
    {
        Artist[] items = {new Artist(1, "Acconci"),
                new Artist(2, "Ames"),
                new Artist(3, "Aserty"),
                new Artist(4, "Baron"),
                new Artist(5, "Battenberg")};

        BagInterface<Artist> shoppingCart = new ArrayBag<>();
        int totalCost = 0;

        // Statements that add selected items to the shopping cart:
        for (int index = 0; index < items.length; index++)
        {
            Artist nextItem = items[index]; // Simulate getting item from shopper
            shoppingCart.add(nextItem);
            totalCost = totalCost + nextItem.getPrice();
        } // end for

        // Simulate checkout
        while (!shoppingCart.isEmpty())
            System.out.println(shoppingCart.remove());

        System.out.println("Total cost: " + "\t$" + totalCost / 100 + "." +
                totalCost % 100);
    } // end main
} // end OnlineShopper

/*
Sunflower seeds $12.95
Bird bath	    $44.99
Squirrel guard	 $15.47
Bird feeder	    $20.50
Total cost: 	 $93.91
*/