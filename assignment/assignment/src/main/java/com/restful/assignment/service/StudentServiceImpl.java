package com.restful.assignment.service;

import java.util.ArrayList;
import java.util.List;

import com.restful.assignment.model.Student;

/**
 * Service implementation class to handle the business functionality/logic related to the Student
 */
public class StudentServiceImpl implements StudentService {

	public static List<Student> studentsList = new ArrayList<Student>(List.of(
			new Student("S01", "Steve Martin", "C1" , 90f),
			new Student("S02", "Rachel Lesnar", "B1" , 87f),
			new Student("S03", "Rahul Kurian", "A1" , 95f),
			new Student("S04", "Steve Harvey", "A2" , 75f),
			new Student("S05", "Conor Reynold", "B2" , 93f),
			new Student("S06", "Dwayne Johnson", "C2" , 90f),
			new Student("S07", "Ryan Collingwood", "A3" , 77f),
			new Student("S08", "Jackie Sharp", "B3" , 92f),
			new Student("S09", "Claire Underwood", "C3" , 95f),
			new Student("S10", "Nancy Barnes", "C1" , 90f)
			));
	
	/**
	 * Method to retrieve list of all the students
	 */
	@Override
	public List<Student> getStudents() {
		
		return studentsList;
	}

	/**
	 * Method to retrieve a student based on the given studentId
	 */
	@Override
	public Student getStudentById(String id) {
		
		Student student = new Student();
		
		for (final Student stud : studentsList) {
			if (stud.getStudentId().equalsIgnoreCase(id)) {
				student = stud;
				break;
			}
		}
		
		return student;
	}
	
	/**
	 * Method to retrieve list of students whose marks are greater than the given marks
	 */
	@Override
	public List<Student> getStudentsByMarks(float marks) {

		final List<Student> filteredStudentList = new ArrayList<Student>();
		
		for (final Student student : studentsList) {
			if (student.getStudentTotalMarks() > marks) {
				filteredStudentList.add(student);
			}
		}
		
		return filteredStudentList;
	}
	
	/**
	 * Method to add a student to the list of students
	 */
	@Override
	public Student addStudent(Student newStudent) {
		
		studentsList.add(newStudent);
		
		//return "Student " + newStudent.getStudentId() + " has been successfully added.";
		return newStudent;
		
	}

	/**
	 * Method to update a student based on the given studentId
	 */
	@Override
	public Student updateStudent(Student updatedStudent, String studentId) {
		
		final Student updatedStudentToBeAdded = new Student();
		boolean studentExists = false;
		int index = 0;
		
		for (Student student : studentsList) {
			if (student.getStudentId().equals(studentId)) {
				updatedStudentToBeAdded.setStudentId(updatedStudent.getStudentId());
				updatedStudentToBeAdded.setStudentName(updatedStudent.getStudentName() != null ? updatedStudent.getStudentName() : student.getStudentName());
				updatedStudentToBeAdded.setStudentClass(updatedStudent.getStudentClass() != null ? updatedStudent.getStudentClass() : student.getStudentClass());
				updatedStudentToBeAdded.setStudentTotalMarks((updatedStudent.getStudentTotalMarks() > 0 && updatedStudent.getStudentTotalMarks() <= 100) 
						? updatedStudent.getStudentTotalMarks() : student.getStudentTotalMarks());
				studentExists = true;
				break;
			}
			index++;
		}
		
		if (studentExists) {
			studentsList.remove(index);
			studentsList.add(updatedStudentToBeAdded);
		}
		
		return updatedStudent;
		
	}

	/**
	 * Method to delete a student based on the given studentId
	 */
	@Override
	public String deleteStudentById(String studentId) {
		
		boolean studentExists = false;
		int index = 0;
		final StringBuilder response = new StringBuilder(); 
		
		for (Student student : studentsList) {
			if (student.getStudentId().equalsIgnoreCase(studentId)) {
				studentExists = true;
				break;
			}
			index++;
		}
		
		if (studentExists) {
			studentsList.remove(index);
			response.append("Student " + studentId + " has been successfully deleted.");
		} else {
			response.append("Student " + studentId + " doesn't exist.");
		}
		
		return response.toString();
	}

	/**
	 * Method to retrieve list of students belonging to the given class
	 */
	@Override
	public List<Student> getStudentsByClass(String className) {

		final List<Student> filteredStudentList = new ArrayList<Student>();
		
		for (final Student student : studentsList) {
			if (student.getStudentClass().equalsIgnoreCase(className)) {
				filteredStudentList.add(student);
			}
		}
		
		return filteredStudentList;
	}

}
