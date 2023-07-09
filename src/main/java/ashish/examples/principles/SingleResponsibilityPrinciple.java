package ashish.examples.principles;

public class SingleResponsibilityPrinciple {

    public static void main(String[] args) {
        System.out.println("SOLID PRINCIPLES - Single Responsibility");
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

class Mobile{
    String name;
    String company;
    String color;
    int year;
    double price;

    public Mobile(String name, String company, String color, int year, double price) {
        this.name = name;
        this.company = company;
        this.color = color;
        this.year = year;
        this.price = price;
    }
}


/**
 * The MobileInvoice class has more than one reason to change.
 * If in the future we need to send invoice via email this will change.
 * If for the archival the data needs to be send to BQ or some other repo this will change
 * If for total calculation some new tax needs to be computed this will change
 */
class MobileInvoice{
    private Mobile mobile;
    private int quantity;
    MobileInvoice(Mobile mobile, int quantity) {
        this.mobile = mobile;
        this.quantity = quantity;
    }

    public double totalPrice() {
        return mobile.price * quantity;
    }

    public void printInvoice(){
        //print the invoice
    }

    public void save(){
        //persist the invoice to DB
    }

}

/**
 * Solution to this problem could be breaking the class above as
 */

class Invoice{
    private Mobile mobile;
    private int quantity;
    Invoice(Mobile mobile, int quantity) {
        this.mobile = mobile;
        this.quantity = quantity;
    }

    public double totalPrice() {
        return mobile.price * quantity;
    }
}

class InvoiceDAO{
    private Invoice invoice;
    public InvoiceDAO(Invoice invoice){
        this.invoice = invoice;
    }

    public void save(){
        //save the invoice
    }
}

class InvoicePrinter{
    private Invoice invoice;
    public InvoicePrinter(Invoice invoice){
        this.invoice = invoice;
    }

    public void print(){
        //prints Invoice
    }
}
