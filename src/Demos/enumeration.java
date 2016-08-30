package Demos;

/**
 * Created by Sean on 8/27/2016.
 */
public class enumeration {
    enum Suit
    {
        CLUBS("black"), DIAMONDS("red"), HEARTS("red"), SPADES("black");

        private final String color;

        private Suit(String suitColor)
        {
            color = suitColor;
        } //end constructor

        public String getColor()
        {
            return color;
        } //end getColor
    } //end suit
    public static void main(String[] cheese)
    {
        for (Suit nextSuit : Suit.values())
        {
            System.out.println(nextSuit + " are " + nextSuit.getColor() +
            " and have an ordinal value of " + nextSuit.ordinal());
        }
    }
}
