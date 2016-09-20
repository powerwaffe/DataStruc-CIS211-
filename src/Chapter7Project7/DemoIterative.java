package Chapter7Project7;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by Sean on 9/20/2016.
 */
public class DemoIterative
{
    private static BufferedReader stdin = new BufferedReader( new InputStreamReader( System.in ) );

    public static void TowersOfHanoi(int numberOfDisks, String startPole, String tempPole, String endPole)
    {
        //if (numberOfDisks > 0)
        while (numberOfDisks > 0)
        {
           // TowersOfHanoi(numberOfDisks - 1, startPole, tempPole, endPole);
           // System.out.println(startPole+" -> "+tempPole);
           // TowersOfHanoi(numberOfDisks - 1, tempPole, endPole, startPole);

            TowersOfHanoi(numberOfDisks - 1, startPole, endPole, tempPole);
            System.out.println(startPole+" -> "+tempPole);
            //TowersOfHanoi(numberOfDisks - 1, tempPole, startPole, endPole);
            numberOfDisks = numberOfDisks - 1;
            startPole = tempPole;
            tempPole = startPole;
            endPole = endPole;
        }
    }

    public static void main(String[] args)
    {
        int n;
        // Prompt the user
        System.out.println("Type a positive integer.");
        try
        {
            // Read a line of text from the user.
            String input = stdin.readLine();
            // converts a String into an int value
            n = Integer.parseInt(input);

            System.out.println("Type the name of the source peg:");
            String startPole = stdin.readLine();
            System.out.println("Type the name of the destination peg:");
            String tempPole = stdin.readLine();
            System.out.println("Type the name of the temporary peg:");
            String endPole = stdin.readLine();

            TowersOfHanoi(n, startPole, tempPole, endPole);

        }
        catch (java.io.IOException e)
        {
            System.out.println(e);
        }
    } // end of main
} // end DemoIterative

