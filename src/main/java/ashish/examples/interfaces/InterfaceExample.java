package ashish.examples.interfaces;


/**
 * Why do we code to an interface?
 * 1) Its always a good practice using a parent reference to instantiate and not concrete implementation classes.
 * As when you use Parent reference you use the methods specified in the parent <Interface> and not those specific to child
 * Such implementations are less prone to change.
 * Example
 * Using List<String> list = new LinkedList<>(); is better than using LinkedList<String> list = new LinkedList<>();
 * so you wont be able to use peek, poll pop  methods but rather use methods specified in Parent class
 * Such implementations are less prone to change and are much easier to maintain.
 */
interface IBank {
    void update();

    default void myDefaultMethod() {
        System.out.println("Default method of Interface");
    }

    static void myStaticMethod() {
        System.out.println("static method of Interface");
    }

    //From Java 9
    private void myPrivateMethod(){
        System.out.println("private method");
    }

    //This method cannot be executed using java IBank will get NoClassDefError
    public static void main(String [] args){
        System.out.println("public static main method");
    }

    //You cannot have Object class methods as default or private methods in Interface
    /*default public int hashCode() {
        return 1;
    }

    default public boolean equals(Object obj) {
        return Boolean.TRUE;
    }*/

}

public class InterfaceExample implements IBank {
    //Even if i do not override this method this class does not need to be abstract as its a default

    @Override
    public void myDefaultMethod() {
        //IBank.super.myDefaultMethod();
        System.out.println("Overriding the default method");
    }

    @Override
    public void update() {
        System.out.println("Update method of implementation.");
    }

    public static void main(String[] args) {
        IBank obj = new InterfaceExample();
        obj.update();
        obj.myDefaultMethod();
        IBank.myStaticMethod();
    }
}

class OtherClass extends InterfaceExample{
    public static void main(String[] args) {
        OtherClass obj = new OtherClass();
        obj.myDefaultMethod();
    }
}
