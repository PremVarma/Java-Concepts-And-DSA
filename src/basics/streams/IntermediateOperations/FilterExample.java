package basics.streams.IntermediateOperations;

import java.util.Arrays;
import java.util.List;

public class FilterExample {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", 28, 60000.0, "HR"),
                new Employee("Bob", 35, 75000.0, "IT"),
                new Employee("Charlie", 22, 50000.0, "Finance"),
                new Employee("David", 40, 90000.0, "IT"),
                new Employee("Eva", 30, 80000.0, "HR")
        );

        List<Employee> itDepartmentEmployees = employees.stream()
                .filter(employee -> "IT".equals(employee.getDepartment())).toList();

        List<Employee> olderThan30Employees = employees.stream()
                .filter(employee -> employee.getAge() > 30).toList();

        List<Employee> salaryBetween70And90kEmployees = employees.stream()
                .filter(employee -> employee.getSalary() >= 70000 && employee.getSalary() <= 90000).toList();

        // Print the results
        System.out.println("IT Department Employees: " + itDepartmentEmployees);
        System.out.println("Employees Older Than 30: " + olderThan30Employees);
        System.out.println("Employees with Salary Between 70k and 90k: " + salaryBetween70And90kEmployees);
    }
}
