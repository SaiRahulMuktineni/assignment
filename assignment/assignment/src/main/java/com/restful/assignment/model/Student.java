package com.restful.assignment.model;

/**
 * Class to hold information about the student details
 *
 */
public class Student {

	/**
	 * Student identifier
	 */
	private String studentId;
	
	/**
	 * Name of the student
	 */
	private String studentName;
	
	/**
	 * Class the student belongs to
	 */
	private String studentClass;
	
	/**
	 * Total marks obtained by the student
	 */
	private float studentTotalMarks;

	/**
	 * Default constructor
	 */
	public Student() {
		super();
	}

	/**
	 * Parameterized constructor
	 *
	 * @param studentId
	 * @param studentName
	 * @param studentClass
	 * @param studentTotalMarks
	 */
	public Student(String studentId, String studentName, String studentClass, float studentTotalMarks) {
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentClass = studentClass;
		this.studentTotalMarks = studentTotalMarks;
	}

	/**
	 * Return the student identifier
	 * 
	 * @return {@link #studentId}
	 */
	public String getStudentId() {
		return studentId;
	}

	/**
	 * Set the student identifier
	 *
	 * @param studentId student identifier
	 */
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	/**
	 * Return the student name
	 * 
	 * @return {@link #studentName}
	 */
	public String getStudentName() {
		return studentName;
	}

	/**
	 * Set the name of the student
	 *
	 * @param studentName student name
	 */
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	/**
	 * Return the student class
	 * 
	 * @return {@link #studentClass}
	 */
	public String getStudentClass() {
		return studentClass;
	}

	/**
	 * Set the class the student belongs to
	 * 
	 * @param studentClass student class
	 */
	public void setStudentClass(String studentClass) {
		this.studentClass = studentClass;
	}

	/**
	 * Return the total marks obtained by the student
	 * 
	 * @return {@link #studentTotalMarks}
	 */
	public float getStudentTotalMarks() {
		return studentTotalMarks;
	}

	/**
	 * Set the total marks obtained by the student
	 *
	 * @param studentTotalMarks student total marks
	 */
	public void setStudentTotalMarks(float studentTotalMarks) {
		this.studentTotalMarks = studentTotalMarks;
	}
	
	
	
}
