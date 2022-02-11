package com.restful.assignment.controller;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.restful.assignment.model.Employee;
import com.restful.assignment.service.EmployeeService;

/**
 * Controller that handles the requests related to Employee
 *
 */
@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	/**
	 * API to return a list of all employees
	 * 
	 * @return {@link #List<Employee>}
	 */
	@RequestMapping(value = "/employees", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_XML})
	public List<Employee> getEmployees() {
		return employeeService.retrieveEmployees();
	}
	
	/**
	 * API to return a list of employees by employee location
	 *
	 * @param empLocation employee location
	 * @return {@link #List<Employee>}
	 */
	@RequestMapping(value = "/employees/empLocations/{empLocation}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_XML})
	public List<Employee> getEmployeesByLocation(@PathVariable(value = "empLocation") final String empLocation) {
		return employeeService.getEmployeesByLocation(empLocation);
	}
	
	/** 
	 * API to return list of employees by employee band
	 *
	 * @param empBand employee band
	 * @return {@link #List<Employee>}
	 */
	@RequestMapping(value = "/employees/empBands/{empBand}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_XML})
	public List<Employee> getEmployeesByBand(@PathVariable(value = "empBand") final String empBand) {
		return employeeService.getEmployeesByBand(empBand);
	}
	
	/**
	 * API to return an employee by employee id
	 *
	 * @param employeeId employee identifier
	 * @return {@link #Employee}
	 */
	@RequestMapping(value = "/employees/{employeeId}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_XML})
	public Employee getEmployeeById(@PathVariable(value = "employeeId") final String employeeId) {
		return employeeService.getEmployee(employeeId);
	}
	
	/**
	 * API to add an employee
	 *
	 * @param employee Employee object
	 * @return {@link #Employee}
	 */
	@RequestMapping(value = "/employees", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON}, consumes = {MediaType.APPLICATION_XML})
	public Employee addEmployee(@RequestBody Employee employee) {
		return employeeService.saveEmployee(employee);
	}
	
	/**
	 * API to update an employee
	 *
	 * @param employee Employee object
	 * @param employeeId employee identifier
	 * @return {@link #Employee}
	 */
	@RequestMapping(value = "/employees/{employeeId}", method = RequestMethod.PUT, produces = {MediaType.APPLICATION_JSON}, consumes = {MediaType.APPLICATION_XML})
	public Employee updateEmployee(@RequestBody Employee employee, @PathVariable(value = "employeeId") final String employeeId) {
		return employeeService.updateEmployee(employee, employeeId);
	}
	
}
