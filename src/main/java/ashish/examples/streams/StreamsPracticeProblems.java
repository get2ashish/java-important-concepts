package ashish.examples.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamsPracticeProblems {
    public static void main(String[] args) {
        //Separate the numbers based on even and odd
        List<Integer> numbers = List.of(1,2,3,4,5,6,7,8,9,10);
        Map<Boolean,List<Integer>> partitionedNumbers = numbers
                .stream()
                .collect(Collectors.partitioningBy(number-> number%2==0));
        System.out.println(partitionedNumbers);

        //Frequency of each character in a string
        String sentence = "Hi my name is Ashish Shukla";
        Map<String,Long> freqMap = Arrays.stream(sentence.split(""))
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println(freqMap);

        //Sort a list in reverse order
       numbers.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);

       //Print the multiple of 5 from the list
        numbers.stream().filter(item-> item%5 == 0).forEach(System.out::println);

        //Merge 2 unsorted array into a single sorted array
        int[] array1 = {23,4,6,8,9,0,1};
        int[] array2 = {2,8,7,44,5};
        int[] sortedArray = IntStream.concat(Arrays.stream(array1),Arrays.stream(array2)).sorted().distinct().toArray();
        System.out.println("Sorted merged array "+sortedArray);

        //Find first 3 max and min numbers from list
        List<Integer>top3Max =  numbers.stream().sorted().limit(3).collect(Collectors.toUnmodifiableList());
        List<Integer>top3Min =  numbers.stream().sorted(Comparator.reverseOrder()).limit(3).collect(Collectors.toUnmodifiableList());

        System.out.println(top3Max);
        System.out.println(top3Min);

        //Sort a list of String in increasing order of their length
        List<String> cities = List.of("Phoenix","Los Angeles","Chicago","Indianapolis","Westfield");
        List<String> sortedCityNames = cities.stream().sorted(Comparator.comparing(String::length)).collect(Collectors.toList());
        System.out.println("City sorted by names are "+sortedCityNames);

        //Sum and average of all element in an array
        IntSummaryStatistics response = Arrays.stream(array1).summaryStatistics();
        System.out.println("Sum is "+response.getSum());
        System.out.println("Average is "+response.getAverage());

        //Reverse and integer array
        IntStream.rangeClosed(1, array1.length)
                .map(element -> array1[array1.length - element])
                .toArray();

        //Remove duplicate from list
        List<Integer> duplicateList = List.of(1,1,3,2,3,4,5,6,7,8,9,10,5);
        List<Integer> updatedList = duplicateList.stream().distinct().collect(Collectors.toUnmodifiableList());
        System.out.println("Removed duplicates "+updatedList);


    }
}
