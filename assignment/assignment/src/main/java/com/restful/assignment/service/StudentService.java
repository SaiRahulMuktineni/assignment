package com.restful.assignment.service;

import java.util.List;

import com.restful.assignment.model.Student;

/**
 * Service class to handle the student business methods
 */
public interface StudentService {

	public List<Student> getStudents();
	
	public Student getStudentById(String id);
	
	public List<Student> getStudentsByMarks(float marks);
	
	public Student addStudent(Student newStudent);
	
	public Student updateStudent(Student updatedStudent, String studentId);
	
	public String deleteStudentById(String studentId);

	public List<Student> getStudentsByClass(String className);
}
