package ParkingLot.repository;

import ParkingLot.exceptions.EmployeeNotFoundException;
import ParkingLot.models.Employee;

import java.util.HashMap;

public class EmployeeRepository {
    private HashMap<Integer, Employee> employeeMap;
    private static int idCounter = 0;

    public EmployeeRepository(){
        this.employeeMap = new HashMap<>();
    }

    public Employee get(int employeeId){
        Employee employee = employeeMap.get(employeeId);
        if(employee == null){
            throw new EmployeeNotFoundException("There is no employee with id " + employeeId);
        }
        return employee;
    }

    public void put(Employee employee){
        employee.setId(++idCounter);
        employeeMap.put(employee.getId(), employee);
        System.out.println(employee.getDesignation() + " with id " + employee.getId() + " has been added successfully");
    }
}
