package com.restful.assignment.service;

import javax.ws.rs.core.MediaType;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

/**
 * Rest client to interact with the Employee API's
 */
public class RestClient {

	private static Logger logger = LogManager.getLogger(RestClient.class);

	// Create Client
	private static Client client = Client.create();

	public static void main(String[] args) {

		getEmployeesInJsonFormat();
		logger.info("---------------------------------------------------------");
		getEmployeesInXmlFormat();
		logger.info("---------------------------------------------------------");
		
		getEmployeesByLocationInJsonFormat();
		logger.info("---------------------------------------------------------");
		getEmployeesByLocationInXmlFormat();
		logger.info("---------------------------------------------------------");
		
		getEmployeesByBandInJsonFormat();
		logger.info("---------------------------------------------------------");
		getEmployeesByBandInXmlFormat();
		logger.info("---------------------------------------------------------");
		
		addEmployeeInJsonFormat();
		logger.info("---------------------------------------------------------");
		
		updateEmployeeInJsonFormat();		
		logger.info("---------------------------------------------------------");
		
		deleteEmployeeByIdInJsonFormat();
	}
	
	/**
	 * Method to request all employees in json format
	 */
	public static void getEmployeesInJsonFormat() {
		
		WebResource webResource = client.resource("http://localhost:8080/employees");
		
		ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);

		// If the response is not 200
		if (response.getStatus() != 200) {
			logger.info("Failed with HTTP Error code: " + response.getStatus());
			String error = response.getEntity(String.class);
			logger.info("Error: " + error);
		}

		String output = response.getEntity(String.class);
		logger.info("Response string for /GET /employees in application/json format : ");
		logger.info(output);
	}
	
	/**
	 * Method to request all employees in xml format
	 */
	public static void getEmployeesInXmlFormat() {
		
		WebResource webResource = client.resource("http://localhost:8080/employees");
		
		ClientResponse response = webResource.accept(MediaType.APPLICATION_XML).get(ClientResponse.class);

		// If the response is not 200
		if (response.getStatus() != 200) {
			logger.info("Failed with HTTP Error code: " + response.getStatus());
			String error = response.getEntity(String.class);
			logger.info("Error: " + error);
		}

		String output = response.getEntity(String.class);
		logger.info("Response string for /GET /employees in application/xml format : ");
		logger.info(output);
	}
	
	/**
	 * Method to request employees based on location in json format
	 */
	public static void getEmployeesByLocationInJsonFormat() {
		
		WebResource webResource = client.resource("http://localhost:8080/employees/empLocations/Ottawa");
		
		ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);

		// If the response is not 200
		if (response.getStatus() != 200) {
			logger.info("Failed with HTTP Error code: " + response.getStatus());
			String error = response.getEntity(String.class);
			logger.info("Error: " + error);
		}

		String output = response.getEntity(String.class);
		logger.info("Response string for /GET /employees/empLocation/{empLocation} in application/json format : ");
		logger.info(output);
		
	}
	
	/**
	 * Method to request employees based on location in xml format
	 */
	public static void getEmployeesByLocationInXmlFormat() {
		
		WebResource webResource = client.resource("http://localhost:8080/employees/empLocations/Ottawa");
		
		ClientResponse response = webResource.accept(MediaType.APPLICATION_XML).get(ClientResponse.class);

		// If the response is not 200
		if (response.getStatus() != 200) {
			logger.info("Failed with HTTP Error code: " + response.getStatus());
			String error = response.getEntity(String.class);
			logger.info("Error: " + error);
		}

		String output = response.getEntity(String.class);
		logger.info("Response string for /GET /employees/empLocation/{empLocation} in application/xml format : ");
		logger.info(output);
	}
	
	/**
	 * Method to request employees based on band in json format
	 */
	public static void getEmployeesByBandInJsonFormat() {
		
		WebResource webResource = client.resource("http://localhost:8080/employees/empBands/A3");
		
		ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);

		// If the response is not 200
		if (response.getStatus() != 200) {
			logger.info("Failed with HTTP Error code: " + response.getStatus());
			String error = response.getEntity(String.class);
			logger.info("Error: " + error);
		}

		String output = response.getEntity(String.class);
		logger.info("Response string for /GET /employees/empBand/{empBand} in application/json format : ");
		logger.info(output);
		
	}
	
	/**
	 * Method to request employees based on band in xml format
	 */
	public static void getEmployeesByBandInXmlFormat() {
		
		WebResource webResource = client.resource("http://localhost:8080/employees/empBands/A3");
		
		ClientResponse response = webResource.accept(MediaType.APPLICATION_XML).get(ClientResponse.class);

		// If the response is not 200
		if (response.getStatus() != 200) {
			logger.info("Failed with HTTP Error code: " + response.getStatus());
			String error = response.getEntity(String.class);
			logger.info("Error: " + error);
		}

		String output = response.getEntity(String.class);
		logger.info("Response string for /GET /employees/empBand/{empBand} in application/xml format : ");
		logger.info(output);
	}
	
	/**
	 * Method to add an employee record in the database
	 */
	public static void addEmployeeInJsonFormat() {

		WebResource webResource = client.resource("http://localhost:8080/employees");

		// data sent as a POST request body to web service
		String input = "<Employee>" + "<empId>EM010</empId>" + "<empFirstName>Joe</empFirstName>"
				+ "<empLastName>Trudeau</empLastName>" + "<empLocation>Vancouver</empLocation>"
				+ "<empBand>C3</empBand>" + "</Employee>";

		ClientResponse response = webResource.type("application/xml").accept("application/json")
				.post(ClientResponse.class, input);

		// If the response is not 200
		if (response.getStatus() != 200) {
			logger.info("Failed with HTTP Error code: " + response.getStatus());
			String error = response.getEntity(String.class);
			logger.info("Error: " + error);
		}

		String output = response.getEntity(String.class);
		logger.info("Response string for /POST /employees in application/json format : ");
		logger.info(output);
	}
	
	/**
	 * Method to update an employee record in the database
	 */
	public static void updateEmployeeInJsonFormat() {

		WebResource webResource = client.resource("http://localhost:8080/employees/EM010");

		// data sent as a PUT request body to web service
		String input = "<Employee>" + "<empId>EM010</empId>" + "<empFirstName>Joe</empFirstName>"
				+ "<empLastName>Trudeau</empLastName>" + "<empLocation>Vancouver</empLocation>"
				+ "<empBand>A1</empBand>" + "</Employee>";

		ClientResponse response = webResource.type("application/xml").accept("application/json")
				.put(ClientResponse.class, input);

		// If the response is not 200
		if (response.getStatus() != 200) {
			logger.info("Failed with HTTP Error code: " + response.getStatus());
			String error = response.getEntity(String.class);
			logger.info("Error: " + error);
		}

		String output = response.getEntity(String.class);
		logger.info("Response string for /PUT /employees/{empId} in application/json format : ");
		logger.info(output);
	
	}
	
	/**
	 * Method to delete an employee record in the database
	 */
	public static void deleteEmployeeByIdInJsonFormat() {
		
		WebResource webResource = client.resource("http://localhost:8080/employees/EM010");
		
		ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).delete(ClientResponse.class);

		// If the response is not 200
		if (response.getStatus() != 200) {
			logger.info("Failed with HTTP Error code: " + response.getStatus());
			String error = response.getEntity(String.class);
			logger.info("Error: " + error);
		}

		String output = response.getEntity(String.class);
		logger.info("Response string for /DELETE /employees/{empId} in application/json format : ");
		logger.info(output);
		
	}
	
}
