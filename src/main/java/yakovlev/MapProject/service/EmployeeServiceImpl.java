package yakovlev.MapProject.service;

import org.springframework.stereotype.Service;
import yakovlev.MapProject.controller.Employee;
import yakovlev.MapProject.exception.EmployeeAlreadyAddedException;
import yakovlev.MapProject.exception.EmployeeNotFoundException;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    //    private final List<Employee> employeeList;
    private final Map<String, Employee> employeeMap;

    public EmployeeServiceImpl() {
//        this.employeeList = new ArrayList<>();
        this.employeeMap = new HashMap<>();
    }

    @Override
//    public Employee add(String firstName, String lastName) {
//        Employee employee = new Employee(firstName, lastName);
//        if (employeeList.contains(employee)) {
//            throw new EmployeeAlreadyAddedException();
//        }
//        employeeList.add(employee);
//        return employee;
//    }
    public Employee add(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employeeMap.containsValue(employee)) {
            throw new EmployeeAlreadyAddedException();
        }
        String key = lastName + firstName;
        employeeMap.put(key, employee);
        return employee;
    }

    @Override
//    public Employee remove(String firstName, String lastName) {
//        Employee employee = new Employee(firstName, lastName);
//        if (employeeList.contains(employee)) {
//            employeeList.remove(employee);
//            return employee;
//        }
//        throw new EmployeeNotFoundException();
//    }
    public Employee remove(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employeeMap.containsValue(employee)) {
            String key = lastName + firstName;
            employeeMap.remove(key);
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

    @Override
//    public Employee find(String firstName, String lastName) {
//        Employee employee = new Employee(firstName, lastName);
//        if (employeeList.contains(employee)) {
//            return employee;
//        }
//        throw new EmployeeNotFoundException();
//    }
    public Employee find(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employeeMap.containsValue(employee)) {
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

    //    @Override
//    public Collection<Employee> findAll() {
//        return Collections.unmodifiableList(employeeList);
//    }
    @Override
    public Map<String, Employee> findAll() {
        return employeeMap;
    }
}
