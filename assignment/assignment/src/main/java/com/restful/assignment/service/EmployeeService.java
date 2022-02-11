package com.restful.assignment.service;

import java.util.List;

import com.restful.assignment.model.Employee;

/**
 * Service class to handle the employee business methods
 */
public interface EmployeeService {
	
	public List<Employee> retrieveEmployees();
	
	public Employee getEmployee(String employeeId);
	
	public Employee saveEmployee(Employee employee);
	
	public Employee updateEmployee(Employee employee, String employeeId);
	
	public void deleteEmployee(String employeeId);

	public List<Employee> getEmployeesByLocation(String empLocation);

	public List<Employee> getEmployeesByBand(String empBand);
	
}
