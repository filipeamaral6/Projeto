package com.polarising.bootsecurity.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.polarising.bootsecurity.soap.client.tibco.schemas.client.OutputClient;
import com.polarising.bootsecurity.soap.employee.example.xmlns._1564670906833.EmployeeService;
import com.polarising.bootsecurity.soap.employee.tibco.schemas.employee.InputEmployee;
import com.polarising.bootsecurity.soap.employee.tibco.schemas.employee.OutputEmployee;
import com.polarising.bootsecurity.soap.employee.tibco.schemas.employee.Root;
import com.polarising.bootsecurity.soap.employee.tibco.schemas.getbyid.GetById;

@RestController
@RequestMapping("/")
@CrossOrigin
public class EmployeeController {

	@Autowired
	PasswordEncoder passwordEncoder;

	// Add Client
	@PostMapping("employees/add")
	public ResponseEntity<Object> AddEmployee(@Valid @RequestBody InputEmployee inputEmployee, BindingResult result) {

		if (!result.hasErrors()) {

			inputEmployee.setPassword(passwordEncoder.encode(inputEmployee.getPassword()));

			EmployeeService employeeService = new EmployeeService();

			OutputEmployee message = employeeService.getPortTypeEmployeeEndpoint1().operation(inputEmployee);
			return new ResponseEntity<Object>(message, HttpStatus.OK);

		}

		HashMap<String, String> error = new HashMap<>();
		error.put("field", result.getFieldError().getField());
		error.put("message", result.getFieldError().getDefaultMessage());

		return new ResponseEntity<Object>(error, HttpStatus.BAD_REQUEST);
	}

	// Get Employees
	@GetMapping("employees")
	public ResponseEntity<List<Object>> getEmployees() {

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

		return new ResponseEntity<List<Object>>(message, HttpStatus.OK);
	}

	// Get Client by Id
	@GetMapping("employees/id/{id}")
	public ResponseEntity<Object> getEmployeeById(@PathVariable String id) {

		EmployeeService employeeService = new EmployeeService();

		GetById getById = new GetById();
		getById.setId(id);

		Root getEmployeeById = employeeService.getPortTypeGetEmployeeEndpoint1().operation(getById);

		if (getEmployeeById.getInputEmployee().isEmpty()) {
			return new ResponseEntity<Object>(getEmployeeById.getOutputEmployee(), HttpStatus.OK);
		} else {
			return new ResponseEntity<Object>(getEmployeeById.getInputEmployee(), HttpStatus.OK);
		}
	}

	// Update Client
	@PutMapping("employees/update")
	public ResponseEntity<Object> updateClient(@Valid @RequestBody InputEmployee inputEmployee, BindingResult result) {

		if (!result.hasErrors()) {

			EmployeeService employeeService = new EmployeeService();

			OutputEmployee message = employeeService.getPortTypeUpdateEmployeeEndpoint1().operation(inputEmployee);

			return new ResponseEntity<Object>(message, HttpStatus.OK);

		}

		HashMap<String, String> error = new HashMap<>();
		error.put("field", result.getFieldError().getField());
		error.put("message", result.getFieldError().getDefaultMessage());

		return new ResponseEntity<Object>(error, HttpStatus.BAD_REQUEST);

	}
}
