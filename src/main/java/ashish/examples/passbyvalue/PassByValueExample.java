package ashish.examples.passbyvalue;

import java.util.ArrayList;
import java.util.List;

public class PassByValueExample {
    public void modifyIntValue(int value) {
        System.out.println("Int value received : " + value);
        value = value + 70;
    }

    public void modifyEmployee(Employee employee) {
        employee.setName("Ethan Hunt");
        employee.setDesignation("Secret Agent");
    }

    public void modifyEmployeeList(List<Employee> employeeList) {
        for (Employee employee : employeeList) {
            employee.setName("James Bond");
            employee.setDesignation("007");
        }
    }

    public void modifyIntegerValue(Integer value) {
        value = value + 700;
    }


    public static void main(String[] args) {
        int myIntValue = 10;
        Integer integerValue = 140;
        List<Employee> employeeList = new ArrayList<>();
        Employee employee = new Employee("Ashish", "Software Engineer");
        employeeList.add(employee);

        PassByValueExample passByValueExample = new PassByValueExample();
        System.out.println("int value before method call " + myIntValue);
        passByValueExample.modifyIntValue(myIntValue);
        System.out.println("int value after method call " + myIntValue);

        System.out.println("List value before method call " + employeeList);
        passByValueExample.modifyEmployeeList(employeeList);
        System.out.println("List value after method call " + employeeList);

        System.out.println("Employee value before method call " + employee);
        passByValueExample.modifyEmployee(employee);
        System.out.println("Employee value after method call " + employee);

        System.out.println("Integer value before method call " + integerValue);
        passByValueExample.modifyIntegerValue(integerValue);
        System.out.println("Integer value after method call " + integerValue);
    }
}