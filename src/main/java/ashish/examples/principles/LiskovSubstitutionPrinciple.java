package ashish.examples.principles;

import java.util.ArrayList;
import java.util.List;

public class LiskovSubstitutionPrinciple {
    public static void main(String[] args) {
        System.out.println("SOLID PRINCIPLES - Liskov Substitution Principle");
        /**
         * S --> Single Responsibility Principle (For a class there should be only one reason to change)
         * O --> Open/Closed Principle (A class should be open for extension but closed for modifications)
         * L --> Liskov Substitution Principle (Object of a super class can be replaced by object of its sub class without breaking the program.)
         *       (If a program works with a base class it should also work with any of its derived classes)
         *       (The key ideal behind LSP is that client code should not be aware of any specific subclass/implementation but rather rely on common interface, this will allow better code reuse and extensibility)
         *       (Sub Class should extend the capability of Parent and NOT narrow it down)
         *       (Granularize the interfaces, have multiple interfaces and split the functionality)
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


//------------LSP Violated Use case--------------------------------
        List<Employee> employeeList1 = new ArrayList<>();
        employeeList1.add(new PermanentEmployee());
        employeeList1.add(new ContractEmployee());

        Manager microManager = new Manager();
        microManager.getTotalSalary(employeeList1);
        microManager.totalBonus(employeeList1);
//------------LSP Violated Use case--------------------------------


//------------LSP Compliant Use case--------------------------------
        List<Employee> employeeList2 = new ArrayList<>();
        employeeList2.add(new PermanentEmployee());
        employeeList2.add(new ContractEmployee());

        List<IEmployeeBonus> employeeBonusList = new ArrayList<>();
        employeeBonusList.add(new FullTimeEmployee());
        //employeeBonusList.add(new ContractEmployee()); //This will be a complilation error

        MicroManager manager = new MicroManager();
        manager.getTotalSalary(employeeList2);
        manager.totalBonus(employeeBonusList);
//------------LSP Compliant Use case--------------------------------
    }
}

interface Employee {
    double getSalary();

    double getJoiningBonus();
}

class PermanentEmployee implements Employee {
    @Override
    public double getSalary() {
        return 25000;
    }

    @Override
    public double getJoiningBonus() {
        return 5000;
    }
}

class ContractEmployee implements Employee {
    @Override
    public double getSalary() {
        return 27000;
    }

    @Override
    public double getJoiningBonus() {
        throw new UnsupportedOperationException("Not Eligible for Contract Employee");
    }
}

class Manager {

    public double getTotalSalary(List<Employee> employeeList) {
        double totalSalary = 0d;
        for (Employee employee : employeeList) {
            totalSalary = totalSalary + employee.getSalary();
        }
        return totalSalary;
    }

    public double totalBonus(List<Employee> employeeList) {
        double totalBonus = 0d;
        for (Employee employee : employeeList) {
            totalBonus = totalBonus + employee.getJoiningBonus();
        }
        return totalBonus;
    }
}

//Code breaks here and and if we add instance of Checks manager class needs to aware about the implementation
//Possible solution

interface IEmployee {
    double getSalary();
}

interface IEmployeeBonus {
    double getJoiningBonus();
}

class FullTimeEmployee implements IEmployee, IEmployeeBonus {

    @Override
    public double getSalary() {
        return 25000;
    }

    @Override
    public double getJoiningBonus() {
        return 5000;
    }
}

class Contractor implements IEmployee {

    @Override
    public double getSalary() {
        return 27000;
    }
}

class MicroManager {
    public double getTotalSalary(List<Employee> employeeList) {
        double totalSalary = 0d;
        for (Employee employee : employeeList) {
            totalSalary = totalSalary + employee.getSalary();
        }
        return totalSalary;
    }

    public double totalBonus(List<IEmployeeBonus> employeeList) {
        double totalBonus = 0d;
        for (IEmployeeBonus employee : employeeList) {
            totalBonus = totalBonus + employee.getJoiningBonus();
        }
        return totalBonus;
    }
}