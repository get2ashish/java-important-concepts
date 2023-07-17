package ashish.examples.interfaces;


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
