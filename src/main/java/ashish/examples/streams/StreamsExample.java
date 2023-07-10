package ashish.examples.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsExample {

    /**
     * Streams are sequence of objects. There are can 2 Types of Operation that can be performed on them
     * 1) Intermediate Operation (filter,map,sort) they will return a stream
     * 2) Terminal Operation (forEach, collect, reduce) they will either give void(forEach) or a nonStream request (Map,List,Set etc)
     */

    public static void main(String[] args) {

        // 0.0 is the initial value , a is the running total and b is the next element from stream
        Double sum = Stream.of(1.8,2.0,0.2,7.8,2.2).reduce(0.0,(Double a, Double b) -> a+b);
        System.out.println("Sum is "+sum);

        //Find occurrences in a string
        String sentence = "Iamajavaengineer!";
        Map<String, Long> map = Arrays.stream(sentence.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("Each character occurs "+map);

        //Find Duplicate characters in String
        List<String> repeatingChars = Arrays.stream(sentence.split(""))
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet()
                .stream()
                .filter(es->es.getValue()>1)
                .map(item->item.getKey())
                .collect(Collectors.toList());

        System.out.println("Duplicate Characters are "+repeatingChars);

        //Find Unique characters in String
        List<String> uniqueChars = Arrays.stream(sentence.split(""))
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet()
                .stream()
                .filter(es->es.getValue()==1)
                .map(item->item.getKey())
                .collect(Collectors.toList());

        System.out.println("Unique Characters are "+uniqueChars);


        //Find the first non repeating character in String
        String firstUniqueChars = Arrays.stream(sentence.split(""))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new,Collectors.counting()))
                .entrySet()
                .stream()
                .filter(es->es.getValue()==1)
                .findFirst()
                .get()
                .getKey();

        System.out.println("First non repeating character "+firstUniqueChars);

        //Find the highest age from Array
        int[] ageArr = {10,80,72,44,5};
        int max = Arrays.stream(ageArr)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .findFirst()
                .get();
        System.out.println("Max age "+max);
        //If you do not reverse then use can use skip() and pick up the last one

        //Find the 2nd highest age from Array
        int secondMaxAge = Arrays.stream(ageArr)
                .boxed()
                .sorted()
                .skip(ageArr.length-2)
                .findFirst()
                .get();
        System.out.println("Second max age "+secondMaxAge);

        //Find the longest String from given Array
        //Variation can be find the length of longest string
        String [] names = {"Ashish","java","SE","sup"};
        int lengthOfMaxString = Arrays.stream(names)
                .mapToInt(item -> item.length())
                .max()
                .getAsInt();

        System.out.println("Length of maxed length String is "+lengthOfMaxString);

        String longestString = Arrays.stream(names)
                .sorted((s1, s2) -> s2.length()-s1.length())
                .findFirst()
                .get();

        System.out.println("Longest String in Array "+longestString);


        //Find the numbers that start with 1
        int[] intArr = {1,23,11,10,12,14,77};
        List<String> values = Arrays.stream(intArr)
                .boxed()
                .map(String::valueOf)
                .filter(item->item.startsWith("1"))
                .collect(Collectors.toList());

        System.out.println(values);
    }

}
