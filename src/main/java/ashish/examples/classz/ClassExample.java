package ashish.examples.classz;

public class ClassExample {

    public static void main(String[] args) throws ClassNotFoundException {
        //ClassNotFoundException
        //If Oracle JDBC driver is not present in class path it will throw ClassNotFoundException
        Class.forName("oracle.jdbc.driver.OracleDriver");

        //NoClassDefFoundError :  When Java Runtime system tried to load a class when its no longer present.
        //It was present at Compile time but missing at run time
    }
}
