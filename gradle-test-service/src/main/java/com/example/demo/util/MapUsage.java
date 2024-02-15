package com.example.demo.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class MapUsage {

    public static void main(String[] args) {
        Map<String, Employee> employeeMap = new HashMap<>();

        // Populate the HashMap with some sample data
        employeeMap.put("emp1", new Employee("John Doe", 30, "Software Engineer"));
        employeeMap.put("emp2", new Employee("Alice Smith", 35, "Product Manager"));
        employeeMap.put("emp3", new Employee("Bob Johnson", 28, "Data Scientist"));

        for (Map.Entry<String, Employee> employee : employeeMap.entrySet()) {
            System.out.println(employee.getValue());
        }

        Set<Employee> emp = employeeMap.entrySet().stream().map(e -> e.getValue()).collect(Collectors.toSet());

        emp.stream().filter(e -> e.age() > 33).collect(Collectors.toSet()).forEach(System.out::println);
        var finalSum = emp.stream().map(e -> e.age()).reduce(0, Integer::sum);
        System.out.println(finalSum);

        var olderstEmployee = emp.stream().reduce((emp1, emp2) -> emp1.age() > emp2.age()?emp1: emp2).get();

        System.out.println("oldest: " + olderstEmployee);
    }
}

record Employee(String name, int age, String job) {
};
