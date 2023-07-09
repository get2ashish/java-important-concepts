package ashish.examples.map;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortingMapExample {

    public static void main(String[] args) {

        Map<String,String> myMap = new HashMap<>();
        myMap.put("1","z");
        myMap.put("2","z");
        myMap.put("3","y");
        myMap.put("4","a");

        List<Map.Entry<String,String>> mapEntryList = new ArrayList<>(myMap.entrySet());
        Collections.sort(mapEntryList, Comparator.comparing(Map.Entry::getValue));
        Collections.sort(mapEntryList, new Comparator<Map.Entry<String, String>>() {
            @Override
            public int compare(Map.Entry<String, String> stringStringEntry, Map.Entry<String, String> t1) {
                return stringStringEntry.getValue().compareTo(t1.getValue());
            }
        });
        System.out.println(mapEntryList);

    }
}
