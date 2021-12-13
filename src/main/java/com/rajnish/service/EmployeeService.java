package com.rajnish.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rajnish.model.Employee;

@Service
public interface EmployeeService {
 public List<Employee> getAllEmployees();
 public String saveEmployee(Employee employee);
 public Employee getEmpoloyeeById(int id);
 public String deleteEmployeeById(int id);
}
