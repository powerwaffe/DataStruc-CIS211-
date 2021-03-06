package Chapter19Project5;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Sean on 12/5/2016.
 */
public class PhysicianHelper
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
        put(map, "Cold", "Coughing");

        int keepGoing = 1; // Variable used to continue or exit loop
        while (keepGoing == 1)
        {
            // Print illness and symptom map
            map.forEach((s, strings) ->
            {
                System.out.print(s + ": ");
                System.out.println(strings.stream().collect(Collectors.joining(", ")));
            });

            // Illness and symptom selection menu
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


                System.out.println(searchMap((HashMap) map, newSymptom));
                // Place new symptom into map
                put(map, illnessSelection, newSymptom);

                /**for(String key : map.keySet())
                {
                    List<String> value = map.get(key);

                    if(newSymptom.equals(value))
                    {
                        String keyAndValue = key + value; // this is what you want
                        System.out.println(keyAndValue + " FLAFLASLFDASD");
                    }
                }*/

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
                keepGoing = 0; // Exit loop and program
            }
        } // end while loop
    } // end main

    /** Method will add a value to a existing key or create a key and a value to amp */
    private static <KEY, VALUE> void put(Map<KEY, List<VALUE>> map, KEY key, VALUE value)
    {
        map.compute(key, (s, strings) -> strings == null ? new ArrayList<>() : strings).add(value);
    } // end put

    /** Method will remove a given value from a given key of a map */
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

    /** Will read a text file data
     * NOT IMPLEMENTED YET! */
    public static void readFile(Scanner data)
    {
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
    } // end readFile

    public static ArrayList < String > searchMap ( HashMap map, String value )
    {
        ArrayList < String > matchesFound = new ArrayList < String >();
        Iterator it = map.entrySet().iterator();
        while ( it.hasNext() )
        {
            Map.Entry entry = (Map.Entry) it.next();
            if ( entry.getValue() == value )
                matchesFound.add( entry.getKey() + " : " + entry.getValue() );
        }
        return matchesFound;
    }
} // end PhysicianHelper