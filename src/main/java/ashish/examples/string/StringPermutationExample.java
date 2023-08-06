package ashish.examples.string;


import java.util.ArrayList;
import java.util.List;

public class StringPermutationExample {
    public static List<String> findPermutations(String str) {
        List<String> result = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return result;
        }
        findPermutationsHelper("", str, result);
        return result;
    }

    /**
     * function findPermutations(prefix, suffix, result):
     *     if suffix is empty:
     *         add prefix to the result list
     *     else:
     *         for each character in suffix:
     *             newPrefix = prefix + character
     *             newSuffix = suffix without character
     *             findPermutations(newPrefix, newSuffix, result)
     *
     * function findPermutationsWrapper(inputString):
     *     result = an empty list
     *     findPermutations("", inputString, result)
     *     return result
     */
    private static void findPermutationsHelper(String prefix, String suffix, List<String> result) {
        int n = suffix.length();
        if (n == 0) {
            result.add(prefix);
        } else {
            for (int i = 0; i < n; i++) {
                char currentChar = suffix.charAt(i);
                String newPrefix = prefix + currentChar;
                String newSuffix = suffix.substring(0, i) + suffix.substring(i + 1);
                findPermutationsHelper(newPrefix, newSuffix, result);
            }
        }
    }

    public static void main(String[] args) {
        String inputString = "ABCD";
        List<String> permutations = findPermutations(inputString);
        System.out.println("All possible permutations of the string '" + inputString + "':");
        for (String permutation : permutations) {
            System.out.println(permutation);
        }
    }
}
