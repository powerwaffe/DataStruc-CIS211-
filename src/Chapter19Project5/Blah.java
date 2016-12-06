package Chapter19Project5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Sean on 12/5/2016.
 */
public class Blah
{
    // Map to be used
    private static Map<String, List<String>> map = new HashMap<>();

    public static void main(String[] args)
    {
        // Create scanner object
        Scanner input = new Scanner(System.in);

        // Variables
        String illnessSelection;
        String newSymptom;

        System.out.println("===================Physician Helper===================");
        System.out.println("Here is a list of illnesses and their symptoms:\n");

        // Place items into map
        put(map, "Headache", "Head pain");
        put(map, "Headache", "Sensation of tightness of pressure on head");
        put(map, "Flu", "Coughing");
        put(map, "Flu", "Chills");
        put(map, "Flu", "Fatigue");

        int keepGoing = 1;

        while (keepGoing == 1)
        {
            // Must edit filepath or FileNotFound exception will be thrown
            //String fileName = "C:\\Users\\Sean\\IdeaProjects\\DataStruc [CIS211]\\src\\Chapter19Project5\\Data.txt";

            /**try
             {
             Scanner data = new Scanner(new File(fileName));
             readFile(data);

             map.forEach((s, strings) ->
             {
             System.out.print(s + ": ");
             System.out.println(strings.stream().collect(Collectors.joining(", ")));
             });
             }
             catch (FileNotFoundException e)
             {
             System.out.println("File not found: " + e.getMessage());
             }
             */
            //remove(map, "Headache", "Head pain");

            // Print illness and symptom map
            map.forEach((s, strings) ->
            {
                System.out.print(s + ": ");
                System.out.println(strings.stream().collect(Collectors.joining(", ")));
            });

            System.out.println("\nWould you like to add(1) or remove(2) a symptom to an existing illness?");
            System.out.println("(1) - To add a symptom");
            System.out.println("(2) - To remove a symptom");
            System.out.println("(0) - To exit program");
            String response = input.next();

            if (response.equals("1"))
            {
                System.out.println("Type in the illness you would like to add to");
                String bufferLine = input.nextLine();
                illnessSelection = input.nextLine();
                System.out.println("Now type in the symptom you would like to add");
                newSymptom = input.nextLine();

                // Place new symptom into map
                put(map, illnessSelection, newSymptom);
            }
            else if (response.equals("2"))
            {
                System.out.println("Type in the illness you would like to remove a symptom from");
                String bufferLine = input.nextLine();
                illnessSelection = input.nextLine();
                System.out.println("Now type in the symptom you would like to remove");
                newSymptom = input.nextLine();

                // Place new symptom into map
                remove(map, illnessSelection, newSymptom);
            }
            else
            {
                // Exit loop and program
                keepGoing = 0;
            }
        } // end while loop
    } // end main

    // Adds value to map
    private static <KEY, VALUE> void put(Map<KEY, List<VALUE>> map, KEY key, VALUE value)
    {
        map.compute(key, (s, strings) -> strings == null ? new ArrayList<>() : strings).add(value);
    } // end put

    // Removes value from map
    private static boolean remove(Map<String, List<String>> map,
                                               String key, String value)
    {
        List<String> existingValues = map.get(key);
        if (existingValues != null)
        {
            return existingValues.remove(value);
        } // end if
        return false;
    } // end remove

    public static void readFile(Scanner data)
    {
        //Map<String, List<String>> map = new HashMap<>();
        while (data.hasNext())
        {
            String line = data.nextLine();
            String[] temp = line.split(",");

            String illness = data.next();
            String symptom1 = data.next();
            //String symptom2 = data.next();
            //String symptom3 = data.next();
            String symptomList = symptom1;

            //map.put(illness, symptomList);
            put(map, illness, symptomList);
        }
        data.close();
    }
} // end Blah