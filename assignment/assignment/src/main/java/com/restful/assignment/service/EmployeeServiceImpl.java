package com.restful.assignment.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restful.assignment.model.Employee;
import com.restful.assignment.repository.EmployeeRepository;

/**
 * Service implementation class to handle the business functionality/logic related to the Employee
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public void setEmployeeRepository(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	/**
	 * Method to retrieve all employees
	 */
	@Override
	public List<Employee> retrieveEmployees() {
		return employeeRepository.findAll();
	}

	/**
	 * Method to retrieve the employee corresponding to the given employeeId
	 */
	@Override
	public Employee getEmployee(String employeeId) {
		return employeeRepository.findById(employeeId).get();
	}

	/**
	 * Method to save an employee to the database
	 */
	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);

	}

	/**
	 * Method to update an employee in the database
	 */
	@Override
	public Employee updateEmployee(Employee employee, String employeeId) {

		Employee currentEmployee = employeeRepository.findById(employeeId).get();
		if (currentEmployee != null) {
			currentEmployee.setEmpFirstName(employee.getEmpFirstName());
			currentEmployee.setEmpLastName(employee.getEmpLastName());
			currentEmployee.setEmpLocation(employee.getEmpLocation());
			currentEmployee.setEmpBand(employee.getEmpBand());
		}
		employeeRepository.save(currentEmployee);
		
		return currentEmployee;
	}

	/**
	 * Method to delete an employee in the database
	 */
	@Override
	public void deleteEmployee(String employeeId) {

		Optional<Employee> currentEmployee = employeeRepository.findById(employeeId);
		if (currentEmployee.isPresent()) {
			employeeRepository.deleteById(employeeId);
		}
	}

	/**
	 * Method to retrieve list of employees working in the given location
	 */
	@Override
	public List<Employee> getEmployeesByLocation(String empLocation) {

		List<Employee> employeeList = employeeRepository.findAll();
		
		return employeeList.stream().filter(employee -> employee.getEmpLocation().equalsIgnoreCase(empLocation)).collect(Collectors.toList());
	}

	/**
	 * Method to retrieve list of employees working in the same band
	 */
	@Override
	public List<Employee> getEmployeesByBand(String empBand) {
		
		List<Employee> employeeList = employeeRepository.findAll();
		
		return employeeList.stream().filter(employee -> employee.getEmpBand().equalsIgnoreCase(empBand)).collect(Collectors.toList());
		
	}
	
}
