package ashish.examples.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DuplicateExample {
    public static void main(String[] args) {
        int arr [] = {1,2,3,3,1,5,6,1,2,6,6,6,2,2,2};

        int arr2[] = {6};

        //Remove duplicate from arrays
        List<Integer> distinctArrays = Arrays.stream(arr).boxed().distinct().collect(Collectors.toList());
        System.out.println(distinctArrays);


        //Find common elements
        List<Integer> common = Arrays.stream(arr)
                .filter(number1 -> Arrays.stream(arr2).anyMatch(number2 -> number1 == number2))
                .boxed()
                .collect(Collectors.toList());
        System.out.println(common);

        //Find the 2nd smallest number in the Array
        int secondSmallest = Arrays.stream(arr).distinct().sorted().skip(1).findFirst().orElseThrow(()->new RuntimeException("Custom Msg"));
        System.out.println(secondSmallest);

        //Find the 2nd largest number in the Array
        int secondLargest = Arrays.stream(arr).distinct().sorted().skip(arr.length-2).findFirst().orElse(-1);
        System.out.println(secondLargest);
        //this will not work as size may reduce if there are duplicates so we need to break it in 2 steps.
        //Step1 : get sorted unique element
        //Step2 : get the second last element

        // Find the non repeating element in array
        Map<Integer,Integer> countMap = new HashMap<>();
        for(int i : arr){
            if(countMap.containsKey(i)){
                Integer val = countMap.get(i);
                val= val+1;
                countMap.put(i,val);
            }else{
                countMap.put(i,1);
            }
        }

        System.out.println(countMap);

        countMap.forEach((k,v)->{
            if(v==1){
                System.out.println("Key "+k+", Value is "+v);
            }
        });

        String [] nameArr = {"Ashish","Java","MerryXmas"};
        int highestLength = Arrays.stream(nameArr).mapToInt(name-> name.length()).max().orElse(-1);
        System.out.println(highestLength);
    }


}
