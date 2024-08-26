package ds.Array.medium;

import java.util.*;
import java.util.stream.Collectors;

class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;

    public Employee(int id, int importance, List<Integer> subordinates) {
        this.id = id;
        this.importance = importance;
        this.subordinates = subordinates;
    }
}

public class EmployeeImportance {

    public static int getImportance(List<Employee> employees, int id) {
        // Create a map to store employee id to Employee object mapping using Streams
        Map<Integer, Employee> employeeMap = employees.stream()
                .collect(Collectors.toMap(emp -> emp.id, emp -> emp));

        // Use a helper method to calculate the total importance using DFS
        return dfs(employeeMap, id);
    }

    private static int dfs(Map<Integer, Employee> employeeMap, int id) {
        Employee employee = employeeMap.get(id);
        int totalImportance = employee.importance;

        // Iterate over each subordinate and calculate their importance recursively
        for (int subId : employee.subordinates) {
            totalImportance += dfs(employeeMap, subId);
        }

        return totalImportance;
    }

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee(1, 5, Arrays.asList(2, 3)),
                new Employee(2, 3, Collections.singletonList(4)),
                new Employee(3, 4, Collections.emptyList()),
                new Employee(4, 1, Collections.emptyList())
        );

        int id = 1;
        System.out.println("Total importance for employee with ID " + id + " is: " + getImportance(employees, id));
    }
}
