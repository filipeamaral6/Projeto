package com.polarising.bootsecurity.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.polarising.bootsecurity.soap.employee.example.xmlns._1564670906833.EmployeeService;
import com.polarising.bootsecurity.soap.employee.tibco.schemas.employee.InputEmployee;
import com.polarising.bootsecurity.soap.employee.tibco.schemas.employee.Root;
import com.polarising.bootsecurity.soap.employee.tibco.schemas.getbyid.GetById;

@RestController
@RequestMapping("/")
@CrossOrigin
public class EmployeeController {

	// Get Employees
	@GetMapping("employees")
	public List<Object> getEmployees() {

		EmployeeService employeeService = new EmployeeService();
		Root getEmployees = employeeService.getPortTypeGetAllEmployeesEndpoint1().operation();

		List<Object> message = new ArrayList<Object>();

		if (!getEmployees.getInputEmployee().isEmpty()) {
			for (InputEmployee client : getEmployees.getInputEmployee()) {
				message.add(client);
			}
		} else {
			message.add(getEmployees.getOutputEmployee());
		}

		return message;
	}

	// Get Client by Id
	@GetMapping("employees/id/{id}")
	public Object getEmployeeById(@PathVariable String id) {

		EmployeeService employeeService = new EmployeeService();
		
		GetById getById = new GetById();
		getById.setId(id);
		
		Root getEmployeeById = employeeService.getPortTypeGetEmployeeEndpoint1().operation(getById);
		
		if (getEmployeeById.getInputEmployee().isEmpty()) {
			return getEmployeeById.getOutputEmployee();
		} else {
			return getEmployeeById.getInputEmployee();
		}
	}
}
