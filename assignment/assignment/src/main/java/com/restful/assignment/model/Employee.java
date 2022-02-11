package com.restful.assignment.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Class to hold Employee object information
 */
@Entity
@Table(name = "employee")
public class Employee {

	/**
	 * Employee identifier
	 */
	@Id
	@Column(name = "empId")
	private String empId;
	
	/**
	 * Employee first name
	 */
	@Column(name = "empFirstName")
	private String empFirstName;
	
	/**
	 * Employee last name
	 */
	@Column(name = "empLastName")
	private String empLastName;
	
	/**
	 * Employee location
	 */
	@Column(name = "empLocation")
	private String empLocation;
	
	/**
	 * Employee band
	 */
	@Column(name = "empBand")
	private String empBand;

	/**
	 * Returns the employee id
	 *
	 * @return {@link #empId}
	 */
	public String getEmpId() {
		return empId;
	}

	/**
	 * Set the value of employee id
	 *
	 * @param empId employee identifier
	 */
	public void setEmpId(String empId) {
		this.empId = empId;
	}

	/**
	 * Returns the employee first name
	 *
	 * @return {@link #empFirstName}
	 */
	public String getEmpFirstName() {
		return empFirstName;
	}

	/**
	 * Set the value of employee first name
	 *
	 * @param empFirstName employee first name
	 */
	public void setEmpFirstName(String empFirstName) {
		this.empFirstName = empFirstName;
	}

	/**
	 * Returns the employee last name
	 *
	 * @return {@link #empLastName}
	 */
	public String getEmpLastName() {
		return empLastName;
	}

	/**
	 * Set the value of employee last name
	 *
	 * @param empLastName employee last name
	 */
	public void setEmpLastName(String empLastName) {
		this.empLastName = empLastName;
	}

	/**
	 * Returns the employee location
	 *
	 * @return {@link #empLocation}
	 */
	public String getEmpLocation() {
		return empLocation;
	}

	/**
	 * Set the value of employee location
	 *
	 * @param empLocation employee location
	 */
	public void setEmpLocation(String empLocation) {
		this.empLocation = empLocation;
	}
	
	/**
	 * Returns the employee band
	 *
	 * @return {@link #empBand}
	 */
	public String getEmpBand() {
		return empBand;
	}

	/**
	 * Set the value of employee band
	 *
	 * @param empBand employee band
	 */
	public void setEmpBand(String empBand) {
		this.empBand = empBand;
	}
	
	
}
