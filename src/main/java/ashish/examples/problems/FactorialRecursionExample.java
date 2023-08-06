package ashish.examples.problems;

public class FactorialRecursionExample {
    public static void main(String[] args) {
        int factorial = factorial(6);
        System.out.println(factorial);
    }

    public static int factorial(int number) {
        return number > 1 ? number * factorial(number - 1) : 1;
    }
}
