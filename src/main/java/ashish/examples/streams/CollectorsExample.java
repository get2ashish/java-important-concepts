package ashish.examples.streams;

import ashish.examples.passbyvalue.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectorsExample {
    public static void main(String[] args) {

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("Ashish","Software Engineer"));
        employeeList.add(new Employee("Sachi","Mechanical Engineer"));
        employeeList.add(new Employee("Avyukt","Software Engineer"));
        employeeList.add(new Employee("Samendra","Administrator"));


        //ToMap

        Map<String,Employee> empMap1 = employeeList.stream()
                .collect(Collectors.toMap(Employee::getName, Function.identity()));

        //OR (both will give same results)

        Map<String,Employee> empMap2 = employeeList.stream()
                .collect(Collectors.toMap(value->value.getName(),value->value));

        System.out.println(empMap1);

        //PartitionBy

        Map<Boolean, List<Employee>> empMapPartitionBy =  employeeList.stream()
                .collect(Collectors.partitioningBy(employee -> employee.getDesignation().equalsIgnoreCase("Software Engineer")));

        System.out.println(empMapPartitionBy);

        //Grouping By
        Map<String, List<Employee>> empMapGroupBy =  employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDesignation));

        System.out.println(empMapGroupBy);
    }
}
