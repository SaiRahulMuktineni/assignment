package com.restful.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restful.assignment.model.Employee;

/**
 * Employee repository
 */
public interface EmployeeRepository extends JpaRepository<Employee, String> {
}
