package Chapter4Project1;
import java.util.*;
/**
 * Created by Sean on 9/12/2016.
 */
public class AlgorithmEfficiency
{
    public static void main(String[] args)
    {
        long n = 10000; // ten thousand
        long sum = 0;

        /**Algorithm A*/
        System.out.println("\t\t\t\t(Table A)");
        System.out.println("Value of n\t\tTime(ns)\t\tSum\n-----------------------------"+
                            "-----------------");
        for (int j = 0; j < 3; j++) //Run algorithm A 3 times
        {
            long startTime1 = System.nanoTime(); //Start timer for beginning of algorithm
            for (long i = 1; i <= n; i++)
                sum = sum + i;
            long endTime1 = System.nanoTime(); //End timer for end of algorithm
            long duration1 = (endTime1 - startTime1); //Calculate time ran

            //Print results for algorithm A
            System.out.println(n + "\t\t\t" + duration1 + "\t\t" + sum);
            n+=10000; //Increment n by 10,000
        } //end for

        /**Algorithm B*/
        System.out.println("\n\t\t\t\t(Table B)");
        System.out.println("Value of n\t\tTime(ns)\t\tSum\n-----------------------------"+
                "-----------------");
        sum = 0;
        n = 10000; //Reset n to 10,000
        for (int k = 0; k < 3; k++) //Run algorithm B 3 times
        {
            long startTime2 = System.nanoTime();
            for (long i = 1; i <= n; i++)
            {
                for (long j = 1; j <= i; j++)
                    sum = sum + 1;
            } // end for
            long endTime2 = System.nanoTime();
            long duration2 = (endTime2 - startTime2);

            //Print results for algorithm B
            System.out.println(n + "\t\t\t" + duration2 + "\t\t" + sum);
            n+=10000; //Increment n by 10,000
        } //end for

        /**Algorithm C*/
        System.out.println("\n\t\t\t\t(Table C)");
        System.out.println("Value of n\t\tTime(ns)\t\tSum\n-----------------------------"+
                "-----------------");
        n = 10000;
        for (int i = 0; i < 3; i++)
        {
            long startTime3 = System.nanoTime();
            sum = n * (n + 1) / 2;
            long endTime3 = System.nanoTime();
            long duration3 = (endTime3 - startTime3);

            //Print results for algorithm C
            System.out.println(n + "\t\t\t" + duration3 + "\t\t" + sum);
            n+=10000; //Increment n by 10,000
        } //end for
    } //end main
} //end AlgorithmEfficiency
