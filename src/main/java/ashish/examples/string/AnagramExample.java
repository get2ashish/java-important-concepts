package ashish.examples.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AnagramExample {

    public static void main(String[] args) {
        //race,part,trap,earth,heart,vishnu,care
        //Output: [race,care],[part,trap],[earth,heart],[vishnu]
        List<String> myList = new ArrayList<>();
        myList.add("race");
        myList.add("part");
        myList.add("trap");
        myList.add("earth");
        myList.add("heart");
        myList.add("vishnu");
        myList.add("care");

        Map<Integer, List<String>> collect = myList.stream()
                .collect(Collectors.groupingBy(item -> item.length()));

        for (Map.Entry<Integer, List<String>> entry : collect.entrySet()) {
            List<String> nameList = entry.getValue();
            String firstName = nameList.remove(0);
            char[] arr = firstName.toCharArray();
            Arrays.sort(arr);
            for (String name : nameList) {
                char[] nextNameArr = name.toCharArray();
                Arrays.sort(nextNameArr);
                if (Arrays.equals(arr, nextNameArr)) {
                    System.out.println(firstName + " is anagram to " + name);
                }
            }
        }


        //Or using streams
        myList.stream()
                .collect(Collectors.groupingBy(item -> item.length()))
                .entrySet()
                .stream()
                .forEach(entry -> {
                    List<String> nameList = entry.getValue();
                    String firstName = nameList.remove(0);
                    char[] arr = firstName.toCharArray();
                    Arrays.sort(arr);
                    for (String name : nameList) {
                        char[] nextNameArr = name.toCharArray();
                        Arrays.sort(nextNameArr);
                        if (Arrays.equals(arr, nextNameArr)) {
                            System.out.println(firstName + " is anagram to " + name);
                            break;
                        }
                    }
                });


    }
}
