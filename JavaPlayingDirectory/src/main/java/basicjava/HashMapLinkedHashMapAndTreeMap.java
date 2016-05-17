package basicjava;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import static java.lang.System.out;

/**
 * http://stackoverflow.com/questions/2889777/difference-between-hashmap-linkedhashmap-and-treemap
 */
public class HashMapLinkedHashMapAndTreeMap {

    public static void main(String[] argc) {
        out.println("HashMap:"); //No ordering at all
        Map hm = new HashMap();
        hm.put("map", "01-HashMap");
        hm.put("schildt", "02-java2");
        hm.put("mathew", "03-Hyden");
        hm.put("schildt", "04-java2s");
        out.println(hm.keySet());
        out.println(hm.values());

        out.println("\nTreeMap:"); //Ordering according to comparator
        SortedMap sm = new TreeMap();
        sm.put("map", "01-TreeMap");
        sm.put("schildt", "02-java2");
        sm.put("mathew", "03-Hyden");
        sm.put("schildt", "04-java2s");
        out.println(sm.keySet());
        out.println(sm.values());

        out.println("\nLinkedHashMap:"); //Order of inserting
        LinkedHashMap lm = new LinkedHashMap();
        lm.put("map", "01-LinkedHashMap");
        lm.put("schildt", "02-java2");
        lm.put("mathew", "03-Hyden");
        lm.put("schildt", "04-java2s");
        out.println(lm.keySet());
        out.println(lm.values());
    }
}
