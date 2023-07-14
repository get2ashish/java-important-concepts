package ashish.examples.interfaces;


interface IBank {
    void update();

    default void myDefaultMethod() {
        System.out.println("Default method of Interface");
    }

    static void myStaticMethod() {
        System.out.println("static method of Interface");
    }
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
