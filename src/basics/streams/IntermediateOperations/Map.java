package basics.streams.IntermediateOperations;

import java.util.Arrays;
import java.util.List;

public class Map {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", 28, 60000.0, "HR"),
                new Employee("Bob", 35, 75000.0, "IT"),
                new Employee("Charlie", 22, 50000.0, "Finance"),
                new Employee("David", 40, 90000.0, "IT"),
                new Employee("Eva", 30, 80000.0, "HR")
        );

//        UPPERCASE
        List<String> uppercaseNames = employees.stream().map(Employee::getName).map(String::toUpperCase).toList();
//        Salary By 10%
        List<Double> increasedSalaries = employees.stream().map(employee -> employee.getSalary() * 1.1).toList();
//        Bonus based on age
        List<Integer> ageBasedBonuses = employees.stream().map(employee -> employee.getAge() * 100).toList();

        // Print the results
        System.out.println("Uppercase Names: " + uppercaseNames);
        System.out.println("Increased Salaries: " + increasedSalaries);
        System.out.println("Age-Based Bonuses: " + ageBasedBonuses);
    }
}
