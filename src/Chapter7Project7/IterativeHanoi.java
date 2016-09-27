package Chapter7Project7;

import java.util.Scanner;

/**
 * Created by Sean on 9/26/2016.
 */
public class IterativeHanoi
{
    public static void TowersOfHanoi(int numberOfDisks, String startPole, String tempPole, String endPole)
    {
        //while (numberOfDisks > 0)
        for (int i = numberOfDisks; i > 0; i--)
        {
            /** MUST GO 1, 3, 2, 1 */
            //System.out.println(startPole + "-" + tempPole + "-" + endPole);
            //System.out.println(startPole + " -> " + endPole + " 1");
            TowersOfHanoi(numberOfDisks - 1, startPole, endPole, tempPole);
            System.out.println(startPole + " -> " + endPole + " 1");
            endPole = startPole;
            startPole = tempPole;
            numberOfDisks = numberOfDisks - 1;
            //i--;

        }
        System.out.println("End loop");
    }

    public static void main(String[] args)
    {
        System.out.println("Enter amount of discs: ");
        Scanner scanner = new Scanner(System.in);
        int discs = scanner.nextInt();
        TowersOfHanoi(discs, "A", "B", "C");
    } // end of main
}
