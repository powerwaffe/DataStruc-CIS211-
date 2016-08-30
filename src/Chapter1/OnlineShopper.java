package Chapter1;

/**
 * Created by Sean on 8/28/2016.
 */
public class OnlineShopper
{
    public static void main (String[] args)
    {
        Item[] items = {new Item ("Bird feeder", 2050),
                new Item("Squirrel guard", 1547),
                new Item("Bird bath", 4499),
                new Item("Sunflower seeds", 1295)};

        BagInterface <Item> shoppingCart = new ArrayBag<Item> ();
        int totalCost = 0;

        // statements that add selected items to the shopping cart:
        for(int index = 0 ; index < items.length ; index++)
        {
            Item nextItem = items[index]; // simulate getting item from
            // shopper
            shoppingCart.add(nextItem);
            totalCost = totalCost + nextItem.getPrice();
        } // end for

        // simulate checkout
        while (!shoppingCart.isEmpty())
            System.out.println (shoppingCart.remove());
        System.out.println ("Total cost: " +
                "\t$" + totalCost / 100 + "." +
                totalCost % 100);
    } // end main

} // end OnlineShopper