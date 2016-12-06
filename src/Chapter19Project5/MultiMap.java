package Chapter19Project5;

import java.util.*;

/**
 * Created by Sean on 11/26/2016.
 */
public class MultiMap {
    public static void main(String[] args) {
        Map<String, List<String>> hm = new HashMap<String, List<String>>();
        List<String> values = new ArrayList<String>();
        values.add("Value 1");
        values.add("Value 2");
        hm.put("Key1", values);

        // to get the arraylist
        System.out.println(hm.get("key1"));
    }
}
