package ashish.examples.string;

public class StringImmutableExample {
    public static void main(String[] args) {
        String s1 = new String("Ashish Shukla");
        s1.substring(s1.indexOf(" ")+1,s1.length());
        //Remember Strings are immutable and wont change unless you store them back using their references
        System.out.println(s1);
        s1.toUpperCase();
        System.out.println(s1);
    }
}
