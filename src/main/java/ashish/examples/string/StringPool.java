package ashish.examples.string;

public class StringPool {
    public static void main(String[] args) {

        //String Pool or String Constant Pool is a memory area (in heap) which stores String literals.
        //New keyword always creates a new object in heap(not in String constant pool), so if we want check if it exists
        // in String pool using intern() method to optimize memory allocation

        String s1 = new String("JavaLife!");
        String s2 = new String("JavaLife!");
        String s3 = "JavaLife!";
        String s4 = "JavaLife!";
        String s5 = new String("JavaLife!").intern();
        String s6 = s1;

        System.out.println(s1==s2);
        System.out.println(s1==s3);
        System.out.println(s3==s4);
        System.out.println(s3==s5);
        System.out.println(s1==s6);

        System.out.println("---------------");

        System.out.println(s1.equals(s2));
        System.out.println(s1.equals(s3));
        System.out.println(s1.equals(s4));
        System.out.println(s1.equals(s5));



        String s7 = "Go-Java!";
        String s8 = new String("Go-Java!").intern();
        String s9 = new String("Go-Java!").intern();
        System.out.println("Intern checks");
        System.out.println(s7==s8);
        System.out.println(s8==s9);



        String s10 = "JavaWorld";
        String s11 = new String("JavaWorld");
        String s12 = new String("JavaWorld").intern();
        System.out.println("New and Intern");
        System.out.println(s10==s11);
        System.out.println(s10==s12);

    }
}
