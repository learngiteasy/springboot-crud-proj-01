package com.rajnish.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rajnish.model.Employee;
import com.rajnish.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;
	@Override
	public List<Employee> getAllEmployees() {
		// 
		return this.employeeRepository.findAll();
	}
	@Override
	public String saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		Employee save = this.employeeRepository.save(employee);
		if(save!=null)
		return "Added";
		else
			return "Not added";
	}
	@Override
	public Employee getEmpoloyeeById(int id) {
		// fetch data of a particulr employee by its ID
		Employee byId = this.employeeRepository.getById(id);
		return byId;
		
	}
	@Override
	public String deleteEmployeeById(int id) {
		// TODO Auto-generated method stub
		this.employeeRepository.deleteById(id);
		return "deleted";
		 
		
	}

}
