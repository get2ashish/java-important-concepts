package ashish.examples.solidprinciples;

public class OpenAndClosePrinciple {
    public static void main(String[] args) {
        System.out.println("SOLID PRINCIPLES - Open And Close Principle");
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
 * This class is the same which we saw in Single Responsibility (Just name changed to avoid name space collision)
 * Here we got a new requirement that we need to save invoice to NOSQL DB, so we added extra method which saves in NOSQL DB
 * This violates the OPEN/CLOSE Principle as we are modifying the existing code
 */
class MobileInvoiceDAO{
    private Invoice invoice;
    public MobileInvoiceDAO(Invoice invoice){
        this.invoice = invoice;
    }

    public void save(){
        //save the invoice
    }

    public void saveToNoSQLDB(){
        //send the invoice over email
    }

}

//One possible Solution for this could be
interface IMobileInvoice{
    public void save();
}

class MobileInvoiceDatabaseDAO implements IMobileInvoice{
    @Override
    public void save() {
        //SAVE IN DB
    }
}

class MobileInvoiceNOSQLDatabaseDAO implements  IMobileInvoice{
    @Override
    public void save() {
        //SAVE IN NO SQL DB
    }
}
