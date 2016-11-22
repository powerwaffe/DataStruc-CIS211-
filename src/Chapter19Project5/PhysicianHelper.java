package Chapter19Project5;
import com.sun.org.apache.bcel.internal.generic.RET;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
/**
 * Created by Sean on 11/21/2016.
 */
public class PhysicianHelper
{
    public static Map<String, String> m = new HashMap<String, String>();

    public static void main(String[] args)
    {
        // Must edit filepath or FileNotFound exception will be thrown
        String fileName = "C:\\Users\\Sean\\IdeaProjects\\DataStruc [CIS211]\\src\\Chapter19Project5\\Data.txt";

        try
        {
            Scanner data = new Scanner(new File(fileName));
            readFile(data);
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found: " + e.getMessage());
        }

        //System.out.println(m.toString());

        Set<String> keys = m.keySet();  //get all keys
        for(String i: keys)
        {
            System.out.println(m.get(i));
        }
    }

    public static void readFile(Scanner data)
    {
        while (data.hasNext())
        {
            String firstName = data.next();
            String lastName = data.next();
            String phoneNumber = data.next();
            String fullName = firstName + " " + lastName;

            m.put(fullName, phoneNumber);
        }
        data.close();
    }

    public String getPhoneNumber(String name)
    {
        return  m.get(name);
    }
}
