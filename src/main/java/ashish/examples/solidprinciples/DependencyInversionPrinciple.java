package ashish.examples.solidprinciples;

public class DependencyInversionPrinciple {
    public static void main(String[] args) {
        System.out.println("SOLID PRINCIPLES - Dependency Inversion Principle");
        /**
         * S --> Single Responsibility Principle (For a class there should be only one reason to change)
         * O --> Open/Closed Principle (A class should be open for extension but closed for modifications)
         * L --> Liskov Substitution Principle (Object of a super class can be replaced by object of its sub class without breaking the program.)
         *       (If a program works with a base class it should also work with any of its derived classes)
         *       (The key ideal behind LSP is that client code should not be aware of any specific subclass/implementation but rather rely on common interface, this will allow better code reuse and extensibility)
         *       (Sub Class should extend the capability of Parent and NOT narrow it down)
         *       (It is kind of a check for inheritance :) So if your code does not follow this Principle may be use need to revisit inheritance)
         * I --> Interface Segregation Principle (Interfaces should be designed such the clients should not be forced to implement un-necessary methods)
         *       (We should have 1-2 FAT interfaces which include a lot of functionality but rather have multiple small interfaces)
         *       (It is KIND-OF extension of SINGLE RESPONSIBILITY Principle, 1-2 interfaces should not include all the needed functionality )
         * D --> Dependency Inversion Principle (Classes should depend on Interfaces rather than concrete classes)
         *       (High level modules should not depend on Low Level Modules, Both should depend on abstraction
         *       which means caller classes should not know about the internal implementation of the classes instead they
         *       should depend upon interfaces)
         *
         * Advantage of Using SOLID Principles
         * 1) Easy to maintain
         * 2) Easy to understand
         * 3) Reduces complexity
         * 4) Flexible
         */
    }
}

/**
 * Lets consider a usecase where there are 3 classes
 * Class A,B,C
 * Class A depends on Class B
 * Class B depends on Class C
 *
 * Class A is aware of implementation of Class B hence it is directly dependent on class B
 * If something in Class B changes it directly impacts class A
 * This type of code difficult to manage, change and test.
 * You also need to mock the dependencies of depending classes while writing test cases
 *
 */

class CacheStore{
    public void add(String key, String value){

    }
    public void remove(String key){

    }

    public void evict(){

    }
}

class UserProfile{

    static CacheStore cacheStore = new CacheStore();

    public void checkUserInCache() {
        //Here Caller class UserProfile is aware about the implementation of CacheStore class
        //If in future the something changes this class will be impacted.
        cacheStore.add("1","Ashish");
    }
}

interface ICacheStore{
    public void add(String key, String value);
    public void remove(String key);
    public void evict();
}

//Using an interface we have the leverage to changing the caching technology like Redis,EhCache,MemCache etc and Caller
//Classes wont need to know about the implementation.
class MyCacheStore implements ICacheStore{

    @Override
    public void add(String key, String value) {

    }

    @Override
    public void remove(String key) {

    }

    @Override
    public void evict() {

    }
}

class UserProfile2{

    static MyCacheStore cacheStore = new MyCacheStore();

    public void checkUserInCache() {
        //There is
        cacheStore.add("1","Ashish");
    }
}

//Example 2
class Desktop{

    private WiredKeyboard wiredKeyboard;
    private WiredMouse wiredMouse;

    public Desktop(WiredKeyboard wiredKeyboard,WiredMouse wiredMouse){
        this.wiredKeyboard = wiredKeyboard;
        this.wiredMouse = wiredMouse;
    }

}

class WiredMouse{

}

class WiredKeyboard{

}

//Solution

interface Mouse{

}
interface Keyboard{

}

class BluetoothMouse implements Mouse{

}

class BluetoothKeyboard implements Keyboard{

}


//This can take Bluetooth keyboard, wired keyboard and Mechanical Keyboard etc
class MyDesktop{
    private Keyboard myKeyboard;
    private Mouse myMouse;

    public MyDesktop(Keyboard keyboard,Mouse mouse){
        this.myKeyboard = keyboard;
        this.myMouse = mouse;
    }
}
