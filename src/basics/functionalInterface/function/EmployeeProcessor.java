package basics.functionalInterface.function;


import java.util.List;
import java.util.function.Function;

public class EmployeeProcessor {
    private final List<Employee> employees;

    public EmployeeProcessor(List<Employee> employees) {
        this.employees = employees;
    }

    // Method to apply a Function to each employee
    public <R> List<R> processEmployees(Function<Employee, R> employeeFunction) {
        return employees.stream()
                .map(employeeFunction)
                .toList();
    }

}