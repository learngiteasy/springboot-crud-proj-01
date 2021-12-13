package com.rajnish.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.rajnish.model.Employee;
import com.rajnish.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/")
	public String viewHomePage(Model model) {
		
		model.addAttribute("name", this.employeeService.getAllEmployees());
		return  "index";
	}
	
	@GetMapping("/showemployeeform")
	public String showEmployeeForm(Model model) {
		
		Employee employee=new Employee();
		model.addAttribute("employee", employee);
		return "new_form";
	}
	//@ModelAttribute is used to handle the form data
	@PostMapping("/saveemployee")
	public String saveEmployee(@ModelAttribute("employee")Employee employee) {
		// save employee to database
		this.employeeService.saveEmployee(employee);
	    return "redirect:/";	
	}
	
	// Showing form for editing
	
	@GetMapping("/showeditform/{id}")
	public String showEditForm(@PathVariable(value="id")int id,Model model) {
	  //Employee employee=new Employee();
		
      // Pre-populate the form by adding employee object as an attribute in model object		
	  Employee employee = this.employeeService.getEmpoloyeeById(id);
	 model.addAttribute("employee", employee);
      return "update_form";
	}
	
	
	@GetMapping("/deleteById/{id}")
	public String deleteById(@PathVariable(value="id")int id) {
	  //Employee employee=new Employee();
		
      // Pre-populate the form by adding employee object as an attribute in model object		
	  this.employeeService.deleteEmployeeById(id);
	
      return "redirect:/";
	}
	
	
}
