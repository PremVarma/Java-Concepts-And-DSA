package basics.questions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Employee {
    public String firstName;
    String lastName;

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Employee{" +
               "firstName='" + firstName + '\'' +
               ", lastName='" + lastName + '\'' +
               '}';
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}

class Person implements Comparable<Person> {
    String firstName;
    String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Person{" +
               "firstName='" + firstName + '\'' +
               ", lastName='" + lastName + '\'' +
               '}';
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public int compareTo(Person o) {
        int firstNameCompare = this.firstName.compareTo(o.firstName);
        if (firstNameCompare != 0) return firstNameCompare;
        return this.lastName.compareTo(o.lastName);
    }
}

class Main {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Prem", "Varma"));
        employees.add(new Employee("Arun", "Sharma"));
        employees.add(new Employee("Pinky", "Varma"));
        employees.add(new Employee("Abhijit", "Kushwaha"));

//------------- USING COMPARATOR--------------------
        Comparator<Employee> firstNameComparator = Comparator.comparing(Employee::getFirstName);
        Comparator<Employee> lastNameComparator = Comparator.comparing(Employee::getLastName, Comparator.reverseOrder()); //.thenComparing(Employee::getFirstName);;
        System.out.println("Sorted By First Name");
        employees.sort(firstNameComparator);
        System.out.println(employees);
        System.out.println("Sorted By Last Name");
        employees.sort(lastNameComparator);
        System.out.println(employees);

//---------------USING COMPARABLE-------------------
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Rahul", "Varma"));
        persons.add(new Person("Sona", "Varma"));
        persons.add(new Person("Rahul", "Devgan"));
        persons.add(new Person("Abhijit", "Kushwaha"));
        System.out.println("Sorting Person class");
        Collections.sort(persons);
        System.out.println(persons);
    }
}
//what if last name is same of two people, in this case, sort by first name
// for example,