package Demos;

/**
 * Created by Sean on 8/27/2016.
 */
public class foreach {
    public static void main(String[] cheese)
    {
        int[] anArray = {1, 2, 3, 4, 5};
        int sum = 0;

        for (int integer : anArray)
            sum = sum + integer;
        System.out.println(sum);

        String[] friends = {"Gavin", "Gail", "Jared", "Jessie"};
        for (String name : friends)
            System.out.println(name);
    }
}
