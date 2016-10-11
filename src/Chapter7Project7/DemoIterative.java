package Chapter7Project7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by Sean on 9/20/2016.
 */
public class DemoIterative
{
    public static void TowersOfHanoi(int numberOfDisks, String startPole, String tempPole, String endPole)
    {
        //while (numberOfDisks > 0)
        if (numberOfDisks > 0)
        {
            /** MUST GO 1, 3, 2, 1 */
            //System.out.println(startPole + " -> " + endPole + " Before Recursive Call");
            TowersOfHanoi(numberOfDisks - 1, startPole, endPole, tempPole);
            System.out.println(startPole + " -> " + endPole + " Recursive Call");
            TowersOfHanoi(numberOfDisks - 1, tempPole, startPole, endPole);
            //numberOfDisks = numberOfDisks - 1;
            //startPole = tempPole;
            //tempPole = startPole;
        }
        //System.out.println("END CONDITIONAL");
    }

    public static void main(String[] args)
    {
        DemoIterative demoIterative = new DemoIterative();
        System.out.println("Enter amount of discs: ");
        Scanner scanner = new Scanner(System.in);
        int discs = scanner.nextInt();
        demoIterative.TowersOfHanoi(discs, "A", "B", "C");
    } // end of main
} // end DemoIterative

