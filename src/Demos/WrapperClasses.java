package Demos;

/**
 * Created by Sean on 8/27/2016.
 */
public class WrapperClasses {
    public static void main(String[] ducks)
    {
        Character c1 = new Character('a');
        Character c2 = new Character('A');
        if (c1.equals(c2))
            System.out.println(c1.charValue() + " is the same as " + c2.charValue());
        else
            System.out.println(c1.charValue() + " is not the same as " + c2.charValue());

        //use method toLowerCase & toUpperCase
        System.out.println(c1 + " became " + toUpperCase(c1) + "\n" + c2 + " became " + toLowerCase(c2));

        //or....
        Character.toLowerCase('A');
        Character.toUpperCase('a');
    }

    public static char toLowerCase(char ch)
    {
        return Character.toLowerCase(ch);
    } //end toLowerCase
    public static char toUpperCase(char ch)
    {
        return Character.toUpperCase(ch);
    } //end toUpperCase
} //end WrapperClasses
