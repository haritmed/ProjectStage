package com.example.employeeimput.services;

import com.example.employeeimput.entities.Employee;
import org.springframework.data.domain.Page;

import java.util.List;

public interface EmployeeService {
    Employee saveEmployee(Employee employee); //"Create" pour créer un nouveau client s'il nexiste pas id
    Employee updateEmployee(Employee employee);//"Update"
    void deleteEmployeeById(Long id);//"Delete by id"
    void deleteAllEmployee();//"Delete All"
    Employee getEmployeeById(Long id); //"Read by id"
    List<Employee> getAllEmployee();
    Page<Employee> getAllEmployeeByPage(int page, int size);
}
