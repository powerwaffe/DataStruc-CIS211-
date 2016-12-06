package Chapter19Project5;
import java.util.*;

/**
 * Created by Sean on 11/23/2016.
 */
public class DemoHashDictionary
{
    public static void main(String[] args) {
        List<Map<String, List<String>>> list = new ArrayList<Map<String, List<String>>>();//This is the final list you need
        Map<String, List<String>> map1 = new HashMap<String, List<String>>();//This is one instance of the map you want to store in the above map
        List<String> arraylist1 = new ArrayList<String>();

        arraylist1.add("Text1");//And so on..
        arraylist1.add("Fartshit");
        //map1.put("key1", Arrays.asList("fart", "dick"));
        map1.put("Key1", arraylist1);
        map1.get("Key1").add("farts");

        //And so on...
        map1.put("Key2", arraylist1);

        list.add(map1);//In this way you can add.

        Set<String> keys = map1.keySet();  //get all keys
        for (String i : keys) {
          //  System.out.println(map1.toString() + map1.get(i));
        }

        System.out.println(map1.toString());
    }
}
