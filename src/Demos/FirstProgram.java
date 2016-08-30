package Demos;
import java.text.DecimalFormat;
import java.util.*;
/**
 * Created by Sean on 8/25/2016.
 */
public class FirstProgram
{
    public static void main(String[] Farts)
    {
        //Choose decimal length
        DecimalFormat df = new DecimalFormat(("#.##"));

        int n = 3;
        int m = 4;
        int result = n * (++m);

        //scanner to read input
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Hello there");
        System.out.println("Want to talk some more?");
        System.out.println("Yes or No");

        //grab input from user
        String answer = keyboard.next();
        if (answer.equals("yes") || answer.equals("Yes"))
            System.out.println("Nice weather we are having");
        System.out.println("Good bye");
        System.out.println("Have some math\n" + result);

        //random print statements
        System.out.println("Lets use inter n * PI\nn = " + n);
        System.out.println("Have some PI " + Math.PI * n);
        System.out.println("Hey that's kind of a messy read...lets trim that to 2 decimals places, ok?");
        System.out.println(df.format(Math.PI * n));

        int count, number;
        number = 10;
        for (count = 1; count <= number; count++)
            System.out.println("Counting..." + count);
    }
}
