package basics.functionalInterface.function;

import java.util.Arrays;
import java.util.List;

public class FunctionExample {
    public static void main(String[] args) {
        List<Employee> employeeList = Arrays.asList(
                new Employee("Alice", 50000.0),
                new Employee("Bob", 60000.0),
                new Employee("Charlie", 75000.0)
        );

        EmployeeProcessor employeeProcessor = new EmployeeProcessor(employeeList);

        // Example 1: Extract employee names
        List<String> employeeNames = employeeProcessor.processEmployees(Employee::getName);
        System.out.println("Employee Names: " + employeeNames);

        // Example 2: Calculate bonus based on salary
        List<Double> bonuses = employeeProcessor.processEmployees(employee ->
                employee.getSalary() * 0.1); // 10% bonus
        System.out.println("Bonuses: " + bonuses);
    }
}
