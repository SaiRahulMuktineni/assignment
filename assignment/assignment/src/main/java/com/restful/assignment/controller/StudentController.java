package com.restful.assignment.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.MatrixParam;
import javax.ws.rs.core.MediaType;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.restful.assignment.model.Student;
import com.restful.assignment.service.StudentService;
import com.restful.assignment.service.StudentServiceImpl;

/**
 * Controller that handles requests related to Student
 */
@RestController
public class StudentController {

	public StudentService studentService = new StudentServiceImpl();

	/**
	 * API to return all the students
	 * 
	 * @return {@link #List<Student>}
	 */
	@RequestMapping(value = "/students", method = RequestMethod.GET, produces = { MediaType.TEXT_XML,
			MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<Student> getStudents() {
		return studentService.getStudents();
	}

	/**
	 * API to return a particular student by studentId
	 *
	 * @param studentId student identifier
	 * @return {@link Student}
	 */
	@RequestMapping(value = "/students/{studentId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	public Student getStudentById(@PathVariable(value = "studentId") final String studentId) {
		return studentService.getStudentById(studentId);
	}

	/**
	 * API to return list of students whose marks are greater than the given marks
	 *
	 * @param studentMarks given student marks
	 * @return {@link #List<Student>}
	 */
	@RequestMapping(value = "/students/studentMarks/{studentMarks}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	public List<Student> getStudentsByMarks(@PathVariable(value = "studentMarks") final Float studentMarks) {
		return studentService.getStudentsByMarks(studentMarks);
	}

	/**
	 * API to add a student
	 *
	 * @param student Student object
	 * @return {@link Student}
	 */
	@RequestMapping(value = "/students", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON)
	public Student addStudent(@RequestBody Student student) {
		return studentService.addStudent(student);
	}

	/**
	 * API to update a student
	 *
	 * @param student Student
	 * @param studentId student identifier
	 * @return {@link #Student}
	 */
	@RequestMapping(value = "/students/{studentId}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON)
	public Student updatedStudent(@RequestBody Student student, @PathVariable(value = "studentId") String studentId) {
		return studentService.updateStudent(student, studentId);
	}

	/**
	 * Delete a student by studentId
	 *
	 * @param studentId student identifier
	 * @return message whether the student is deleted or not
	 */
	@RequestMapping(value = "/students/{studentId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON)
	public String deleteStudent(@PathVariable(value = "studentId") String studentId) {
		return studentService.deleteStudentById(studentId);
	}

	/**
	 * API to return list of students belonging to the given class (className as a path parameter)
	 *
	 * @param className class name
	 * @return {@link #List<Student>}
	 */
	@RequestMapping(value = "/students/studentClasses/{className}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	public List<Student> getStudentsByClass(@PathVariable(value = "className") final String className) {
		return studentService.getStudentsByClass(className);
	}

	/**
	 * API to return list of students belonging to the given class (className as a query parameter)
	 *
	 * @param className class name
	 * @return {@link #List<Student>}
	 */
	@RequestMapping(value = "/students/studentClasses/queryParams", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	public List<Student> getStudentsByClassAsQueryParam(@RequestParam(value = "className") final String className) {
		return studentService.getStudentsByClass(className);
	}

	/**
	 * API to return list of students belonging to the given class (className as a matrix parameter)
	 *
	 * @param className class name
	 * @return {@link #List<Student>}
	 */
	@RequestMapping(value = "/students/studentClasses/matrixParams", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	public List<Student> getStudentsByClassAsMatrixParam(@MatrixParam(value = "className") final String className) {
		return studentService.getStudentsByClass(className);
	}

	/**
	 * API to return list of students belonging to the given class (className as path, query and matrix parameter)
	 *
	 * @param classNameAsPathParam class name as path parameter
	 * @param classNameAsQueryParam class name as query parameter
	 * @param classNameAsMatrixParam class name as matrix parameter
	 * @return {@link #List<Student>}
	 */
	@RequestMapping(value = "/students/studentClasses/multipleParams/{classNameAsPathParam}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	public List<Student> getStudentsByClassAsMultipleParams(
			@PathVariable(value = "classNameAsPathParam") final String classNameAsPathParam,
			@RequestParam(value = "classNameAsQueryParam", required = false) final String classNameAsQueryParam,
			@MatrixParam(value = "classNameAsMatrixParam") final String classNameAsMatrixParam) {

		return studentService.getStudentsByClass(classNameAsPathParam);
	}

	/**
	 * API to return a student based on the studentId (studentId as a query parameter)
	 * 
	 * @param studentId student identifier
	 * @return {@link #Student}
	 */
	@RequestMapping(value = "/students/studentIds/queryParams", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	public Student getStudentByIdAsQueryParam(@RequestParam(value = "studentId") final String studentId) {
		return studentService.getStudentById(studentId);
	}

	/**
	 * API to return a student based on the studentId (studentId as a matrix parameter)
	 * 
	 * @param studentId student identifier
	 * @return {@link #Student}
	 */
	@RequestMapping(value = "/students/studentIds/matrixParams", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	public Student getStudentByIdAsMatrixParam(@MatrixParam(value = "studentId") final String studentId) {
		return studentService.getStudentById(studentId);
	}

	/**
	 * API to return a student based on the studentId (studentId as a path, query and matrix parameter)
	 *
	 * @param studentIdAsPathParam student id as a path parameter
	 * @param studentIdAsQueryParam student id as a query parameter
	 * @param studentIdAsMatrixParam student id as a matrix parameter
	 * @return {@link #Student}
	 */
	@RequestMapping(value = "/students/studentIds/multipleParams/{studentIdAsPathParam}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	public Student getStudentByIdAsMultipleParams(
			@PathVariable(value = "studentIdAsPathParam") final String studentIdAsPathParam,
			@RequestParam(value = "studentIdAsQueryParam", required = false) final String studentIdAsQueryParam,
			@MatrixParam(value = "studentIdAsMatrixParam") final String studentIdAsMatrixParam) {

		return studentService.getStudentById(studentIdAsPathParam);
	}

	/**
	 * API to return list of students whose marks are greater than the given marks (studentMarks as a query parameter)
	 *
	 * @param studentMarks given student marks
	 * @return {@link #List<Student>}
	 */
	@RequestMapping(value = "/students/studentMarks/queryParams", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	public List<Student> getStudentsByMarksAsQueryParam(
			@RequestParam(value = "studentMarks") final Float studentMarks) {
		return studentService.getStudentsByMarks(studentMarks);
	}

	/**
	 * API to return list of students whose marks are greater than the given marks (studentMarks as a matrix parameter)
	 *
	 * @param studentMarks given student marks
	 * @return {@link #List<Student>}
	 */
	@RequestMapping(value = "/students/studentMarks/matrixParams", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	public List<Student> getStudentsByMarksAsMatrixParam(
			@MatrixParam(value = "studentMarks") final String studentMarks) {
		
		final List<Student> studentsList = new ArrayList<Student>();
		if (studentMarks != null) {
			studentsList.addAll(studentService.getStudentsByMarks(Float.parseFloat(studentMarks)));
		}
		
		return studentsList;
	}

	/**
	 * API to return list of students whose marks are greater than the given marks (studentMarks as a path, query and matrix parameter)
	 *
	 * @param studentMarksAsPathParam student marks as a path parameter
	 * @param studentMarksAsQueryParam student marks as a query parameter
	 * @param studentMarksAsMatrixParam student marks as a matrix parameter
	 * @return {@link #List<Student>}
	 */
	@RequestMapping(value = "/students/studentMarks/multipleParams/{studentMarksAsPathParam}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	public List<Student> getStudentByMarksAsMultipleParams(
			@PathVariable(value = "studentMarksAsPathParam") final Float studentMarksAsPathParam,
			@RequestParam(value = "studentMarksAsQueryParam", required = false) final Float studentMarksAsQueryParam,
			@MatrixParam(value = "studentMarksAsMatrixParam") final Float studentMarksAsMatrixParam) {

		return studentService.getStudentsByMarks(studentMarksAsPathParam);
	}
}
