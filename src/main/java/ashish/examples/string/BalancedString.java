package ashish.examples.string;

import java.util.ArrayList;
import java.util.List;

public class BalancedString {
    public static void main(String[] args) {
        System.out.println("is balanced "+isBalanced("ashish"));
    }

    private static boolean  isBalanced(String input) {
        List<Character> upperCase = new ArrayList<>();
        List<Character> lowerCase = new ArrayList<>();
        for(char ch : input.toCharArray()){
            if(Character.isUpperCase(ch)){
                upperCase.add(ch);
            }else{
                lowerCase.add(Character.toUpperCase(ch));
            }
        }
        return upperCase.equals(lowerCase);
    }
}
