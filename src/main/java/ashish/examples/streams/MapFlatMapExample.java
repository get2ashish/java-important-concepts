package ashish.examples.streams;

import java.util.ArrayList;
import java.util.List;

public class MapFlatMapExample {
    public static void main(String[] args) {
        List<Customer> customerList = new ArrayList<>();
        customerList.add(new Customer("John Doe","Pluto",List.of(123456789,987654321)));

        //Map
        customerList.stream().map(customer -> {
            customer.setName(customer.getName() + "- 4 president");
            return customer;
        }).forEach(System.out::println);

        //FlatMap
        customerList.stream()
                //Flattens the Stream<List<Integers>> to Stream<Integers>
                .flatMap(customer -> customer.getPhoneNumbers().stream())
                .forEach(System.out::println);

    }
}

class Customer{
    private String name;
    private String address;
    private List<Integer> phoneNumbers;

    public Customer(String name, String address, List<Integer> phoneNumbers) {
        this.name = name;
        this.address = address;
        this.phoneNumbers = phoneNumbers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Integer> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<Integer> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumbers=" + phoneNumbers +
                '}';
    }
}
