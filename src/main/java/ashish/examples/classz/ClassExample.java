package ashish.examples.classz;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ClassExample {

    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //ClassNotFoundException
        //If Oracle JDBC driver is not present in class path it will throw ClassNotFoundException
        Class.forName("oracle.jdbc.driver.OracleDriver");

        //NoClassDefFoundError :  When Java Runtime system tried to load a class when its no longer present.
        //It was present at Compile time but missing at run time


        Constructor[] constructors = DynamicClass.class.getConstructors();
        Constructor c1 = constructors[0];
        c1.setAccessible(true);
        DynamicClass d1 = (DynamicClass)c1.newInstance();
        d1.printInfo();

    }
}

class DynamicClass{

    DynamicClass(){}

    public void printInfo(){
        System.out.println("Hello");
    }
}

class B{

}

class A{
    public void show(){
        System.out.println("Hi");
    }

    public static void main(String[] args) {
        B obj = new B();
        A onjA = new A();
        onjA.show();
    }


}
