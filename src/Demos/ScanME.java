package Demos;
import java.util.*;
/**
 * Created by Sean on 8/25/2016.
 */
public class ScanME
{
    public static void main(String[] farts)
    {
        String phrase = "one potato         two     potato three potato four";
        Scanner scan = new Scanner(phrase);
        System.out.println(scan.next());
        System.out.println(scan.next());
        System.out.println(scan.next());
        System.out.println(scan.next());
        System.out.println(scan.next());
        System.out.println(scan.next());
        System.out.println(scan.next());

        //delimiter strips away certain spaces of string
        System.out.println("Let's strip away the potato's....NO POTATO'S!");
        Scanner delScan = new Scanner(phrase).useDelimiter("\\s*potato\\s*");
        System.out.println(delScan.next());
        System.out.println(delScan.next());
        System.out.println(delScan.next());
    }
}
